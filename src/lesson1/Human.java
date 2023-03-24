package lesson1;

public class Human implements Actions{
    private final String name;

    protected double limitOfRun;
    protected double limitOfJump;
    protected double height;
    protected double lenght;

    public Human(String name, double limitOfRun, double limitOfJump) {
        this.name = name;
        this.limitOfJump = limitOfJump;
        this.limitOfRun = limitOfRun;
    }

    @Override
    public void run() {
        System.out.println(name + "\nHe can run : " + limitOfRun);
    }

    @Override
    public void jump() {
        System.out.println(name +  "\nHe can jump : " + limitOfJump);
    }
    @Override
    public double getLimitOfRun() {
        return limitOfRun;
    }

    @Override
    public double getLimitOfJump() {
        return limitOfJump;
    }
}
