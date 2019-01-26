package chap6.command;

import chap6.Appliance.CeillingFan;

public class CeillingFanOnCommand implements Command {
    CeillingFan ceillingFan;

    public CeillingFanOnCommand(CeillingFan ceillingFan) {
        this.ceillingFan = ceillingFan;
    }

    @Override
    public void execute() {
        ceillingFan.on();
    }
}
