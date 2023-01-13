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
@Table(name = "funcionario_aceite", catalog = "CEDULA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionarioAceite.findAll", query = "SELECT f FROM FuncionarioAceite f")})
public class FuncionarioAceite implements Serializable {

    @Column(name = "telefone", length = 50)
    private String telefone;

    private static final long serialVersionUID = 1L;
    @Column(name = "nome", length = 50)
    private String nome;
    @Id
    @Basic(optional = false)
    @Column(name = "senha", nullable = false)
    private Integer senha;
    @Column(name = "userName", length = 50)
    private String userName;
    @Column(name = "naturalidade", length = 50)
    private String naturalidade;
    @Column(name = "sexo", length = 50)
    private String sexo;
    @Column(name = "provincia", length = 50)
    private String provincia;
    @Column(name = "distrito", length = 50)
    private String distrito;
    @Column(name = "nomePai", length = 50)
    private String nomePai;
    @Column(name = "nomeMae", length = 50)
    private String nomeMae;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "nrBi", length = 50)
    private String nrBi;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.LAZY)
    private FuncionarioAdmin idFuncionario;
    @JoinColumn(name = "idRequerimentoFunc", referencedColumnName = "idRequerimentoFunc")
    @ManyToOne(fetch = FetchType.LAZY)
    private RequerimentoFuncionarioNormal idRequerimentoFunc;

    public FuncionarioAceite() {
    }

    public FuncionarioAceite(Integer senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public String getNrBi() {
        return nrBi;
    }

    public void setNrBi(String nrBi) {
        this.nrBi = nrBi;
    }

    public FuncionarioAdmin getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(FuncionarioAdmin idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public RequerimentoFuncionarioNormal getIdRequerimentoFunc() {
        return idRequerimentoFunc;
    }

    public void setIdRequerimentoFunc(RequerimentoFuncionarioNormal idRequerimentoFunc) {
        this.idRequerimentoFunc = idRequerimentoFunc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (senha != null ? senha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioAceite)) {
            return false;
        }
        FuncionarioAceite other = (FuncionarioAceite) object;
        if ((this.senha == null && other.senha != null) || (this.senha != null && !this.senha.equals(other.senha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FuncionarioAceite[ senha=" + senha + " ]";
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
