package project.presentation;

import project.model.Produto;
import project.dao.ProdutosDao;

import java.sql.SQLException;
import java.util.Scanner;

public class controller {

    public static void HandleCaastro(Scanner scanner, ProdutosDao service){
        try {
            System.out.println("---- CADASTRAR PRODUTO ----");
            System.out.print("Digite o nome do produto: ");
            String name = scanner.nextLine();
            System.out.print("Digite a descricao do produto: ");
            String description = scanner.nextLine();
            System.out.print("Digite o preco do produto (Unidade) : ");
            double price = scanner.nextDouble();
            System.out.print("Digite a quantidade de produtos: ");
            int quantity = scanner.nextInt();
            Produto pd = new Produto(name,description,quantity,price);
            service.cadastrarProduto(pd);
        } catch (SQLException | ClassNotFoundException ex){
            System.out.println("ERROR: "+ex);
        }
    }
}
