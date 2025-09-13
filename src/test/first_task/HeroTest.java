package test.first_task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import first_task.domain.Hero;
import first_task.strategy.MoveByCar;
import first_task.strategy.MoveByHorse;
import first_task.strategy.MoveByPlain;
import first_task.strategy.MoveByWalk;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero("Артур");
    }

    @Test
    void testHeroInitialization() {
        // Проверяем корректность инициализации героя
        assertEquals("Артур", hero.getHeroName());
        assertEquals(0, hero.getPosition());
        assertTrue(hero.getMoveStrategy() instanceof MoveByWalk);
    }

    @Test
    void testMoveByWalk() {
        // Тестируем перемещение пешком
        hero.setMoveStrategy(new MoveByWalk());
        hero.setPosition(5);

        assertEquals(6, hero.getPosition()); // +1 от текущей позиции
    }

    @Test
    void testMoveByHorse() {
        // Тестируем перемещение на лошади
        hero.setMoveStrategy(new MoveByHorse());
        hero.setPosition(10);

        assertEquals(14, hero.getPosition()); // +4 от текущей позиции
    }

    @Test
    void testMoveByCar() {
        // Тестируем перемещение на машине
        hero.setMoveStrategy(new MoveByCar());
        hero.setPosition(3);

        assertEquals(13, hero.getPosition()); // +10 от текущей позиции
    }

    @Test
    void testMoveByPlain() {
        // Тестируем перемещение на самолете
        hero.setMoveStrategy(new MoveByPlain());
        hero.setPosition(7);

        assertEquals(27, hero.getPosition()); // +20 от текущей позиции
    }

    @Test
    void testMultipleMovesWithDifferentStrategies() {
        // Тестируем несколько перемещений с разными стратегиями
        assertEquals(0, hero.getPosition()); // начальная позиция

        // Первое перемещение - пешком
        hero.setPosition(5);
        assertEquals(6, hero.getPosition());

        // Меняем на лошадь
        hero.setMoveStrategy(new MoveByHorse());
        hero.setPosition(hero.getPosition());
        assertEquals(10, hero.getPosition()); // 6 + 4 = 10

        // Меняем на машину
        hero.setMoveStrategy(new MoveByCar());
        hero.setPosition(hero.getPosition());
        assertEquals(20, hero.getPosition()); // 10 + 10 = 20

        // Меняем на самолет
        hero.setMoveStrategy(new MoveByPlain());
        hero.setPosition(hero.getPosition());
        assertEquals(40, hero.getPosition()); // 20 + 20 = 40
    }

    @Test
    void testStrategyChange() {
        // Тестируем смену стратегии
        assertTrue(hero.getMoveStrategy() instanceof MoveByWalk);

        hero.setMoveStrategy(new MoveByHorse());
        assertTrue(hero.getMoveStrategy() instanceof MoveByHorse);

        hero.setMoveStrategy(new MoveByCar());
        assertTrue(hero.getMoveStrategy() instanceof MoveByCar);

        hero.setMoveStrategy(new MoveByPlain());
        assertTrue(hero.getMoveStrategy() instanceof MoveByPlain);
    }

    @Test
    void testNameChange() {
        // Тестируем изменение имени героя
        hero.setHeroName("Ланселот");
        assertEquals("Ланселот", hero.getHeroName());
    }

    @Test
    void testMoveFromZeroPosition() {
        // Тестируем перемещение из начальной позиции 0
        hero.setMoveStrategy(new MoveByWalk());
        hero.setPosition(0);
        assertEquals(1, hero.getPosition());

        hero.setMoveStrategy(new MoveByHorse());
        hero.setPosition(0);
        assertEquals(4, hero.getPosition());

        hero.setMoveStrategy(new MoveByCar());
        hero.setPosition(0);
        assertEquals(10, hero.getPosition());

        hero.setMoveStrategy(new MoveByPlain());
        hero.setPosition(0);
        assertEquals(20, hero.getPosition());
    }

    @Test
    void testNegativePosition() {
        // Тестируем работу с отрицательными позициями
        hero.setPosition(-5);
        assertEquals(-4, hero.getPosition()); // -5 + 1 = -4 (пешком)

        hero.setMoveStrategy(new MoveByHorse());
        hero.setPosition(-10);
        assertEquals(-6, hero.getPosition()); // -10 + 4 = -6
    }

    @Test
    void testMultipleHeroes() {
        // Тестируем несколько героев с разными стратегиями
        Hero hero1 = new Hero("Герой1");
        Hero hero2 = new Hero("Герой2");

        hero1.setMoveStrategy(new MoveByWalk());
        hero2.setMoveStrategy(new MoveByCar());

        hero1.setPosition(0);
        hero2.setPosition(0);

        assertEquals(1, hero1.getPosition()); // пешком
        assertEquals(10, hero2.getPosition()); // на машине
    }
}
