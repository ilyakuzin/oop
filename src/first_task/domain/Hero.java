package first_task.domain;

import first_task.strategy.MoveByWalk;
import first_task.strategy.MoveStrategy;

public class Hero {
    private String heroName;
    private int position;
    private MoveStrategy moveStrategy; // определяем тип передвижения героя

    public Hero(String heroName) {
        this.heroName = heroName;
        this.position = 0; //по умолчанию все герои находятся на позиции 0
        this.moveStrategy = new MoveByWalk(); //по умолчанию идет пешком
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = getMoveStrategy().move(position);
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}
