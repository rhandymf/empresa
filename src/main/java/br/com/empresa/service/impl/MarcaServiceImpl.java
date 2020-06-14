package br.com.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.bo.MarcaBO;
import br.com.empresa.entity.Marca;
import br.com.empresa.entity.dto.MarcaDTO;
import br.com.empresa.entity.dto.MarcaPatrimonioDTO;
import br.com.empresa.repository.MarcaRepository;
import br.com.empresa.service.MarcaService;
import br.com.empresa.util.ConstanteUtils;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository repository;

	@Resource
	private MarcaBO bo;

	@Override
	public List<MarcaDTO> listarTodos() {
		Iterable<Marca> listaMarcas = repository.findAll();

		return listaMarcas != null 
				? bo.converterListaMarcaParaDTO((List<Marca>) listaMarcas) : null;
	}

	@Override
	public MarcaDTO buscarMarcaPorId(Long idMarca) {
		Optional<Marca> marcaOpt = null;

		if (idMarca != null && idMarca > ConstanteUtils.MENOR_ID_BD_VALIDO) {
			marcaOpt = repository.findById(idMarca);
		}

		return marcaOpt.isPresent() ? bo.converterMarcaParaDTO(marcaOpt.get()) : null;
	}

	@Override
	public MarcaDTO inserir(MarcaDTO marcaDTO) {
		Marca marca = bo.converterDTOParaMarca(marcaDTO);
		
		return marca != null && isMarcaValida(marcaDTO, bo.converterMarcaParaDTO(marca))
				? bo.converterMarcaParaDTO(repository.save(marca)): null;
	}
	
	@Override
	public MarcaDTO alterar(Long id, MarcaDTO marcaDTO) {
		MarcaDTO marcaAtualDTO = buscarMarcaPorId(id);
		
		if (isMarcaValida(marcaDTO, marcaAtualDTO)) {
			Marca marca = bo.converterDTOParaMarca(marcaDTO);
			marca.setId(id);
			
			marcaDTO = bo.converterMarcaParaDTO(repository.save(marca));
		} else {
			marcaDTO = null;
		}
		
		return marcaDTO;
	}

	private boolean isMarcaValida(MarcaDTO marcaDTO, MarcaDTO marcaAtualDTO) {
		return marcaDTO != null && marcaDTO.getNome() != null && !marcaDTO.getNome().trim().isEmpty()
				&& marcaAtualDTO != null && repository.findMarcaByNome(marcaDTO.getNome().trim()) == null;
	}

	@Override
	public String excluir(Long id) {
		String msg = "Marca não excluída.";
		
		if(repository.findById(id) != null) {
			repository.deleteById(id);
			
			msg = "Marca excluída com sucesso.";
		}
		
		return msg;
	}

	@Override
	public MarcaPatrimonioDTO buscarPatrimoniosPorIdMarca(Long idMarca) {
		Optional<Marca> marcaOpt = null;

		if (idMarca != null && idMarca > ConstanteUtils.MENOR_ID_BD_VALIDO) {
			marcaOpt = repository.findById(idMarca);
		}
		
		return marcaOpt.isPresent() ? bo.converteMarcaPatrimonioDTO(marcaOpt.get()) : null;
	}

}
