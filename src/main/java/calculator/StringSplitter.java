package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private final String input;
    private Matcher m;

    public StringSplitter(String input) {
        this.input = input;
    }

    public String[] split() {
        if (isContainsCustomDelimiter()){
            return splitCustomDelimiter();
        }

        if (isContainsDelimiter()){
            return splitDelimiter();
        }

        return new String[]{input};

    }

    public boolean isContainsCustomDelimiter(){
        m = Pattern.compile("//(.)\n(.*)").matcher(input);
        return m.find();
    }

    public String[] splitCustomDelimiter() {
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

    public String[] splitDelimiter() {
        return input.split("[,:]");
    }

    public boolean isContainsDelimiter() {
        return (input.contains(",") || input.contains(":"));
    }

}
