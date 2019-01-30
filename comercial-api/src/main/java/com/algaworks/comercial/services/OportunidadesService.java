package com.algaworks.comercial.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.algaworks.comercial.exceptions.NotFoundException;
import com.algaworks.comercial.model.Oportunidade;
import com.algaworks.comercial.repository.OportunidadeRepository;

@Service
public class OportunidadesService {

	@Autowired
	OportunidadeRepository oportunidadeRepository;

	public List<Oportunidade> listarOportunidades() {
		return oportunidadeRepository.findAll();
	}

	public Oportunidade buscarOportunidade(Long id) {

		Oportunidade oportunidade;

		try {
			oportunidade = oportunidadeRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new NotFoundException("A Oportunidade não foi encontrada");
		}
		return oportunidade;
	}

	public Oportunidade inserir(Oportunidade oportunidade) {
		return oportunidadeRepository.save(oportunidade);
	}

	public ResponseEntity<Void> deletar(Long id) {

		try {
			oportunidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	public void atualizar(Oportunidade oportunidade, Long id) {
		oportunidade.setId(id);
		oportunidadeRepository.save(oportunidade);
	}

}
