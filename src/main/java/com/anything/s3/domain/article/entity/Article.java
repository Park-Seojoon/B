package com.anything.s3.domain.article.entity;

import com.anything.s3.domain.member.entity.Member;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;
}
