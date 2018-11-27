import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class PizzaApp {


    //Usage of the database helper
    public static void main(String[] args) {

        //Create object
        DatabaseHalper halper = new DatabaseHalper();

        //Add new product
        try {
            int id = (int) Calendar.getInstance().getTimeInMillis(); //use this id
            Product product = new Product(id, "Name", "Detail", 100);
            halper.addNewProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Add New Order
        try {
            int id = (int) Calendar.getInstance().getTimeInMillis(); //use this id
            Order order = new Order(id, 1, "Kartik Patel", "6352122123");
            halper.addNewOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Get All Products
        try {
            ArrayList<Product> products = halper.getAllProducts();
            for (Product product : products) {
                System.out.println(product.getId() + " | " + product.getName() + " | " + product.getDetails() + " | " + product.getPrice() + " | ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Get All Orders with name
        try {
            ArrayList<Order> products = halper.getAllOrder(1412275286);
            for (Order product : products) {
                System.out.println(product.getId() + " | " + product.getProductID() + " | " + product.getCustomerName() + " | " + product.getCustomerNumber() + " | ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Get All Orders
        try {
            ArrayList<Order> products = halper.getAllOrder();
            for (Order product : products) {
                System.out.println(product.getId() + " | " + product.getProductID() + " | " + product.getCustomerName() + " | " + product.getCustomerNumber() + " | ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
