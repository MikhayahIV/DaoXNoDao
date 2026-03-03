package semDao;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static void main() {

        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        do{

            try {
                System.out.println("Digite o numero da operacao que deseja realizar: " +
                        "\n1 - Cadastrar Produto" +
                        "\n2 - Listar todos os produtos" +
                        "\n3 - buscar um produto por id" +
                        "\n4 - alterar informacoes de um produto" +
                        "\n5 - deletar produto" +
                        "\n6 - fechar programa");

                int escolha = scanner.nextInt();
                scanner.nextLine();
                opcao = escolha;

            } catch (IllegalArgumentException ex){
                System.out.println("ERRO: Por favor digite apenas o número da operaçao que deseja realizar");
            }

            switch (opcao){
                case 1:
                    try{
                        System.out.println("---- CADASTRAR PRODUTO ----");
                        System.out.print("Digite o nome do produto: ");
                        String name = scanner.nextLine();
                        System.out.print("Digite a descricao do produto: ");
                        String description = scanner.nextLine();
                        System.out.print("Digite o preco do produto: ");
                        double price = scanner.nextDouble();
                        System.out.print("Digite a quantidade do produto: ");
                        int quantity = scanner.nextInt();
                        Produtos prod = new Produtos(name,description,quantity,price);
                        prod.cadastarUsuario(prod);
                        System.out.println("Produto cadastrado com sucesso.");

                    } catch (SQLException | ClassNotFoundException ex){
                        System.out.println("ERROR: "+ex);
                    }break;
                case 2:
                    break;
            }
        }while (opcao !=6);

        //vai ficar com muitas linha esse krl

/*        try {
            Scanner scanner = new Scanner(System.in);
            Produtos prod = new Produtos();
            System.out.println(prod.listarTodosProdutos());


            System.out.print("Digite o id do produto: ");
            String id = scanner.nextLine();
            UUID uid = UUID.fromString(id);
            System.out.println(prod.listarProdPorId(uid));



          System.out.print("Digite o id do produto: ");
            String entradaId = scanner.nextLine();
            UUID id = UUID.fromString(entradaId);
            System.out.print("Digite o novo nome do produto: ");
            String name = scanner.nextLine();
            System.out.print("Digite a nova descricao do produto: ");
            String description = scanner.nextLine();
            System.out.print("Digite a quantidade de produto: ");
            int quantity = scanner.nextInt();
            System.out.print("Digite o valor do produto: ");
            double price = scanner.nextDouble();
            Produtos prod = new Produtos(name,description,quantity,price);
            prod.atualizarProdutoPorId(id,prod);

          System.out.print("Digite o id do produto que deseja deletar:  ");
            String entrada = scanner.nextLine();
            UUID id = UUID.fromString(entrada);
            Produtos prod = new Produtos();
            prod.deletarProdutoPorId(id);
          System.out.print("Digite o nome do produto: ");
            String name = scanner.nextLine();
            System.out.print("Digite a descricao do produto: ");
            String description = scanner.nextLine();
            System.out.print("Digite a quantidade de itens disponiveis: ");
            int quantity = scanner.nextInt();
            System.out.print("Digite o valor do item: ");
            Double price = scanner.nextDouble();
            Produtos prod = new Produtos(name,description,quantity,price);
            prod.cadastarUsuario(prod);
            System.out.println("Produto cadastrado com sucesso.");

        } catch (SQLException | ClassNotFoundException ex){
            System.out.println("ERROR: "+ex);
        }*/
    }
}
