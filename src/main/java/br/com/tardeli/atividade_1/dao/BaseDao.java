package br.com.tardeli.atividade_1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public abstract class BaseDao {
    private static final String SENHA = "admin";
    private static final String USUARIO = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/atividade_1";
    
    public Connection getConexao(){
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return null;
    }
}
