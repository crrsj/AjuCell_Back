package com.assistencia.infra;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class MensagemDeErros{
	
	private HttpStatus status;
	private String mensagem;
}
