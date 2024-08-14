package com.move.proceso.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.move.proceso.entity.Usuario;
import com.move.proceso.request.UsuarioRequest;
import com.move.proceso.response.UsuarioResponse;


@Service

public interface UsuarioService{
	
	
	public ArrayList<UsuarioResponse> findAll();
	
	public UsuarioResponse ingreso(UsuarioRequest tablaRequest) ;
	
	public UsuarioResponse grabarTabla(UsuarioRequest tablaRequest);
	
	public UsuarioResponse actualizarTabla(Optional<Usuario> tabla, UsuarioRequest tablaRequest);
	
	public UsuarioResponse buscar(Long id) ;
	
	public String eliminar(Long id) ;
}


