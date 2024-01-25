package com.project;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Llibre", uniqueConstraints = { @UniqueConstraint(columnNames = "llibreId") })
public class Llibre {

    @Id
    @Column(name = "llibreId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int llibreId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "editorial")
    private String editorial;

    @ManyToOne
    @JoinColumn(name = "autorId", insertable = false, updatable = false)
    private Autor autor;

    @ManyToMany(mappedBy = "llibreId")
    private Set<Biblioteca> biblioteques;

    @ManyToMany(mappedBy = "llibreId")
    private Set<Persona> persones;

    public Llibre(String nom, String editorial) {
        super();
        this.nom = nom;
        this.editorial = editorial;
    }
}
