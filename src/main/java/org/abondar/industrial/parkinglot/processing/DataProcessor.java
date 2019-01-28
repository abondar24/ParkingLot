package org.abondar.industrial.parkinglot.processing;

import org.abondar.industrial.parkinglot.data.CarData;
import org.abondar.industrial.parkinglot.util.MessagesUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 *
 * Class to perform basic operations over the lot
 */
public class DataProcessor {

    private CarData[] parkingLot;

    public DataProcessor(int lotSize){
        parkingLot = new CarData[lotSize];


        System.out.printf(MessagesUtil.CREATED_LOT_MSG,lotSize);
        for (int i=0;i<parkingLot.length;i++){
            System.out.printf(MessagesUtil.ALLOCATED_MSG,i+1);
        }
    }


    public void park(CarData carData){
        var isFull = IntStream.range(0,parkingLot.length).allMatch(i->parkingLot[i]!=null);
        if (isFull){
            System.out.print(MessagesUtil.LOT_FULL_MSG);
            return;
        }

        if (carData.getSlotNum()!=null){
            parkingLot[carData.getSlotNum()-1]=carData;
        } else {
            int emptySlot = IntStream.range(0,parkingLot.length)
                    .filter(i-> parkingLot[i]==null)
                    .findFirst().getAsInt();
            carData.setSlotNum(emptySlot+1);
            parkingLot[emptySlot]=carData;
        }
        System.out.printf(MessagesUtil.PARK_MSG,carData.toString());

    }

    public void leave(Integer slotNum){
        if (slotNum>parkingLot.length || slotNum<1){
            System.out.printf(MessagesUtil.SLOT_NOT_FOUND,slotNum);
            return;
        }

        parkingLot[slotNum-1]=null;
        System.out.printf(MessagesUtil.LEAVE_MSG,slotNum);
    }

    public void status(){

        StringBuilder status = new StringBuilder();
        status.append(MessagesUtil.STATUS_HEADING);
        status.append("\n");
        status.append("\n");

        for (CarData carData : parkingLot) {
            status.append(carData.getSlotNum());
            status.append("\t\t\t\t");
            status.append(carData.getPlateNum());
            status.append("\t\t\t\t\t");
            status.append(carData.getCarColor());
            status.append("\n");
        }

        System.out.println(status.toString());

    }

    public CarData[] getParkingLot() {
        return parkingLot;
    }
}
