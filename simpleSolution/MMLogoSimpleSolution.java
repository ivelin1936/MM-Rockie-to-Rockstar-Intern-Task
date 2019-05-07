package simpleSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MMLogoSimpleSolution {

    private static final String DRAW_PATTERN_FIRST_PART = "%s%s%s%s%s";
    private static final String DRAW_PATTERN_SECOND_PART = "%s%s%s%s%s%s%s";
    private static final String DEFAULT_SPACE_SYMBOL = "-";
    private static final String DEFAULT_LETTER_SYMBOL = "*";
    private static final int DEFAULT_SYMBOL_REPEAT = 2;
    private static final int TWO_HALVES = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputParameter = Integer.parseInt(reader.readLine());

        int rows = inputParameter + 1;
        int halfRows = rows / TWO_HALVES;

        /** draw first half (top) **/
        for (int row = 0; row < halfRows; row++) {
            int sideSpace = inputParameter - row;
            int centerSpace = inputParameter - (row * 2);
            int starsCount = inputParameter + (row * 2);

            drawRowFirstHalf(sideSpace, centerSpace, starsCount);
        }

        /** draw second half (bottom) **/
        for (int row = 0; row < halfRows; row++) {
            int sideSpace = inputParameter - halfRows - row;
            int centerLetterSpace = 1 + (row * 2);
            int centerStarsCount = ((inputParameter * 2) - 1) - (row * 2);

            drawRowSecondHalf(inputParameter, sideSpace, centerLetterSpace, centerStarsCount);
        }
    }

    private static void drawRowSecondHalf(int inputParameter, int sideSpace, int centerLetterSpace, int centerStarsCount) {
        for (int j = 1; j <= DEFAULT_SYMBOL_REPEAT; j++) {
            System.out.print(String.format(DRAW_PATTERN_SECOND_PART,
                    draw(DEFAULT_SPACE_SYMBOL, sideSpace),
                    draw(DEFAULT_LETTER_SYMBOL, inputParameter),
                    draw(DEFAULT_SPACE_SYMBOL, centerLetterSpace),
                    draw(DEFAULT_LETTER_SYMBOL, centerStarsCount),
                    draw(DEFAULT_SPACE_SYMBOL, centerLetterSpace),
                    draw(DEFAULT_LETTER_SYMBOL, inputParameter),
                    draw(DEFAULT_SPACE_SYMBOL, sideSpace)));
        }
        System.out.println();
    }

    private static void drawRowFirstHalf(int sideSpace, int centerSpace, int starsCount) {
        for (int j = 1; j <= DEFAULT_SYMBOL_REPEAT; j++) {
            System.out.print(String.format(DRAW_PATTERN_FIRST_PART,
                    draw(DEFAULT_SPACE_SYMBOL, sideSpace),
                    draw(DEFAULT_LETTER_SYMBOL, starsCount),
                    draw(DEFAULT_SPACE_SYMBOL, centerSpace),
                    draw(DEFAULT_LETTER_SYMBOL, starsCount),
                    draw(DEFAULT_SPACE_SYMBOL, sideSpace)));
        }
        System.out.println();
    }

    private static String draw(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
}
