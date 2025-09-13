package first_task.strategy;

public class MoveByWalk implements MoveStrategy {
    private static final String moveName = "пешком";

    @Override
    public int move(int position) {
        return position + 1;
    }

    @Override
    public String getMoveName() {
        return moveName;
    }
}
