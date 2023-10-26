package racingcar.utils;

import java.util.List;

public class Validator {
    private static final int CAR_NAME_LENGTH_MIN = 1;
    private static final int CAR_NAME_LENGTH_MAX = 5;

    public void checkCarNameInput(List<String> carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (CAR_NAME_LENGTH_MAX < carName.length()) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 한다.");
            }
            if (carName.length() < CAR_NAME_LENGTH_MIN) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상여야 한다.");
            }
        }
    }
}
