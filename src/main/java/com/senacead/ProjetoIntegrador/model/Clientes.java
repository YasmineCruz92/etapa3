package com.senacead.ProjetoIntegrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Clientes")

public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    
    private String Nome;
    
    private String CPF;
    
    private String Telefone;
    
    private String Endereco;
    
    private String Email;
}
