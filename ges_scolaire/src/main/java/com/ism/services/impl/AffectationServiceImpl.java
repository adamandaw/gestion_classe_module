package com.ism.services.impl;


import com.ism.entities.AffectationEntity;

import com.ism.repositories.AffectationReposytory;
import com.ism.repositories.ClasseRepository;
import com.ism.repositories.ModuleReposytory;
import com.ism.services.AffectationService;
import com.ism.services.ClasseService;


public class AffectationServiceImpl implements AffectationService{
    ClasseRepository classeRepository;
    ModuleReposytory moduleReposytory;
    ClasseService classeService;
    AffectationReposytory affectationReposytory;

    

    public AffectationServiceImpl(AffectationReposytory affectationReposytory) {
        this.affectationReposytory = affectationReposytory;
    }



    @Override
    public boolean affecterModule(AffectationEntity affectationEntity) {         
        return affectationReposytory.insert(affectationEntity)!=0;
    }
    
}
