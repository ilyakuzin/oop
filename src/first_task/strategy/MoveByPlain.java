package first_task.strategy;

public class MoveByPlain implements MoveStrategy {
    private static final String moveName = "на самолете";

    @Override
    public int move(int position) {
        return position + 20;
    }

    @Override
    public String getMoveName() {
        return moveName;
    }
}
