package bai12_java_collection_framework.bai_tap.ex_1_arraylist_linkedlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("**********************************" +
                    "\nMenu" +
                    "\n1.\tThêm sản phẩm" +
                    "\n2.\tSửa thông tin sản phẩm theo id" +
                    "\n3.\tXoá sản phẩm theo id" +
                    "\n4.\tHiển thị danh sách sản phẩm" +
                    "\n5.\tTìm kiếm sản phẩm theo tên" +
                    "\n6.\tSắp xếp sản phẩm tăng dần, giảm dần theo giá" +
                    "\n7.\tExit" +
                    "\n**********************************");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            int id;
            String name;
            double price;

            switch (choice) {
                case 1:
                    System.out.println("Enter product ID:");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter product name:");
                    name = scanner.nextLine();
                    System.out.println("Enter product price: ");
                    price = scanner.nextDouble();

                    if (productManager.add(new Product(id, name, price)))
                        System.out.println("Adding successful!");
                    else
                        System.out.println("Your product is already added!");
                    break;
                case 2:
                    System.out.println("Enter product ID");
                    id = scanner.nextInt();
                    if (productManager.contain(id)) {
                        scanner.nextLine();
                        System.out.println("Enter new product name:");
                        name = scanner.nextLine();
                        System.out.println("Enter new product price: ");
                        price = scanner.nextDouble();

                        productManager.edit(id, new Product(id, name, price));
                    } else {
                        System.out.println("Your ID product is not available");
                    }
                    break;
                case 3:
                    System.out.println("Enter product ID");
                    id = scanner.nextInt();
                    if (productManager.contain(id)) {
                        productManager.delete(id);
                    } else {
                        System.out.println("Your ID product is not available");
                    }
                    break;
                case 4:
                    System.out.println(productManager);
                    break;
                case 5:
                    System.out.println("Enter product name");
                    name = scanner.nextLine();
                    Product searchResult =  productManager.search(name);
                    if(searchResult != null){
                        System.out.println(searchResult);
                    }else {
                        System.out.println("Your product is not available");
                    }
                    break;
                case 6:
                    System.out.println("Do you wish to arrange ascending or descending(A/D)?");
                    char choiceArrange = scanner.next().toLowerCase().charAt(0);
                    if(choiceArrange == 'a'){
                        productManager.sortByPrice(true);
                        System.out.println(productManager);
                    } else if(choiceArrange == 'd') {
                        productManager.sortByPrice(false);
                        System.out.println(productManager);
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choice is not available!");
                    break;
            }
        } while (true);
    }
}
