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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chiri
 */
@Entity
@Table(name = "intrebari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intrebari.findAll", query = "SELECT i FROM Intrebari i")
    , @NamedQuery(name = "Intrebari.findById", query = "SELECT i FROM Intrebari i WHERE i.id = :id")
    , @NamedQuery(name = "Intrebari.findByClasa", query = "SELECT i FROM Intrebari i WHERE i.clasa = :clasa")
    , @NamedQuery(name = "Intrebari.findByCapitol", query = "SELECT i FROM Intrebari i WHERE i.capitol = :capitol")
    , @NamedQuery(name = "Intrebari.findByText", query = "SELECT i FROM Intrebari i WHERE i.textIntrebare = :textIntrebare")})
public class Intrebari implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "text_intrebare")
    private String textIntrebare;
    @Basic(optional = false)
    @Column(name = "clasa")
    private String clasa;
    @Basic(optional = false)
    @Column(name = "capitol")
    private String capitol;

    public Intrebari() {
    }

    public Intrebari(Integer id) {
        this.id = id;
    }

    public Intrebari(Integer id, String textIntrebare, String clasa, String capitol) {
        this.id = id;
        this.textIntrebare = textIntrebare;
        this.clasa = clasa;
        this.capitol = capitol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextIntrebare() {
        return textIntrebare;
    }

    public void setTextIntrebare(String textIntrebare) {
        this.textIntrebare = textIntrebare;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intrebari)) {
            return false;
        }
        Intrebari other = (Intrebari) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Intrebari[ id=" + id + " ]";
    }
    
}
