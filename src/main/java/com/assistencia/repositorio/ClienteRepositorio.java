package com.assistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assistencia.entidade.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
