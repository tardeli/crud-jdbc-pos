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

    public boolean atualizar(Pessoa pessoa) {

        String sql = "update pessoa set nome=? where codigo=?";
        try {
            PreparedStatement stmt = getConexao().prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setLong(2, pessoa.getCodigo());
            stmt.execute();
            stmt.close();
            getConexao().close();
            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return false;
    }

    public Pessoa buscarPorId(long codigo) {
        String sql = "select * from pessoa where codigo=?";
        Pessoa p = new Pessoa();
        try {
            PreparedStatement stmt = getConexao().prepareStatement(sql);
            stmt.setLong(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p.setCodigo(rs.getLong("codigo"));
                p.setNome(rs.getString("nome"));
            }
            getConexao().close();
            return p;
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return p;
    }

    public boolean excluir(long codigo) {
        String sql = "delete from pessoa where codigo=?";
        try {
            PreparedStatement stmt = getConexao().prepareStatement(sql);
            stmt.setLong(1, codigo);
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
        String sql = "select * from pessoa";
        try {
            PreparedStatement stmt = getConexao().prepareStatement(sql);
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
