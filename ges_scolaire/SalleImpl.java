package com.ism.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ism.entities.SalleEntity;
import com.ism.repositories.DataBase;
import com.ism.repositories.SalleReposytory;

public class SalleImpl implements SalleReposytory{
    private final String SQL_INSERT = "INSERT INTO `salle`(`libelle`, `place`) VALUES (?,?)";
    // private final String SQL_UPDATE = "UPDATE `salle` SET `libelle`=?,`place`=?,`isArchived`= ? WHERE id = ?";
    private final String  SQL_SELECT_ALL="SELECT * FROM salle";
    // private final String SQL_SELECT_BY_ID = "SELECT * FROM Salle WHERE id = ?";
    private DataBase database;
    // private final String SQL_ARCHIVE = "UPDATE Salle SET isArchived = ? WHERE id = ?";
    public SalleImpl(DataBase database) {
        this.database = database;
    }

    @Override
    public int insert(SalleEntity data) {
       int lastInsertId=0;
            try {
                database.openConnexion();
                database.initPreparedStatement(SQL_INSERT);
                database.getPs().setString(1, data.getLibelle());
                database.getPs().setInt(2, data.getPlace());
                // database.getPs().setBoolean(4, data);
          
                  database.executeUpdate();
                  ResultSet rs=  database.getPs().getGeneratedKeys();
                if(rs.next()){
                  lastInsertId=rs.getInt(1) ; 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
          
            return lastInsertId;
    }

    @Override
    public int update(SalleEntity data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<SalleEntity> findAll() {
        ArrayList<SalleEntity> datas=new ArrayList<>();
                  try {
                      database.openConnexion();
                        database.initPreparedStatement(SQL_SELECT_ALL);
                    ResultSet resultSet=database.executeSelect();
                    while (resultSet.next()) {
                        
                        SalleEntity data=new SalleEntity( resultSet.getInt("id")
                                         , resultSet.getString("libelle")
                                         ,resultSet.getInt("place")
                                          );
                      

                         datas.add(data);
                           
                      }
                   resultSet.close();
                   database.closeConnexion();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erreur execution de Requete");
                }
            
            return datas;
    }

    @Override
    public int archiver(SalleEntity data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'archiver'");
    }

    @Override
    public int reinitialiser(SalleEntity data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reinitialiser'");
    }
    
}
