package chap6.command;

import chap6.Appliance.CeillingFan;

public class CeillingFanOffCommand implements Command {
    CeillingFan ceillingFan;
    int prevspeed;

    public CeillingFanOffCommand(CeillingFan ceillingFan) {
        this.ceillingFan = ceillingFan;
    }

    @Override
    public void execute() {
        prevspeed = ceillingFan.getSpeed();
        ceillingFan.off();
    }

    @Override
    public void undo() {
        if(prevspeed==CeillingFan.HIGH){
            ceillingFan.high();
        }else if(prevspeed==CeillingFan.MEDIUM){
            ceillingFan.medium();
        }else if(prevspeed==CeillingFan.LOW){
            ceillingFan.low();
        }else if(prevspeed==CeillingFan.OFF){
            ceillingFan.off();
        }
    }
}
