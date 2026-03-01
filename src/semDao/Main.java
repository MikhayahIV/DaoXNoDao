package semDao;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static void main() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o id do produto que deseja deletar:  ");
            String entrada = scanner.nextLine();
            UUID id = UUID.fromString(entrada);
            Produtos prod = new Produtos();
            prod.deletarProduto(id);
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
