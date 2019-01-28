package chap6;

import chap6.Appliance.CeillingFan;
import chap6.Appliance.GarageDoor;
import chap6.Appliance.Light;
import chap6.Appliance.Stereo;
import chap6.command.*;

public class RemoteMacroControl {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light("Living Room");
        Stereo stereo = new Stereo("Saloon");
        CeillingFan ceillingFan = new CeillingFan("Attic");
        GarageDoor garageDoor = new GarageDoor("Porch");

        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        StereoOnWithCDCommand stereoOn =  new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        CeillingFanOnCommand ceillingFanOn = new CeillingFanOnCommand(ceillingFan);
        CeillingFanOffCommand ceillingFanOff = new CeillingFanOffCommand(ceillingFan);

        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        Command[] partyOn  = {lightOn, stereoOn, ceillingFanOn, garageDoorOpen};
        Command[] partOff = {lightOff, stereoOff, ceillingFanOff, garageDoorClose};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partOff);

        remoteControl.setCommand(0,partyOnMacro,partyOffMacro);

        System.out.println(remoteControl);
        System.out.println("-------Press Macro On---------");
        remoteControl.onButtonPressed(0);
        System.out.println("-------Press Macro Off---------");
        remoteControl.offButtonPressed(0);
    }
}
