package com.acl.proceso.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acl.proceso.request.UsuarioRequest;
import com.acl.proceso.response.UsuarioResponse;
import com.acl.proceso.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/todos")
    public ArrayList<UsuarioResponse> todos() {
		log.info("Responde todos los registros ");
		
		return  usuarioService.findAll() ;
		
	}
	
	@Operation(summary = "Graba un registro en la BD", description = "Unos datos se insertan en la bd, nombre tabla")	
	@PostMapping("/ingreso")
    public ResponseEntity<UsuarioResponse> ingreso(@Valid @RequestBody UsuarioRequest tabla)  {
		log.info("Ingreso el registro en la BD");
		UsuarioResponse tablaResponse =usuarioService.ingreso(tabla);
		return new ResponseEntity<>(tablaResponse, HttpStatus.CREATED);
       
	}
	
	@Operation(summary = "busca un registro en la BD", description = "Unos datos se insertan en la bd, nombre Usuario")	
	@PutMapping("/buscar/{id}")
    public ResponseEntity<UsuarioResponse> buscar(@PathVariable Long id)  {
		log.debug("Ingreso el registro en la BD");
		UsuarioResponse tablaResponse =usuarioService.buscar(id);
		return new ResponseEntity<>(tablaResponse, HttpStatus.OK);
       
	}
	
	@Operation(summary = "busca un registro en la BD", description = "Unos datos se insertan en la bd, nombre Usuario")	
	@DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id)  {
		log.debug("Ingreso el registro en la BD");
		usuarioService.eliminar(id);
		return "Se ha eliminado el usuario con el id igual a " + id;
       
	}
	

}
