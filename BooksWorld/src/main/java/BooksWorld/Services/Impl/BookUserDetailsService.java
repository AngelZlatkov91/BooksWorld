package BooksWorld.Services.Impl;

import BooksWorld.Models.Entitys.User;
import BooksWorld.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookUserDetailsService implements UserDetailsService {

   private final UserRepository userRepository;

    public BookUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       Optional<User> user = userRepository.findByEmail(email);
       if (user.isEmpty()) {
           throw new UsernameNotFoundException("User not found with " + email);
       }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.get().getEmail())
                .password(user.get().getPassword())
                .build();
    }

}
