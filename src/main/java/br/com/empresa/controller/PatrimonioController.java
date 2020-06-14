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

import br.com.empresa.entity.dto.PatrimonioDTO;
import br.com.empresa.service.PatrimonioService;

@RestController
public class PatrimonioController {
	
	@Resource
	private PatrimonioService service;
	
	@GetMapping("/patrimonios")
	public List<PatrimonioDTO> listarTodos() {
		return service.listarTodos();
	}
	
	@GetMapping("/patrimonios/{id}")
	public PatrimonioDTO patrimonio(@PathVariable("id") Long id) {
		return service.buscarPatrimonioPorId(id);
	}
	
	@PostMapping("/patrimonios")
	public PatrimonioDTO inserir(@RequestBody PatrimonioDTO patrimonio) {
		return service.inserir(patrimonio);
	}
	
	@PutMapping("/patrimonios/{id}")
	public PatrimonioDTO alterar(@PathVariable("id") Long id, @RequestBody PatrimonioDTO patrimonio) {
		return service.alterar(id, patrimonio);
	}
	
	@DeleteMapping("/patrimonios/{id}")
	public String excluir(@PathVariable("id") Long id) {
		return service.excluir(id);
	}
	
}
