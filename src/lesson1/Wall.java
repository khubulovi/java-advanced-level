package lesson1;

public class Wall implements Barriers {
    protected String name;
    protected double heigth;

    public Wall(String name, double heigth) {
        this.name = name;
        this.heigth = heigth;
    }

    @Override
    public boolean moving(Actions actions) {
        System.out.println("The wall " + this.name + "heigth: " + this.heigth);

        actions.jump();
        if (heigth <= actions.getLimitOfJump()) {
            System.out.println("jump success");

            return true;
        } else {
            System.out.println("jump unsuccessfully");
            return false;
        }
    }
}

