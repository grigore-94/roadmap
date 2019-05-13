package com.pen.roadmap.business;

import com.pen.roadmap.annotation.DefaultValue;
import com.pen.roadmap.annotation.RetryIfException;
import com.pen.roadmap.business.converter.UserConverter;
import com.pen.roadmap.business.dto.UserDto;
import com.pen.roadmap.exception.CustomException;
import com.pen.roadmap.repository.UserRepository;
import com.pen.roadmap.repository.entity.User;
import com.pen.roadmap.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserBusiness {
    private final UserConverter converter;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @DefaultValue("some string")
    private String someString;

    @RetryIfException(retry = 3)
    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, repository.findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(User user) {
        user.setEmail("ssss");
        if (!repository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        repository.deleteByUsername(username);
    }

    public User search(String username) {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public User whoami(HttpServletRequest req) {
        return repository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, repository.findByUsername(username).getRoles());
    }

    public List<UserDto> retrieve(Pageable pageable) {
        return repository
                .findAll(pageable)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> create(UserDto dto) {
        return Optional.of(repository.save(converter.reverse().convert(dto))).map(converter::convert);
    }

    public Optional<UserDto> get(long id) {
        return Optional.ofNullable(converter.convert(repository.findById(id).orElse(null)));
    }
}
