package org.me.mmlogo.domain.model;

public abstract class BaseLogo {

    private int fontWeight;

    protected BaseLogo(int parameter) {
        this.setFontWeight(parameter);
    }

    public int getFontWeight() {
        return this.fontWeight;
    }

    private void setFontWeight(int fontWeight) {
        this.fontWeight = fontWeight;
    }
}
