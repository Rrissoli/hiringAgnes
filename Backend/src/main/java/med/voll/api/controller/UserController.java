package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.UserDTOS.Login;
import med.voll.api.dtos.UserDTOS.Registese;
import med.voll.api.services.Usuario.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserAccountService service;
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid Registese registese) {
        try {
            service.register(registese);
            return new ResponseEntity<>("Usuário registrado com sucesso!", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid Login login) {
        try {
            return new ResponseEntity<>(service.Login(login), HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
