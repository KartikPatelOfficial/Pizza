class Order {

    private int id;
    private int productID;
    private String customerName;
    private String customerNumber;

    Order(int _id, int productID, String customerName, String customerNumber) {
        this.id = _id;
        this.productID = productID;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
    }

    int getId() {
        return id;
    }

    int getProductID() {
        return productID;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCustomerNumber() {
        return customerNumber;
    }
}
