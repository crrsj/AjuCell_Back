package com.assistencia.servico;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assistencia.dto.ClienteDto;
import com.assistencia.entidade.Cliente;
import com.assistencia.repositorio.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServico {
	
	private final ClienteRepositorio repositorio;
	
	
	public Cliente cadastrarCelular(ClienteDto cliente) {
		var cadastrar = new Cliente(cliente);
		repositorio.save(cadastrar);
		return cadastrar;
	}
	
	public List<Cliente>Listar(){
		return repositorio.findAll();
	}
   
	public Cliente BuscarPorId(Long id) {
		Optional<Cliente>buscar = repositorio.findById(id);
		return buscar.orElseThrow( NoSuchElementException::new);
	}
	public Cliente atualizar(ClienteDto cliente) {
		var cadastrar = new Cliente(cliente);
		if(cadastrar.getId()== null) {
			throw new NoSuchElementException();
		}
		repositorio.save(cadastrar);
		return cadastrar;
	}
	
	public void excluir(Long id) {
		repositorio.deleteById(id);
	}
}
