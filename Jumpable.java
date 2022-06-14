package Homework8;

public interface Jumpable {

    default boolean Jump(String name, int height, int maxJumpHeight) {
        return false;
    }
}
