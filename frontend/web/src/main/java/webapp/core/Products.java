package webapp.core;


public class Products {
    private int idProducts;
    private String name;
    private int category;
    private int count;
    private double price;
    private int manufacturer;

    public Products(String name, int category, int count, double d, int manufacturer) {
        this.name = name;
        this.category = category;
        this.count = count;
        this.price = d;
        this.manufacturer = manufacturer;
    }

    public Products() {
    }

    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.manufacturer = manufacturer;
    }
   
}