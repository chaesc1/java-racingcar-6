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
        //Input 받아야해
        InputView.requsetCarNameMessage();
        List<String> carnames = parser.parseCarName(Console.readLine());
        InputView.requestTrialNumMessage();
        List<Car> cars = getCars(carnames);
        int trial = parser.parsingNumberOfTrial(Console.readLine());
        gameService = new GameService(trial, cars);
        List<Car> winners = gameService.play();
        outputView.printResults(cars);
        outputView.printWinners(winners);
    }

    private List<Car> getCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carList.add(new Car(carNames.get(i)));
        }
        return carList;
    }
}
