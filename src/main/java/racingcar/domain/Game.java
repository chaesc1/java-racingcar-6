package racingcar.domain;

import java.util.List;

public class Game {
    private final int trial;
    private final List<Car> cars;
    private int trialSum = 0;
    public Game(List<Car> cars, int trial) {
        this.trial = trial;
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addTrialnum() {
        this.trialSum += 1;
    }

    public boolean checkReachTrialToTrialSum() {
        return this.trialSum == this.trial;
    }
}
