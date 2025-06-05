import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControladorContatos controlador = new ControladorContatos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Controle de Contatos ---");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Remover contato");
            System.out.println("4. Filtrar por nome");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    controlador.adicionar(nome, telefone, email);
                    System.out.println("Contato adicionado.");
                    break;
                case 2:
                    List<Contato> lista = controlador.listar();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum contato encontrado.");
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(i + ": " + lista.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Índice do contato a remover: ");
                    int indice = scanner.nextInt();
                    controlador.remover(indice);
                    System.out.println("Contato removido.");
                    break;
                case 4:
                    System.out.print("Nome para filtro: ");
                    String filtro = scanner.nextLine();
                    List<Contato> filtrados = controlador.filtrarPorNome(filtro);
                    for (Contato c : filtrados) {
                        System.out.println(c);
                    }
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
