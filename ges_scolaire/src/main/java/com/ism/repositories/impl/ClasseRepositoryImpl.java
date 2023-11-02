package com.ism.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ism.entities.ClasseEntity;
import com.ism.entities.ModuleEntity;
import com.ism.repositories.ClasseRepository;
import com.ism.repositories.DataBase;

public class ClasseRepositoryImpl implements ClasseRepository {
    private final String SQL_INSERT="INSERT INTO `classe` (`nom`,  `filiere`,  `niveau`) VALUES (?,?,?)";
    private final String SQL_SELECT_MODULE_FROM_CLASSE="SELECT m.libelle FROM module m INNER JOIN affectation a ON m.id = a.module_id WHERE a.classe_id = ?";
    private final String  SQL_SELECT_ALL="SELECT * FROM classe";
    // private final String  SQL_UPDATE="SELECT * FROM classe";

    private DataBase dataBase;
    public ClasseRepositoryImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public int insert(ClasseEntity data) {
        int lastInsertId=0;
            try {
                dataBase.openConnexion();
                dataBase.initPreparedStatement(SQL_INSERT);
                dataBase.getPs().setString(1,data.getNom());
                dataBase.getPs().setString(2,data.getFiliere());
                dataBase.getPs().setString(3,data.getNiveau());
                // dataBase.getPs().setInt(4,data.getModule_id());
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
    public List<ClasseEntity> findAll() {
        ArrayList<ClasseEntity> datas=new ArrayList<>();
                  try {
                      dataBase.openConnexion();
                        dataBase.initPreparedStatement(SQL_SELECT_ALL);
                    ResultSet resultSet=dataBase.executeSelect();
                    while (resultSet.next()) {
                        
                        ClasseEntity data=new ClasseEntity( resultSet.getInt("id")
                                         , resultSet.getString("nom")
                                         ,resultSet.getString("filiere")
                                          ,resultSet.getString("niveau")
                                        //   ,resultSet.getInt("module_id")
                                          );

                         datas.add(data);
                           
                      }
                   resultSet.close();
                   dataBase.closeConnexion();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erreur execution de Requete");
                }
            
            return datas;
    }

    @Override
    public int update(ClasseEntity data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<ModuleEntity> findModuleFromClasse(int id) {
        ArrayList<ModuleEntity> datas=new ArrayList<>();
                  try {
                      dataBase.openConnexion();
                        dataBase.initPreparedStatement(SQL_SELECT_MODULE_FROM_CLASSE);
                        dataBase.getPs().setInt(1,id);
                    ResultSet resultSet=dataBase.executeSelect();
                    while (resultSet.next()) {
                        
                        ModuleEntity data=new ModuleEntity(resultSet.getString("libelle"));

                         datas.add(data);
                           
                      }
                   resultSet.close();
                   dataBase.closeConnexion();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erreur execution de Requete");
                }
            
            return datas;
    }

  
    
}
