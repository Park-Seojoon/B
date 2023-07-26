package com.anything.s3.domain.article.repository;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    boolean existsByTitle (String title);

    List<Article> findByMember(Member member);
    List<Article> findByDoMember(Member doMember);
}
