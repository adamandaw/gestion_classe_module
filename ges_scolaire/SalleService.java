package com.ism.services;

import java.util.ArrayList;

import com.ism.entities.SalleEntity;

public interface SalleService {
    boolean enregistrerSalle(SalleEntity salleEntity);
    ArrayList<SalleEntity> listerSalles();
}
