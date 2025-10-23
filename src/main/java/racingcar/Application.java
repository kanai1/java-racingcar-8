package racingcar;

public class Application {
    public static void main(String[] args) {
        Model racingcarModel = new Model();
        View racingcarView = new View();
        Controller racingcar = new Controller(racingcarModel, racingcarView);
        racingcar.run();
    }
}
