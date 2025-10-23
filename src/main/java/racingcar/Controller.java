package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Controller {

    private final Model model;
    private final View view;
    private int timesToTry;

    public Controller() {
        model = new Model();
        view = new View();
    }

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void initGame() {
        String input = view.getNameOfCar();
        List<String> names = Arrays.stream(input.split(",")).toList();
        if (!verifyName(names)) {
            throw new IllegalArgumentException();
        }
        model.setNameOfParticipants(names);

        input = view.getTimesToTry();
        if(!verifyTimesToTry(input)) {
            throw new IllegalArgumentException();
        }
        timesToTry = Integer.parseInt(input);
    }

    public boolean verifyName(List<String> names) {
        if(new HashSet<>(names).size() != names.size()) {
            return false;
        }
        if (names.size() < 2 || names.size() > 10) {
            return false;
        }
        for(String name: names) {
            if (name.contains(" ")) {
                return false;
            }
            if (name.isEmpty() || name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        List<Car> participants;
        List<String> winners;

        initGame();

        for(int i = 0; i < timesToTry; i++) {
            model.progressRace();
            participants = model.getParticipants();
            view.printResultOfRace(participants);
        }

        winners = model.getWinner();
        view.printWinners(winners);
    }

    public boolean verifyTimesToTry(String input) {
        try {
            int parsed = Integer.parseInt(input);
            if (parsed < 1 || parsed > 20) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
