package com.ism.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ism.entities.ClasseEntity;
import com.ism.entities.FiliereEntity;
import com.ism.entities.ModuleEntity;
import com.ism.entities.NiveauEntity;
import com.ism.repositories.ClasseRepository;
import com.ism.repositories.ModuleReposytory;
import com.ism.services.ClasseService;



public class ClasseServiceImpl  implements ClasseService{
    ClasseRepository classeRepository;
    ModuleReposytory moduleReposytory;
    ClasseEntity classeEntity=new ClasseEntity();
    ClasseService classeService;
    public ClasseServiceImpl(ClasseRepository classeRepository, ModuleReposytory moduleReposytory) {
        this.classeRepository = classeRepository;
        this.moduleReposytory = moduleReposytory;
    }







    @Override
    public boolean ajouterClasse(ClasseEntity classeEntity) {
        return classeRepository.insert(classeEntity)!=0;
    }


    @Override
    public List<ClasseEntity> listerClasse() {
    return classeRepository.findAll();
    }

    @Override
    public List<FiliereEntity> listerFiliere() {
         return Arrays.asList(new FiliereEntity("GLRS"),
                                new FiliereEntity("MAIE"),
                                new FiliereEntity("CDSD")
                                ,new FiliereEntity("TTL")
                                ,new FiliereEntity("CPD")
                                ,new FiliereEntity("ETSE"));

    }

    @Override
    public List<NiveauEntity> listerNiveaux() {
        return Arrays.asList(new NiveauEntity("L1"),new NiveauEntity("L2")
         ,new NiveauEntity("L3"));
    }


    @Override
    public boolean findByModuleId(int id) {
        ArrayList<ModuleEntity> tabModule = moduleReposytory.findAll();
         
        for (ModuleEntity mod : tabModule) {
            if (mod.getId()==id) {
                return true;
            }
           
    }
     return false;
    
    }







    @Override
    public boolean findClasseById(int id) {
        List<ClasseEntity> tabClasses = classeRepository.findAll();
        for (ClasseEntity cl : tabClasses) {
            if (cl.getId()==id) {
                return true;
            }      
        }
        return false;

    }







    @Override
    public ArrayList<ModuleEntity> listerModuleParClasse(int idCl) {
       return classeRepository.findModuleFromClasse(idCl);

    }




}