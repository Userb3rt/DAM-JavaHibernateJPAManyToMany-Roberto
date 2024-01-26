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
@Table(name = "Biblioteca", uniqueConstraints = { @UniqueConstraint(columnNames = "bibliotecaId") })
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bibliotecaId", unique = true, nullable = false)
    private long bibliotecaId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "ciutat")
    private String ciutat;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "Biblioteca_Llibres", joinColumns = {
            @JoinColumn(referencedColumnName = "bibliotecaId") }, inverseJoinColumns = {
                    @JoinColumn(referencedColumnName = "llibreId") })
    private Set<Llibre> llibres;

    public Biblioteca() {
        super();
    }

    public Biblioteca(String nom, String ciutat) {
        super();
        this.nom = nom;
        this.ciutat = ciutat;
    }

    public long getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    public String getllibreslist() {
        String list = "[";
        for (Llibre llibre : llibres) {
            list += llibre.getLlibreId() + ", " + llibre.getEditorial() + ", " + llibre.getNom() + " | ";
        }
        return list;
    }

    @Override
    public String toString() {
        return getBibliotecaId() + ": " + getNom() + ", " + getCiutat() + ", Llibres: " + getllibreslist();
    }

}