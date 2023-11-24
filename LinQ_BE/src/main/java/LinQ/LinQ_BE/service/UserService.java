package LinQ.LinQ_BE.service;

import LinQ.LinQ_BE.dto.PatchUserDto;
import LinQ.LinQ_BE.dto.PatchUserResponseDto;
import LinQ.LinQ_BE.dto.ResponseDto;
import LinQ.LinQ_BE.entity.UserEntity;
import LinQ.LinQ_BE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseDto<PatchUserResponseDto> patchUser(PatchUserDto dto, String userEmail) {
        UserEntity userEntity = null;
        String userNickname = dto.getUserNickname();
        String userProfile = dto.getUserProfile();

        try {
            userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                ResponseDto.setFailed("Does Not Exist User");

            userEntity.setUserNickname(userNickname);
            userEntity.setUserProfile(userProfile);

            userRepository.save(userEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed("Database Error");
        }
        userEntity.setUserPassword("");

        PatchUserResponseDto patchUserResponseDto = new PatchUserResponseDto(userEntity);


        return ResponseDto.setSuccess("Success", patchUserResponseDto);
    }
}
