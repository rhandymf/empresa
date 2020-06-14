package br.com.empresa.bo;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.empresa.entity.Marca;
import br.com.empresa.entity.dto.MarcaDTO;
import br.com.empresa.entity.dto.MarcaPatrimonioDTO;

@Service
public class MarcaBO {

	@Autowired
	private ModelMapper modelMapper;
	
	public List<MarcaDTO> converterListaMarcaParaDTO(List<Marca> listaMarcas) {
		List<MarcaDTO> listaMarcasDTO = null;

		if (!CollectionUtils.isEmpty(listaMarcas)) {
			Type listType = new TypeToken<List<MarcaDTO>>() {}.getType();
			listaMarcasDTO = modelMapper.map(listaMarcas, listType);
		}

		return listaMarcasDTO;
	}
	
	public MarcaPatrimonioDTO converteMarcaPatrimonioDTO(Marca marca) {
		MarcaPatrimonioDTO marcaPatrimonioDTO = null;
		
		if (marca != null) {
			marcaPatrimonioDTO = modelMapper.map(marca, MarcaPatrimonioDTO.class);
		}
		
		return marcaPatrimonioDTO;
	}

	public MarcaDTO converterMarcaParaDTO(Marca marca) {
		return marca != null ? modelMapper.map(marca, MarcaDTO.class) : null;
	}

	public Marca converterDTOParaMarca(MarcaDTO marcaDTO) {
		Marca marca = null;
		
		if(marcaDTO != null && marcaDTO.getNome() != null) {
			marca = modelMapper.map(marcaDTO, Marca.class);
		}
		
		return marca;
	}

}
