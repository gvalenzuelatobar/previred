package com.move.proceso.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.move.proceso.entity.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
	
	public ArrayList<Usuario> findAll();
	
	
}
