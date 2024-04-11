package com.assistencia.entidade;

import com.assistencia.dto.ClienteDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String fone;
	private String marca;
	private String modelo;	
	private String cor;
	@Column(columnDefinition = "TEXT")
	private String servico;
	private double valor;
	
	public Cliente(ClienteDto cliente) {
	 this.id = cliente.id();
	 this.nome = cliente.nome();
	 this.fone = cliente.fone();
	 this.marca = cliente.marca();
	 this.modelo = cliente.modelo();
	 this.cor = cliente.cor();
	 this.servico = cliente.servico();
	 this.valor = cliente.valor();
	}

}
