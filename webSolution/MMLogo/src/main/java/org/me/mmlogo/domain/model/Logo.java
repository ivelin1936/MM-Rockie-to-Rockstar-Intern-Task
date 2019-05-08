package org.me.mmlogo.domain.model;

public class Logo extends BaseLogo {

    private static final int ZERO_ROW = 1;

    private int fontSize;

    public Logo(int inputParameter) {
        super(inputParameter);
        this.setFontSize(inputParameter);
    }

    private void setFontSize(int inputParameter) {
        this.fontSize = inputParameter + ZERO_ROW;
    }

    public int getFontSize() {
        return this.fontSize;
    }
}
