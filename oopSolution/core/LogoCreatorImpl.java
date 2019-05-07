package oopSolution.core;

import oopSolution.io.Writer;
import oopSolution.model.Drawable;

public class LogoCreatorImpl implements LogoCreator {

    private Writer writer;

    public LogoCreatorImpl(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void create(Drawable logo) {
        String result = logo.draw();
        this.writer.writeLine(result);
    }
}
