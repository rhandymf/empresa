package br.com.empresa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.entity.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long>{

	@Query("select m from Marca m where m.nome like %?1%")
	Marca findMarcaByNome(String nome);

}
