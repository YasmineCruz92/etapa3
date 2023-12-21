package com.senacead.ProjetoIntegrador.service;

import com.senacead.ProjetoIntegrador.model.Clientes;
import com.senacead.ProjetoIntegrador.model.Produtos;
import com.senacead.ProjetoIntegrador.repository.ClientesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {
    @Autowired
   ClientesRepository clientesRepository;
    
    
   public Clientes criar(Clientes cli){
       cli.setId(null);
       clientesRepository.save(cli);
       return cli;
   }
   
   public List<Clientes> listarTodos(){
       return clienteRepository.findAll();
   }
   
   public Clientes buscarPorId(Integer id){
       return clientesRepository.findById(id).orElseThrow();
   }
   
   public void excluir(Integer id){
       Clientes clienteEncontrado = buscarPorId(id); //valida se existe id informado
       clienteRepository.deleteById(clienteEncontrado.getId());
   }
   
   public Produtos atualizar(Integer id, Produtos produtosEnviado){
       Produtos clienteEncontrado = buscarPorId(id);
       clienteEncontrado.setNome(clienteEncontrado.getNome());
       clienteEncontradosetCPF(clienteEncontrado.getCPF());
       clienteEncontradosetTelefone(clienteEncontrado.getTelefone());
       clienteEncontradosetEndereco(clienteEncontrado.getEndereco());
       clienteEncontradosetEmail(clienteEncontrado.getEmail());
       clienteEncontrado.save(clienteEncontrado); 
       return clienteEncontrado;
   } 
}
