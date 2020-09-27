package demo.util.IdiomSolitaire;

import java.util.Scanner;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月26日 15:40
 */
public class IdiomShell {

    private WordMap wordMap = LoaderUtil.getWordMap();

    private final String PROMPT = "-:成语接龙:->";

    private StringBuilder sb = new StringBuilder();

    public void start() {

        boolean SIGN = true;

        Scanner scanner = new Scanner(System.in);

        while (SIGN) {
            sb.setLength(0);

            System.out.print(PROMPT);

            String input = scanner.nextLine();

            if (input.equals("0")) {
                SIGN = false;
            }

        }
    }

}
