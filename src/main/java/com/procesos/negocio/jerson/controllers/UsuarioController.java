package com.procesos.negocio.jerson.controllers;

import com.procesos.negocio.jerson.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UsuarioController {

    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Jerson");
        usuario.setApellidos("garcia");
        usuario.setDocumento("12345678");
        usuario.setDireccion("ssssss");
        usuario.setFechaNacimiento(new Date(2020,12,01));
        usuario.setTelefono("22222222");
        return usuario;
    }
}
