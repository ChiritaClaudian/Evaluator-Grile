/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chiri
 */
@Entity
@Table(name = "teste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teste.findAll", query = "SELECT t FROM Teste t")
    , @NamedQuery(name = "Teste.findById", query = "SELECT t FROM Teste t WHERE t.id = :id")
    , @NamedQuery(name = "Teste.findByNume", query = "SELECT t FROM Teste t WHERE t.nume = :nume")
    , @NamedQuery(name = "Teste.findByPrenume", query = "SELECT t FROM Teste t WHERE t.prenume = :prenume")
    , @NamedQuery(name = "Teste.findByClasa", query = "SELECT t FROM Teste t WHERE t.clasa = :clasa")
    , @NamedQuery(name = "Teste.findByCapitol", query = "SELECT t FROM Teste t WHERE t.capitol = :capitol")
    , @NamedQuery(name = "Teste.findByNota", query = "SELECT t FROM Teste t WHERE t.nota = :nota")})
public class Teste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nume")
    private String nume;
    @Basic(optional = false)
    @Column(name = "prenume")
    private String prenume;
    @Basic(optional = false)
    @Column(name = "clasa")
    private String clasa;
    @Basic(optional = false)
    @Column(name = "capitol")
    private String capitol;
    @Basic(optional = false)
    @Column(name = "nota")
    private int nota;

    public Teste() {
    }

    public Teste(Integer id) {
        this.id = id;
    }

    public Teste(Integer id, String nume, String prenume, String clasa, String capitol, int nota) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.clasa = clasa;
        this.capitol = capitol;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public String getCapitol() {
        return capitol;
    }

    public void setCapitol(String capitol) {
        this.capitol = capitol;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teste)) {
            return false;
        }
        Teste other = (Teste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Teste[ id=" + id + " ]";
    }
    
}
