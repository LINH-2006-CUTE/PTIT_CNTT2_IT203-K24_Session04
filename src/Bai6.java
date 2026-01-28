import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String review = "Cuốn sách này rất tệ, nội dung thật là ngu ngốc và không đáng đọc. " ;

        String[] blacklist = {"tệ", "ngu ngốc"};

        String regex = "(?i)" + String.join("|", blacklist);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(review);

        StringBuilder sbFiltered = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group();
            String stars = "*".repeat(word.length());
            matcher.appendReplacement(sbFiltered, stars);
        }
        matcher.appendTail(sbFiltered);

        String result = sbFiltered.toString();

        if (result.length() > 200) {
            int cutIndex = result.substring(0, 200).lastIndexOf(" ");
            result = result.substring(0, cutIndex) + "...";
        } else if (result.length() > 50) {
            int cutIndex = result.substring(0, 45).lastIndexOf(" ");
            result = result.substring(0, cutIndex) + "...";
        }

        System.out.println("Review sau khi xử lý: " + result);

    }
}