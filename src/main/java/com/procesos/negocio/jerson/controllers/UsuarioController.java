package com.procesos.negocio.jerson.controllers;

import com.procesos.negocio.jerson.models.Usuario;
import com.procesos.negocio.jerson.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity getUsuario(@PathVariable Long id){
        return usuarioService.getUserById(id);
    }

    @PostMapping("/usuario")
    public ResponseEntity crearUsuario(@Valid @RequestBody  Usuario usuario){
        return usuarioService.createUser(usuario);
    }

    @GetMapping("/usuarios")
    public ResponseEntity listarUsuarios(){
        return usuarioService.allUsers();
    }

    @GetMapping("/usuario/{nombre}/{apellidos}")
    public ResponseEntity listarPorNombreApellidos(@PathVariable String nombre, @PathVariable String apellidos){
        return usuarioService.allUsersByNameAndLastName(nombre, apellidos);
    }

    @GetMapping("/usuario/apellidos/{apellidos}")
    public ResponseEntity listarPorApellidos(@PathVariable String apellidos){
        return usuarioService.allUsersByLastName(apellidos);
    }

    @GetMapping("/usuario/nombre/{nombre}")
    public ResponseEntity listarPorNombre(@PathVariable String nombre){
        return usuarioService.allUsersByName(nombre);
    }
    @PutMapping("/usuario/{id}")
    public ResponseEntity editarUsuario(@PathVariable Long id,
                                        @Valid @RequestBody Usuario usuario){
        return usuarioService.editUser(id, usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable Long id){
        return usuarioService.deleteUserById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}









