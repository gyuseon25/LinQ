package LinQ.LinQ_BE.dto;

import LinQ.LinQ_BE.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchUserResponseDto {

    private UserEntity user;
}
