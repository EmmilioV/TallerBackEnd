package com.sofka.firstcrudspringboot.repositories;

import com.sofka.firstcrudspringboot.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
    public abstract Optional<UsuarioModel> findByEmail(String email);
}
