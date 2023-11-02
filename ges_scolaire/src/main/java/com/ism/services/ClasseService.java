package com.ism.services;

import java.util.ArrayList;
import java.util.List;

import com.ism.entities.ClasseEntity;
import com.ism.entities.FiliereEntity;
import com.ism.entities.ModuleEntity;
import com.ism.entities.NiveauEntity;

public interface ClasseService {
    boolean ajouterClasse(ClasseEntity classeEntity);
     List<ClasseEntity> listerClasse();
     ArrayList<ModuleEntity> listerModuleParClasse(int id);

     List<FiliereEntity> listerFiliere();
     List<NiveauEntity> listerNiveaux();
     boolean findByModuleId(int id);
     boolean findClasseById(int id);

    
}
