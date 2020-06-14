package br.com.empresa.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.bo.PatrimonioBO;
import br.com.empresa.entity.Patrimonio;
import br.com.empresa.entity.dto.PatrimonioDTO;
import br.com.empresa.repository.PatrimonioRepository;
import br.com.empresa.service.PatrimonioService;
import br.com.empresa.util.ConstanteUtils;

@Service
public class PatrimonioServiceImpl implements PatrimonioService {

	@Autowired
	private PatrimonioRepository repository;

	@Resource
	private PatrimonioBO bo;

	@Override
	public List<PatrimonioDTO> listarTodos() {
		Iterable<Patrimonio> listaPatrimonios = repository.findAll();

		return listaPatrimonios != null 
				? bo.converterListaPatrimonioParaDTO((List<Patrimonio>) listaPatrimonios) : null;
	}

	@Override
	public PatrimonioDTO buscarPatrimonioPorId(Long idPatrimonio) {
		Optional<Patrimonio> patrimonioOpt = null;

		if (idPatrimonio != null && idPatrimonio > ConstanteUtils.MENOR_ID_BD_VALIDO) {
			patrimonioOpt = repository.findById(idPatrimonio);
		}

		return patrimonioOpt.isPresent() ? bo.converterPatrimonioParaDTO(patrimonioOpt.get()) : null;
	}

	@Override
	public PatrimonioDTO inserir(PatrimonioDTO patrimonioDTO) {
		Patrimonio patrimonio = bo.converterDTOParaPatrimonio(patrimonioDTO);
		
		Long ultimoNumeroTombo = repository.buscarUltimoNumeroTombo();
		
		if (ultimoNumeroTombo != null) {
			patrimonio.setNumeroTombo(Long.sum(ultimoNumeroTombo, BigInteger.ONE.longValue()));
		} else {
			patrimonio = null;
		}
		
		return patrimonio != null ? bo.converterPatrimonioParaDTO(repository.save(patrimonio)) : null;
	}
	
	@Override
	public PatrimonioDTO alterar(Long id, PatrimonioDTO patrimonioDTO) {
		PatrimonioDTO patrimonioAtualDTO = buscarPatrimonioPorId(id);
		
		patrimonioDTO = bo.obterAlteracoesDTO(patrimonioAtualDTO, patrimonioDTO);
		
		if(patrimonioDTO != null) {
			Patrimonio patrimonio = bo.converterDTOParaPatrimonio(patrimonioDTO);
			patrimonio.setId(id);
			
			patrimonioDTO = bo.converterPatrimonioParaDTO(repository.save(patrimonio));
		}
		
		return patrimonioDTO;
	}

	@Override
	public String excluir(Long id) {
		String msg = "Patrimônio não excluído.";
		
		if(buscarPatrimonioPorId(id) != null) {
			repository.deleteById(id);
			
			msg = "Patrimônio excluído com sucesso.";
		}
		
		return msg;
	}

}
