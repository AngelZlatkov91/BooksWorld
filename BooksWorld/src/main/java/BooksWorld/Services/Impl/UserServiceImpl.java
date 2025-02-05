package BooksWorld.Services.Impl;
import BooksWorld.Event.UserRegisterEvent;
import BooksWorld.Models.DTO.UserRegistrationDTO;
import BooksWorld.Models.Entitys.User;
import BooksWorld.Repositories.UserRepository;
import BooksWorld.Services.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    private final ApplicationEventPublisher applicationEventPublisher;


    public  UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ApplicationEventPublisher applicationEventPublisher) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

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



    private User getUser(UserRegistrationDTO userRegistrationDTO) {
        return new User(userRegistrationDTO.getEmail(), userRegistrationDTO.getFullName(), passwordEncoder.encode(userRegistrationDTO.getPassword()));
    }

}
