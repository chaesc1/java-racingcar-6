package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private GameService gameService;
    private OutputView outputView = new OutputView();
    private Parser parser = new Parser();

    public void run() {
        List<Car> cars = settingInit();
        List<Car> winners = gameService.play();
        printResults(cars, winners);
    }

    private List<Car> settingInit() {
        List<Car> cars = getCarsUserInput();
        int trial = getUserTrialInput();
        gameService = new GameService(trial, cars);
        return cars;
    }

    private void printResults(List<Car> cars, List<Car> winners) {
        outputView.printResults(cars);
        outputView.printWinners(winners);
    }

    private int getUserTrialInput() {
        InputView.requestTrialNumMessage();
        int trial = parser.parsingNumberOfTrial(Console.readLine());
        return trial;
    }

    private List<Car> getCarsUserInput() {
        InputView.requsetCarNameMessage();
        List<String> carnames = parser.parseCarName(Console.readLine());
        List<Car> cars = getCars(carnames);
        return cars;
    }

    private List<Car> getCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carList.add(new Car(carNames.get(i)));
        }
        return carList;
    }
}
