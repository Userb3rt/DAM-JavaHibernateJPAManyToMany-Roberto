package com.project;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Autor", uniqueConstraints = { @UniqueConstraint(columnNames = "autorId") })
public class Autor {

    @Id
    @Column(name = "autorId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long autorId;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "autorId")
    private Set<Llibre> llibres;

    public Autor(String nom) {
        super();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    public long getAutorId() {
        return autorId;
    }

}
