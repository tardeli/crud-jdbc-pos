package br.com.tardeli.atividade_1.modelo;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class Pessoa {
    private long codigo;
    private String nome;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
 
}
