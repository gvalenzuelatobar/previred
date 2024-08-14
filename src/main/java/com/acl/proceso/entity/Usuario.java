package com.acl.proceso.entity;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {
	
		
		@Id	
		@Column(name = "ID")
		@GeneratedValue(strategy =GenerationType.AUTO)
		private Long id;
		
		
		@Column(name = "NOMBRE")
	    private String nombre; 
		
		@Column(name = "USERNAME")
	    private String username; 
		
		@Column(name = "PASSWORD")
	    private String password; 
		
		@Column(name = "EDAD")
	    private Integer edad; 
		
		@Column(name = "FECHA_NACIMIENTO")
	    private Date fechaNacimiento;	

}
