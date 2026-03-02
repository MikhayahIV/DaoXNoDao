package semDao;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static void main() {
        try {
            Scanner scanner = new Scanner(System.in);
            Produtos prod = new Produtos();
            System.out.print("Digite o id do produto: ");
            String id = scanner.nextLine();
            UUID uid = UUID.fromString(id);
            System.out.println(prod.listarProdPorId(uid));


/*          System.out.print("Digite o id do produto: ");
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
            prod.atualizarProdutoPorId(id,prod);*/

/*          System.out.print("Digite o id do produto que deseja deletar:  ");
            String entrada = scanner.nextLine();
            UUID id = UUID.fromString(entrada);
            Produtos prod = new Produtos();
            prod.deletarProdutoPorId(id);*/
/*          System.out.print("Digite o nome do produto: ");
            String name = scanner.nextLine();
            System.out.print("Digite a descricao do produto: ");
            String description = scanner.nextLine();
            System.out.print("Digite a quantidade de itens disponiveis: ");
            int quantity = scanner.nextInt();
            System.out.print("Digite o valor do item: ");
            Double price = scanner.nextDouble();
            Produtos prod = new Produtos(name,description,quantity,price);
            prod.cadastarUsuario(prod);
            System.out.println("Produto cadastrado com sucesso.");*/

        } catch (SQLException | ClassNotFoundException ex){
            System.out.println("ERROR: "+ex);
        }
    }
}
