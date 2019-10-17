package br.com.tardeli.atividade_1.tela;

import br.com.tardeli.atividade_1.dao.PessoaDao;
import br.com.tardeli.atividade_1.modelo.Pessoa;
import java.util.Scanner;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class TelaPessoa {

    private Scanner teclado = new Scanner(System.in);

    private Pessoa p = new Pessoa();
    private PessoaDao pessoaDao = new PessoaDao();

    public Scanner getTeclado() {
        return teclado;
    }

    public void cadastrarConsole() {

        teclado.nextLine();
        System.out.println("Digite um nome: ");
        p.setNome(teclado.nextLine());

        if (pessoaDao.cadastrar(p)) {
            System.out.println("Salvo pessoa de nome: " + p.getNome() + ", com sucesso!!!");
        } else {
            System.out.println("*****Erro ao salvar*****");
        }

    }

    public void atualizarConsole() {
        String codigo = "";
        Pessoa obj = new Pessoa();

        teclado.nextLine();
        System.out.println("Digite um código de pessoa para atualizar: ");

        codigo = teclado.nextLine();

        obj = pessoaDao.buscarPorId(Long.parseLong(codigo));

        
        if (obj.getCodigo() > 0) {
            System.out.println("Digite um nome: ");
            obj.setNome(teclado.nextLine());

            if (pessoaDao.atualizar(obj)) {
                System.out.println("Atualizado pessoa de nome: " + obj.getNome() + ", com sucesso!!!");
            } else {
                System.out.println("*****Erro ao atualizar*****");
            }
        } else {
            System.out.println("*****Pessoa não localizada*****");
        }

    }
    
    public void excluirConsole() {
        String codigo = "";
        Pessoa obj = new Pessoa();

        teclado.nextLine();
        System.out.println("Digite um código de pessoa para excluir: ");

        codigo = teclado.nextLine();
        
        if (pessoaDao.excluir(Long.parseLong(codigo))) {
            System.out.println("Excluido com sucesso!!!");
        } else {
            System.out.println("*****Erro ao excluir*****");
        }
        
        
    }

    public void buscarPorIdConsole() {
        String codigo = "";
        Pessoa obj = new Pessoa();

        teclado.nextLine();
        System.out.println("Digite um código: ");

        codigo = teclado.nextLine();

        obj = pessoaDao.buscarPorId(Long.parseLong(codigo));

        if (obj.getCodigo() > 0) {
            System.out.println(obj.toString());
        } else {
            System.out.println("*****Pessoa não localizada*****");
        }

    }

    public void listarConsole() {
        for (Pessoa obj : pessoaDao.listar()) {
            System.out.println(obj.toString());
        }
    }

}
