package com.etf.rms.warehouse.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etf.rms.warehouse.exception.ResourceException;
public class ResourcesManager {

    
    
    /*
    Ovo se zove staticki inicijalizatorski blok...
    On se zapravo pozove pri inicijalizaciji klase pre nego sto se napravi bilo kakav objekat.
    U javi klase poziva Class Loader kada pokrenes program...
    */
    static {
    
        try {
            
            /*
            forName("com.mysql.jdbc.Driver")-inicijaliziju klasu com.mqsql.jdbc.Driver
            U sustini Class.forName("X"); vraca objekat klase Class koji je povezan sa imenom X, a sama inicijalizacija klase X,
            mozemo reci da je sporedni efekat... 
            
            ****OVO SAM PRONASAO U DOKUMENTACIJI> 
                Applications no longer need to explicitly load JDBC drivers using Class.forName().
            Existing programswhich currently load JDBC drivers using Class.forName() will continue to work withoutmodification. *****
            */
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Ova metoda pravi konekciju na bazu
    public static Connection getConnection() throws SQLException {
        Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3308/warehousedb?user=root&password=");
        System.out.println("Konekcija na bazu-USPESNA");
        return con;
    }

    //zatvaranje ResultSet-a i PreparedStatemant-a
    public static void closeResources(ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    //Zatvaranje konekcije na bazu
    public static void closeConnection(Connection con) throws ResourceException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new ResourceException("Failed to close database connection.", ex);
            }
        }
    }
    //vracanje transakcije. Vracanje na prethodno stanje baze podataka.
    public static void rollbackTransactions(Connection con) throws ResourceException {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new ResourceException("Failed to rollback database transactions.", ex);
            }
        }
    }
}
