package com.ism.entities;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClasseEntity {

    private int id;
    private String nom;
    private String filiere;
    private String niveau;

         


    
   public ClasseEntity(int id, String nom, String filiere, String niveau) {
  this.id = id;
  this.nom = nom;
  this.filiere = filiere;
  this.niveau = niveau;

}

  public  ClasseEntity(int id){
      this.id=id;
    }

  @Override
  public String toString() {
    return "Classe : [id=" + id + ", nom=" + nom + ", filiere=" + filiere + ", niveau=" + niveau + "]";
  }

 


    
}
