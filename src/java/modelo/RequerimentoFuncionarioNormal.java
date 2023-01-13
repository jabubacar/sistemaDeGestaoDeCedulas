/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jozino M. Abubacar
 */
@Entity
@Table(name = "requerimento_funcionario_normal", catalog = "CEDULA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequerimentoFuncionarioNormal.findAll", query = "SELECT r FROM RequerimentoFuncionarioNormal r")})
public class RequerimentoFuncionarioNormal implements Serializable {

    @Column(name = "telefone", length = 50)
    private String telefone;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRequerimentoFunc", nullable = false)
    private Integer idRequerimentoFunc;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "nomePai", length = 50)
    private String nomePai;
    @Column(name = "nomeMae", length = 50)
    private String nomeMae;
    @Column(name = "naturalidade", length = 50)
    private String naturalidade;
    @Column(name = "distrito", length = 50)
    private String distrito;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "dataRequerimento")
    @Temporal(TemporalType.DATE)
    private Date dataRequerimento;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "nrBI", length = 15)
    private String nrBI;
    @Column(name = "scannerBI", length = 255)
    private String scannerBI;
    @OneToMany(mappedBy = "idRequerimentoFunc", fetch = FetchType.LAZY)
    private List<FuncionarioAceite> funcionarioAceiteList;

    public RequerimentoFuncionarioNormal() {
    }

    public RequerimentoFuncionarioNormal(Integer idRequerimentoFunc) {
        this.idRequerimentoFunc = idRequerimentoFunc;
    }

    public Integer getIdRequerimentoFunc() {
        return idRequerimentoFunc;
    }

    public void setIdRequerimentoFunc(Integer idRequerimentoFunc) {
        this.idRequerimentoFunc = idRequerimentoFunc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataRequerimento() {
        return dataRequerimento;
    }

    public void setDataRequerimento(Date dataRequerimento) {
        this.dataRequerimento = dataRequerimento;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrBI() {
        return nrBI;
    }

    public void setNrBI(String nrBI) {
        this.nrBI = nrBI;
    }

    public String getScannerBI() {
        return scannerBI;
    }

    public void setScannerBI(String scannerBI) {
        this.scannerBI = scannerBI;
    }

    @XmlTransient
    public List<FuncionarioAceite> getFuncionarioAceiteList() {
        return funcionarioAceiteList;
    }

    public void setFuncionarioAceiteList(List<FuncionarioAceite> funcionarioAceiteList) {
        this.funcionarioAceiteList = funcionarioAceiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequerimentoFunc != null ? idRequerimentoFunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequerimentoFuncionarioNormal)) {
            return false;
        }
        RequerimentoFuncionarioNormal other = (RequerimentoFuncionarioNormal) object;
        if ((this.idRequerimentoFunc == null && other.idRequerimentoFunc != null) || (this.idRequerimentoFunc != null && !this.idRequerimentoFunc.equals(other.idRequerimentoFunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RequerimentoFuncionarioNormal[ idRequerimentoFunc=" + idRequerimentoFunc + " ]";
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
