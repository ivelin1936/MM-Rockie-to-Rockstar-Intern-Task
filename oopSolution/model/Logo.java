package oopSolution.model;

public class Logo extends BaseLogo implements Drawable {

    private static final String DEFAULT_SPACE = "-";
    private static final String DEFAULT_LETTER_SYMBOL = "*";
    private static final String DRAW_PATTERN_FIRST_PART = "%s%s%s%s%s";
    private static final String DRAW_PATTERN_SECOND_PART = "%s%s%s%s%s%s%s";
    private static final int DEFAULT_SYMBOL_REPEAT = 2;
    private static final int TWO_HALVES = 2;
    private static final int ZERO_ROW = 1;

    private int fontSize;

    public Logo(int inputParameter) {
        super(inputParameter);
        this.setFontSize(inputParameter);
    }

    private void setFontSize(int inputParameter) {
        this.fontSize = inputParameter + ZERO_ROW;
    }

    @Override
    public String draw() {
        StringBuilder logoBuilder = new StringBuilder();
        int halfRows = this.fontSize / TWO_HALVES;

        /** build first half (top) **/
        buildTop(halfRows, logoBuilder);
        /** build second half (bottom) **/
        buildBottom(halfRows, logoBuilder);

        return logoBuilder.toString();
    }

    /** Method build first half (top) **/
    private void buildTop(int halfRows, StringBuilder logoBuilder) {
        for (int row = 0; row < halfRows; row++) {
            int sideSpace = super.getFontWeight() - row;
            int centerSpace = super.getFontWeight() - (row * 2);
            int starsCount = super.getFontWeight() + (row * 2);

            buildRowFirstHalf(logoBuilder, sideSpace, centerSpace, starsCount);
        }
    }

    /** Method build row on first half (top) **/
    private void buildRowFirstHalf(StringBuilder logoBuilder,
                                   int sideSpace,
                                   int centerSpace,
                                   int starsCount) {
        for (int j = 1; j <= DEFAULT_SYMBOL_REPEAT; j++) {
            logoBuilder.append(
                    String.format(DRAW_PATTERN_FIRST_PART,
                            super.drawSequence(DEFAULT_SPACE, sideSpace),
                            super.drawSequence(DEFAULT_LETTER_SYMBOL, starsCount),
                            super.drawSequence(DEFAULT_SPACE, centerSpace),
                            super.drawSequence(DEFAULT_LETTER_SYMBOL, starsCount),
                            super.drawSequence(DEFAULT_SPACE, sideSpace)));
        }
        logoBuilder.append(System.lineSeparator());
    }

    /** Method build second half (bottom) **/
    private void buildBottom(int halfRows, StringBuilder logoBuilder) {
        for (int row = 0; row < halfRows; row++) {
            int sideSpace = super.getFontWeight() - halfRows - row;
            int centerSpace = 1 + (row * 2);
            int centerStarsCount = ((super.getFontWeight() * 2) - 1) - (row * 2);

            buildRowSecondHalf(logoBuilder, sideSpace, centerSpace, centerStarsCount);
        }
    }

    /** Method build row on second half (bottom) **/
    private void buildRowSecondHalf(StringBuilder logoBuilder,
                                   int sideSpace,
                                   int centerSpace,
                                   int centerStarsCount) {
        for (int j = 1; j <= DEFAULT_SYMBOL_REPEAT; j++) {
            logoBuilder.append(
                    String.format(DRAW_PATTERN_SECOND_PART,
                            super.drawSequence(DEFAULT_SPACE, sideSpace),
                            super.drawSequence(DEFAULT_LETTER_SYMBOL, super.getFontWeight()),
                            super.drawSequence(DEFAULT_SPACE, centerSpace),
                            super.drawSequence(DEFAULT_LETTER_SYMBOL, centerStarsCount),
                            super.drawSequence(DEFAULT_SPACE, centerSpace),
                            super.drawSequence(DEFAULT_LETTER_SYMBOL, super.getFontWeight()),
                            super.drawSequence(DEFAULT_SPACE, sideSpace)));
        }
        logoBuilder.append(System.lineSeparator());
    }
}
