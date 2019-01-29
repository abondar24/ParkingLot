package org.abondar.industrial.parkinglot.processing;

import org.abondar.industrial.parkinglot.data.*;
import org.abondar.industrial.parkinglot.util.MessagesUtil;

import java.util.*;
import java.util.stream.*;

/**
 * Class to perform basic operations over the lot
 */
public class DataProcessor {

    private CarData[] parkingLot;

    public DataProcessor(int lotSize) {
        parkingLot = new CarData[lotSize];


        System.out.printf(MessagesUtil.CREATED_LOT_MSG, lotSize);

    }


    public void park(CarData carData) {
        var isFull = Arrays.stream(parkingLot).allMatch(Objects::nonNull);
        if (isFull) {
            System.out.print(MessagesUtil.LOT_FULL_MSG);
            return;
        }

        if (carData.getSlotNum() != null) {
            parkingLot[carData.getSlotNum() - 1] = carData;
        } else {
            int emptySlot = IntStream.range(0, parkingLot.length)
                    .filter(i -> parkingLot[i] == null)
                    .findFirst().getAsInt();
            carData.setSlotNum(emptySlot + 1);
            parkingLot[emptySlot] = carData;
        }

        System.out.printf(MessagesUtil.ALLOCATED_MSG,carData.getSlotNum());
    }

    public void leave(Integer slotNum) {
        if (slotNum > parkingLot.length || slotNum < 1) {
            System.out.println(MessagesUtil.NOT_FOUND);
            return;
        }

        parkingLot[slotNum-1]=null;
        System.out.printf(MessagesUtil.LEAVE_MSG,slotNum);
    }

    public void status() {

        StringBuilder status = new StringBuilder();
        status.append(MessagesUtil.STATUS_HEADING);
        status.append("\n");
        status.append("\n");

        for (CarData carData : parkingLot) {
            if (carData != null) {
                status.append(carData.getSlotNum());
                status.append("\t\t\t");
                status.append(carData.getRegNum());
                status.append("\t\t\t");
                status.append(carData.getCarColor());
                status.append("\n");
            }
        }

        System.out.println(status.toString());

    }

    public List<String> getRegNumbersByColor(String color) {
        var carsByColor = getCarsByColor(color);

        return carsByColor.stream().map(CarData::getRegNum).collect(Collectors.toList());
    }


    public List<Integer> getSlotNumbersByColor(String color) {
        var carsByColor = getCarsByColor(color);

        return carsByColor.stream().map(CarData::getSlotNum).collect(Collectors.toList());
    }

    public List<CarData> getCarsByColor(String color) {
        if (!colorExists(color)) {
            return new ArrayList<>();
        }

        var isEmpty = Arrays.stream(parkingLot).allMatch(Objects::isNull);
        if (isEmpty) {
            return new ArrayList<>();
        }

        return Arrays.stream(parkingLot)
                .filter(Objects::nonNull)
                .filter(cd -> cd.getCarColor().name().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }


    public Integer getSlotNumberByRegNum(String regNum) {
        var res = Arrays.stream(parkingLot)
                .filter(Objects::nonNull)
                .filter(cd -> cd.getRegNum().equals(regNum)).findFirst();

        if (res.isEmpty()) {
            System.out.println(MessagesUtil.NOT_FOUND);
            return 0;
        }

        return res.get().getSlotNum();
    }

    private boolean colorExists(String color) {
        for (CarColor cc : CarColor.values()) {
            if (cc.name().equalsIgnoreCase(color)) {
                return true;
            }
        }

        return false;
    }

    public CarData[] getParkingLot() {
        return parkingLot;
    }
}
