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
@Table(name = "cedulas_confirmadas", catalog = "CEDULA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CedulasConfirmadas.findAll", query = "SELECT c FROM CedulasConfirmadas c")})
public class CedulasConfirmadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroAssento", nullable = false)
    private Integer numeroAssento;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "distrito", length = 50)
    private String distrito;
    @Column(name = "nomeMae", length = 50)
    private String nomeMae;
    @Column(name = "nomePai", length = 50)
    private String nomePai;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "sexo", length = 50)
    private String sexo;
    @Column(name = "dataEmissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "registoCivil", length = 50)
    private String registoCivil;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.LAZY)
    private FuncionarioNormal idFuncionario;
    @JoinColumn(name = "idRequerente", referencedColumnName = "idRequerente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Requerente idRequerente;

    public CedulasConfirmadas() {
    }

    public CedulasConfirmadas(Integer numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public Integer getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(Integer numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getRegistoCivil() {
        return registoCivil;
    }

    public void setRegistoCivil(String registoCivil) {
        this.registoCivil = registoCivil;
    }

    public FuncionarioNormal getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(FuncionarioNormal idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Requerente getIdRequerente() {
        return idRequerente;
    }

    public void setIdRequerente(Requerente idRequerente) {
        this.idRequerente = idRequerente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroAssento != null ? numeroAssento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CedulasConfirmadas)) {
            return false;
        }
        CedulasConfirmadas other = (CedulasConfirmadas) object;
        if ((this.numeroAssento == null && other.numeroAssento != null) || (this.numeroAssento != null && !this.numeroAssento.equals(other.numeroAssento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CedulasConfirmadas[ numeroAssento=" + numeroAssento + " ]";
    }

    public void setDataEmissao(String dataEmissao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setDataNascimento(String dataNascimento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdFuncionario(String idFuncionario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setTelefone(String telefone) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setNaturalidade(String naturalidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
