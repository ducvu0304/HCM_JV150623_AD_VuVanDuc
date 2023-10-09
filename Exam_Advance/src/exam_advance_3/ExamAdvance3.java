package exam_advance_3;

import utils.ScannerUtils;

import java.util.*;

public class ExamAdvance3 {
    public static void main(String[] args) {
        String string = "";
        Deque<String> queue = new ArrayDeque<>();
        List<String> list = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        boolean isLoop =  true;

        while (isLoop) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                               "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                               "2. Phụ huynh tiếp theo\n" +
                               "3. Thoát");

            System.out.println("Xin mời chọn chức năng:");
            int choice = ScannerUtils.inputInt(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Nhập tên phụ huynh nộp hồ sơ: ");
                    string = ScannerUtils.inputString(scanner);

                    if(string.length() >= 1) {
                        queue.add(string);
                    }

                    break;
                case 2:
                    if(!queue.isEmpty()) {
                        System.out.println("Xin mời phụ huynh: " + queue.getFirst());
                        list.add(queue.poll());
                    }else {
                        System.out.println("Không có danh sách phụ huynh chờ.");
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
