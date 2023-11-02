package com.ism.views;

import java.util.Scanner;

import com.ism.entities.AffectationEntity;
import com.ism.entities.ClasseEntity;
import com.ism.entities.FiliereEntity;
import com.ism.entities.ModuleEntity;
import com.ism.entities.NiveauEntity;
import com.ism.repositories.AffectationReposytory;
import com.ism.repositories.ClasseRepository;
import com.ism.repositories.DataBase;
import com.ism.repositories.ModuleReposytory;
import com.ism.repositories.impl.AffectationImpl;
import com.ism.repositories.impl.ClasseRepositoryImpl;
import com.ism.repositories.impl.ModuleImpl;
import com.ism.repositories.impl.MysqlImpl;
import com.ism.services.AffectationService;
import com.ism.services.ClasseService;
import com.ism.services.ModuleService;
import com.ism.services.impl.AffectationServiceImpl;
import com.ism.services.impl.ClasseServiceImpl;
import com.ism.services.impl.ModuleServiceImpl;

public class Main {
       static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
     DataBase dataBase=new MysqlImpl();
    // REPOSYTORY
    ClasseRepository classeRepository=new ClasseRepositoryImpl(dataBase);
    ModuleReposytory moduleReposytory=new ModuleImpl(dataBase);
    AffectationReposytory affectationReposytory=new AffectationImpl(dataBase);
    // FIN REPOSYTORY

    ClasseService classeService =new ClasseServiceImpl(classeRepository, moduleReposytory);
    ModuleService moduleService=new ModuleServiceImpl(moduleReposytory);
    AffectationService affectationService=new AffectationServiceImpl(affectationReposytory);


   int choix;
        do {
          System.out.println("1. Ajouter une classe");
          System.out.println("2. Lister les classes");
          System.out.println("3. Affecter un module a une classe");
          System.out.println("4. Lister les modules d'une classe");
          System.out.println("5. Creer un nouveau module");
          System.out.println("6. Lister les Modules");
          choix=sc.nextInt();
            // choix = gestionClasseMenu();
            switch (choix) {
                case 1:
                    sc.nextLine();
            System.out.println("Choisir une Filiere");
            classeService.listerFiliere().forEach(System.out::println);
            int idFiliere=sc.nextInt();

            System.out.println("Choisir une Niveaux");
            classeService.listerNiveaux().forEach(System.out::println);
            int idNiveau=sc.nextInt();
            sc.nextLine();
             FiliereEntity filiereSelect=classeService.listerFiliere().get(idFiliere-1);
                     NiveauEntity niveauSelect=classeService.listerNiveaux().get(idNiveau-1);
                     String nom=String.format("%s %s",niveauSelect.getLibelle(),filiereSelect.getLibelle());
             ClasseEntity classe=new ClasseEntity(0,nom,filiereSelect.getLibelle(),niveauSelect.getLibelle());
            //    System.out.println(classe);
            if (classeService.ajouterClasse(classe)) {
                System.out.println("La classe a ete enregistrer  !");
            }else{
                System.out.println("Erreur d'insertion !");
            }

                    
                    break;
                case 2:
                System.out.println("\t\t Listes des classes :\n");
                classeService.listerClasse().forEach(System.out::print);
                    break;
                case 3:
                     System.out.println("Choisissez la classe :\n\n");
                classeService.listerClasse().forEach(System.out::print);
                int idClasse= sc.nextInt();
                if (classeService.findClasseById(idClasse)) {
                    sc.nextLine();
                    System.out.println("Choisissez le module a affecter :\n\n");
                    moduleService.listerModules().forEach(System.out::print);
                    int idModule= sc.nextInt();
                    if (classeService.findByModuleId(idModule)) {
                        // inserer dans affectation
                        AffectationEntity affectationEntity=new AffectationEntity(0, idClasse, idModule);             
                        
                        if (affectationService.affecterModule(affectationEntity)) {
                            System.out.println(" Nickel !");
                        }
                    }else{
                        System.out.println(" Ce module n'existe pas");
                    }
                }else{
                    System.out.println("Cette classe n'existe pas");
                }
                    break;
                case 4:
                System.out.println("Choisissez la classe :\n\n");
                System.out.println("|ID|\t|NOM|\t\t|FILIERE|\t|NIVEAU|\n");
               classeService.listerClasse().forEach(System.out::print);
               int idCl= sc.nextInt();
                if (classeService.findClasseById(idCl)) {
                   System.out.println("Cette Classe a les modules suivants :\n"); 
                    classeService.listerModuleParClasse(idCl)
                           .forEach(System.out::print);
                }else{
                   System.out.println("Aucune Classe ne contient l'id "+idCl);
               }   
                    break;

                    case 5:
                    sc.nextLine();
                     
                     System.out.println("Entrer le libelle du module :");
                       String libelle=sc.nextLine();
                    
                     ModuleEntity moduleEntity=new ModuleEntity(0,libelle);
                    //  System.out.println(moduleEntity);
                     Boolean ok=moduleService.creerModule(moduleEntity);
                     if (ok) {
                        System.out.println(libelle + " "+" a bien ete creer ");
                     }else{
                        System.out.println("erreur de creation ");
                     }
                    break;

                    case 6 :
                    System.out.println("\t\t\tListe des modules \n");
                    System.out.println("|ID|\t|LIBELLE|\n");
                        moduleService.listerModules().forEach(System.out::print);
                    break;
            
                default:
                    break;
            }
        } while (choix != 6);
    }
}
