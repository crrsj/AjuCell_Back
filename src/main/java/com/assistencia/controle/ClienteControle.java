package com.assistencia.controle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assistencia.dto.ClienteDto;
import com.assistencia.servico.ClienteServico;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("celular")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClienteControle {
	
	private final ClienteServico servico;
	
	@PostMapping("adicionar")
	public ResponseEntity<ClienteDto>cadastrarCelular(@RequestBody @Valid ClienteDto cadastro){
		var cadastre = servico.cadastrarCelular(cadastro);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("celular/adicionar/{id}")
		.buildAndExpand(cadastre.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cadastre));
		
	}
	
	@GetMapping("lista")
	public ResponseEntity<List<ClienteDto>>listar(){
		var lista = servico.Listar().stream().map(ClienteDto::new).toList();
		return ResponseEntity.ok(lista);
				
				
	}		
	
	@GetMapping("busca/{id}")
	public ResponseEntity<?>buscarId(@PathVariable Long id)	{
		var busca = servico.BuscarPorId(id);
		return  ResponseEntity.ok(busca);
	}
	
	@PutMapping("editar")
	public ResponseEntity<ClienteDto>atualizar(@RequestBody @Valid ClienteDto atualizar){		
		var atualize = servico.atualizar(atualizar);
		return ResponseEntity.ok().body(new ClienteDto(atualize));
			
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<ClienteDto>excluir(@PathVariable Long id){
		servico.excluir(id);
		return ResponseEntity.noContent().build();
	}
				
	 @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
           Map<String, String> errors = new HashMap<>();
           ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);


    }
 
}		
				
				
				
				
	


