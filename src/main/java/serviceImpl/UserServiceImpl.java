package serviceImpl;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserMapper;
import service.UserService;
import util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mUserMapper;
    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public User getUserById(long id) {
        return mUserMapper.getUserById(id);
    }

    @Override
    public long getIdByPwd(String pwd) {
        return mUserMapper.getIdByPwd(pwd);
    }

    @Override
    public long getIdByEmail(String email) {
        return mUserMapper.getIdByEmail(email);
    }

    @Override
    public int insertNewUser(User user) {
        System.out.println(user.getId()+"\n"+user.getEmail()+"\n"+user.getName()+"n"+user.getPassword());
        return mUserMapper.insertNewUser(user);
    }

    @Override
    public String logInValidation(User user) {
        String email = user.getEmail();
        String pwd = user.getPassword();
        try {
            if (email.isEmpty() || pwd.isEmpty()) {
                throw new Exception("email or password is empty.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            long id = mUserMapper.getIdByEmail(email);
            User temp = mUserMapper.getUserById(id);
            if(!pwd.equals(temp.getPassword())){
                throw new Exception("invalid Password!");
            }else{
                return jwtUtil.genJsonWebToken(Long.valueOf(temp.getId()));   /*jwt*/
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "login Faliure";
    }

    //jwtValue : BEARER ~~~~
    @Override
    public User getUserIfValid(String jwtValue) {
        long id = jwtUtil.getIdByParsingValidJwt(jwtValue);
        return mUserMapper.getUserById(id);
    }


}
