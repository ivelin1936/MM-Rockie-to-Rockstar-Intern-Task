package org.me.mmlogo.service;

import org.me.mmlogo.domain.model.Logo;
import org.me.mmlogo.utils.DrawUtils;
import org.me.mmlogo.validators.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;


@Service
public class LogoCreatorServiceImpl implements LogoCreatorService {

    private static final String DEFAULT_INVALID_PARAMETER_EX_MSG = "N should be odd number between 2 and 10 000 (2 < N < 10 000)";
    private static final String DEFAULT_SPACE = "-";
    private static final String DEFAULT_LETTER_SYMBOL = "*";
    private static final String DRAW_PATTERN_FIRST_PART = "%s%s%s%s%s";
    private static final String DRAW_PATTERN_SECOND_PART = "%s%s%s%s%s%s%s";
    private static final int DEFAULT_SYMBOL_REPEAT = 2;
    private static final int TWO_HALVES = 2;

    private final Validator<Integer> validator;

    @Autowired
    public LogoCreatorServiceImpl(Validator<Integer> validator) {
        this.validator = validator;
    }

    @Override
    public String create(int fontWeight) {
        if (!this.validator.isValid(fontWeight)) {
            throw new InvalidParameterException(DEFAULT_INVALID_PARAMETER_EX_MSG);
        }

        /** This logo instance dont make sense :) **/
        Logo logo = new Logo(fontWeight);
        StringBuilder logoBuilder = new StringBuilder();
        int halfRows = logo.getFontSize() / TWO_HALVES;

        /** build first half (top) **/
        buildTop(halfRows, logoBuilder, logo.getFontWeight());
        /** build second half (bottom) **/
        buildBottom(halfRows, logoBuilder, logo.getFontWeight());

        return logoBuilder.toString();
    }

    /** Method build first half (top) **/
    private void buildTop(int halfRows, StringBuilder logoBuilder, int fontWeight) {
        for (int row = 0; row < halfRows; row++) {
            int sideSpace = fontWeight - row;
            int centerSpace = fontWeight - (row * 2);
            int starsCount = fontWeight + (row * 2);

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
                            DrawUtils.drawSequence(DEFAULT_SPACE, sideSpace),
                            DrawUtils.drawSequence(DEFAULT_LETTER_SYMBOL, starsCount),
                            DrawUtils.drawSequence(DEFAULT_SPACE, centerSpace),
                            DrawUtils.drawSequence(DEFAULT_LETTER_SYMBOL, starsCount),
                            DrawUtils.drawSequence(DEFAULT_SPACE, sideSpace)));
        }
        logoBuilder.append(System.lineSeparator());
    }

    /** Method build second half (bottom) **/
    private void buildBottom(int halfRows, StringBuilder logoBuilder, int fontWeight) {
        for (int row = 0; row < halfRows; row++) {
            int sideSpace = fontWeight - halfRows - row;
            int centerSpace = 1 + (row * 2);
            int centerStarsCount = ((fontWeight * 2) - 1) - (row * 2);

            buildRowSecondHalf(logoBuilder, sideSpace, centerSpace, centerStarsCount, fontWeight);
        }
    }

    /** Method build row on second half (bottom) **/
    private void buildRowSecondHalf(StringBuilder logoBuilder,
                                    int sideSpace,
                                    int centerSpace,
                                    int centerStarsCount,
                                    int fontWeight) {
        for (int j = 1; j <= DEFAULT_SYMBOL_REPEAT; j++) {
            logoBuilder.append(
                    String.format(DRAW_PATTERN_SECOND_PART,
                            DrawUtils.drawSequence(DEFAULT_SPACE, sideSpace),
                            DrawUtils.drawSequence(DEFAULT_LETTER_SYMBOL, fontWeight),
                            DrawUtils.drawSequence(DEFAULT_SPACE, centerSpace),
                            DrawUtils.drawSequence(DEFAULT_LETTER_SYMBOL, centerStarsCount),
                            DrawUtils.drawSequence(DEFAULT_SPACE, centerSpace),
                            DrawUtils.drawSequence(DEFAULT_LETTER_SYMBOL, fontWeight),
                            DrawUtils.drawSequence(DEFAULT_SPACE, sideSpace)));
        }
        logoBuilder.append(System.lineSeparator());
    }
}
