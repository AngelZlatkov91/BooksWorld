package BooksWorld.Services.Impl;
import BooksWorld.Event.UserRegisterEvent;
import BooksWorld.Models.DTO.LoginUserDTO;
import BooksWorld.Models.DTO.UserRegistrationDTO;
import BooksWorld.Models.Entitys.User;
import BooksWorld.Repositories.UserRepository;
import BooksWorld.Services.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final ApplicationEventPublisher applicationEventPublisher;


    public  UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, ApplicationEventPublisher applicationEventPublisher) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.applicationEventPublisher = applicationEventPublisher;
    }
    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) throws Exception {

      try {
          userRepository.save(getUser(userRegistrationDTO));
          applicationEventPublisher.publishEvent(new UserRegisterEvent("UserService",
                  userRegistrationDTO.getEmail(), userRegistrationDTO.getFullName()));

      } catch (Exception ex) {
          throw  new Exception("Error something is wrong");
      }


    }

    @Override
    public String login(LoginUserDTO loginUserDTO) throws Exception {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(),loginUserDTO.getPassword()));
            return "dummy-jwt-token";
        } catch (AuthenticationException e ) {
            throw new Exception("invalid email or password");
        }

    }

    private User getUser(UserRegistrationDTO userRegistrationDTO) {
        return new User(userRegistrationDTO.getEmail(), userRegistrationDTO.getFullName(), passwordEncoder.encode(userRegistrationDTO.getPassword()));
    }

}
