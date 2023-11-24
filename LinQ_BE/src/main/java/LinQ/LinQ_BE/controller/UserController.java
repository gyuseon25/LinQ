package LinQ.LinQ_BE.controller;

import LinQ.LinQ_BE.dto.PatchUserDto;
import LinQ.LinQ_BE.dto.PatchUserResponseDto;
import LinQ.LinQ_BE.dto.ResponseDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @PatchMapping("/")
    public ResponseDto<PatchUserResponseDto> patchUser(@RequestBody PatchUserDto requestBody, @AuthenticationPrincipal String userEmail) {
        return null;
    }
}
