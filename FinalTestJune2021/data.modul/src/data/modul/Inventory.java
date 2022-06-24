package data.modul;


public class Inventory {
    private static int UID = 1;
    public final String ID_NUMBER;
    public Category category;
    public String invDescription;
    public double price;

    public Inventory(Category category, double price) {
        ID_NUMBER = String.valueOf(UID++);

        this.category = category;
        this.price = price;
        this.invDescription = String.format("Product - %s", ID_NUMBER);
    }

    public Category getCategory() {
        return this.category;
    }

    public double getPrice() {
        return price;
    }

    public String getInvDescription() {
        return invDescription;
    }

    public void setCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Cannot be null category!");
        }

        this.category = category;
    }


    public void setPrice(double price) {
        if (price < 0.0) {
            price = 0;
        }

        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product: %s%nCategory: %s%nPrice: %.2f%nSuppliers: %s%n", ID_NUMBER, category, price,
                category.getSuppliers());
    }
}
