package com.senacead.ProjetoIntegrador.repository;

import com.senacead.ProjetoIntegrador.model.Clientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientesRepository extends JpaRepository{
    List<Clientes> findByClienteId(Integer id);
}
