/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.warehouse.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pikacu
 */
public class ResourcesManager {
/**
 * Ova klasa treba da implementira:
 * getConnection();
 * closeConnectiol(Connection con);
 * rollbackTransaction(Connection con);
 * closeResources(PrepairedStatemant ps, ResultSet rs);
 */
    //staticki inicijalizatorski blok...
    static {
        try {
            /*
            forName("com.mysql.jdbc.Driver")-inicijaliziju klasu com.mqsql.jdbc.Driver
            U sustini Class.forName("X"); vraca objekat klase Class koji je povezan sa imenom X, a sama inicijalizacija klase X,
            mozemo reci da je sporedni efekat... 
            Izgleda da ovo nije nepohdono visi... tako bar pise u dokumentaciji.
            */
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

public static Connection getConnection() throws SQLException{
       
    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/warehouse?user=root&password=");
    
    return con;
    
}    

public static void closeConnection(Connection con) throws SQLException{
    
    if(con!=null)
    con.close();
}

public static void closeResources(PreparedStatement ps,ResultSet rs) throws SQLException{
    if(ps!=null)
        ps.close();
    if(rs!=null)
        rs.close();
}

public static void rollbackTransaction(Connection con) throws SQLException{
    if(con!=null)
        con.rollback();
}

}
