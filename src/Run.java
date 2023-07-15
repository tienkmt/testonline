import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input : ");
        String input = scanner.nextLine();
        List output = findTelex(input);
        System.out.println("Output : " + output.size() + " " + output);
    }

    public static List<String> findTelex(String input) {
        List output = new ArrayList<>();
        int index = 0;
        int length = input.length();
        while (index < length) {
            StringBuffer stringBuffer = new StringBuffer();
            if (index == length - 1 || input.charAt(index) == 'w') {
                stringBuffer.append(input.charAt(index));
            } else if (index <= length - 2) {
                stringBuffer.append(input.charAt(index));
                stringBuffer.append(input.charAt(index + 1));
            }
            if (isTelex(stringBuffer.toString())) {
                output.add(stringBuffer);
                if (input.charAt(index) != 'w') {
                    index++;
                }
            }
            index++;
        }
        return output;
    }

    public static boolean isTelex(String string) {
        List<String> telex = Arrays.asList("aa", "aw", "dd", "ee", "oo", "ow", "w");
        return telex.contains(string);
    }
}