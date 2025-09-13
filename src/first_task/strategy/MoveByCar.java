package first_task.strategy;

public class MoveByCar implements MoveStrategy{
    private static final String moveName = "на машине";

    @Override
    public int move(int position) {
        return position + 10;
    }

    @Override
    public String getMoveName() {
        return moveName;
    }


}
