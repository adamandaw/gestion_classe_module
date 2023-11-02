package com.ism.repositories;

import java.util.ArrayList;

import com.ism.entities.ModuleEntity;

public interface ModuleReposytory extends BaseReposytory<ModuleEntity>{
    ArrayList<ModuleEntity> findAll();
}
