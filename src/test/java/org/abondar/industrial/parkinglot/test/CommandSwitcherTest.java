package org.abondar.industrial.parkinglot.test;

import org.abondar.industrial.parkinglot.processing.command.CommandSwitcher;
import org.abondar.industrial.parkinglot.util.FileParserUtil;
import org.junit.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommandSwitcherTest {


    @Test
    public void parseFileTest() {
        System.out.println("parseFileTest");

        String fileName = "/test.txt";
        InputStream is = CommandSwitcherTest.class.getResourceAsStream(fileName);

        var res = FileParserUtil.parseFile(is);

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
        InputStream is = CommandSwitcherTest.class.getResourceAsStream(fileName);
        var commands = FileParserUtil.parseFile(is);
        CommandSwitcher cs = new CommandSwitcher();
        commands.forEach(cs::executeCommand);
    }

    @Test
    public void executeCommandsNoCreateTest() {
        System.out.println();
        System.out.println("executeNoCreateTest");

        String fileName = "/testCommandsNoCreate.txt";
        InputStream is = CommandSwitcherTest.class.getResourceAsStream(fileName);
        var commands = FileParserUtil.parseFile(is);
        CommandSwitcher cs = new CommandSwitcher();
        commands.forEach(cs::executeCommand);
    }

    @Test
    public void executeCommandsNotFullTest() {
        System.out.println();
        System.out.println("executeNotFullTest");

        String fileName = "/testCommandsNotFull.txt";
        InputStream is = CommandSwitcherTest.class.getResourceAsStream(fileName);
        var commands = FileParserUtil.parseFile(is);
        CommandSwitcher cs = new CommandSwitcher();
        commands.forEach(cs::executeCommand);
    }
}
