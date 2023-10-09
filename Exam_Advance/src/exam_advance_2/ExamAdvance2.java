package exam_advance_2;

import utils.ScannerUtils;

import java.util.Scanner;
import java.util.Stack;

public class ExamAdvance2 {
    public static void main(String[] args) {
        String string = "";
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        boolean isLoop =  true;

        while (isLoop) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                               "1. Nhập câu\n" +
                               "2. Đảo ngược câu\n" +
                               "3. Thoát");

            System.out.println("Xin mời chọn chức năng:");
            int choice = ScannerUtils.inputInt(scanner);

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Xin mời nhập 1 câu: ");
                        string = ScannerUtils.inputString(scanner);

                        if(string.length() < 1) {
                            System.out.println("Câu không được để trống");
                        }
                    }while (string.length() < 1);

                    break;
                case 2:

                    if(!string.isEmpty()) {
                        String[] strings = string.split("\\s");

                        for (int i = 0; i < strings.length; i++) {
                            stack.push(strings[i]);
                        }


                        String reverseString = "";
                        while (!stack.isEmpty()) {
                            reverseString += (stack.pop() + " ");
                        }

                        System.out.println(reverseString);

                    }else {
                        System.out.println("Chuỗi rỗng không thể đảo câu.");
                    }

                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.printf("Tính năng số \"%d\" không có trong menu %n", choice);
            }
        }
    }
}
