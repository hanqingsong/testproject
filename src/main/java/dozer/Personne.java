package dozer;

import lombok.Data;

@Data
public class Personne {
    private String nom;
    private String surnom;
    private int age;
 
    public Personne() {}
 
    public Personne(String nom, String surnom, int age) {
        super();
        this.nom = nom;
        this.surnom = surnom;
        this.age = age;
    }
     
    // standard getters and setters
}