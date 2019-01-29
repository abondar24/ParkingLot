package org.abondar.industrial.parkinglot.util;

import org.abondar.industrial.parkinglot.data.*;
import org.abondar.industrial.parkinglot.processing.*;

import java.io.*;
import java.util.*;

/**
 *
 * Input processing utility
 */
public class InputUtil {

    private static DataProcessor dp;


    public static List<String[]> parseFile(InputStream is) {

        List<String[]> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        br.lines()
                .forEach(l -> {

                    String[] data = l.split(" ");

                    lines.add(data);
                });
        return lines;
    }

    public static void executeCommand(String[] data) {
        switch (data[0]) {
            case CommandsUtil.CREATE_LOT:
                if (data.length < 2) {
                    System.out.println(CommandsUtil.WRONG_COMMAND_FORMAT);
                    return;
                }

                dp = new DataProcessor(Integer.valueOf(data[1]));
                break;

            case CommandsUtil.PARK:
                if (dp == null || data.length < 3) {
                    System.out.println(CommandsUtil.LOT_NOT_CREATED + " or " + CommandsUtil.WRONG_COMMAND_FORMAT);
                    return;
                }
                dp.park(new CarData(data[1], CarColor.valueOf(data[2].toUpperCase())));
                break;

            case CommandsUtil.LEAVE:
                if (dp == null || data.length < 2) {
                    System.out.println(CommandsUtil.LOT_NOT_CREATED + " or " + CommandsUtil.WRONG_COMMAND_FORMAT);
                    return;
                }

                dp.leave(Integer.valueOf(data[1]));
                break;

            case CommandsUtil.STATUS:
                if (dp == null){
                    return;
                }

                dp.status();
                break;

            case CommandsUtil.REG_NUMBERS_COLOR:
                if (dp == null || data.length < 2) {
                    System.out.println(CommandsUtil.LOT_NOT_CREATED + " or " + CommandsUtil.WRONG_COMMAND_FORMAT);
                    return;
                }

                var regNums = dp.getRegNumbersByColor(data[1]);

                if (regNums.size()>0){
                    System.out.println(regNums.toString()
                            .replace("[","")
                    .replace("]",""));
                }
                break;

            case CommandsUtil.SLOT_NUMBERS_COLOR:
                if (dp == null || data.length < 2) {
                    System.out.println(CommandsUtil.LOT_NOT_CREATED + " or " + CommandsUtil.WRONG_COMMAND_FORMAT);
                    return;
                }

                var slotNums = dp.getSlotNumbersByColor(data[1]);

                if (slotNums.size()>0){
                    System.out.println(slotNums.toString()
                            .replace("[","")
                            .replace("]",""));
                }
                break;

            case CommandsUtil.SLOT_NUMBER_REG_NUM:
                if (dp == null || data.length < 2) {
                    System.out.println(CommandsUtil.LOT_NOT_CREATED + " or " + CommandsUtil.WRONG_COMMAND_FORMAT);
                    return;
                }

                var slotNum = dp.getSlotNumberByRegNum(data[1]);

                if (slotNum!=0){
                    System.out.println(slotNum);
                }
                break;

            default:
                System.out.println(CommandsUtil.COMMAND_NOT_FOUND);
                break;
        }
    }


}
