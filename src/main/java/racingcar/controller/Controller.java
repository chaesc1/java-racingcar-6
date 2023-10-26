package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Parser;
import racingcar.view.InputView;

public class Controller {
    private Parser parser = new Parser();
    public void run() {
        //Input 받아야해
        InputView.requsetCarNameMessage();
        List<String> carnames = parser.parsingCarName(Console.readLine());
        InputView.requestTrialNumMessage();
        int trial = parser.parsingNumberOfTrial(Console.readLine());

    }
}
