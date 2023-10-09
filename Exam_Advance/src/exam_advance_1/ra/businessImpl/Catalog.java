package exam_advance_1.ra.businessImpl;

import exam_advance_1.ra.business.IShop;
import utils.ScannerUtils;

import java.util.Scanner;

public class Catalog implements IShop {
    private static int id = 1;
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;


    /**Constructor*/
    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    /**Getter && Setter*/
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }



    /**Input Data*/
    @Override
    public void inputData(Scanner scanner) {
        System.out.println("*** Xin mời nhập thông tin danh mục ***");

        /**Catalog id*/
        this.catalogId = id++;

        /**Catalog name*/
        do {
            System.out.println("Nhập tên danh mục");
            this.catalogName =  ScannerUtils.inputString(scanner);

            if(this.catalogName.isEmpty()) {
                System.out.println("Tên danh mục không được để trống");
            }
        }while (this.catalogName.isEmpty());


        /** Priority */
        do {
            System.out.println("Nhập độ ưu tiên");
            this.priority =  ScannerUtils.inputInt(scanner);

            if(this.priority <= 0) {
                System.out.println("Độ ưu tiên phải lớn hơn 0.");
            }
        }while (this.priority <= 0);

        /**Descriptions*/
        System.out.println("Nhập mô tả danh mục.");
        this.descriptions =  ScannerUtils.inputString(scanner);



        /**Catalog status*/
        boolean isLoop = true;
        do {
            System.out.println("Xin mời chọn trạng thái sách (1. Hoạt động - 2. Không hoạt động.): ");
            int choice =  ScannerUtils.inputInt(scanner);

            switch (choice) {
                case 1:
                    this.catalogStatus = true;
                    isLoop = false;
                    break;
                case 2:
                    this.catalogStatus = false;
                    isLoop = false;
                    break;
                default:
                    System.out.printf("Không có lựa chọn \"%d\"%n", choice);
            }

            if(!isLoop ) {
                break;
            }
        }while (isLoop);
    }

    /**Display Data*/
    @Override
    public void displayData() {
        String status = this.catalogStatus ? "Hoạt động" : "Không hoạt động";

        System.out.printf("**** Thông tin sách \"%s\" *****%n", this.catalogName);
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s %n" +
                         "Độ ưu tiên: %s  %n" +
                         "Mô tả: %s %n" +
                         "Trạng thái danh mục: %s %n",
                this.catalogId, this.catalogName,
                this.priority,
                this.descriptions,
                status);
    }

    @Override
    public String toString() {
        return "Danh mục{" +
                "Mã danh mục =" + catalogId +
                ", Tên danh mục='" + catalogName + '\'' +
                '}';
    }
}
