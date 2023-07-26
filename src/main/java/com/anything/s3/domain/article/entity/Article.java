package com.anything.s3.domain.article.entity;

import com.anything.s3.domain.article.presentation.request.EditArticleRequest;
import com.anything.s3.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", nullable = false)
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime editedDate;

    public void update(EditArticleRequest editArticleRequest) {
        this.title = editArticleRequest.getTitle();
        this.content = editArticleRequest.getContent();
    }

//    public void update(EditBoardRequest editBoardRequest) {
//        this.title = editBoardRequest.getTitle();
//        this.content = editBoardRequest.getContent();
//    }
}
