package chap6;

import chap6.Appliance.Light;
import chap6.command.LightOffCommand;
import chap6.command.LightOnCommand;

public class RemoteLoader2 {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteContrl = new RemoteControlWithUndo();

        Light livingRoomLight = new Light("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        remoteContrl.setCommand(0,livingRoomLightOn, livingRoomLightOff);

        remoteContrl.onButtonPressed(0);
        remoteContrl.offButtonPressed(0);
        System.out.println(remoteContrl);
        remoteContrl.undoButtonWasPressed();
        remoteContrl.offButtonPressed(0);
        remoteContrl.onButtonPressed(0);
        System.out.println(remoteContrl);
        remoteContrl.undoButtonWasPressed();
    }
}
