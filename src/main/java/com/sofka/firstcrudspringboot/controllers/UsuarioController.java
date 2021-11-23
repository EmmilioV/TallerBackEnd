package com.sofka.firstcrudspringboot.controllers;

import com.sofka.firstcrudspringboot.models.UsuarioModel;
import com.sofka.firstcrudspringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public Object guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }


    @GetMapping(path = "/{id}")
    public Object obtenerUsuarioPorId(@PathVariable("id") Long id){
        Optional<UsuarioModel> usuarioModel = this.usuarioService.obtenerPorId(id);
        if(usuarioModel.isEmpty())
            return "El usuario con el id " + id + " no está registrado en la base de datos";
        else
            return usuarioModel;
    }

    /*@GetMapping(path = "/{email}")
    public Object obtenerUsuarioPorEmail(@PathVariable("email") String email){
        Optional<UsuarioModel> usuarioModel = this.usuarioService.obtenerPorEmail(email);
        if(usuarioModel.isEmpty())
            return "El usuario con el email " + email + " no está registrado en la base de datos";
        else
            return usuarioModel;
    }*/

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String borrarUsuarioPorId(@PathVariable("id") Long id){
        boolean borrado = this.usuarioService.borrarPorId(id);
        if(borrado)
            return  "El usuario con id " + id +" ha sido borrado";
        else
            return  "Ha ocurrido un problema al borrar al usuario con id " + id;
    }
}
