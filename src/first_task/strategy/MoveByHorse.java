package first_task.strategy;

public class MoveByHorse implements MoveStrategy {
    private static final String moveName = "на лошади";

    @Override
    public int move(int position) {
        //здесь логика того, как он должен менять позицию
        return position + 4;
    }

    @Override
    public String getMoveName() {
        return moveName;
    }
}
