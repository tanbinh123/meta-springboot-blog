package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리

    @ColumnDefault("0")
    private int count; //조회수

    //    Board : Many , User : One
//    한명의 user는 여러개의 Board를 생성가능
    @ManyToOne(fetch = FetchType.EAGER)
//    foreign key 설정
    @JoinColumn(name = "userId")
    private User user; // DB는 오브젝트를 저장할수없어서 foreign key를 사용하지만 java는 오브젝트 사용

    //board가 One reply가 Many
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    // 내가 연관관계의 주인이아나고 reply가 주인이다.
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

}
