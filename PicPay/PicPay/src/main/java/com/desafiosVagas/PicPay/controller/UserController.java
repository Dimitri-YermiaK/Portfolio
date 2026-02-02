package com.desafiosVagas.PicPay.controller;

import com.desafiosVagas.PicPay.model.User;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desafiosVagas.PicPay.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<User> cadastrar(@RequestBody User user) {
        User saved = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") UUID id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> editar(
            @PathVariable UUID id,
            @RequestBody User user) {

        return userRepository.findById(id)
                .map(existingUser -> {

                    if (user.getName() != null) {
                        existingUser.setName(user.getName());
                    }

                    if (user.getGmail() != null) {
                        existingUser.setGmail(user.getGmail());
                    }

                    if (user.getCpf() != null) {
                        existingUser.setCpf(user.getCpf());
                    }

                    if (user.getPassword() != null) {
                        existingUser.setPassword(user.getPassword());
                    }

                    User saved = userRepository.save(existingUser);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> buscar(@PathVariable("id") UUID id){
        return userRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
}


}