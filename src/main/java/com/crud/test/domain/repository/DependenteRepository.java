package com.crud.test.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.test.domain.model.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long>{
	
	List<Dependente> findByNomeContaining(String nome);

}
