package br.com.tardeli.atividade_1.tela;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class Principal {
    static int opcao = 0;
    static TelaPessoa tp = new TelaPessoa();

    public static void main(String[] args) {
        
        do {
            menu();   
            switch (opcao) {
                case 1:
                    tp.cadastrarConsole();
                    break;
                case 2:
                    tp.listarConsole();
                    break;
                case 0:
                    System.out.println("Você saiu do sistema - Volte Logo!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (opcao != 0);

    }

    private static void menu() {
        System.out.println("\n");
            System.out.println("|===========MENU===========|");
            System.out.println("| Menu Cadastro de Pessoas |");
            System.out.println("| 1-CADASTRAR              |");
            System.out.println("| 2-LISTAR                 |");
            System.out.println("| 0-SAIR                   |");
            System.out.println("|==========================|");
            System.out.println("Escolha uma opção: ");
            opcao = tp.teclado.nextInt();
            System.out.println("\n");
    }

}
