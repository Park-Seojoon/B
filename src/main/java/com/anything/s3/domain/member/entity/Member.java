package com.anything.s3.domain.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Builder
@Table(name = "S3Member")
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false, length = 10, unique = true)
    private String name;

    @Column(nullable = false, unique = true, name = "user_email")
    private String email;

    @Column(nullable = false)
    private String password;

    private int point;

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updatePoint(int point) {
        int tPoint = this.point;
        tPoint += point;
        this.point = tPoint;
    }
}
