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
@Table(name = "funcionario_normal_excluido", catalog = "CEDULA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionarioNormalExcluido.findAll", query = "SELECT f FROM FuncionarioNormalExcluido f")})
public class FuncionarioNormalExcluido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFuncionarioNormalExcluido", nullable = false)
    private Integer idFuncionarioNormalExcluido;
    @Column(name = "dataExclusao")
    @Temporal(TemporalType.DATE)
    private Date dataExclusao;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.LAZY)
    private FuncionarioAdmin idFuncionario;

    public FuncionarioNormalExcluido() {
    }

    public FuncionarioNormalExcluido(Integer idFuncionarioNormalExcluido) {
        this.idFuncionarioNormalExcluido = idFuncionarioNormalExcluido;
    }

    public Integer getIdFuncionarioNormalExcluido() {
        return idFuncionarioNormalExcluido;
    }

    public void setIdFuncionarioNormalExcluido(Integer idFuncionarioNormalExcluido) {
        this.idFuncionarioNormalExcluido = idFuncionarioNormalExcluido;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public FuncionarioAdmin getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(FuncionarioAdmin idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionarioNormalExcluido != null ? idFuncionarioNormalExcluido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioNormalExcluido)) {
            return false;
        }
        FuncionarioNormalExcluido other = (FuncionarioNormalExcluido) object;
        if ((this.idFuncionarioNormalExcluido == null && other.idFuncionarioNormalExcluido != null) || (this.idFuncionarioNormalExcluido != null && !this.idFuncionarioNormalExcluido.equals(other.idFuncionarioNormalExcluido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FuncionarioNormalExcluido[ idFuncionarioNormalExcluido=" + idFuncionarioNormalExcluido + " ]";
    }
    
}
