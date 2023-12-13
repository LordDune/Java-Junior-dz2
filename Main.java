package ru.geekbrains.lesson2.dz2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Class dog = Class.forName("ru.geekbrains.lesson2.dz2.Dog"); // создали описатель класса Dog
        Class cat = Class.forName("ru.geekbrains.lesson2.dz2.Cat"); // создали описатель класса Cat
        Constructor[] consDog = dog.getConstructors(); // получили массив конструкторов класса Dog
        Constructor[] consCat = cat.getConstructors(); // получили массив конструкторов класса Cat

        Animal[] animals = new Animal[6]; // создали массив Animal и заполнили его объектами, созданными при помощи Reflection API
        Object dog1 = consDog[0].newInstance("Шарик", 5, "Вася", 3);
        Object dog2 = consDog[0].newInstance("Рэкс", 4, "Петя", 2);
        Object dog3 = consDog[0].newInstance("Мэри", 4, "Оля", 1);
        Object cat1 = consCat[0].newInstance("Барсик>", 1, "Оля");
        Object cat2 = consCat[0].newInstance("Пушок>", 3, "Максим");
        Object cat3 = consCat[0].newInstance("Тиша", 5, "Егор");
        animals[0] = (Animal) dog1;
        animals[1] = (Animal) dog2;
        animals[2] = (Animal) dog3;
        animals[3] = (Animal) cat1;
        animals[4] = (Animal) cat2;
        animals[5] = (Animal) cat3;

        for (int i = 0; i < animals.length; i++) { // проходим по массиву животных
            System.out.println(animals[i]);         // выводим информацию о каждом элементе
            Method[] methods = animals[i].getClass().getMethods();     // получаем массив методов каждого животного
            for (Method method : methods) {                          // проходим по массиву методов
                if (method.getName().equals("makeSound")) {          // выясняем, есть ли среди методов метод makeSound
                    Method makeSound = animals[i].getClass().getDeclaredMethod("makeSound");
                    makeSound.invoke(animals[i]);      // вызываем метод makeSound при помощи Reflection API

                }
            }
        }
    }
}

//    Dog{owner='Вася', commandsCount=3, name='Шарик', age=5}
//    Dog{owner='Петя', commandsCount=2, name='Рэкс', age=4}
//    Dog{owner='Оля', commandsCount=1, name='Мэри', age=4}
//    Cat{color='Оля', lives=9, name='Барсик>', age=1}
//    Cat Барсик>: Мяу
//    Cat{color='Максим', lives=9, name='Пушок>', age=3}
//    Cat Пушок>: Мяу
//    Cat{color='Егор', lives=9, name='Тиша', age=5}
//    Cat Тиша: Мяу