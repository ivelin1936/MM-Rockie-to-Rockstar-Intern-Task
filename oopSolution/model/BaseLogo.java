package oopSolution.model;

import oopSolution.exception.InvalidParameterException;

public abstract class BaseLogo {

    private static final String DEFAULT_INVALID_PARAMETER_EX_MSG = "N should be odd number between 2 and 10 000 (2 < N < 10 000)";
    private static final int MIN_FONT_WEIGHT = 2;
    private static final int MAX_FONT_WEIGHT = 10000;

    private int fontWeight;

    protected BaseLogo(int parameter) {
        this.setFontWeight(parameter);
    }

    protected int getFontWeight() {
        return this.fontWeight;
    }

    private void setFontWeight(int fontWeight) {
        if (fontWeight <= MIN_FONT_WEIGHT
                || fontWeight >= MAX_FONT_WEIGHT
                || isEvenNumber(fontWeight)) {
            throw new InvalidParameterException(DEFAULT_INVALID_PARAMETER_EX_MSG);
        }

        this.fontWeight = fontWeight;
    }

    protected String drawSequence(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    private boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }
}
