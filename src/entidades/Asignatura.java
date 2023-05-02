/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rene2
 */
@Entity
@Table(name = "Asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findById", query = "SELECT a FROM Asignatura a WHERE a.id = :id")
    , @NamedQuery(name = "Asignatura.findByAsignatura", query = "SELECT a FROM Asignatura a WHERE a.asignatura = :asignatura")
    , @NamedQuery(name = "Asignatura.findByModalidad", query = "SELECT a FROM Asignatura a WHERE a.modalidad = :modalidad")
    , @NamedQuery(name = "Asignatura.findBySemestre", query = "SELECT a FROM Asignatura a WHERE a.semestre = :semestre")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "asignatura")
    private String asignatura;
    @Basic(optional = false)
    @Column(name = "modalidad")
    private String modalidad;
    @Basic(optional = false)
    @Column(name = "semestre")
    private String semestre;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id")
    @ManyToOne
    private Profesor idProfesor;
    @JoinColumn(name = "id_carrera", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carrera idCarrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsignatura")
    private List<AsignaturaEstudiante> asignaturaEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsignatura")
    private List<Convocatoria> convocatoriaList;

    public Asignatura() {
    }

    public Asignatura(Integer id) {
        this.id = id;
    }

    public Asignatura(Integer id, String asignatura, String modalidad, String semestre) {
        this.id = id;
        this.asignatura = asignatura;
        this.modalidad = modalidad;
        this.semestre = semestre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    @XmlTransient
    public List<AsignaturaEstudiante> getAsignaturaEstudianteList() {
        return asignaturaEstudianteList;
    }

    public void setAsignaturaEstudianteList(List<AsignaturaEstudiante> asignaturaEstudianteList) {
        this.asignaturaEstudianteList = asignaturaEstudianteList;
    }

    @XmlTransient
    public List<Convocatoria> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<Convocatoria> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
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
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Asignatura[ id=" + id + " ]";
    }
    
}
