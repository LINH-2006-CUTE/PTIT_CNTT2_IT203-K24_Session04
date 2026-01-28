import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] transactions = {"BK001-20/01", "BK005-21/01", "BK099-22/01"};
        String ngayTao = "24/01/2026";
        long startSB = System.currentTimeMillis(); // Lấy thời gian bắt đầu
        StringBuilder report = new StringBuilder();
        report.append("--- BÁO CÁO MƯỢN SÁCH ---\n");
        report.append("Ngày tạo: ").append(ngayTao).append("\n");

        for (String record : transactions) {
            report.append("Giao dịch: ").append(record).append("\n");
        }
        long endSB = System.currentTimeMillis(); // Lấy thời gian kết thúc
        long time = endSB - startSB;
        System.out.println(report.toString());
        System.out.println("Số thời gian thực thi đối với StringBuilder: " + time);


    }
}