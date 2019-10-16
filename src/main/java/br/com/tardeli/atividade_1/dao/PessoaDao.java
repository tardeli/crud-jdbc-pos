package br.com.tardeli.atividade_1.dao;

import br.com.tardeli.atividade_1.modelo.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class PessoaDao extends BaseDao {

    public boolean cadastrar(Pessoa pessoa) {
        String sql = "insert into pessoa (nome) values (?)";
        try {
            PreparedStatement stmt = getConexao().prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.execute();
            stmt.close();
            getConexao().close();
            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return false;
    }

    public List<Pessoa> listar() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            PreparedStatement stmt = getConexao().prepareStatement("select * from pessoa");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long codigo = rs.getLong("codigo");
                String nome = rs.getString("nome");
                Pessoa obj = new Pessoa(codigo, nome);
                pessoas.add(obj);    
            }
            getConexao().close();
            return pessoas;
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return pessoas;
    }

}
