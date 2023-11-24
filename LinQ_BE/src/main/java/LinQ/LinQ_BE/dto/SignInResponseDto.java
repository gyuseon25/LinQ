package LinQ.LinQ_BE.dto;

import LinQ.LinQ_BE.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 이 dto는 컨트롤러에서 뷰로
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {
    private String token;
    private int exprTime; // 유효시간
    private UserEntity user;
}
