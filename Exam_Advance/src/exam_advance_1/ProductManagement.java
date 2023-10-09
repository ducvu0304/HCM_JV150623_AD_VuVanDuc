package exam_advance_1;

import exam_advance_1.ra.businessImpl.Catalog;
import exam_advance_1.ra.businessImpl.Product;
import utils.ScannerUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static List<Catalog> catalogList = new ArrayList<>();

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean isLoop = true;
        boolean isExist = false;

        while (isLoop) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                               "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục [10 điểm]\n" +
                               "2. Nhập số sản phẩm và nhập thông tin các sản phẩm [20 điểm]\n" +
                               "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator) [10 điểm]\n" +
                               "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm [05 điểm]\n" +
                               "5. Thoát [05 điểm]");

            System.out.println("Xin mời chọn chức năng:");
            int choice = ScannerUtils.inputInt(scanner);

            switch (choice){
                case 1:
                    System.out.println("Xin mời nhập số danh mục:");
                    number = ScannerUtils.inputInt(scanner);

                    for (int i = 0; i < number; i++) {
                        Catalog catalog =  new Catalog();
                        catalog.inputData(scanner);
                        catalogList.add(catalog);
                    }

                    for (Catalog c : catalogList) {
                        c.displayData();
                    }

                    System.out.println("Nhập thông tin danh mục  thành công");
                    break;

                case 2:
                    System.out.println("Xin mời nhập số sản phẩm:");
                    number = ScannerUtils.inputInt(scanner);

                    for (int i = 0; i < number; i++) {
                        Product product =  new Product();
                        product.inputData(scanner);
                        productList.add(product);
                    }

                    System.out.println("Nhập thông tin sản phẩm thành công");

                    break;
                case 3:
                    if(!productList.isEmpty()) {
                        Collections.sort(productList);
                        for (Product product: productList) {
                            product.displayData();
                        }
                        System.out.println("Sản phẩm đã được sắp xếp theo giá sản phẩm tăng dần thành công!");
                    }else {
                        System.out.println("Danh sách rỗng");
                    }

                    break;
                case 4:
                    if(!productList.isEmpty()) {
                        isExist = false;
                        System.out.println("Xin mời nhập tên danh mục");
                        String catalogName = ScannerUtils.inputString(scanner).toLowerCase();

                        for (Product product: productList) {
                            if(product.getCatalog().getCatalogName().toLowerCase().contains(catalogName)) {
                                isExist = true;
                                product.displayData();
                            }
                        }

                        if(!isExist) {
                            System.out.println("Không tìm thấy sản phẩm.");
                        }
                    }else {
                        System.out.println("Danh sách rỗng");
                    }

                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.printf("Tính năng số \"%d\" không có trong menu %n", choice);
            }
        }
    }
}
