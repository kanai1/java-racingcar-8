package racingcar;

import java.util.HashSet;
import java.util.List;

public class Controller {

    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
    }

    public void initGame() {

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
    }
}
