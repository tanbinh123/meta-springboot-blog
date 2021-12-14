package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

// @Controller
// 사용자의 요청 -> 응답(HTML파일)

// 사용자의 요청 -> 응답(data)
@RestController
public class HttpControllerTest {

    // 인터넷 브라우저 요청은 get요청만 할수있다.
    // http://localhost:8000/blog/http/get
    @GetMapping("/http/get")
//    public String getTest(@RequestParam int id) {
    public String getTest(Member m) {
        return "get 요청: "
                + m.getId() + ","
                + m.getUsername() + ","
                + m.getPassword() + "," + m.getEmail();
    }

    // http://localhost:8000/blog/http/post
    @PostMapping("/http/post") // ex) text/plain, application/json
    public String postTest(@RequestBody Member m) { // MessageConverter(스프링부트)가 json을 java object로 mapping 해줌
        return "post 요청: "
                + m.getId() + ","
                + m.getUsername() + ","
                + m.getPassword() + "," + m.getEmail();
    }

    // http://localhost:8000/blog/http/put
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청: "
                + m.getId() + ","
                + m.getUsername() + ","
                + m.getPassword() + "," + m.getEmail();
    }

    // http://localhost:8000/blog/http/delete
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
