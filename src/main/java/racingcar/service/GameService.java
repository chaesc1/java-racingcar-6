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

    public GameService(int trial, List<Car> cars) {
        this.game = new Game(trial, cars);
    }

    public List<Car> play() {
        while (!game.checkReachTrialToTrialSum()) {
            moveForardToRandomNumber();
            game.addTrialnum();
        }
        return getWinners();
    }

    private List<Car> getWinners() {
        int max = -1;
        List<Car> winners = new ArrayList<>();
        for (Car car : game.getCars()) {
            if (max == car.getPosition()) {
                winners.add(car);
            }
            if (max < car.getPosition()) {
                max = car.getPosition();
                winners = new ArrayList<>();
                winners.add(car);
            }
        }
        return winners;
    }

    private void moveForardToRandomNumber() {
        for (Car car : game.getCars()) {
            if (MOVE_FORWARD_CONDITION <= getRandomNumber()) {
                car.moveForward(1);
            }
        }
    }
    //랜덤 숫자 받기
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START, END);
    }

}