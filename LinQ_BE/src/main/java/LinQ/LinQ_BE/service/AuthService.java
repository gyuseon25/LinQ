package LinQ.LinQ_BE.service;

import LinQ.LinQ_BE.dto.ResponseDto;
import LinQ.LinQ_BE.dto.SignInDto;
import LinQ.LinQ_BE.dto.SignInResponseDto;
import LinQ.LinQ_BE.dto.SignUpDto;
import LinQ.LinQ_BE.entity.UserEntity;
import LinQ.LinQ_BE.repository.UserRepository;
import LinQ.LinQ_BE.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service//서비스로 작동한다.
public class AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();


        try {
            // email 중복 확인 , 레포지토리 접근하는 것들은 try catch로
            if (userRepository.existsById(userEmail))
                return ResponseDto.setFailed("Existed Email!");
        } catch (Exception error) {
            return ResponseDto.setFailed("Data Base Error!");
        }

        //비밀번호가 서로 다르면 failed response 반환
        if (!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("Password does not matched!");

        //userEntity 생성
        UserEntity userEntity = new UserEntity(dto);

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userPassword);
        userEntity.setUserPassword(encodedPassword);

        try {
            //userRepository를 이용해서 데이터베이스에 Entity 저장!!
            userRepository.save(userEntity);
        } catch (Exception error) {
            return ResponseDto.setFailed("Data Base Error!");
        }

        //성공시 success response 반환
        return ResponseDto.setSuccess("SignUp Success!", null);
    }

    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        UserEntity userEntity = null;
        try {
            userEntity = userRepository.findByUserEmail(userEmail);
            // 잘못된 이메일
            if (userEntity == null)
                return ResponseDto.setFailed("Sign In Failed!");
            // 잘못된 패스워드
            if (!passwordEncoder.matches(userPassword, userEntity.getUserPassword()))
                return ResponseDto.setFailed("Sign In Failed!");
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }
        userEntity.setUserPassword("");

        String token = tokenProvider.create(userEmail);
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);
        return ResponseDto.setSuccess("Sign In Successs", signInResponseDto);
    }
}
