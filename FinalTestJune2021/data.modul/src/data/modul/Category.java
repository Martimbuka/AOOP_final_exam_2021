package data.modul;

import java.util.ArrayList;
import java.util.List;
public enum Category {
    A(1, new ArrayList<>()),
    B(2, new ArrayList<>()),
    C(3, new ArrayList<>()),
    D(4, new ArrayList<>());

    private int reorderQty;
    private List<String> suppliers;

    Category(int num, List<String> listOfStrings) {
        this.reorderQty = num;
        this.suppliers = listOfStrings;
    }

    public int getReorderQty() {
        return this.reorderQty;
    }

    public List<String> getSuppliers() {
        return this.suppliers;
    }

    public void setSuppliers(List<String> supps) {
        if (supps == null) {
            this.suppliers = new ArrayList<>();
        } else {
            this.suppliers = supps;
        }
    }

    public void setReorderQty(int num) {
        reorderQty = num;
    }
}
