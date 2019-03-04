package org.abondar.industrial.parkinglot.processing.command;

import org.abondar.industrial.parkinglot.processing.DataProcessor;
import org.abondar.industrial.parkinglot.util.CommandsUtil;

public class RegNumbersColorCommand implements Command {

    private DataProcessor dp;
    private String[] data;

    public RegNumbersColorCommand(DataProcessor dp, String[] data) {
        this.dp = dp;
        this.data = data;
    }

    @Override
    public void execute() {
        if (data.length < 2) {
            System.out.println(CommandsUtil.WRONG_COMMAND_FORMAT);
            return;
        }

        var regNums = dp.getRegNumbersByColor(data[1]);

        if (regNums.size()>0){
            System.out.println(regNums.toString()
                    .replace("[","")
                    .replace("]",""));
        }

    }
}
