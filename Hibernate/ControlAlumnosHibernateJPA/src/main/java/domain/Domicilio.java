/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private int idDomicilio;
    private String calle;
    @Column(name = "no_calle")
    private int noCalle;
    private String pais;

    public Domicilio() {

    }

    public Domicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domicilio(String calle, int noCalle, String pais) {
        this.calle = calle;
        this.noCalle = noCalle;
        this.pais = pais;
    }

    public Domicilio(int idDomicilio, String calle, int noCalle, String pais) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.noCalle = noCalle;
        this.pais = pais;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNoCalle() {
        return noCalle;
    }

    public void setNoCalle(int noCalle) {
        this.noCalle = noCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", noCalle=" + noCalle + ", pais=" + pais + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idDomicilio;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domicilio other = (Domicilio) obj;
        if (this.idDomicilio != other.idDomicilio) {
            return false;
        }
        return true;
    }

}
