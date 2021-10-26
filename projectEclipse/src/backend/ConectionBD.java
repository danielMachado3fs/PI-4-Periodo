package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionBD {
    public static Connection conectarBD() {
        Connection conexao=null;
        try {
            if ( conexao == null ) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_museu?useTimezone=true&serverTimezone=UTC", "root", "");
                System.out.println("Banco de dados conectado!");
            }
        }
        catch(SQLException e) {
            System.out.println("N�o foi possivel conectar com o banco de dados" + e.toString());
            System.exit(1);
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erro: driver do banco n�o encontrado");
            System.exit(1);
        }
        return conexao;
    }
    public static void main(String[] args) {
        conectarBD();
    }
}