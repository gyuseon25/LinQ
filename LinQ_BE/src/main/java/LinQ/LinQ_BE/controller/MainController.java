package LinQ.LinQ_BE.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "http://localhost:3000") // 이 패턴 허용하겠다.
@RestController
@RequestMapping("/") // 슬래시는 패턴 아무것도 존재 안한다는 뜻인듯?
public class MainController {

    @GetMapping("")
    public String hello(){
        return "Connection Successful";
    }
}
