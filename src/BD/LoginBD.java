package BD;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginBD {

    public Connection LoginBD(String usuario,String senha) {
        System.out.println("Conectando no banco de dados.....");
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/curso", usuario, senha);
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar...");
            return null;
        }
    }
}