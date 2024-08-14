package com.acl.proceso.request;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioRequest {	
		
		@NotNull
		@Min(value = 1, message = "El valor del Id, debe ser mayor que 0")
		private Long id;	
		
		private String nombre; 	
		private String username; 	
		private String password; 	
		private Integer edad; 	
		private Date fechaNacimiento;	
	
}
