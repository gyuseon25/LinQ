package LinQ.LinQ_BE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // view와 controller 레이어 사이에 dto라는 객체 만들어 전달, 이 dto는 뷰에서 컨트롤러
public class SignUpDto {
    private String userEmail;
    private String userPassword;
    private String userPasswordCheck;
    private String userNickname;
    private String userPhoneNumber;
    private String userAddress;
    private String userAddressDetail;
}
