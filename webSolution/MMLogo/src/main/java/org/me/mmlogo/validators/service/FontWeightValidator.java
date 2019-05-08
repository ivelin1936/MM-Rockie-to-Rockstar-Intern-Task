package org.me.mmlogo.validators.service;

import org.springframework.stereotype.Component;

@Component
public class FontWeightValidator implements Validator<Integer> {

    private static final int MIN_FONT_WEIGHT = 2;
    private static final int MAX_FONT_WEIGHT = 10000;

    @Override
    public boolean isValid(Integer fontWeight) {
        return fontWeight > MIN_FONT_WEIGHT
                && fontWeight < MAX_FONT_WEIGHT
                && !isEvenNumber(fontWeight);
    }

    private boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }
}
