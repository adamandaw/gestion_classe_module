package com.ism.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.ism.entities.ModuleEntity;
import com.ism.repositories.DataBase;
import com.ism.repositories.ModuleReposytory;

public class ModuleImpl  implements ModuleReposytory{
    private DataBase dataBase;
    private final String SQL_INSERT="INSERT INTO `module`(`libelle`) VALUES (?)";
    private final String SQL_SELECT_ALL="SELECT * FROM `module`";
// Module by classe SELECT DISTINCT libelle FROM module m, classe c WHERE  m.classe_id = 2;


    public ModuleImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public int insert(ModuleEntity data) {
        int lastInsertId=0;
            try {
                dataBase.openConnexion();
                dataBase.initPreparedStatement(SQL_INSERT);
                dataBase.getPs().setString(1, data.getLibelle());
                dataBase.executeUpdate();
                  ResultSet rs=  dataBase.getPs().getGeneratedKeys();
                if(rs.next()){
                  lastInsertId=rs.getInt(1) ; 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
          
            return lastInsertId; 
    }


    @Override
    public int update(ModuleEntity data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }





    @Override
    public ArrayList<ModuleEntity> findAll() {
         ArrayList<ModuleEntity> datas=new ArrayList<>();
                  try {
                      dataBase.openConnexion();
                        dataBase.initPreparedStatement(SQL_SELECT_ALL);
                    ResultSet resultSet=dataBase.executeSelect();
                    while (resultSet.next()) {
                        
                        ModuleEntity data=new ModuleEntity( resultSet.getInt("id")
                                         , resultSet.getString("libelle")
                                         );

                         datas.add(data);
                           
                      }
                   resultSet.close();
                   dataBase.closeConnexion();
                } catch (SQLException e) {
                    System.out.println("Erreur execution de Requete");
                }
            
            return datas;
    }
    
}
