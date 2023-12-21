package com.senacead.ProjetoIntegrador.repository;

import com.senacead.ProjetoIntegrador.model.Produtos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutosRepository extends JpaRepository{
    List<Produtos> findByProdutoId(Integer id);
}
