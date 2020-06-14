package br.com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.empresa.entity.Patrimonio;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long>{

	@Query(value = "SELECT MAX(numero_tombo) FROM patrimonio", nativeQuery = true)
	Long buscarUltimoNumeroTombo();

}
