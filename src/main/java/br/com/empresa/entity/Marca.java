package br.com.empresa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "marca", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Patrimonio> patrimonios;

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

	public Set<Patrimonio> getPatrimonios() {
		return patrimonios;
	}

	public void setPatrimonios(Set<Patrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}

}