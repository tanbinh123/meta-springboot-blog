package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // sequence, auto_increment

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne // Many : reply(this class), One: Board
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne // 여러개의 답변을 하나의 유저가 쓸수 있다.
    @JoinColumn(name = "userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}
