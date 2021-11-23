package com.sofka.firstcrudspringboot.repositories;

import com.sofka.firstcrudspringboot.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

}
