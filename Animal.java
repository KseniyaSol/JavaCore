package Homework6;

public abstract class Animal {

    protected String name;
    protected int maxLenghtOfRun;
    protected int maxLenghtOfSwim;
    private static int animals;

    public Animal(String name) {
        this.name = name;
        animals++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxLenghtOfRun() {
        return maxLenghtOfRun;
    }

    public void setMaxLenghtOfRun(int maxLenghtOfRun) {
        this.maxLenghtOfRun = maxLenghtOfRun;
    }

    public int getMaxLenghtOfSwim() {
        return maxLenghtOfSwim;
    }

    public void setMaxLenghtOfSwim(int maxLenghtOfSwim) {
        this.maxLenghtOfSwim = maxLenghtOfSwim;
    }

    public void run(int lenght){
        if ((maxLenghtOfRun >= lenght) && (lenght != 0)) System.out.printf("%s пробежал %d метров.\n", name, lenght);
        else System.out.printf("%s не побежал.\n", name);
    }

    public void swim(int lenght){
        if ((maxLenghtOfSwim >= lenght) && (lenght != 0)) System.out.printf("%s проплыл %d метров.\n", name, lenght);
        else System.out.printf("%s не поплыл.\n", name);
    }

    public static void allAnimals(){
        System.out.printf("Всего животных: %d\n", animals);
    }
}
