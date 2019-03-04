package org.abondar.industrial.parkinglot.processing.command;

import org.abondar.industrial.parkinglot.processing.DataProcessor;

public class StatusCommand implements Command{

    private DataProcessor dp;

    public StatusCommand(DataProcessor dp) {
        this.dp = dp;
    }

    @Override
    public void execute() {
       dp.status();
    }
}
