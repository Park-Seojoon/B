package com.anything.s3.domain.article.entity;

import com.anything.s3.domain.article.entity.enums.IngType;
import com.anything.s3.domain.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

    private int point;

    private Boolean completed;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_email")
    private Member doMember;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    private String url;

    @Enumerated(EnumType.STRING)
    private IngType ingType;

    public void updateDoIt(Member member) {
        this.doMember = member;
    }

    public void updateCompleted(Boolean completed, IngType type) {
        this.completed = completed;
        this.ingType = type;
    }

    public void updateUrl(String url) {
        this.url = url;
    }
}
