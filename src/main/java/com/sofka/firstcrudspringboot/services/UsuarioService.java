package com.sofka.firstcrudspringboot.services;

import com.sofka.firstcrudspringboot.models.UsuarioModel;
import com.sofka.firstcrudspringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario)
    {
        return usuarioRepository.save(usuario);
    }
}
