package semDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String DRIVER = "org.postgresql.Driver";
        String URL = "jdbc:postgresql://localhost:5434/dbForDesignerPatterns";
        String USERNAME = "JAYSIX";
        String PASSWROD = "NovaKk666";
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
}
