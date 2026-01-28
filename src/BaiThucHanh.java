import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaiThucHanh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bookID;
        String isbn;
        int years;

        String author;
        String title;

//        Phần 1: Kiểm tra định dạng bằng Regex
//        Xây dựng các bộ lọc để kiểm tra dữ liệu đầu vào:
//        Mã sách (Book ID): Phải có định dạng LIB-xxxx-S (trong đó xxxx là 4 chữ số)
//        Mã ISBN: Chấp nhận định dạng ISBN-10 (chỉ gồm 10 chữ số)
//        Năm xuất bản: Phải là 4 chữ số và không lớn hơn năm hiện tại (2026)

        //KTRA BoolID
        boolean check = false; //  biến kiếm tra điều kiện nhập vào
        // Kiếm tra BOOK ID
        do {
            System.out.println("Nhap ID sach:");
            bookID = sc.nextLine();

            if (Pattern.matches("^LIB-\\d{4}-S$", bookID)) {
                System.out.println("Thong bao: Nhap hop le");
                check = true;
                break;
            } else {
                System.out.println("Thong bao: Nhap lai ");
            }
        } while (true);

        // Kiểm tra ISBN
        do {
            System.out.println("Nhập mã ISBN :");
            isbn = sc.nextLine();

            if (Pattern.matches("^ISBN-\\d{10}$", isbn)) {
                System.out.println("Thông báo: Nhập hợp lệ");
                check = true;
                break;
            } else {
                System.out.println("Thông báo: Nhâp lại");
            }
        } while (true);

// Kiểm  tra năm
        do {
            System.out.println("Nhập năm xuất bản:");
            String input = sc.nextLine();
            if (Pattern.matches("^\\d{4}$", input)) {
                years = Integer.parseInt(input); // đổi chuỗi years thành số int ( input)
                System.out.println("Thông báo: Nhập hợp lệ");
                if (years <= 2026) {
                    check = true;
                    break;
                } else {
                    System.out.println("Thông báo: Năm không vượt quá 2026!!!");
                }
            } else {
                System.out.println("Thông báo: Nhập lại");
            }
        } while (true);
// Phần 2: Chuẩn hóa tiêu đề và tác giả
//Giả sử tên sách nhập vào là: " lập trình jaVa căn bản "
//Sử dụng trim() và split("\\s+") để tách các từ.
//Viết hoa chữ cái đầu tiên của mỗi từ, các chữ cái còn lại viết thường.
//Kết quả mong muốn: "Lập Trình Java Căn Bản"
        System.out.println("Nhập tiêu đề sách:");
        title = sc.nextLine().trim();
        String[] key = title.split("\\s+");
        for (int i = 0; i < key.length; i++) {
            String firt = key[i].substring(0, 1).toUpperCase(); //  lấy kí tự đầu để vieét hoa
            String end = key[i].substring(1).toLowerCase(); //lấy phần còn lại của mảng
            key[i] = firt + end; // gán ngược lại vào mảng

        }
        String result = String.join(" ", key);
        System.out.println("Kết quả là:" + result);
    }

    //        Phần 3: Tạo chuỗi trích dẫn bằng StringBuilder
//        Viết phương thức tạo một chuỗi "Thông tin đầy đủ" để in tem nhãn theo cấu trúc: [Mã Sách] - [Tên Sách] - [Tác Giả] (Năm XB)
//        Yêu cầu: Sử dụng StringBuilder để nối các thành phần này thay vì dùng toán tử +. Giải thích ngắn gọn tại sao cách này tối ưu hơn về bộ nhớ
    public static void showInfo(String id, String title, String author, int year) {
        StringBuilder sb = new StringBuilder(); // Sử dụng StringBuilder để tối ưu bộ nhớ
        sb.append("[")
                .append(id)
                .append("] - [")
                .append(title)
                .append("] - [")
                .append(author)
                .append("] (")
                .append(year)
                .append(")");

        System.out.println("\n--- KẾT QUẢ BIÊN MỤC ---");
        System.out.println(sb.toString());
        System.out.println("Giai thich: StringBuilder tối ưu hơn toán tử + vì nó không tạo ra nhiều đối tượng chuỗi rác trong bộ nhớ Heap khi nối chuỗi.");

    }
}