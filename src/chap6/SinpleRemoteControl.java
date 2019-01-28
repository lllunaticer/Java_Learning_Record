package chap6;

import chap6.command.Command;

public class SinpleRemoteControl {
    Command slot;

    public SinpleRemoteControl() {
    }

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
