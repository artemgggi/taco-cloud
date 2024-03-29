package artemgggi.tacocloud.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Users toUser(PasswordEncoder passwordEncoder) {
        return new Users(
                username, passwordEncoder.encode(password),
                name, phone);
    }
}
