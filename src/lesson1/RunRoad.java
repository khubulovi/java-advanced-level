package lesson1;

public class RunRoad implements Barriers {
    protected String name;
    protected double length;

    public RunRoad(String name, double length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public boolean moving(Actions actions) {
        System.out.println("The Run Road " + this.name + "heigth: " + this.length);
        actions.run();

        if (length <= actions.getLimitOfRun()) {
            System.out.println("run success");
            return true;
        } else {
            System.out.println("run unsuccessfully");
            return false;
        }
    }
}
