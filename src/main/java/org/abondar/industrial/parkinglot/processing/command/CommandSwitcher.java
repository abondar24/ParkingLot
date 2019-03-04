package org.abondar.industrial.parkinglot.processing.command;

import org.abondar.industrial.parkinglot.data.*;
import org.abondar.industrial.parkinglot.processing.*;
import org.abondar.industrial.parkinglot.util.CommandsUtil;

import java.io.*;
import java.util.*;

/**
 * Input processing utility
 */
public class CommandSwitcher {

    private DataProcessor dp;
    private Switch sw;

    public CommandSwitcher() {
        dp = DataProcessor.getInstance();
        sw = new Switch();
    }


    public void executeCommand(String[] data) {
        switch (data[0]) {
            case CommandsUtil.CREATE_LOT:
                var createLot = new CreateLotCommand(dp, data);
                sw.storeAndExecute(createLot);
                break;

            case CommandsUtil.PARK:
                var park = new ParkCommand(dp, data);
                sw.storeAndExecute(park);
                break;

            case CommandsUtil.LEAVE:
                var leave = new LeaveCommand(dp, data);
                sw.storeAndExecute(leave);
                break;

            case CommandsUtil.STATUS:
                var status = new StatusCommand(dp);
                sw.storeAndExecute(status);
                break;

            case CommandsUtil.REG_NUMBERS_COLOR:
                var regNumCl = new RegNumbersColorCommand(dp, data);
                sw.storeAndExecute(regNumCl);
                break;

            case CommandsUtil.SLOT_NUMBERS_COLOR:
                var slotNumCl = new SlotNumbersColorCommand(dp, data);
                sw.storeAndExecute(slotNumCl);
                break;

            case CommandsUtil.SLOT_NUMBER_REG_NUM:
                var slotNumRegNum = new SlotNumberRegNumCommand(dp, data);
                sw.storeAndExecute(slotNumRegNum);
                break;

            default:
                System.out.println(CommandsUtil.COMMAND_NOT_FOUND);
                break;
        }
    }


}
