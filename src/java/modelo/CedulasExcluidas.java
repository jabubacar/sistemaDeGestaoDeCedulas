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
@Table(name = "cedulas_excluidas", catalog = "CEDULA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CedulasExcluidas.findAll", query = "SELECT c FROM CedulasExcluidas c")})
public class CedulasExcluidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCedulaExcluida", nullable = false)
    private Integer idCedulaExcluida;
    @Column(name = "numeroAssento")
    private Integer numeroAssento;
    @Column(name = "dataExclusao")
    @Temporal(TemporalType.DATE)
    private Date dataExclusao;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.LAZY)
    private FuncionarioNormal idFuncionario;

    public CedulasExcluidas() {
    }

    public CedulasExcluidas(Integer idCedulaExcluida) {
        this.idCedulaExcluida = idCedulaExcluida;
    }

    public Integer getIdCedulaExcluida() {
        return idCedulaExcluida;
    }

    public void setIdCedulaExcluida(Integer idCedulaExcluida) {
        this.idCedulaExcluida = idCedulaExcluida;
    }

    public Integer getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(Integer numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
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
        hash += (idCedulaExcluida != null ? idCedulaExcluida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CedulasExcluidas)) {
            return false;
        }
        CedulasExcluidas other = (CedulasExcluidas) object;
        if ((this.idCedulaExcluida == null && other.idCedulaExcluida != null) || (this.idCedulaExcluida != null && !this.idCedulaExcluida.equals(other.idCedulaExcluida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CedulasExcluidas[ idCedulaExcluida=" + idCedulaExcluida + " ]";
    }
    
}
