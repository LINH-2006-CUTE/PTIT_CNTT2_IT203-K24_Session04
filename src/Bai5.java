import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] logs = {
                "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345",
                "2024-05-21 | User: TranVanB | Action: RETURN | BookID: BK12345",
                "2024-05-22 | User: NguyenVanA | Action: BORROW | BookID: BK99999"
        };

        String regex = "^(\\d{4}-\\d{2}-\\d{2}) \\| User: (.*?) \\| Action: (BORROW|RETURN) \\| BookID: (.*)$";
        Pattern pattern = Pattern.compile(regex);
        int borrowCount = 0;
        int returnCount = 0;
        for (int i = 0; i < logs.length; i++) {
            Matcher matcher = pattern.matcher(logs[i]);
            while (matcher.find()) {
                String date = matcher.group(1);
                String userName = matcher.group(2);
                String action = matcher.group(3);
                String bookID = matcher.group(4);

                System.out.printf("Ngày: %s\n", date);
                System.out.printf("Người dùng: %s\n", userName);
                System.out.printf("Hành động: %s\n", action);
                System.out.printf("Mã sách: %s\n\n", bookID);

                if (action.equals("BORROW")) {
                    borrowCount++;
                } else if (action.equals("RETURN")) {
                    returnCount++;
                }
            }
        }
        System.out.println("Thống kê:");
        System.out.printf("Số hành động BORROW: %d\n", borrowCount);
        System.out.printf("Số hành động RETURN: %d", returnCount);

    }
}