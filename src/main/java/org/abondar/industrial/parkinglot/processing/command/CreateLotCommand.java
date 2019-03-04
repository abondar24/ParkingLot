package org.abondar.industrial.parkinglot.processing.command;

import org.abondar.industrial.parkinglot.processing.DataProcessor;
import org.abondar.industrial.parkinglot.util.CommandsUtil;

public class CreateLotCommand implements Command {

    private DataProcessor dp;
    private String[] data;

    public CreateLotCommand(DataProcessor dp,String[] data) {
        this.dp = dp;
        this.data = data;
    }

    @Override
    public void execute() {
        if (data.length < 2) {
            System.out.println(CommandsUtil.WRONG_COMMAND_FORMAT);
            return;
        }
        dp.createLot(Integer.valueOf(data[1]));
    }


}
