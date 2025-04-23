package com.example.onepot.controller;


import com.example.onepot.dto.LoginRequestDTO;
import com.example.onepot.dto.RegisterRequestDTO;
import com.example.onepot.dto.ResponseDTO;
import com.example.onepot.entities.User.Role;
import com.example.onepot.entities.User.User;
import com.example.onepot.infra.security.TokenService;
import com.example.onepot.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;



    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches( body.password(), user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return  ResponseEntity.ok(new ResponseDTO(user.getUsername(), token));

        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {

        Optional<User> user = this.repository.findByEmail(body.email());
        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setUsername(body.username());
            newUser.setSecondname(body.secondname());
            newUser.setCpf(body.cpf());
            newUser.setRole(Role.CLIENTE);
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getUsername(), token));
        }

        return ResponseEntity.badRequest().build();
    }

}
