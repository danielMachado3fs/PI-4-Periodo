package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    public static Connection connectBD() {
        Connection connection=null;
        try {
            if ( connection == null ) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_museu?useTimezone=true&serverTimezone=UTC", "root", "297369Da@");
                System.out.println("Banco de dados conectado!");
            }
        }
        catch(SQLException e) {
            System.out.println("Não foi possivel conectar com o banco de dados" + e.toString());
            System.exit(1);
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erro: driver do banco não encontrado");
            System.exit(1);
        }
        return connection;
    }
    public static void main(String[] args) {
        connectBD();
    }

    /*
    * Passos para dicionar um external jar no IntelliJ:

        Cliquem em File na barra de tarefas
        Selecione a opção Project Structure (CTRL + SHIFT + ALT + S no Windows/Linux, ⌘ + ; no Mac OS X)
        Selecione Modules no painel esquerdo
        Selecione a tab Dependencies
        Selecione o icone +
        Selecione a opção 1 JARs or directories
    */
}
