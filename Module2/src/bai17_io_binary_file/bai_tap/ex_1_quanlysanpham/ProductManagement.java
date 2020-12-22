package bai17_io_binary_file.bai_tap.ex_1_quanlysanpham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductManagement {
    private static final String FILE_PATH = "product.data";
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        load(FILE_PATH);
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu" +
                    "\n1.\tThêm sản phẩm" +
                    "\n2.\tHiển thị danh sách sản phẩm" +
                    "\n3.\tTìm kiếm theo ID" +
                    "\n4.\tExit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Product newProduct = new Product();

                    System.out.println("Enter ID:");
                    newProduct.setId(scanner.nextInt());

                    scanner.nextLine();

                    System.out.println("Enter name:");
                    newProduct.setName(scanner.nextLine());

                    System.out.println("Enter company:");
                    newProduct.setCompany(scanner.nextLine());

                    System.out.println("Enter price:");
                    newProduct.setPrice(scanner.nextDouble());

                    scanner.nextLine();

                    System.out.println("Enter description:");
                    newProduct.setDescription(scanner.nextLine());

                    products.add(newProduct);
                    save(FILE_PATH);

                    break;
                case 2:
                    display();
                    break;
                case 3:
                    System.out.println("Enter product ID:");
                    int searchId = scanner.nextInt();
                    for (Product product : products) {
                        if (product.getId() == searchId) {
                            System.out.println("Your product is: " + product);
                        }
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choice is not valid");
                    break;
            }
        } while (choice != 4);
    }

    private static void display() {
        for (Product element : products) {
            System.out.print(element + "\t");
            System.out.println();
        }

    }

    private static void load(String FILE_PATH) {
        File sourceFile = new File(FILE_PATH);
        products.clear();
        try {
            if (!sourceFile.exists()) {
                sourceFile.createNewFile();
                return;
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sourceFile));
            Object product;
            while ((product = ois.readObject()) != null) {
                products.add((Product) product);
            }
            ois.close();
        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void save(String FILE_PATH) {
        File sourceFile = new File(FILE_PATH);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sourceFile));
            for (Product product : products) {
                oos.writeObject(product);
            }
            oos.close();
        } catch (IOException e) {
        }
    }
}