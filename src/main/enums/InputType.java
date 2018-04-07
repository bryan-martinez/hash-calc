package main.enums;

public enum InputType {
    DIRECTORY("Directory"),
    FILE("File"),
    STRING("Text");

    private String input;
    InputType(String input) { this.input = input; }
    public String getInput() { return input; }
}
