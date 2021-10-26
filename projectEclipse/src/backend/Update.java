package backend;

import java.sql.ResultSet;

public interface Update {

	ResultSet buscaDados(String email, String cpf);

	void preencheCampos();

	String criptografaSenha(String senha);

	void atualizaDados(String nome, String email, String senha, String localizacao, String cpf);

}
