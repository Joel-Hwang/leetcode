package DesignPattern.Command;

abstract class Command {
    protected Robot robot;
    public void setRobot(Robot robot){
        this.robot = robot;
    }
    public abstract void execute();
}
//이동 Command
class MoveForwardCommand extends Command{
    int space;
    public MoveForwardCommand(int space){
        this.space = space;
    }
    @Override
    public void execute() {
        robot.moveForward(space);
    }
}
//방향 전환 Command
class TurnCommand extends Command{
    Robot.Direction direction;
    public TurnCommand(Robot.Direction direction){
        this.direction = direction;
    }
    @Override
    public void execute() {
        robot.turn(direction);
    }
}
//Pickup Command
class PickupCommand extends Command{
    public PickupCommand(){
    }
    @Override
    public void execute() {
        robot.pickup();
    }
}