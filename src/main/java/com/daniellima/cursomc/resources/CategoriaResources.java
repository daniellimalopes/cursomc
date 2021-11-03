package com.daniellima.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daniellima.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResources {

	@RequestMapping(method=RequestMethod.GET) 
	public List<Categoria> listar() { 
	 Categoria cat1 = new Categoria(); 
	 Categoria cat2 = new Categoria(); 
	 
	 List<Categoria> lista = new ArrayList<>(); 
	 lista.add(cat1); 
	 lista.add(cat2); 
	 
	 return lista; 
	}
}
