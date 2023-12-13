package ru.geekbrains.lesson2.dz2;

public class Dog extends Animal{

    private String owner;
    private int commandsCount;

    public Dog(String name, int age, String owner, int commandsCount) {
        this.commandsCount = commandsCount;
        this.owner = owner;
        this.name = name;
        this.age = age;
    }

    public void voice() {
        System.out.printf("Dog %s: Гав!", name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "owner='" + owner + '\'' +
                ", commandsCount=" + commandsCount +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
