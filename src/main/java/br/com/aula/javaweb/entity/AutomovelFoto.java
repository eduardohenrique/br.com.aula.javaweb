package br.com.aula.javaweb.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "automovelfoto")
public class AutomovelFoto implements Serializable {
    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue
    @Column(name = "idAutomovelFoto",nullable = false)
    private Integer idAutomovelFoto;
   
    @Column(name = "caminho",nullable = false,length = 100)
    private String caminho;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAutomovel",nullable = false)
    private Automovel automovel;

    public Integer getIdAutomovelFoto() {
        return idAutomovelFoto;
    }

    public void setIdAutomovelFoto(Integer idAutomovelFoto) {
        this.idAutomovelFoto = idAutomovelFoto;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idAutomovelFoto);
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
        final AutomovelFoto other = (AutomovelFoto) obj;
        if (!Objects.equals(this.idAutomovelFoto, other.idAutomovelFoto)) {
            return false;
        }
        return true;
    }
    
   
}
