import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bookName;
        String type;
        String author;
        System.out.println("Nhập tên sách:");
        bookName = sc.nextLine();

        System.out.println("Nhập thể loại sách:");
        type = sc.nextLine();

        System.out.println("Nhập tác giả:");
        author = sc.nextLine();

        // Ten sach biet hoa  toan bo
        String title = String.join(" ", bookName.trim().split("\\s+")).toUpperCase();
        // ten tac gia viet hoa moi chu cai dau
        String [] authorName = author.trim().split("\\s+");
        for (int i =0; i < authorName.length; i++) {
            String firstIndex = authorName[i].substring(0,1).toUpperCase();
            String endIndex = authorName[i].substring(1).toLowerCase();
            authorName[i] = firstIndex +endIndex;
        }
        String result = String.join(" ", authorName);


        StringBuilder sb = new StringBuilder();
        sb.append("[")
                .append(title)
                .append("] - Tác giả: [")
                .append(result)
                .append("]");

        System.out.println("\n--- KẾT QUẢ ĐỊNH DẠNG ---");
        System.out.println(sb.toString());
    }
}