package bai07_abstract_interface.thuc_hanh.ex_1_animal_editable.animal;

import bai07_abstract_interface.thuc_hanh.ex_1_animal_editable.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
