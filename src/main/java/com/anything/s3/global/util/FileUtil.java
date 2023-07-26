package com.anything.s3.global.util;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.file.entity.ArticleFile;
import com.anything.s3.domain.file.repository.ArticleFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileUtil {

    private final ArticleFileRepository articleFileRepository;

    public String getUrl(Article article) {
        ArticleFile file = articleFileRepository.getArticleFileByArticle(article);

        return file.getUrl();
    }
}
