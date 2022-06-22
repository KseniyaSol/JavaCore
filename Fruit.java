package Homework11;

public abstract class Fruit {

    private String type;
    private float weight;

    public Fruit(String type, float weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public float getWeight() {
        return weight;
    }
}
