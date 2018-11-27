import java.sql.*;
import java.util.ArrayList;

class DatabaseHalper {

    private Statement statement = null;

    DatabaseHalper() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", null);
            statement = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Get All Products
    ArrayList<Product> getAllProducts() throws SQLException {

        ArrayList<Product> products = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("select * from products;");

        while (resultSet.next()) {
            products.add(
                    new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4)
                    )
            );
        }

        return products;
    }

    //Add new Product
    void addNewProduct(Product product) throws SQLException {
        String values = product.getId() + ",\"" + product.getName() + "\",\"" + product.getDetails() + "\"," + product.getPrice();
        statement.execute("insert into products(_id,name,detail,price) values (" + values + ")");
    }

    //Add new Order
    void addNewOrder(Order order) throws SQLException {
        String values = order.getId() + "," + order.getProductID() + ",\"" + order.getCustomerName() + "\",\"" + order.getCustomerNumber() + "\"";
        statement.execute("insert into history(_id,productID,customerName,customerPhone) values (" + values + ")");

    }

    //Get All Orders
    ArrayList<Order> getAllOrder() throws SQLException {

        ArrayList<Order> orders = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select * from history;");

        while (resultSet.next()) {
            orders.add(
                    new Order(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    )
            );
        }
        return orders;
    }

    //Get Order With Name
    ArrayList<Order> getAllOrder(int id) throws SQLException {

        ArrayList<Order> orders = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select * from history where _id = " + id + ";");

        while (resultSet.next()) {
            orders.add(
                    new Order(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    )
            );
        }
        return orders;
    }

}  