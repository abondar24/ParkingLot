package org.abondar.industrial.parkinglot.processing.command;

import org.abondar.industrial.parkinglot.processing.DataProcessor;
import org.abondar.industrial.parkinglot.util.CommandsUtil;

public class SlotNumbersColorCommand implements Command {

    private DataProcessor dp;
    private String[] data;

    public SlotNumbersColorCommand(DataProcessor dp, String[] data) {
        this.dp = dp;
        this.data = data;
    }

    @Override
    public void execute() {
        if (data.length < 2) {
            System.out.println(CommandsUtil.WRONG_COMMAND_FORMAT);
            return;
        }

        var slotNums = dp.getSlotNumbersByColor(data[1]);

        if (slotNums.size()>0){
            System.out.println(slotNums.toString()
                    .replace("[","")
                    .replace("]",""));
        }
    }
}
