import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thẻ: ");
        String cardId = sc.nextLine();

        String result = validateCardId(cardId);
        System.out.println(result);
    }

    public static String validateCardId(String cardId) {
        if (!cardId.matches("^[A-Z]{2}.*")) {
            return "Lỗi: Thiếu tiền tố mã thẻ hoặc không viết hoa (Ví dụ đúng: TV)";
        }
        if (!cardId.matches("^[A-Z]{2}\\d{4}.*")) {
            return "Lỗi: Năm học không hợp lệ (Phải là 4 chữ số sau tiền tố)";
        }
        if (!cardId.matches("^[A-Z]{2}\\d{4}\\d{5}$")) {
            if (cardId.length() != 11) {
                return "Lỗi: Độ dài mã thẻ không đúng (Tổng phải đủ 11 ký tự)";
            }
            return "Lỗi: 5 ký tự cuối phải là chữ số";
        }
        return "Mã thẻ " + cardId + " hợp lệ!";
    }
}
