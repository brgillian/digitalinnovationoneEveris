package com.digitalinnovationone.projeto.connectiondatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    
    // Parâmetros para conexão com banco de dados
    String driver = "mysql";
    String dataBaseAddress = "localhost";
    String dataBaseName = "digital_innovation_one";
    String user = "root";
    String password = "password";

    // Construção da String de Conexão
    StringBuilder sb = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append(":3606/")
                .append(dataBaseName);

                String connectionUrl = sb.toString();{ //sb.toString() == "jdbc:mysql://localhost/digital_innovation_one" 

                try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
                    System.out.println("SUCESSO ao se conectar ao banco MySQL!");
                } catch (SQLException e) {
                    System.out.println("FALHA ao se conectar ao banco MySQL!");
                    e.printStackTrace();
                }
        
            }
}
