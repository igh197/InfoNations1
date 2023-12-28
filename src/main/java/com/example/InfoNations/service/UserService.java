package com.example.InfoNations.service;

import com.example.InfoNations.entity.User;
import com.example.InfoNations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(User.builder()
                        .username(user.getUsername())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .email(user.getEmail())
                        .auth("USER")

                .build());
    }

    public User getUser(Long id) {
        return userRepository.findUserById(id);
    }

    public User putUser(User user, Long id) {
        User newUser = userRepository.findUserById(id);
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        userRepository.save(newUser);
        return newUser;
    }

    public void delUser(Long id) {
        userRepository.deleteById(id);
    }
}
