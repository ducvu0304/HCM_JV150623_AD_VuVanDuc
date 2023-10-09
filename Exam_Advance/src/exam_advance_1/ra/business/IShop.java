package exam_advance_1.ra.business;

import exam_advance_1.ra.businessImpl.Catalog;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    float RATE = 1.3F;

    void inputData(Scanner scanner);

    void displayData();
}
