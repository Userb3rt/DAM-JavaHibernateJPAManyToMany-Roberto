package com.project;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Persona", 
   uniqueConstraints = {@UniqueConstraint(columnNames = "personaId")})
public class Persona {

    @Id
    @Column(name = "personaId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personaId;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nom")
    private String nom;

    @Column(name = "telefon")
    private String telefon;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "Persona_llibre", joinColumns = {
            @JoinColumn(referencedColumnName = "personaId") }, inverseJoinColumns = {
                    @JoinColumn(referencedColumnName = "llibreId") })
    private Set<Llibre> llibres;

    public Persona() {
        super();
    }

    public Persona(String dni, String nom, String telefon) {
        super();
        this.dni = dni;
        this.nom = nom;
        this.telefon = telefon;
    }

    public long getPersonaId() {
        return personaId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    public String getlistllibres(){
        String listllibres = "[";
        for (Llibre llibre : llibres) {
            listllibres+= llibre.getLlibreId()+", "+llibre.getEditorial()+", "+llibre.getNom()+" | ";
        }
        return listllibres;
    }

    @Override
    public String toString() {
        return getPersonaId()+": "+ getNom()+", "+getTelefon()+", Llibres: "+ getlistllibres();
    }

}
