package br.com.aula.javaweb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "pessoa")
@DiscriminatorColumn(name = "tipo",discriminatorType = DiscriminatorType.CHAR)
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa",nullable = false)
    private Integer idPessoa;
   
    @Column(name = "nome",nullable = false,length = 100)
    @NotNull(message = "Informe o nome")
    private String nome;
    
    @Column(name = "cpf",nullable = false,length = 14)
    @NotNull(message = "Informe o cpf")
    @CPF(message = "CPF Inválido")
    private String cpf;
    
    @Column(name = "dataNascimento",nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Informe a data de nascimento")
    private Date dataNascimento;
    
     
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "pessoa",cascade = CascadeType.ALL)
    private Usuario usuario;

    public Pessoa(){
        this.usuario = new Usuario();
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idPessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        return true;
    }
  
   
    
}
