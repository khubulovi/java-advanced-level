package lesson1;
/**
 * Java Core. Advanced level. Lesson 1
 *
 * @author Malkhaz Khubulovi
 * @version dated Mart 24, 2023
 */


// Task
//   1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
//   2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//   3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
//   4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

public class Main {
    public static void main(String[] args) {
        Actions[] actions= {
                new Cat("Barsik",4.6,7.6),
                new Cat("Snegurocka",4.2,5.2),
                new Human("Malkhaz",2.4,1.5),
                new Human("Nika",2.6,2),
                new Robot("Alik",4.5,6),
                new Robot("Giorgi",4.2,8.5)
        };
        Barriers[]barriers={
                new Wall("Buelding,",4),
                new RunRoad("Running Distanse", 5)
        };
        for (Actions action:actions
        ) {
            for (Barriers barrier:barriers
            ) {barrier.moving(action);
            }
        }
    }
}

