package LinQ.LinQ_BE.controller;

import LinQ.LinQ_BE.dto.ResponseDto;
import LinQ.LinQ_BE.dto.SignInDto;
import LinQ.LinQ_BE.dto.SignInResponseDto;
import LinQ.LinQ_BE.dto.SignUpDto;
import LinQ.LinQ_BE.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    @PostMapping("/signIn")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> result = authService.signIn(requestBody);
        return result;
    }
}
