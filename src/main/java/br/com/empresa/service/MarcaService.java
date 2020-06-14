package br.com.empresa.service;

import java.util.List;

import br.com.empresa.entity.dto.MarcaDTO;
import br.com.empresa.entity.dto.MarcaPatrimonioDTO;

public interface MarcaService {
	
	public List<MarcaDTO> listarTodos();

	public MarcaDTO buscarMarcaPorId(Long idMarca);

	public MarcaDTO inserir(MarcaDTO marca);

	public MarcaDTO alterar(Long id, MarcaDTO marca);

	public String excluir(Long id);

	public MarcaPatrimonioDTO buscarPatrimoniosPorIdMarca(Long id);
	
}
