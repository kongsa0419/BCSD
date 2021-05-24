package domain;

import lombok.Data;

@Data
public class User {

    private long id;
    private String name;
    private String email;
    private String password;

}
