package com.daniellima.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniellima.cursomc.domain.Categoria;
import com.daniellima.cursomc.repositorys.CategoriaRepository;
import com.daniellima.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo" + Categoria.class.getName()));

	}
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
	