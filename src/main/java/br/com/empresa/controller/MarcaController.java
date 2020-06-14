package br.com.empresa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.dto.MarcaDTO;
import br.com.empresa.entity.dto.MarcaPatrimonioDTO;
import br.com.empresa.service.MarcaService;

@RestController
public class MarcaController {
	
	@Resource
	private MarcaService service;
	
	@GetMapping("/marcas")
	public List<MarcaDTO> listarTodos() {
		return service.listarTodos();
	}
	
	@GetMapping("/marcas/{id}")
	public MarcaDTO buscarMarcaPorId(@PathVariable("id") Long id) {
		return service.buscarMarcaPorId(id);
	}
	
	@GetMapping("/marcas/{id}/patrimonios")
	public MarcaPatrimonioDTO buscarPatrimoniosPorIdMarca(@PathVariable("id") Long id) {
		return service.buscarPatrimoniosPorIdMarca(id);
	}
	
	@PostMapping("/marcas")
	public MarcaDTO inserir(@RequestBody MarcaDTO marca) {
		return service.inserir(marca);
	}
	
	@PutMapping("/marcas/{id}")
	public MarcaDTO alterar(@PathVariable("id") Long id, @RequestBody MarcaDTO marca) {
		return service.alterar(id, marca);
	}
	
	@DeleteMapping("/marcas/{id}")
	public String excluir(@PathVariable("id") Long id) {
		return service.excluir(id);
	}
	
}
