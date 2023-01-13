/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jozino M. Abubacar
 */
@Entity
@Table(name = "cedulas_editadas", catalog = "CEDULA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CedulasEditadas.findAll", query = "SELECT c FROM CedulasEditadas c")})
public class CedulasEditadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCedulaEditadas", nullable = false)
    private Integer idCedulaEditadas;
    @Column(name = "numeroAssento")
    private Integer numeroAssento;
    @Column(name = "dataEdicao")
    @Temporal(TemporalType.DATE)
    private Date dataEdicao;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.LAZY)
    private FuncionarioNormal idFuncionario;

    public CedulasEditadas() {
    }

    public CedulasEditadas(Integer idCedulaEditadas) {
        this.idCedulaEditadas = idCedulaEditadas;
    }

    public Integer getIdCedulaEditadas() {
        return idCedulaEditadas;
    }

    public void setIdCedulaEditadas(Integer idCedulaEditadas) {
        this.idCedulaEditadas = idCedulaEditadas;
    }

    public Integer getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(Integer numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public Date getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(Date dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public FuncionarioNormal getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(FuncionarioNormal idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCedulaEditadas != null ? idCedulaEditadas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CedulasEditadas)) {
            return false;
        }
        CedulasEditadas other = (CedulasEditadas) object;
        if ((this.idCedulaEditadas == null && other.idCedulaEditadas != null) || (this.idCedulaEditadas != null && !this.idCedulaEditadas.equals(other.idCedulaEditadas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CedulasEditadas[ idCedulaEditadas=" + idCedulaEditadas + " ]";
    }
    
}
