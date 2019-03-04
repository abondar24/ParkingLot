package org.abondar.industrial.parkinglot.processing.command;

import org.abondar.industrial.parkinglot.data.CarColor;
import org.abondar.industrial.parkinglot.data.CarData;
import org.abondar.industrial.parkinglot.processing.DataProcessor;
import org.abondar.industrial.parkinglot.util.CommandsUtil;

public class ParkCommand implements Command {

    private DataProcessor dp;
    private String[] data;

    public ParkCommand(DataProcessor dp,String[] data){
        this.dp = dp;
        this.data = data;
    }

    @Override
    public void execute() {
        if (data.length < 3) {
            System.out.println(CommandsUtil.WRONG_COMMAND_FORMAT);
            return;
        }
        dp.park(new CarData(data[1], CarColor.valueOf(data[2].toUpperCase())));
    }
}
