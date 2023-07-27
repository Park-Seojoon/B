package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.entity.enums.IngType;
import com.anything.s3.domain.article.exception.ExistTitleException;
import com.anything.s3.domain.article.presentation.request.CreateArticleRequest;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.file.entity.ArticleFile;
import com.anything.s3.domain.file.repository.ArticleFileRepository;
import com.anything.s3.domain.file.service.ArticleFileService;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.global.annotation.RollbackService;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RollbackService
@RequiredArgsConstructor
public class CreateArticleService {


    @Value("${cloud.aws.s3.url}")
    private String AWS_S3_ADDRESS;

    private final ArticleRepository articleRepository;

    private final ArticleFileService articleFileService;

    private final ArticleFileRepository articleFileRepository;

    private final UserUtil userUtil;

    public void execute(CreateArticleRequest articleRequest, List<MultipartFile> multipartFileList) {

        Member member = userUtil.currentUser();

        if (articleRepository.existsByTitle(articleRequest.getTitle())) {
            throw new ExistTitleException();
        }

        Article article = Article.builder()
                .title(articleRequest.getTitle())
                .content(articleRequest.getContent())
                .member(member)
                .point(1000)
                .completed(false)
                .doMember(null)
                .url(null)
                .ingType(IngType.PROCEED)
                .build();

        articleRepository.save(article);

        if(multipartFileList != null) {
            List<String> uploadFile = articleFileService.uploadFile(multipartFileList);
            for (String uploadFileUrl : uploadFile) {
                String resultUrl = uploadFileUrl.replaceFirst("^blohny", "");
                articleFileRepository.save(saveToUrl(article, resultUrl));
            }
        }
    }

    private ArticleFile saveToUrl(Article article, String uploadFileUrl) {

        article.updateUrl(AWS_S3_ADDRESS + uploadFileUrl);

        articleRepository.save(article);

        return ArticleFile.builder()
                .article(article)
                .url(AWS_S3_ADDRESS + uploadFileUrl)
                .build();
    }
}
