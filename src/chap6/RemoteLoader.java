package chap6;

import chap6.Appliance.CeillingFan;
import chap6.Appliance.GarageDoor;
import chap6.Appliance.Light;
import chap6.Appliance.Stereo;
import chap6.command.*;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeillingFan ceillingFan = new CeillingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeillingFanOnCommand ceillingFanOn = new CeillingFanOnCommand(ceillingFan);
        CeillingFanOffCommand ceillingFanOff = new CeillingFanOffCommand(ceillingFan);

        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remoteControl.setCommand(0,livingRoomLightOn,livingRoomLightOff);
        remoteControl.setCommand(1,kitchenLightOn,kitchenLightOff);
        remoteControl.setCommand(2,ceillingFanOn,ceillingFanOff);
        remoteControl.setCommand(3,stereoOnWithCD,stereoOff);
        remoteControl.setCommand(4,garageDoorOpen,garageDoorClose);

        System.out.println(remoteControl);

        remoteControl.onButtonPressed(0);
        remoteControl.offButtonPressed(0);
        remoteControl.onButtonPressed(1);
        remoteControl.offButtonPressed(1);
        remoteControl.onButtonPressed(2);
        remoteControl.offButtonPressed(2);
        remoteControl.onButtonPressed(3);
        remoteControl.offButtonPressed(3);
        remoteControl.onButtonPressed(4);
        remoteControl.offButtonPressed(4);

    }
}
