package com.ism.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ism.entities.AffectationEntity;
import com.ism.repositories.AffectationReposytory;
import com.ism.repositories.DataBase;

import lombok.AllArgsConstructor;
@AllArgsConstructor

public class AffectationImpl implements AffectationReposytory{
    private final String SQL_INSERT="INSERT INTO `affectation`(`classe_id`, `module_id`) VALUES (?,?)";
    
    // private final String  SQL_UPDATE="SELECT * FROM classe";

    private DataBase dataBase;

    @Override
    public int insert(AffectationEntity data) {
        int lastInsertId=0;
            try {
                dataBase.openConnexion();
                dataBase.initPreparedStatement(SQL_INSERT);
                dataBase.getPs().setInt(1,data.getClasse_id());
                dataBase.getPs().setInt(2,data.getModule_id());
          
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
    public int update(AffectationEntity data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
