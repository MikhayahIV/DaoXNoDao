package semDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class Produtos {

    private UUID id;
    private String name;
    private String description;
    private int quantity;
    private Double price;

    public Produtos() {
    }

    public Produtos( String name, String description, int quantity, Double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Produtos(UUID id, String name, String description, int quantity, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static Connection getConexao() throws SQLException, ClassNotFoundException{
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(".env")) {
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("Could not find .env file!");
            e.printStackTrace();
        }
        String DRIVER = prop.getProperty("DB_DRIVER");
        String URL = prop.getProperty("DB_URL");
        String USERNAME = prop.getProperty("DB_USER");
        String PASSWROD = prop.getProperty("DB_PASSWORD");

        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USERNAME,PASSWROD);
    }

    public void cadastarUsuario(Produtos prod) throws SQLException, ClassNotFoundException{
        Connection conn = getConexao();
        String SQL = "INSERT INTO PRODUTOS(NAME,DESCRIPTION,QUANTITY,PRICE) VALUES(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(SQL);
        stmt.setString(1,prod.getName());
        stmt.setString(2,prod.getDescription());
        stmt.setInt(3,prod.getQuantity());
        stmt.setDouble(4,prod.getPrice());
        stmt.execute();
        conn.close();
    }

    public void deletarProdutoPorId(UUID id) throws SQLException,ClassNotFoundException{
        Connection coon = getConexao();
        String SQL = "DELETE FROM PRODUTOS WHERE ID = ?";
        PreparedStatement stmt = coon.prepareStatement(SQL);
        stmt.setObject(1,id);
        stmt.execute();
        coon.close();
    }

    public void atualizarProdutoPorId(UUID id, Produtos prod) throws SQLException,ClassNotFoundException{
        Connection conn = getConexao();
        String SQL = "UPDATE PRODUTOS SET NAME = ?, DESCRIPTION = ?, QUANTITY = ?, PRICE = ? WHERE ID = ? ";
        PreparedStatement stmt = conn.prepareStatement(SQL);
        stmt.setString(1,prod.getName());
        stmt.setString(2,prod.getDescription());
        stmt.setInt(3,prod.getQuantity());
        stmt.setDouble(4,prod.getPrice());
        stmt.setObject(5,id);
        stmt.execute();
        conn.close();
    }

    public List<Produtos> listarTodosProdutos() throws SQLException, ClassNotFoundException{
        Connection conn = getConexao();
        String SQL = "SELECT * FROM PRODUTOS";
        PreparedStatement stmt = conn.prepareStatement(SQL);
        ResultSet resultSet = stmt.executeQuery();
        List<Produtos> listapd = new LinkedList();
        while (resultSet.next()){
            Produtos prod = new Produtos();
            prod.setId((UUID) resultSet.getObject("ID"));
            prod.setName(resultSet.getString("NAME"));
            prod.setDescription(resultSet.getString("DESCRIPTION"));
            prod.setPrice(resultSet.getDouble("QUANTITY"));
            prod.setQuantity(resultSet.getInt("PRICE"));
            listapd.add(prod);
        }
        conn.close();
        return listapd;
    }

     public Produtos listarProdPorId(UUID id) throws SQLException, ClassNotFoundException{
        Connection conn = getConexao();
        String SQL = "SELECT * FROM PRODUTOS WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(SQL);
        stmt.setObject(1,id);
        ResultSet resultSet = stmt.executeQuery();
        Produtos prod = new Produtos();
        if(resultSet.next()) {
            prod.setId(id);
            prod.setName(resultSet.getString("NAME"));
            prod.setDescription(resultSet.getString("DESCRIPTION"));
            prod.setQuantity(resultSet.getInt("QUANTITY"));
            prod.setPrice(resultSet.getDouble("PRICE"));
        }
        conn.close();
        return prod;
    }

    @Override
    public String toString() {
        return "\nProduto: " +
                "\nID: " + id +
                "\nname: " + name +
                "\nDESCRIPTION: " + description +
                "\nQUANTITY: " + quantity +
                "\nPRICE: " + price +
                "\n"+ "-".repeat(25)
                ;
    }
}
