package ThinkingInJava;

import java.util.List;

/**
 * Created by rarshion on 16/9/6.
 */
public class PasswordUtils {

    @UseCase(id = 47, description = "password must contain at least one")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "new password")
    public boolean checkForNewPassword(List<String> prevPassword, String password) {
        return true;
    }
}
