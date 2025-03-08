package models;

import java.util.LinkedHashMap;

public class TypeIncrement {
    private LinkedHashMap <String, Long> typeIncrement;

    public TypeIncrement() {
        typeIncrement = new LinkedHashMap<>();
        // Set values that card type will be increment to the offset base
        typeIncrement.put("Dragon", 0L);
        typeIncrement.put("Spellcaster", 6L);
        typeIncrement.put("Zombie", 12L);
        typeIncrement.put("Warrior", 18L);
        typeIncrement.put("BeastWarrior", 24L);
        typeIncrement.put("Beast", 30L);
        typeIncrement.put("WingedBeast", 36L);
        typeIncrement.put("Fiend", 42L);
        typeIncrement.put("Fairy", 48L);
        typeIncrement.put("Insect", 54L);
        typeIncrement.put("Dinosaur", 60L);
        typeIncrement.put("Reptile", 66L);
        typeIncrement.put("Fish", 72L);
        typeIncrement.put("SeaSerpent", 78L);
        typeIncrement.put("Machine", 84L);
        typeIncrement.put("Thunder", 90L);
        typeIncrement.put("Aqua", 96L);
        typeIncrement.put("Pyro", 102L);
        typeIncrement.put("Rock", 108L);
        typeIncrement.put("Plant", 114L);
    }

    public LinkedHashMap <String, Long> getTypeIncrement() {
        return typeIncrement;
    }

}
