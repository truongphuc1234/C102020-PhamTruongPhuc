package bai7_abstract_interface.thuc_hanh.ex_1_animal_editable;


import bai7_abstract_interface.thuc_hanh.ex_1_animal_editable.animal.Animal;
import bai7_abstract_interface.thuc_hanh.ex_1_animal_editable.animal.Chicken;
import bai7_abstract_interface.thuc_hanh.ex_1_animal_editable.animal.Tiger;
import bai7_abstract_interface.thuc_hanh.ex_1_animal_editable.edible.Edible;

import bai7_abstract_interface.thuc_hanh.ex_1_animal_editable.fruit.Apple;
import bai7_abstract_interface.thuc_hanh.ex_1_animal_editable.fruit.Fruit;
import bai7_abstract_interface.thuc_hanh.ex_1_animal_editable.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1]= new Chicken();

        for(Animal animal: animals ){
            System.out.println(animal.makeSound());

            if(animal instanceof Chicken){
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();

        for(Fruit fruit: fruits){
            System.out.println(fruit.howToEat());
        }
    }
}
