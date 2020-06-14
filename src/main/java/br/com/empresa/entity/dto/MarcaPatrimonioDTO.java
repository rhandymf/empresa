package br.com.empresa.entity.dto;

import java.util.Set;

public class MarcaPatrimonioDTO {
	
	private Long id;

	private String nome;
	
	Set<PatrimonioDTO> patrimonios;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<PatrimonioDTO> getPatrimonios() {
		return patrimonios;
	}

	public void setPatrimonios(Set<PatrimonioDTO> patrimonios) {
		this.patrimonios = patrimonios;
	}

}
