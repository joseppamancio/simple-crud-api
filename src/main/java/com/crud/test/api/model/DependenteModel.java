package com.crud.test.api.model;

import java.util.Date;

import com.crud.test.domain.model.EstadoCivil;
import com.crud.test.domain.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DependenteModel {

	private Long id;
	private String nome;
	private Integer idade;
	private Date dataNascimento;
	private EstadoCivil estadoCivil;
	private Pessoa pessoa;
}
