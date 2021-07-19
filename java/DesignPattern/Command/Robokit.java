package DesignPattern.Command;

import java.util.ArrayList;

public class Robokit {
    private Robot robot = new Robot();
    private ArrayList<Command> commands = new ArrayList<Command>();
    public void addCommand(Command c){
        commands.add(c);
    }
    public void start(){
        for(Command c : commands){
            c.setRobot(robot);
            c.execute();
        }
    }
}
