package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private Validator validator = new Validator();

    public List<String> parseCarName(String input) throws IllegalArgumentException {
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        validator.checkCarNameInput(carNames);
        return carNames;
    }
    public int parsingNumberOfTrial(String input) {
        return Integer.parseInt(input);
    }
}
