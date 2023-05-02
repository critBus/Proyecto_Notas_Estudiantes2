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
@Table(name = "Asignatura_Estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignaturaEstudiante.findAll", query = "SELECT a FROM AsignaturaEstudiante a")
    , @NamedQuery(name = "AsignaturaEstudiante.findById", query = "SELECT a FROM AsignaturaEstudiante a WHERE a.id = :id")})
public class AsignaturaEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estudiante idEstudiante;
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignatura idAsignatura;

    public AsignaturaEstudiante() {
    }

    public AsignaturaEstudiante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
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
        if (!(object instanceof AsignaturaEstudiante)) {
            return false;
        }
        AsignaturaEstudiante other = (AsignaturaEstudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AsignaturaEstudiante[ id=" + id + " ]";
    }
    
}
