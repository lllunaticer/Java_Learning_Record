package chap6;

import chap6.Appliance.GarageDoor;
import chap6.Appliance.Light;
import chap6.command.GarageDoorOpenCommand;
import chap6.command.LightOnCommand;

public class RemoteControlTest {
    public static void main(String[] args) {
        SinpleRemoteControl remote = new SinpleRemoteControl();
        Light light = new Light("");
        GarageDoor garageDoor = new GarageDoor("");
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand doorOpen = new GarageDoorOpenCommand(garageDoor);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(doorOpen);
        remote.buttonWasPressed();
    }
}
