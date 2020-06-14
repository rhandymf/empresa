package br.com.empresa.entity.dto;

public class PatrimonioDTO {
	
	private Long id;

	private String nome;
	
	private String descricao;
	
	private Long numeroTombo;
	
	private Long marcaId;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getNumeroTombo() {
		return numeroTombo;
	}

	public void setNumeroTombo(Long numeroTombo) {
		this.numeroTombo = numeroTombo;
	}

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

}
