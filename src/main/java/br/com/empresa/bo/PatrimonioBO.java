package br.com.empresa.bo;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.empresa.entity.Marca;
import br.com.empresa.entity.Patrimonio;
import br.com.empresa.entity.dto.PatrimonioDTO;
import br.com.empresa.repository.MarcaRepository;
import br.com.empresa.util.ConstanteUtils;

@Service
public class PatrimonioBO {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MarcaRepository marcaRepository;
	
	public List<PatrimonioDTO> converterListaPatrimonioParaDTO(List<Patrimonio> listaPatrimonios) {
		List<PatrimonioDTO> listaPatrimoniosDTO = null;

		if (!CollectionUtils.isEmpty(listaPatrimonios)) {
			Type listType = new TypeToken<List<PatrimonioDTO>>() {}.getType();
			listaPatrimoniosDTO = modelMapper.map(listaPatrimonios, listType);
		}

		return listaPatrimoniosDTO;
	}

	public PatrimonioDTO converterPatrimonioParaDTO(Patrimonio patrimonio) {
		return patrimonio != null ? modelMapper.map(patrimonio, PatrimonioDTO.class) : null;
	}

	public Patrimonio converterDTOParaPatrimonio(PatrimonioDTO patrimonioDTO) {
		Patrimonio patrimonio = null;
		Marca marca = validarPatrimonioObterMarca(patrimonioDTO);
		
		if(marca != null) {
			patrimonio = modelMapper.map(patrimonioDTO, Patrimonio.class);
			patrimonio.setMarca(marca);
		}
		
		return patrimonio;
	}

	private Marca validarPatrimonioObterMarca(PatrimonioDTO patrimonioDTO) {
		Optional<Marca> marcaOpt = null;
		
		if (patrimonioDTO != null && patrimonioDTO.getNome() != null && (patrimonioDTO.getMarcaId() != null
				&& patrimonioDTO.getMarcaId() > ConstanteUtils.MENOR_ID_BD_VALIDO)) {
			marcaOpt = marcaRepository.findById(patrimonioDTO.getMarcaId());
		}
		
		return marcaOpt != null ? marcaOpt.get() : null;
	}

	public PatrimonioDTO obterAlteracoesDTO(PatrimonioDTO patrimonioAtualDTO, PatrimonioDTO patrimonioAlteradoDTO) {
		
		if(patrimonioAtualDTO != null && patrimonioAlteradoDTO != null) {
			if(patrimonioAlteradoDTO.getNome() != null && !patrimonioAlteradoDTO.getNome().trim().isEmpty()) {
				patrimonioAtualDTO.setNome(patrimonioAlteradoDTO.getNome());
			}
			
			if(patrimonioAlteradoDTO.getDescricao() != null && !patrimonioAlteradoDTO.getDescricao().trim().isEmpty()) {
				patrimonioAtualDTO.setDescricao(patrimonioAlteradoDTO.getDescricao());
			}
			
			if(patrimonioAlteradoDTO.getMarcaId() != null) {
				Marca marca = validarPatrimonioObterMarca(patrimonioAlteradoDTO);
				
				if(marca != null) {
					patrimonioAtualDTO.setMarcaId(marca.getId());
				} else {
					patrimonioAtualDTO = null;
				}
			}
		}
		
		return patrimonioAtualDTO;
	}

}
