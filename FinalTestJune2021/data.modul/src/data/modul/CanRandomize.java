package data.modul;

import java.util.Random;

public enum CanRandomize {
    RAND(new Random());
    public final Random GENERATOR;

    CanRandomize(Random generator) {
        GENERATOR = generator;
    }

}
