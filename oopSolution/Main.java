package oopSolution;

import oopSolution.core.LogoCreator;
import oopSolution.core.LogoCreatorImpl;
import oopSolution.io.ConsoleInputReader;
import oopSolution.io.ConsoleOutputWriter;
import oopSolution.io.Reader;
import oopSolution.io.Writer;
import oopSolution.model.Drawable;
import oopSolution.model.Logo;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleInputReader();
        int inputParameter = Integer.parseInt(reader.readLine());
        Drawable mmLogo = new Logo(inputParameter);

        Writer writer = new ConsoleOutputWriter();
        LogoCreator creator = new LogoCreatorImpl(writer);

        creator.create(mmLogo);
    }
}
