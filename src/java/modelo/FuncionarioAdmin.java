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
@Table(name = "funcionario_admin", catalog = "CEDULA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionarioAdmin.findAll", query = "SELECT f FROM FuncionarioAdmin f")})
public class FuncionarioAdmin implements Serializable {

    @Column(name = "telefone", length = 50)
    private String telefone;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFuncionario", nullable = false)
    private Integer idFuncionario;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "nomePai", length = 50)
    private String nomePai;
    @Column(name = "nomeMae", length = 50)
    private String nomeMae;
    @Column(name = "naturalidade", length = 50)
    private String naturalidade;
    @Column(name = "provincia", length = 50)
    private String provincia;
    @Column(name = "distrito", length = 50)
    private String distrito;
    @Column(name = "sexo", length = 50)
    private String sexo;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "nrBI", length = 15)
    private String nrBI;
    @Column(name = "scannerBI", length = 255)
    private String scannerBI;
    @Column(name = "nomeUsuario", length = 50)
    private String nomeUsuario;
    @Column(name = "senha", length = 255)
    private String senha;
    @OneToMany(mappedBy = "idFuncionario", fetch = FetchType.LAZY)
    private List<FuncionarioAceite> funcionarioAceiteList;
    @OneToMany(mappedBy = "idFuncionario", fetch = FetchType.LAZY)
    private List<FuncionarioNormalExcluido> funcionarioNormalExcluidoList;

    public FuncionarioAdmin() {
    }

    public FuncionarioAdmin(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<FuncionarioAceite> getFuncionarioAceiteList() {
        return funcionarioAceiteList;
    }

    public void setFuncionarioAceiteList(List<FuncionarioAceite> funcionarioAceiteList) {
        this.funcionarioAceiteList = funcionarioAceiteList;
    }

    @XmlTransient
    public List<FuncionarioNormalExcluido> getFuncionarioNormalExcluidoList() {
        return funcionarioNormalExcluidoList;
    }

    public void setFuncionarioNormalExcluidoList(List<FuncionarioNormalExcluido> funcionarioNormalExcluidoList) {
        this.funcionarioNormalExcluidoList = funcionarioNormalExcluidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioAdmin)) {
            return false;
        }
        FuncionarioAdmin other = (FuncionarioAdmin) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FuncionarioAdmin[ idFuncionario=" + idFuncionario + " ]";
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
