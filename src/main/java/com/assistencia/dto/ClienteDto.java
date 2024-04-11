package com.assistencia.dto;

import com.assistencia.entidade.Cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteDto(
		Long id,
		@NotBlank(message = "não pode estar em branco")
		String nome,
		@NotBlank(message = "não pode estar em branco")
		String fone,
		@NotBlank(message = "não pode estar em branco")
		String marca,
		@NotBlank(message = "não pode estar em branco")
		String modelo,
		@NotBlank(message = "não pode estar em branco")
		String cor,
		@NotBlank(message = "não pode estar em branco")
		String servico,
		
		double valor) {

	public ClienteDto(Cliente cadastre) {
		this(
				cadastre.getId(),
				cadastre.getNome(),
				cadastre.getFone(),cadastre.getMarca(),
				cadastre.getModelo(),
				cadastre.getCor(),
				cadastre.getServico(),
				cadastre.getValor());
	}

}
