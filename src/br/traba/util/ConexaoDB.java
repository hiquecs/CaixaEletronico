package br.traba.util;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoDB {
	public static Connection getConexao() {		
		try {
			
			//Carregando o Driver do SQLite e suas bibliotecas
			//Esta linha poderÃ¡ causar uma exceÃ§Ã£o em tempo de compilaÃ§Ã£o 
			//chamada ClassNotFoundException
			Class.forName("org.sqlite.JDBC");
			
			String url = "jdbc:sqlite:CaixaEletronicoDB.db";  
			
			//Estabelecendo e obtendo uma conexÃ£o com o Banco de dados
			//Esta linha poderÃ¡ causar uma exceÃ§Ã£o em tempo de compilaÃ§Ã£o 
			//chamada SQLException
			return DriverManager.getConnection(url);

		} catch (Exception e) {
			//Caso uma das duas linhas especificada causem alguma exceÃ§Ã£o
			//este bloco irÃ¡ tratar lanÃ§ando uma exceÃ§Ã£o em tempo de execuÃ§Ã£o.
			throw new RuntimeException(e.getMessage());
		}
		
	}
}

