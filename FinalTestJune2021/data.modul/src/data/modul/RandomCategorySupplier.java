package data.modul;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@FunctionalInterface
public interface RandomCategorySupplier extends Supplier<List<Inventory>> {
    private void updateType(Category type) {
        type.getSuppliers().clear();

        CanRandomize randomizer = CanRandomize.RAND;
        for (int i = 0; i < randomizer.GENERATOR.nextInt(4) + 1; i++) {
            type.getSuppliers().add(String.format("%s Supplier %d", type, i));
        }

        type.setReorderQty(randomizer.GENERATOR.nextInt(10 * type.getSuppliers().size()) + 1);
    }

    default List<Inventory> getRandomData(int howMany, int a, int b) {
        List<Inventory> result = new ArrayList<>();
        CanRandomize randomizer = CanRandomize.RAND;

        for (int i = 0; i < howMany; i++) {
            result.add(new Inventory(Category.values()[randomizer.GENERATOR.nextInt(Category.values().length)],
                    randomizer.GENERATOR.nextDouble() * (b - a) + a));
        }

        result.forEach(inv -> updateType(inv.getCategory()));
        return result;
    }
}
