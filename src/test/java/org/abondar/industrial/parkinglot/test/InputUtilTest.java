package org.abondar.industrial.parkinglot.test;

import org.abondar.industrial.parkinglot.util.*;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class InputUtilTest {


    @Test
    public void parseFileTest() {
        System.out.println("parseFileTest");

        String fileName = "/test.txt";
        InputStream is = InputUtilTest.class.getResourceAsStream(fileName);
        var res = InputUtil.parseFile(is);

        assertEquals(5L, res.size());
        assertEquals(2L, res.get(0).length);
        assertEquals(3L, res.get(1).length);
        assertEquals(2L, res.get(2).length);
        assertEquals(1L, res.get(3).length);
        assertEquals(2L, res.get(4).length);
    }

    @Test
    public void executeCommandsTest() {
        System.out.println();
        System.out.println("executeCommandsTest");

        String fileName = "/testCommands.txt";
        InputStream is = InputUtilTest.class.getResourceAsStream(fileName);
        var commands = InputUtil.parseFile(is);

        commands.forEach(InputUtil::executeCommand);
    }

    @Test
    public void executeCommandsNoCreateTest() {
        System.out.println();
        System.out.println("executeNoCreateTest");

        String fileName = "/testCommandsNoCreate.txt";
        InputStream is = InputUtilTest.class.getResourceAsStream(fileName);
        var commands = InputUtil.parseFile(is);

        commands.forEach(InputUtil::executeCommand);
    }

    @Test
    public void executeCommandsNotFullTest() {
        System.out.println();
        System.out.println("executeNotFullTest");

        String fileName = "/testCommandsNotFull.txt";
        InputStream is = InputUtilTest.class.getResourceAsStream(fileName);
        var commands = InputUtil.parseFile(is);

        commands.forEach(InputUtil::executeCommand);
    }
}
