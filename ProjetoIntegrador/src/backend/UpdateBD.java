package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class UpdateBD {
    //Busca dados do usuário no banco
    public static ResultSet queryUser(String data) {
        ResultSet resultado=null;
        String sql = null;
        Connection connection = ConnectionBD.connectBD();
        if(data.length() == 11){
            sql =  "SELECT * FROM tb_visitante WHERE at_cpf = ?;";
        }else{
            sql =  "SELECT * FROM tb_visitante WHERE at_email = ?;";
        }
        try {
            PreparedStatement comando = connection.prepareStatement( sql );
            comando.setString(1, data);
            resultado = comando.executeQuery();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de contatos.");
        }
        System.out.println(resultado);
        return resultado;
    }

    //Atualiza dados do usuário no banco
    public static int updateUser(String nome, String email, String senha, String localizacao, String cpf) {
        int codErro = 0;
        Connection connection = ConnectionBD.connectBD();

        try {
            String sql = "UPDATE tb_visitante SET at_nome=?, at_email=?, at_senha=?, at_localizacao=? WHERE at_cpf=? ;" ;
            PreparedStatement comando = connection.prepareStatement( sql );
            comando.setString(1, nome);
            comando.setString(2, email);
            comando.setString(3, senha);
            comando.setString(4, localizacao);
            comando.setString(5, cpf);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao atualizar cadastro: "+ex.toString());
            codErro = 1;
        }
        return codErro;
    }
    public static String getSHA256(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }
}
