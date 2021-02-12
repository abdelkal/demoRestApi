package be.unit.demo.security.service;

import be.unit.demo.entity.User;
import be.unit.demo.repository.UserRepository;
import be.unit.demo.security.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;



    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ username));

        return user.map(UserPrincipal::new).get();

    }
}
