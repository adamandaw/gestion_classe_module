package com.ism.services.impl;

import java.util.ArrayList;

import com.ism.entities.ModuleEntity;
import com.ism.repositories.ModuleReposytory;
import com.ism.services.ModuleService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class ModuleServiceImpl implements ModuleService{
   private ModuleReposytory moduleReposytory;
    @Override
    public boolean verifierLibelle(ModuleEntity moduleEntity) {
      ArrayList<ModuleEntity> tabModule = moduleReposytory.findAll();
        for (ModuleEntity mod : tabModule) {
                if (mod.equals(moduleEntity)) {
                       return true;
                }
        }
        return false;
    }
    @Override
    public boolean creerModule(ModuleEntity moduleEntity) {
        return moduleReposytory.insert(moduleEntity)!=0;
        
            
        
    }
    @Override
    public ArrayList<ModuleEntity> listerModules() {
      return moduleReposytory.findAll();
    }
    
}
