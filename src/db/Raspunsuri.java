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
@Table(name = "raspunsuri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Raspunsuri.findAll", query = "SELECT r FROM Raspunsuri r")
    , @NamedQuery(name = "Raspunsuri.findById", query = "SELECT r FROM Raspunsuri r WHERE r.id = :id")
    , @NamedQuery(name = "Raspunsuri.findByIdIntrebare", query = "SELECT r FROM Raspunsuri r WHERE r.idIntrebare = :idIntrebare")
    , @NamedQuery(name = "Raspunsuri.findByIsCorrect", query = "SELECT r FROM Raspunsuri r WHERE r.isCorrect = :isCorrect")
    , @NamedQuery(name = "Raspunsuri.findByTextRaspuns", query = "SELECT i FROM Raspunsuri i WHERE i.textRaspuns = :textRaspuns")})
public class Raspunsuri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_intrebare")
    private int idIntrebare;
    @Basic(optional = false)
    @Lob
    @Column(name = "text_raspuns")
    private String textRaspuns;
    @Basic(optional = false)
    @Column(name = "isCorrect")
    private int isCorrect;

    public Raspunsuri() {
    }

    public Raspunsuri(Integer id) {
        this.id = id;
    }

    public Raspunsuri(Integer id, int idIntrebare, String textRaspuns, int isCorrect) {
        this.id = id;
        this.idIntrebare = idIntrebare;
        this.textRaspuns = textRaspuns;
        this.isCorrect = isCorrect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdIntrebare() {
        return idIntrebare;
    }

    public void setIdIntrebare(int idIntrebare) {
        this.idIntrebare = idIntrebare;
    }

    public String getTextRaspuns() {
        return textRaspuns;
    }

    public void setTextRaspuns(String textRaspuns) {
        this.textRaspuns = textRaspuns;
    }

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
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
        if (!(object instanceof Raspunsuri)) {
            return false;
        }
        Raspunsuri other = (Raspunsuri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Raspunsuri[ id=" + id + " ]";
    }
    
}
