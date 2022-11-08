package com.gusta.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gusta.bookstore.domain.Categoria;
import com.gusta.bookstore.dto.CategoriaDTO;
import com.gusta.bookstore.repository.CategoriaRepository;
import com.gusta.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository rp;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = rp.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return rp.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return rp.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return rp.save(obj);
	}

	public void delete(Integer id) {
		findById(id);

		try {
			rp.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.gusta.bookstore.service.exception.DataIntegrityViolationException(
					"Categoria não pode ser deletada. Possui livros associados!");
		}
	}
}
