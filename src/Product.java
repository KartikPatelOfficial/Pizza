class Product {

    private int id;
    private String name;
    private String details;
    private int price;

    Product(int id, String name, String details, int price) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getDetails() {
        return details;
    }

    int getPrice() {
        return price;
    }

}
