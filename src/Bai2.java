import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
String descrip;

        System.out.println("Nhap mo ta sach:");
        descrip =sc.nextLine();
        if (descrip.contains("Kệ:")){
            System.out.println("Tim thay sach");
            int index = descrip.indexOf("Kệ:");
            int indexEnd = descrip.indexOf(",");

            String result;

            // tìm cho hết dòng đến dấu phẩy tiếp theo

            if (indexEnd == -1) {
                result = descrip.substring(index, indexEnd).trim();
            }else {
                result = descrip.substring(index).trim(); // khoong tim thya dau phau thi lay het chuoi do
            }
            System.out.println("Ket qua la:"+ result);

            String newDescrip = descrip.replace("Kệ:", "Vị trí lưu trữ:");
            System.out.println("Mô tả mới:" + newDescrip);
        }else {
            System.out.println("Khong tim thay ke sach");
        }
    }
}