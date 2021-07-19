package DesignPattern.Command;

public class Main {
    public static void main(String[] args) {
        Robokit robokit = new Robokit();
        robokit.addCommand(new MoveForwardCommand(2));
        robokit.addCommand(new TurnCommand(Robot.Direction.LEFT));
        robokit.addCommand(new MoveForwardCommand(1));
        robokit.addCommand(new TurnCommand(Robot.Direction.RIGHT));
        robokit.addCommand(new PickupCommand());
        robokit.start();
    }
}
