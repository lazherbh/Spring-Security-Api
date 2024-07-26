package com.coderdot.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


@Entity
public  class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;



    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String motDePasse;


    @ManyToMany(fetch = FetchType.EAGER) //on a utilisé eager car à chque fois je vais charger un utilisateur, j'ai besion de telecharger ses roles
    private Collection<Role> roles = new ArrayList<>();

    public Utilisateur(Long id, String username,  String email, String motDePasse, Collection<Role> roles) {
        this.id = id;
        this.username = username;

        this.email = email;
        this.motDePasse = motDePasse;
        this.roles = roles;
    }

    public Utilisateur() {

    }

    // Getters, setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Offre> getOffres() {
        return new ArrayList<>();
    }
}
