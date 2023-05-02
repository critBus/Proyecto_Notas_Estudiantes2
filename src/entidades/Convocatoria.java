/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rene2
 */
@Entity
@Table(name = "Convocatoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convocatoria.findAll", query = "SELECT c FROM Convocatoria c")
    , @NamedQuery(name = "Convocatoria.findById", query = "SELECT c FROM Convocatoria c WHERE c.id = :id")
    , @NamedQuery(name = "Convocatoria.findByFecha", query = "SELECT c FROM Convocatoria c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Convocatoria.findByNota", query = "SELECT c FROM Convocatoria c WHERE c.nota = :nota")
    , @NamedQuery(name = "Convocatoria.findByNumero", query = "SELECT c FROM Convocatoria c WHERE c.numero = :numero")})
public class Convocatoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @Column(name = "nota")
    private String nota;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignatura idAsignatura;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estudiante idEstudiante;

    public Convocatoria() {
    }

    public Convocatoria(Integer id) {
        this.id = id;
    }

    public Convocatoria(Integer id, String fecha, String nota, String numero) {
        this.id = id;
        this.fecha = fecha;
        this.nota = nota;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
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
        if (!(object instanceof Convocatoria)) {
            return false;
        }
        Convocatoria other = (Convocatoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Convocatoria[ id=" + id + " ]";
    }
    
}
