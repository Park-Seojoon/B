package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.exception.ArticleOwnerMismatchException;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.file.entity.ArticleFile;
import com.anything.s3.domain.file.repository.ArticleFileRepository;
import com.anything.s3.domain.file.service.ArticleFileService;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.global.annotation.RollbackService;
import com.anything.s3.global.util.ArticleUtil;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RollbackService
@RequiredArgsConstructor
public class DeleteArticleService {

    private final ArticleRepository articleRepository;

    private final ArticleFileRepository articleFileRepository;

    private final ArticleFileService articleFileService;

    private final UserUtil userUtil;

    private final ArticleUtil articleUtil;

    public void execute(Long articleId) {

        Article article = articleUtil.findArticleById(articleId);

        List<ArticleFile> articleFiles = articleFileRepository.getBoardFileByArticleId(articleId);

        Member member = userUtil.currentUser();

        if(!(article.getMember() == member)) {
            throw new ArticleOwnerMismatchException();
        }

        if (articleFiles != null) {

            for (ArticleFile articleFile : articleFiles) {
                articleFileService.deleteFile(articleFile.getUrl().substring(54));

                articleFileRepository.deleteAllByArticle(article);
            }
        }

        articleRepository.delete(article);
    }
}
