package project.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricarConexao {

    public static Connection getConexao() throws SQLException, ClassNotFoundException{
        Properties prop = new Properties();
        try(FileInputStream fis = new FileInputStream(".env")) {
            prop.load(fis);
        }catch (IOException ex){
            System.out.println("ERRO: "+ex);
        }

        String DRIVER = prop.getProperty("DB_DRIVER");
        String URL = prop.getProperty("DB_URL");
        String USERNAME = prop.getProperty("DB_USER");
        String PASSWORD = prop.getProperty("DB_PASSWORD");

        Class.forName(DRIVER);

        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
