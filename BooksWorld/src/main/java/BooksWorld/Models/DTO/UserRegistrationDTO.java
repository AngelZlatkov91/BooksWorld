package BooksWorld.Models.DTO;

import BooksWorld.Validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRegistrationDTO {

    @Email
    @NotEmpty
    @UniqueUserEmail
    private String email;

    @NotEmpty
    @Size(min = 3)
    private String fullName;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String password;


    public UserRegistrationDTO(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
