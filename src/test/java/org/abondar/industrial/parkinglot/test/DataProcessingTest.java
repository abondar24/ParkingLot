package org.abondar.industrial.parkinglot.test;

import org.abondar.industrial.parkinglot.data.CarColor;
import org.abondar.industrial.parkinglot.data.CarData;
import org.abondar.industrial.parkinglot.processing.DataProcessor;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataProcessingTest {

    @Test
    public void createLotTest(){
        System.out.println("createLotTest");

        int lotSize = 2;
        DataProcessor dp = new DataProcessor(lotSize);

        var lot = dp.getParkingLot();
        assertEquals(lotSize,lot.length);
        assertNull(lot[0]);
        assertNull(lot[1]);
    }

    @Test
    public void parkTest(){
        System.out.println();
        System.out.println("parkTest");

        int lotSize = 2;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        dp.park(cd1);

        var cd2=new CarData("222-222", CarColor.WHITE);
        dp.park(cd2);

        var lot = dp.getParkingLot();

        assertEquals(lotSize,lot.length);
        assertEquals(cd1,lot[0]);
        assertEquals((Integer) 1,lot[0].getSlotNum());
        assertEquals(cd2,lot[1]);
        assertEquals((Integer)2,lot[1].getSlotNum());


    }

    @Test
    public void parkTestParkedBefore(){
        System.out.println();
        System.out.println("parkTestParkedBefore");

        int lotSize = 3;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        cd1.setSlotNum(2);
        dp.park(cd1);

        var lot = dp.getParkingLot();

        assertEquals(cd1,lot[1]);

    }

    @Test
    public void parkTestMiddle(){
        System.out.println();
        System.out.println("parkTestMiddle");

        int lotSize = 4;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        cd1.setSlotNum(2);
        dp.park(cd1);

        var cd2=new CarData("222-222", CarColor.WHITE);
        cd2.setSlotNum(4);
        dp.park(cd2);


        var lot = dp.getParkingLot();

        assertEquals(lotSize,lot.length);
        assertEquals(cd1,lot[1]);
        assertEquals(cd2,lot[3]);

        var cd3=new CarData("333-333", CarColor.WHITE);
        dp.park(cd3);
        assertEquals(cd3,lot[0]);
        assertEquals((Integer)1,cd3.getSlotNum());


    }

    @Test
    public void parkTestFull(){
        System.out.println();
        System.out.println("parkTestFull");

        int lotSize = 2;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        dp.park(cd1);

        var cd2=new CarData("222-222", CarColor.WHITE);
        dp.park(cd2);

        var cd3=new CarData("333-333", CarColor.WHITE);
        dp.park(cd3);

        var lot = dp.getParkingLot();

        assertEquals(lotSize,lot.length);
        assertEquals(cd1,lot[0]);
        assertEquals(cd2,lot[1]);

    }



    @Test
    public void leaveTest(){
        System.out.println();
        System.out.println("leaveTest");

        int lotSize = 2;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        dp.park(cd1);

        var cd2=new CarData("222-222", CarColor.WHITE);
        dp.park(cd2);

        dp.leave(cd2.getSlotNum());

        var lot = dp.getParkingLot();

        assertEquals(lotSize,lot.length);
        assertNotNull(lot[0]);
        assertNull(lot[1]);

    }

    @Test
    public void leaveTestWrongSlot(){
        System.out.println();
        System.out.println("leaveTest");

        int lotSize = 2;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        dp.park(cd1);

        var cd2=new CarData("222-222", CarColor.WHITE);
        dp.park(cd2);

        dp.leave(-1);
        dp.leave(lotSize+3);

        var lot = dp.getParkingLot();

        assertEquals(lotSize,lot.length);
        assertNotNull(lot[0]);
        assertNotNull(lot[1]);

    }

    @Test
    public void printStatusTest(){
        System.out.println();
        System.out.println("printStatusTest");

        int lotSize = 2;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        dp.park(cd1);

        var cd2=new CarData("222-222", CarColor.WHITE);
        dp.park(cd2);

        dp.status();
    }
}
