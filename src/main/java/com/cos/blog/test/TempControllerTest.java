package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// controller라는 annotation 이 붙으면 파일 을 return 한다
public class TempControllerTest {



    @GetMapping("/temp/jsp")
    public String tempJsp() {
        // jasper가 자동으로 폴더구조를 webapp으로 설정함
        return "test";
    }
}
