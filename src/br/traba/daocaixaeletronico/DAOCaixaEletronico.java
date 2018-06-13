package br.traba.daocaixaeletronico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.traba.caixaeletronico.Caixa;
import br.traba.util.ConexaoDB;


public class DAOCaixaEletronico {

	public Integer atualizaNota(int tipo) {
		try {
			// 1º Passo - Abrir e obter conexÃ£o
			Connection con = ConexaoDB.getConexao();

			// 2º Passo - Criar e executar instrução SQL (e obter resultados se houver)
			String sql = "SELECT Cedula FROM Cedula WHERE Tipo = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tipo);
			// Executa o comando SQL preparado acima e obtem o resultado da consulta
			ResultSet rs = ps.executeQuery();
			
			
		  	Integer cedula = rs.getInt("Cedula");		
			// 3º Passo - Encerrar o processo de execução de instruçoes e a conexão.
			ps.close();
			con.close();
			
			return cedula;
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Integer cotaMinima() {
		try {
			// 1º Passo - Abrir e obter conexÃ£o
			Connection con = ConexaoDB.getConexao();

			// 2º Passo - Criar e executar instrução SQL (e obter resultados se houver)
			String sql = "SELECT*FROM CotaMinima";
			PreparedStatement ps = con.prepareStatement(sql);
			// Executa o comando SQL preparado acima e obtem o resultado da consulta
			ResultSet rs = ps.executeQuery();
		  	Integer cotaminima = rs.getInt("CotaMinima");		
			// 3º Passo - Encerrar o processo de execução de instruçoes e a conexão.
			ps.close();
			con.close();
			
			return cotaminima;
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public void cotaMinima(Integer cotaminima) {
		try {
			// 1º Passo - Abrir e obter conexÃ£o
			Connection con = ConexaoDB.getConexao();
			// 2º Passo - Criar e executar instrução SQL (e obter resultados se houver)
			String sql = "UPDATE CotaMinima SET CotaMinima = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cotaminima);
			// Executa o comando SQL preparado acima e obtem o resultado da consulta
			ps.executeUpdate();	
			// 3º Passo - Encerrar o processo de execução de instruçoes e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void atualizaNota(int tipo,Integer quantidade) {
		
		try {
			// 1º Passo - Abrir e obter conexÃ£o
			Connection con = ConexaoDB.getConexao();

			// 2º Passo - Criar e executar instrução SQL (e obter resultados se houver)
			String sql = "UPDATE Cedula SET Cedula = ? WHERE Tipo = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, quantidade);
			ps.setInt(2, tipo);
			// Executa o comando SQL preparado acima e obtem o resultado da consulta
			ps.executeUpdate();
		 	// 3º Passo - Encerrar o processo de execução de instruçoes e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void extratoAdd(String extrato) {
		try {
			// 1º Passo - Abrir e obter conexÃ£o
			Connection con = ConexaoDB.getConexao();

			// 2º Passo - Criar e executar instrução SQL (e obter resultados se houver)
			String sql = "INSERT INTO Extrato Values (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,extrato);
			// Executa o comando SQL preparado acima e obtem o resultado da consulta
			ps.executeUpdate();
			// 3º Passo - Encerrar o processo de execução de instruçoes e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public void esvaziaExtrato() {
		try {
			// 1º Passo - Abrir e obter conexÃ£o
			Connection con = ConexaoDB.getConexao();

			// 2º Passo - Criar e executar instrução SQL (e obter resultados se houver)
			String sql = "DELETE FROM Extrato";
			PreparedStatement ps = con.prepareStatement(sql);
			// Executa o comando SQL preparado acima e obtem o resultado da consulta
			ps.executeUpdate();
			// 3º Passo - Encerrar o processo de execução de instruçoes e a conexão.
			ps.close();
			con.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public ArrayList<Caixa> listAll() {
		try {
			//1Âº Passo - Abrir e obter conexÃ£o
			Connection con = ConexaoDB.getConexao();
			
			//2Âº Passo - Criar e executar instruÃ§Ã£o SQL (e obter resultados se houver)
			String sql = "SELECT * FROM Extrato ";
			PreparedStatement ps = con.prepareStatement(sql);
			//Executa o comando SQL preparado acima e obtÃ©m o resultado da consulta
			ResultSet rs = ps.executeQuery();
			//Cria um objeto aluno com os dados retornado do banco
		      ArrayList<Caixa> extrato = new ArrayList<>();
			while(rs.next()) {
				Caixa  extratos = new Caixa();
				extratos.setExtrato(rs.getString("Extrato"));
				extrato.add(extratos);
			}
			
			//3Âº Passo - Encerrar o processo de execuÃ§Ã£o de instruÃ§Ãµes e a conexÃ£o.
			ps.close();
			con.close();
			
			return extrato; //Retorna o objeto aluno criado
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	
	}
}