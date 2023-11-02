package com.ism.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ism.entities.*;

public interface ClasseRepository extends BaseReposytory<ClasseEntity> {
    List<ClasseEntity> findAll();
    ArrayList<ModuleEntity> findModuleFromClasse(int id);
    
}
