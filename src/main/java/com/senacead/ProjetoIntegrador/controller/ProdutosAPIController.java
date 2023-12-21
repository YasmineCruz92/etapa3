package com.senacead.ProjetoIntegrador.controller;

import com.senacead.ProjetoIntegrador.model.Clientes;
import com.senacead.ProjetoIntegrador.model.Produtos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")

public class ProdutosAPIController {
    @Autowired
    ProdutosService livroService;

    //cadastrar(C)
    @PostMapping("/adicionar")
    public ResponseEntity<Produtos> addLivro(@RequestBody Produtos prod) {
        var novoLivro = livroService.criar(prod);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Produtos> produtos = produtosService.listarTodos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    //buscar(R)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Produtos> pesquisar(@PathVariable Integer id) {
        Produtos produtoEncontrado = livroService.buscarPorId(id);
        return new ResponseEntity<>(produtoEncontrado, HttpStatus.OK);
    }

    //alterar(U)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produtos> editProdutos(@PathVariable Integer id, @RequestBody Produtos liv) {
        var editarProdutos = produtoService.atualizar(id, liv);
        return new ResponseEntity<>(editarProdutos, HttpStatus.OK);
    }

    //excluir(D)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        livroService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
