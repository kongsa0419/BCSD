package service;

import domain.User;

public interface UserService {
    User getUserById(long id);

    long getIdByPwd(String pwd);

    long getIdByEmail(String email);

    int insertNewUser(User user);

    String logInValidation(User user);

    User getUserIfValid(String jwtValue);
}
