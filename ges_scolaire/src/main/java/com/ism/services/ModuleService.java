package com.ism.services;

import java.util.ArrayList;

// import com.ism.entities.ClasseEntity;
import com.ism.entities.ModuleEntity;


public interface ModuleService {
    boolean creerModule(ModuleEntity moduleEntity);
    boolean verifierLibelle(ModuleEntity moduleEntity);
      ArrayList<ModuleEntity> listerModules();
}
