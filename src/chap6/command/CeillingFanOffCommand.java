package chap6.command;

import chap6.Appliance.CeillingFan;

public class CeillingFanOffCommand implements Command {
    CeillingFan ceillingFan;

    public CeillingFanOffCommand(CeillingFan ceillingFan) {
        this.ceillingFan = ceillingFan;
    }

    @Override
    public void execute() {
        ceillingFan.off();
    }
}
