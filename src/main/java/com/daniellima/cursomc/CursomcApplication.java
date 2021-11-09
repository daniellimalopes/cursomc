package com.daniellima.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daniellima.cursomc.domain.Categoria;
import com.daniellima.cursomc.domain.Cidade;
import com.daniellima.cursomc.domain.Cliente;
import com.daniellima.cursomc.domain.Endereco;
import com.daniellima.cursomc.domain.Estado;
import com.daniellima.cursomc.domain.Produto;
import com.daniellima.cursomc.domain.enums.TipoCliente;
import com.daniellima.cursomc.repositorys.CategoriaRepository;
import com.daniellima.cursomc.repositorys.CidadeRepository;
import com.daniellima.cursomc.repositorys.ClienteRepository;
import com.daniellima.cursomc.repositorys.EnderecoRepository;
import com.daniellima.cursomc.repositorys.EstadoRepository;
import com.daniellima.cursomc.repositorys.ProdutoRepository;



@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Instanciando os produtos e as categorias.
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		// Adicionando os produtos que tem associacao com cada categoria.
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		// Adicionando as categorias que tem associacao com cada produto.
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1, cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");

		Cidade c1 = new Cidade(null,"Uberlandia", est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est1);

		est1.getCidade().addAll(Arrays.asList(c1));
		est2.getCidade().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "44352256404", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("13996530291", "19996585412"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Casa", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "11705370", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		

	}

}
