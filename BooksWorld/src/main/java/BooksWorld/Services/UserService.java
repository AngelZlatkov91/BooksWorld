package BooksWorld.Services;


import BooksWorld.Models.DTO.LoginUserDTO;
import BooksWorld.Models.DTO.UserRegistrationDTO;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO) throws Exception;


    String login(LoginUserDTO loginUserDTO) throws Exception;

}
