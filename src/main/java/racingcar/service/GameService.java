package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private static final int START = 0;
    private static final int END = 9;
    private static final int MOVE_FORWARD_CONDITION = 4;
    private Game game;

    public GameService(int trial, List<String> carNames) {
        this.game = new Game(trial, getCars(carNames));
    }

    private List<Car> getCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carList.add(new Car(carNames.get(i)));
        }
        return carList;
    }

    //랜덤 숫자 받기
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START, END);
    }
}