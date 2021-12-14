package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
// 자동으로 bean으로 등록된다
//spring이 메모리에 뛰어준다
// @Repository 생략가능

// user table이 관리하한다
public interface UserRepository extends JpaRepository<User, Integer> {

}
