package chap6;

import chap6.Appliance.CeillingFan;
import chap6.command.CeillingFanHighCommand;
import chap6.command.CeillingFanMediumCommand;
import chap6.command.CeillingFanOffCommand;

public class RemoteLoader3 {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        CeillingFan ceillingFan = new CeillingFan("Living Room");

        CeillingFanHighCommand ceillingFanHigh = new CeillingFanHighCommand(ceillingFan);
        CeillingFanMediumCommand ceillingFanMedium = new CeillingFanMediumCommand(ceillingFan);
        CeillingFanOffCommand ceillingFanOff = new CeillingFanOffCommand(ceillingFan);

        remoteControl.setCommand(0,ceillingFanMedium,ceillingFanOff);
        remoteControl.setCommand(1,ceillingFanHigh, ceillingFanOff);

        remoteControl.onButtonPressed(0);
        remoteControl.offButtonPressed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();

        remoteControl.onButtonPressed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();
    }
}
