package com.SpringStudy2.Spring.Models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Laptop {
    private int LapID;
    private String LapName;
    private String LapProcessor;
    private int LapHardDisk;
    private String LapKeyboard;

    public int getLapID() {
        return LapID;
    }

    public void setLapID(int lapID) {
        LapID = lapID;
    }

    public String getLapName() {
        return LapName;
    }

    public void setLapName(String lapName) {
        LapName = lapName;
    }

    public String getLapProcessor() {
        return LapProcessor;
    }

    public void setLapProcessor(String lapProcessor) {
        LapProcessor = lapProcessor;
    }

    public int getLapHardDisk() {
        return LapHardDisk;
    }

    public void setLapHardDisk(int lapHardDisk) {
        LapHardDisk = lapHardDisk;
    }

    public String getLapKeyboard() {
        return LapKeyboard;
    }

    public void setLapKeyboard(String lapKeyboard) {
        LapKeyboard = lapKeyboard;
    }

    public void printDetails() {
        System.out.println("Laptop ID is "+LapID+" \nLaptop Name: "+LapName+" \nLaptop Processor: "+LapProcessor+" \nLaptop Hard Disk: "+LapHardDisk+" \nLaptop Keyboard: "+LapKeyboard);
    }
}
