package com.senacead.ProjetoIntegrador.service;

import com.senacead.ProjetoIntegrador.model.Produtos;
import com.senacead.ProjetoIntegrador.repository.ProdutosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutosService {
    @Autowired
   ProdutosRepository livroRepository;
    
    
   public Produtos criar(Produtos prod){
       prod.setId(null);
       livroRepository.save(prod);
       return prod;
   }
   
   public List<Produtos> listarTodos(){
       return produtosRepository.findAll();
   }
   
   public Produtos buscarPorId(Integer id){
       return produtosRepository.findById(id).orElseThrow();
   }
   
   public void excluir(Integer id){
       Produtos produtosEncontrado = buscarPorId(id); //valida se existe id informado
       produtosRepository.deleteById(produtosEncontrado.getId());
   }
   
   public Produtos atualizar(Integer id, Produtos produtosEnviado){
       Produtos produtoEncontrado = buscarPorId(id);
       produtosEncontrado.setNome(produtosEnviado.getNome());
       produtosEncontrado.setValor(produtosEnviado.getValor());
       produtosEncontrado.setPeso(produtosEnviado.isPeso());
       produtosRepository.save(produtosEncontrado);
       return produtosEncontrado;
   }
}
