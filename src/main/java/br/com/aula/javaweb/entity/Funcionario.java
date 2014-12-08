package br.com.aula.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name ="idPessoa")
@DiscriminatorValue("F")
public class Funcionario extends Pessoa{
     
     
    @Column(name = "salario",nullable = false)
    @NotNull(message = "Informe o salário")
    private Double salario;
   
    public Funcionario() {
     
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
   
}
