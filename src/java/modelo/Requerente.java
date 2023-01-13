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
@Table(name = "requerente", catalog = "CEDULA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requerente.findAll", query = "SELECT r FROM Requerente r")})
public class Requerente implements Serializable {

    @Column(name = "telefone", length = 50)
    private String telefone;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRequerente", nullable = false)
    private Integer idRequerente;
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
    @Column(name = "scannerCertidao", length = 255)
    private String scannerCertidao;
    @OneToMany(mappedBy = "idRequerente", fetch = FetchType.LAZY)
    private List<CedulasConfirmadas> cedulasConfirmadasList;

    public Requerente() {
    }

    public Requerente(Integer idRequerente) {
        this.idRequerente = idRequerente;
    }

    public Integer getIdRequerente() {
        return idRequerente;
    }

    public void setIdRequerente(Integer idRequerente) {
        this.idRequerente = idRequerente;
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

    public String getScannerCertidao() {
        return scannerCertidao;
    }

    public void setScannerCertidao(String scannerCertidao) {
        this.scannerCertidao = scannerCertidao;
    }

    @XmlTransient
    public List<CedulasConfirmadas> getCedulasConfirmadasList() {
        return cedulasConfirmadasList;
    }

    public void setCedulasConfirmadasList(List<CedulasConfirmadas> cedulasConfirmadasList) {
        this.cedulasConfirmadasList = cedulasConfirmadasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequerente != null ? idRequerente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerente)) {
            return false;
        }
        Requerente other = (Requerente) object;
        if ((this.idRequerente == null && other.idRequerente != null) || (this.idRequerente != null && !this.idRequerente.equals(other.idRequerente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Requerente[ idRequerente=" + idRequerente + " ]";
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Requerente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
