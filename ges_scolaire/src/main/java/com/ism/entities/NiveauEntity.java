package com.ism.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NiveauEntity {
    private static int nbreNiveau; 
    private int id;
    private String libelle;
    public  NiveauEntity(String libelle){
       id=++nbreNiveau;
       this.libelle=libelle;
    }

    @Override
    public String toString() {
        return "id=" + id + ", libelle=" + libelle ;
    } 


}
