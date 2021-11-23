package com.sofka.firstcrudspringboot.services;

import com.sofka.firstcrudspringboot.models.UsuarioModel;
import com.sofka.firstcrudspringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public Object guardarUsuario(UsuarioModel usuario)
    {
        if(usuarioRepository.findByEmail(usuario.getEmail()).isEmpty())
            return usuarioRepository.save(usuario);
        else
            return "Ya existe un usuario con este correo";
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel> obtenerPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean borrarPorId(Long id){
        try
        {
            usuarioRepository.deleteById(id);
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }
}
