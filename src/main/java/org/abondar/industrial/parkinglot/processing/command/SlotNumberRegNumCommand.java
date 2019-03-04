package org.abondar.industrial.parkinglot.processing.command;

import org.abondar.industrial.parkinglot.processing.DataProcessor;
import org.abondar.industrial.parkinglot.util.CommandsUtil;

public class SlotNumberRegNumCommand implements Command {

    private DataProcessor dp;
    private String[] data;

    public SlotNumberRegNumCommand(DataProcessor dp, String[] data) {
        this.dp = dp;
        this.data = data;
    }

    @Override
    public void execute() {
        if (data.length < 2) {
            System.out.println(CommandsUtil.WRONG_COMMAND_FORMAT);
            return;
        }

        var slotNum = dp.getSlotNumberByRegNum(data[1]);

        if (slotNum!=0){
            System.out.println(slotNum);
        }
    }
}
