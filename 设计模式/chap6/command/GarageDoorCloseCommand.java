package chap6.command;

import chap6.Appliance.GarageDoor;

public class GarageDoorCloseCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.doorClose();
    }

    @Override
    public void undo() {
        garageDoor.doorOpen();
    }
}
