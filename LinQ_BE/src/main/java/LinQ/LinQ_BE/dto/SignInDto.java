package LinQ.LinQ_BE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    @NotBlank // 필수로 값이 오도록
    private String userEmail;
    @NotBlank
    private String userPassword;
}
