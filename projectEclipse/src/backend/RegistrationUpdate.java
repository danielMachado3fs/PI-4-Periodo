package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistrationUpdate implements Update{
	Connection connection = ConectionBD.conectarBD();
	private ResultSet data;
	
	@Override
	public ResultSet buscaDados(String email, String cpf) {
		String sql = null;
		PreparedStatement command;
		try {
			if(cpf != null) {
				sql = "select from tb_visitante where cpf = ?";
				command = connection.prepareStatement(sql);
				command.setString(1, cpf);
			}else {
				sql = "select from tb_visitante where email = ?";
				command = connection.prepareStatement(sql);
				command.setString(1, email);
			}
				data = command.executeQuery();
			
		}catch(SQLException ex) {
			System.out.println("Erro ao buscar dados no banco");
		}
		return data;		
		
	}

	@Override
	public void preencheCampos() {
		
        /*ResultSet busca = LoginBackend.login(email);
        campo_senha.setText(senha);
        
        try {data.next();
        campo_nome.setText(data.getString("at_nome"));
        campo_email.setText(data.getString("at_email"));        
        campo_localizacao.setText(data.getString("at_localizacao"));   
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
		
	}

	@Override
	public String criptografaSenha(String senha) {
		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(senha.getBytes("utf8"));
		    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
	    }

	@Override
	public void atualizaDados(String nome, String email, String senha, String localizacao, String cpf) {
		String sql = "Update tb_visitante set at_nome = ?, at_email = ?, at_senha = ?, at_localizacao = ? where at_cpf = cpf";
		try {
			PreparedStatement command = connection.prepareStatement(sql);
			command.setString(1, nome);
			command.setString(2, email);
			command.setString(3, senha);
			command.setString(4, localizacao);
			command.setString(5, cpf);
			command.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar dados no banco");
			e.printStackTrace();
		}
		
	}
	
}
