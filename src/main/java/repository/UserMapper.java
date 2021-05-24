package repository;

import domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserById(long id);

    long getIdByEmail(String email);

    long getIdByPwd(String pwd);

    int insertNewUser(User user);
}
