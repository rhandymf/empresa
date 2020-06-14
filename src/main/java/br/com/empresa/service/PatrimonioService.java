package br.com.empresa.service;

import java.util.List;

import br.com.empresa.entity.dto.PatrimonioDTO;

public interface PatrimonioService {
	
	public List<PatrimonioDTO> listarTodos();

	public PatrimonioDTO buscarPatrimonioPorId(Long idPatrimonio);

	public PatrimonioDTO inserir(PatrimonioDTO patrimonio);

	public PatrimonioDTO alterar(Long id, PatrimonioDTO patrimonio);

	public String excluir(Long id);
	
}
