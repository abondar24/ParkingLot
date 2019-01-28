package org.abondar.industrial.parkinglot.test;

import org.abondar.industrial.parkinglot.data.CarColor;
import org.abondar.industrial.parkinglot.data.CarData;
import org.abondar.industrial.parkinglot.processing.DataProcessor;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataProcessingTest {

    @Test
    public void createLotTest(){
        int lotSize = 2;
        DataProcessor dp = new DataProcessor(lotSize);

        var lot = dp.getParkingLot();
        assertEquals(lotSize,lot.length);
        assertNull(lot[0]);
        assertNull(lot[1]);
    }

    @Test
    public void parkTest(){
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
        int lotSize = 3;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        cd1.setSlotNum(2);
        dp.park(cd1);

        var lot = dp.getParkingLot();

        assertEquals(cd1,lot[1]);

    }

    @Test
    public void parkTestMiddlepark(){
        int lotSize = 4;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        cd1.setSlotNum(2);
        dp.park(cd1);

        var cd2=new CarData("222-222", CarColor.WHITE);
        cd1.setSlotNum(4);
        dp.park(cd2);


        var lot = dp.getParkingLot();

        System.out.println(lot[1]);
        System.out.println(lot[2]);
        System.out.println(lot[3]);
        System.out.println(lot[4]);

        assertEquals(lotSize,lot.length);
        assertEquals(cd1,lot[1]);
        assertEquals(cd2,lot[3]);

        var cd3=new CarData("333-333", CarColor.WHITE);
        dp.park(cd3);
        assertEquals(cd3,lot[0]);
        assertEquals((Integer)1,cd3.getSlotNum());


    }

    @Test
    public void parkLotFullTest(){
        int lotSize = 2;
        DataProcessor dp = new DataProcessor(lotSize);

        var cd1=new CarData("111-111", CarColor.BLACK);
        dp.park(cd1);

        var cd2=new CarData("222-222", CarColor.WHITE);
        dp.park(cd2);

        var res = dp.getParkingLot();

       // assertFalse(lotSize,lot.length);


    }

}
