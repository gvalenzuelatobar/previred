package com.move.proceso.dto;

import lombok.Data;

public class UsuarioDTO {

	@Data
	public class ErrorDTO {
		
		private Long code;
		private String mensaje;
	}
}
