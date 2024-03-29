package lesson1;

public class Cat implements Actions{
    protected String name;
    protected double limitOfRun;
    protected double limitOfJump;

    public Cat(String name, double limitOfRun, double limitOfJump) {
        this.name = name;
        this.limitOfJump = limitOfJump;
        this.limitOfRun = limitOfRun;
    }
    @Override
    public void run() {
        System.out.println(name +  "\nHe can run : " + limitOfRun);
    }

    @Override
    public void jump () {
        System.out.println(name + "\nHe can jump : " + limitOfJump);
    }

    @Override
    public double getLimitOfRun () {
        return limitOfRun;
    }
    @Override
    public double getLimitOfJump () {
        return limitOfJump;
    }
}

