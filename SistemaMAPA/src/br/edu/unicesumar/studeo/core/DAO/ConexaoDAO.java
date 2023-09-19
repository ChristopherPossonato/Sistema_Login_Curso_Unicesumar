package br.edu.unicesumar.studeo.core.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/mapa?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Pneumo2709*";

    private static Connection conexao;

    public static Connection getConexao() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão bem-sucedida");
                return conexao;
            } else {
                System.out.println("Conexão reutilizada");
            }
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
