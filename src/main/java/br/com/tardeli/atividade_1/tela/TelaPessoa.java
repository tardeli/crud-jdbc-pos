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
        
    public void cadastrarConsole(){
              
        teclado.nextLine();
        System.out.println("Digite um nome: ");
        p.setNome(teclado.nextLine());
                
        if(pessoaDao.cadastrar(p))
            System.out.println("Salvo pessoa de nome: "+p.getNome()+", com sucesso!!!");
        else
            System.out.println("*****Erro ao salvar*****");
        
    }
    
    public void listarConsole(){
        for (Pessoa obj: pessoaDao.listar()) {
            System.out.println(obj.toString());
        }
    }
    
}
