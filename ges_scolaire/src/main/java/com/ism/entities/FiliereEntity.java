package com.ism.entities;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FiliereEntity {
    private static int nbreFiliere; 
    private int id;
    private String libelle;
    public  FiliereEntity(String libelle){
       id=++nbreFiliere;
       this.libelle=libelle;
    }
    @Override
    public String toString() {
        return "id=" + id + ", libelle=" + libelle ;
    } 
    
}
