package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

// html이아니고 data를 return 해주는 restcontroller
@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입 DI
    private UserRepository userRepository;


    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "failed to delete(User not found)";
        }
        return "deleted: id => "+ id;
    }


    @Transactional
    // id,  email, password 를 받아야한다.
    @PutMapping("/dummy/user/{id}")
    // json data를 받을 려면  requestbody annotation이 필요하다
    // messageconverter의 jackson라이브러리가 json을 java object로 변환해준다
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id : " + id);
        System.out.println("password : " + requestUser.getPassword());
        System.out.println("email : " + requestUser.getEmail());

        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("failed to update");
                });

//        더티 체킹
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        /*
        // save함수는 id를 전달하지 않으면 insert를 해주고
        // save함수는 id를 전달하면 해당id에 대한 데이터가 있으면 update를 해주고
        // save함수는 id를 전달하면 해당id에 대한 데이터가 없으면 insert를 해준다.
        userRepository.save(user);
         */

        return user;
    }

    @GetMapping("/dummy/users/")
    public List<User> list() {
        return userRepository.findAll();
    }

    //    한페이지당 2건의 데이터를 리턴받기
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);


        List<User> users = pagingUser.getContent();
        return users;
    }


    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id)
                .orElseThrow(new Supplier<IllegalArgumentException>() {
                    @Override
                    public IllegalArgumentException get() {
                        return new IllegalArgumentException("user not found");
                    }
                });
        // user 객체는 자바 object
        // 요청은 web browser
        // browser가 이해할수있는 것으로 변환해야한다. ex) json(Gson 라이브러리)
        return user;
    }


    // http://localhost:8000/blog/dummy/join (요청)
    // http 의 body에 username, password, email 데이터를 가지고 요청
    @PostMapping("/dummy/join")
//    object로도 받을수 있다
    public String join(User user) {
        // key=value 타입을 알아서 parsing 해준다.
//    public String join(String username, String password, String email) {
//    public String join(@RequestParam("username") String u, ...etc) {
        System.out.println("username : " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email : " + user.getEmail());

        user.setRole(RoleType.USER); // default 값
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}