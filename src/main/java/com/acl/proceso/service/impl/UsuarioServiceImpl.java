package com.acl.proceso.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acl.proceso.entity.Usuario;
import com.acl.proceso.repository.UsuarioRepositorio;
import com.acl.proceso.request.UsuarioRequest;
import com.acl.proceso.response.UsuarioResponse;
import com.acl.proceso.service.UsuarioService;
import com.acl.proceso.util.FormatFecha;


@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private  Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	UsuarioRepositorio usuarioRepositorio;		
	
	
	public ArrayList<UsuarioResponse> findAll() {
		
		ArrayList<Usuario> user =  usuarioRepositorio.findAll();
		ArrayList<UsuarioResponse> lisResp= new ArrayList<UsuarioResponse>();
		
		for (Usuario obj: user) {
		      
			lisResp.add(cambiarUsuarioResponse(obj));
		    }
		
		return lisResp;
	}
	
	
	@Override
	@Transactional
	public UsuarioResponse ingreso(UsuarioRequest tablaRequest)  {
		UsuarioResponse response = null;
		try {
			UsuarioResponse resp = null;
			
			Optional<Usuario> usr =usuarioRepositorio.findById(tablaRequest.getId());
			if(usr.isEmpty()) {
				log.info("Registo Vacia, se ingresa el registro");
				resp = grabarTabla(tablaRequest);				
				
			}else {
				log.info("Registro encontrado, se actualiza información, segun el id encontrado");				
				resp = actualizarTabla(usr, tablaRequest);
			}
			
			 response =new UsuarioResponse(
					 resp.getId(),
					 resp.getNombre(),
					 resp.getUsername(),
					 resp.getPassword(),
					 resp.getEdad(),
					 resp.getFechaNacimiento()
					 );
			
		} catch (DataAccessException ex) {
        	log.error(ex.getCause().getMessage());
        }		
		return response;
		
	}
	
	@Override
	@Transactional
	public UsuarioResponse grabarTabla(UsuarioRequest request) {
		
		Usuario tabla = Usuario.builder()
				.id(request.getId())
				.nombre(request.getNombre())
				.username(request.getUsername())
				.password(request.getPassword())
				.edad(request.getEdad())
				.fechaNacimiento(request.getFechaNacimiento())
				.build();
		
		Usuario resp =usuarioRepositorio.save(tabla);
		
		return cambiarUsuarioResponse(resp);
	}
	
	@Override
	@Transactional
	public UsuarioResponse actualizarTabla(Optional<Usuario> tabla, UsuarioRequest request) {
		
		Usuario updateTabla = Usuario.builder()
				.nombre(request.getNombre())
				.username(request.getUsername())
				.password(request.getPassword())
				.edad(request.getEdad())
				.fechaNacimiento(request.getFechaNacimiento())
				.build();
		
		Usuario resp = usuarioRepositorio.save(updateTabla);
		return cambiarUsuarioResponse(resp);
	}
	
	@Override
	public UsuarioResponse buscar(Long id)  {
		
		UsuarioResponse response = new UsuarioResponse();
		try {
			
			Optional<Usuario> usr =usuarioRepositorio.findById(id);
			
			
			response = UsuarioResponse.builder()
					.id(usr.get().getId())
					.username(usr.get().getUsername())
					.password(usr.get().getPassword())
					.nombre(usr.get().getNombre())
					.edad(usr.get().getEdad())
					.fechaNacimiento(FormatFecha.convertirfechaToString(usr.get().getFechaNacimiento()))
					.build();
			
		} catch (DataAccessException ex) {
        	log.error(ex.getCause().getMessage());
        }		
		return response;
	}
	
	@Override
	@Transactional
	public String eliminar(Long id)  {
		
		try {
			Optional<Usuario> usr =usuarioRepositorio.findById(id);
			usuarioRepositorio.deleteById(id);		
		} catch (DataAccessException ex) {
        	log.error(ex.getCause().getMessage());
        }		
		return "se elimino correctamente el registro";
		
	}
	
	
	private UsuarioResponse cambiarUsuarioResponse(Usuario user){
		
		UsuarioResponse resp =new UsuarioResponse(
			user.getId(),
			user.getNombre(),
			user.getUsername(),
			user.getPassword(),
			user.getEdad(),
			FormatFecha.convertirfechaToString(user.getFechaNacimiento())
		);
		
		return resp;
	}
	
}


