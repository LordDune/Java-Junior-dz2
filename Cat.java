package ru.geekbrains.lesson2.dz2;

public class Cat extends Animal {

    private String color;
    private int lives = 9;

    public Cat(String name, int age, String color) {
        this.color = color;
        this.name = name;
        this.age = age;
    }

    public void loseLife (){
        if (lives > 1) lives --;
    }

    public void makeSound() {
        System.out.printf("Cat %s: Мяу \n", name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", lives=" + lives +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
