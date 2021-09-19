package br.com.alura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	Page<Topico> findByCurso_Nome(String nomeCurso, Pageable paginacao );
	
	//outra opção:
	//@Query("SELECT t FROM topico t WHERE t.curso.nome = :nomeCurso")
	//List<Topico> escolhaNome(@Param("nomeCurso") String nomeCurso);

}
