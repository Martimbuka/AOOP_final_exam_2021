package data.modul;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManagement {
    private List<Inventory> inventories;
    private RandomCategorySupplier supplier;

    public InventoryManagement() {
        this.supplier = ArrayList::new;
        this.inventories = supplier.getRandomData(10, 0, 100);
    }

    public String showInventory() {
        return inventories
                .stream()
                .map(Inventory::toString)
                .collect(Collectors.joining("\n"));
    }

    public double averagePrice() {
        return inventories
                .stream()
                .mapToDouble(Inventory::getPrice)
                .average()
                .getAsDouble();
    }

    public List<Inventory> sortInventoryTypeAndID() {
        return inventories
                .stream()
                .sorted(Comparator.comparing(Inventory::getCategory).thenComparing(a -> a.ID_NUMBER))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public String findLargestPricePerCategory() {
        return inventories
                .stream()
                .collect(Collectors.groupingBy(Inventory::getCategory))
                .entrySet()
                .stream()
                .map(entry -> String.format("%s\n%s", entry.getKey(),
                        entry.getValue()
                                .stream()
                                .max(Comparator.comparing(Inventory::getPrice))
                                .get()))
                .reduce("The largest price per categories:", (a, b) -> a + "\n" + b);
    }
}

