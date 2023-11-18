package com.ism.services.impl;

import java.util.ArrayList;

import com.ism.entities.SalleEntity;
import com.ism.repositories.SalleReposytory;
import com.ism.services.SalleService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class SalleServiceImpl implements  SalleService{
    private SalleReposytory salleReposytory;

    @Override
    public boolean enregistrerSalle(SalleEntity salleEntity) {
        return salleReposytory.insert(salleEntity)!=0;
    }

    @Override
    public ArrayList<SalleEntity> listerSalles() {
        return salleReposytory.findAll();
    }
    
}
