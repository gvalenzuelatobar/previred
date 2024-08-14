package com.acl.proceso.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
	
	private Long id;
	private String nombre; 	
	private String username; 	
	private String password; 	
	private Integer edad; 	
	private String fechaNacimiento;	
}
