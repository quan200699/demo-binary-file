package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "output.txt";
        String destination = "result.txt";
        readDataFromFile(filePath);
        writeDataToFile(destination);
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "IP", 10000));
        products.add(new Product(2, "IP", 10000));
        products.add(new Product(3, "IP", 10000));
        products.add(new Product(4, "IP", 10000));
        writeObjectToBinaryFile(products, "object.txt");
        readObjectFromBinaryFile("object.txt");
        List<Person> people = new ArrayList<>();
        people.add(new Student("Quan", "Hn", 22, "001", 9));
        people.add(new Student("Quanss", "Hn", 23, "002", 5));
        people.add(new Student("Quang", "Hn", 244, "003", 6));
        Person person = new Student("Vu", "BN", 25, "004", 8);
        people.add(person);
        writeToFile(people);
        readStudentFromFile();
        people.remove(person);
        writeToFile(people);
        readStudentFromFile();


    }

    private static void writeToFile(List<Person> people) {
        try {
            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(people);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readStudentFromFile() {
        try {
            FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Person> personList = (List<Person>) ois.readObject();
            for (Person p : personList) {
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readObjectFromBinaryFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Product> productList = (List<Product>) ois.readObject();
            showProductElement(productList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void showProductElement(List<Product> productList) {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    private static void writeObjectToBinaryFile(List<Product> products, String path) {
        try {
            FileOutputStream fos = new FileOutputStream("object.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDataToFile(String destination) {
        try {
            FileOutputStream fos = new FileOutputStream(destination);
            byte[] bytes = {'H', 'e', 'l', 'l', 'o'};
            for (int i = 0; i < bytes.length; i++) {
                fos.write(bytes[i]);
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readDataFromFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            byte[] bytes = new byte[10];
            int i;
            while ((i = fis.read(bytes)) != -1) {
                String line = new String(bytes, 0, i);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
