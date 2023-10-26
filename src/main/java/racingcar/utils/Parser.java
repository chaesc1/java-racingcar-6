package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> parsingCarName(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int parsingNumberOfTrial(String input) {
        return Integer.parseInt(input);
    }
}
