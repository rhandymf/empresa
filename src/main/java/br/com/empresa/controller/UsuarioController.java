package br.com.empresa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.dto.UsuarioDTO;
import br.com.empresa.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Resource
	private UsuarioService service;
	
	@GetMapping("/usuarios")
	public List<UsuarioDTO> listarTodos() {
		return service.listarTodos();
	}
	
	@PostMapping("/usuarios")
	public UsuarioDTO inserir(@RequestBody UsuarioDTO usuario) {
		return service.inserir(usuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public String excluir(@PathVariable("id") Long id) {
		return service.excluir(id);
	}
	
}
