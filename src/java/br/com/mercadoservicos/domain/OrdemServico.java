package br.com.mercadoservicos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ordemServico")
public class OrdemServico implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name="dataHora")
    private Date dataHora;
    
    @Column(name="observacao")
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName="id")
    private Usuario cliente;
    
    @ManyToOne
    @JoinColumn(name="idEmpresa", referencedColumnName="id")
    private Usuario empresa;

    public OrdemServico(Integer id, Date dataHora, String observacao, Usuario cliente, Usuario empresa) {
        this.id = id;
        this.dataHora = dataHora;
        this.observacao = observacao;
        this.cliente = cliente;
        this.empresa = empresa;
    }
    
    
    
    public OrdemServico(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Usuario empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.dataHora);
        hash = 83 * hash + Objects.hashCode(this.observacao);
        hash = 83 * hash + Objects.hashCode(this.cliente);
        hash = 83 * hash + Objects.hashCode(this.empresa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdemServico other = (OrdemServico) obj;
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "id=" + id + ", dataHora=" + dataHora + ", observacao=" + observacao + ", cliente=" + cliente + ", empresa=" + empresa + '}';
    }
    
    
    
}
