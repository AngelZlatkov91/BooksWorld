package BooksWorld.Models.DTO;

public class UserRegistrationDTO {

    private String email;

    private String fullName;

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
}
