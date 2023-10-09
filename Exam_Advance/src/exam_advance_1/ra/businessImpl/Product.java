package exam_advance_1.ra.businessImpl;

import exam_advance_1.ra.business.IShop;
import utils.ScannerUtils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static exam_advance_1.ProductManagement.catalogList;

public class Product implements IShop, Comparable<Product> {
    static int id = 1;
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean bookStatus;

    /**
     * Constructor
     */
    public Product() {
    }


    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean bookStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
    }

    /**
     * Getter && Setter
     */
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Product.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("*** Xin mời nhập thông tin sách ***");

        /**Book id*/
        this.productId = id++;

        /**Book name*/
        do {
            System.out.println("Nhập tên sản phẩm");
            this.productName = ScannerUtils.inputString(scanner);

            if (this.productName.isEmpty()) {
                System.out.println("Tên sản phẩm không được để trống");
            }
        } while (this.productName.isEmpty());

        /**Title*/
        do {
            System.out.println("Nhập tiêu đề sản phẩm");
            this.title = ScannerUtils.inputString(scanner);

            if (this.title.isEmpty()) {
                System.out.println("Tên tiêu đề sản phẩm không được để trống");
            }
        } while (this.title.isEmpty());

        /**descriptions*/
        do {
            System.out.println("Nhập mô tả sản phẩm");
            this.descriptions = ScannerUtils.inputString(scanner);

            if (this.descriptions.isEmpty()) {
                System.out.println("Tên tiêu đề sản phẩm không được để trống");
            }
        } while (this.descriptions.isEmpty());

        /**Import price*/
        do {
            System.out.println("Xin mời nhập giá nhập sản phẩm");
            this.importPrice = ScannerUtils.inputFloat(scanner);

            if (this.importPrice <= 0) {
                System.out.println("Giá nhập sản phẩm phải lớn hơn 0.");
            }
        } while (this.importPrice <= 0);

        /**Export price*/
        this.exportPrice = this.importPrice * RATE;


        /**Book status*/
        boolean isLoop = true;
        do {
            System.out.println("Xin mời chọn trạng thái sản phẩm (1. Đang bán - 2. Hết hàng.): ");
            int choice = ScannerUtils.inputInt(scanner);

            switch (choice) {
                case 1:
                    this.bookStatus = true;
                    isLoop = false;
                    break;
                case 2:
                    this.bookStatus = false;
                    isLoop = false;
                    break;
                default:
                    System.out.printf("Không có lựa chọn \"%d\"%n", choice);
            }

            if (!isLoop) {
                break;
            }
        } while (isLoop);

        /**Catalog*/
        if (!catalogList.isEmpty()) {
            for (Catalog catalog : catalogList) {
                System.out.println(catalog.toString());
            }

            boolean isExist = false;

            while (!isExist) {
                System.out.println("Xin mời chọn mã catalog");
                int choice = ScannerUtils.inputInt(scanner);

                for (Catalog catalog : catalogList) {
                    if (catalog.getCatalogId() == choice) {
                        this.catalog = catalog;
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {
                    System.out.printf("Danh mục \"%d\" không có trong list danh mục %n", choice);
                }
            }
        } else {
            System.out.println("Danh mục chưa được khởi tạo");
            this.catalog = null;
        }
    }

    @Override
    public void displayData() {
        String status = this.bookStatus ? "Đang bán" : "Hết hàng";
        String catalogName;
        Optional<Catalog> optional = Optional.ofNullable(this.catalog);

        if (optional.isPresent()) {
            catalogName = catalog.getCatalogName();
        } else {
            catalogName = "Chưa có danh mục.";
        }


        System.out.printf("**** Thông tin sản phẩm \"%s\" *****%n", this.productName);
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s %n" +
                        "Tên danh mục: %s %n" +
                        "Giá bán: %.2f %n" +
                        "Trạng thái:  %s %n",
                         this.productId, this.productName,
                         catalogName,
                         this.exportPrice,
                         status);
    }

    @Override
    public int compareTo(Product o) {
        if(this.exportPrice > o.getExportPrice()) {
            return 1;
        }else if(this.exportPrice < o.getExportPrice()) {
            return -1;
        }else {
            return 0;
        }
    }
}
