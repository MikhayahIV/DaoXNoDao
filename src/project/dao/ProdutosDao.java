package project.dao;

import project.config.FabricarConexao;
import project.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutosDao {

    public void  cadastrarProduto(Produto pd) throws SQLException,ClassNotFoundException{
        String SQL = "INSERT INTO PRODUTOS (NAME,DESCRIPTION,PRICE,QUANTITY) VALUES(?,?,?,?)";
        try(Connection conn = FabricarConexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(SQL);) {
            stmt.setString(1,pd.getName());
            stmt.setString(2, pd.getDescription());
            stmt.setDouble(3,pd.getPrice());
            stmt.setInt(4,pd.getQuantity());
            stmt.execute();
        } catch (SQLException | ClassNotFoundException ex){
            System.out.println("ERROR: "+ex);
        }
    }
}
