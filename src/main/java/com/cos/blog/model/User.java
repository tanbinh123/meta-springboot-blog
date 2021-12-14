package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 springboot가 실행될때 자동으로 mysql에 table을 생성한다.
//@DynamicInsert // insert시에 null인 필드는 제외 하고 insert
public class User {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; //시퀀스, auto_increment

    @Column(nullable = false, length = 30)
    private String username; // id

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

//    @ColumnDefault("user")
    // DB는 RoleType이 없다
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum을 쓰는게 좋다.

    @CreationTimestamp // 시간이 자동으로 입력된다.
    private Timestamp createDate;
}
