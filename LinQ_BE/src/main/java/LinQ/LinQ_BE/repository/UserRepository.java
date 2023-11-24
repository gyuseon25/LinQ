package LinQ.LinQ_BE.repository;

import LinQ.LinQ_BE.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {//UserEntity를 매개체로 db와 통신하겠다, 뒤에는 기본키타입

    public boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);

    public UserEntity findByUserEmail(String userEmail);
}
