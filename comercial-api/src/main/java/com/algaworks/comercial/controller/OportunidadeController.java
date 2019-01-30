package com.algaworks.comercial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.comercial.model.Oportunidade;
import com.algaworks.comercial.services.OportunidadesService;

@CrossOrigin
@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

	@Autowired
	private OportunidadesService oportunidades;

	@GetMapping
	public List<Oportunidade> listar() {

		return oportunidades.listarOportunidades();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Oportunidade> buscar(@PathVariable Long id) {
		Oportunidade oportunidade = oportunidades.buscarOportunidade(id);

		return ResponseEntity.ok(oportunidade);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // Retorna o status HTTP Created
	public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade) {

		return oportunidades.inserir(oportunidade);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return oportunidades.deletar(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Oportunidade oportunidade, @PathVariable("id") Long id) {
		oportunidades.atualizar(oportunidade, id);
		return ResponseEntity.noContent().build();
	}

}
