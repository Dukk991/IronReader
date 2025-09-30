package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.PhysicalMemory;

public class MemoryData {
    static class RAMmember {
        public String RAM_BankLabel;
        public long RAM_Capacity;
        public long RAM_ClockSpeed;
        public String RAM_Manufacturer;
        public String RAM_Type;
        public String RAM_PartNumber;
        public String RAM_SerialNumber;

        @Override
        public String toString() {
            return String.format(
                "Capacity: %d, Clockspeed: %d, Manufacturer: %s, Type: %s, %s",
                RAM_Capacity, RAM_ClockSpeed, RAM_Manufacturer, RAM_Type
            );
        }
    }

    public static void getStaticMemoryData() {
        SystemInfo si = new SystemInfo();
        GlobalMemory memory = si.getHardware().getMemory();
        Vector<RAMmember> ramList = new Vector<>();

        for (PhysicalMemory pm : memory.getPhysicalMemory()) {
            RAMmember ram = new RAMmember();
            //ram.RAM_BankLabel = pm.getBankLabel();
            ram.RAM_Capacity = pm.getCapacity();
            ram.RAM_ClockSpeed = pm.getClockSpeed();
            ram.RAM_Manufacturer = pm.getManufacturer();
            //ram.RAM_PartNumber = pm.getPartNumber();
            //ram.RAM_SerialNumber = pm.getSerialNumber();
            ram.RAM_Type = pm.getMemoryType();
            ramList.add(ram);
        }
    }

    public static Set<RAMmember> getStaticMemoryData1() {
        SystemInfo si = new SystemInfo();
        GlobalMemory memory = si.getHardware().getMemory();
        Set<RAMmember> ramSet = new HashSet<>();

        for (PhysicalMemory pm : memory.getPhysicalMemory()) {
            RAMmember ram = new RAMmember();
            ram.RAM_BankLabel = pm.getBankLabel();
            ram.RAM_Capacity = pm.getCapacity();
            ram.RAM_ClockSpeed = pm.getClockSpeed();
            ram.RAM_Manufacturer = pm.getManufacturer();
            ram.RAM_PartNumber = pm.getPartNumber();
            ram.RAM_SerialNumber = pm.getSerialNumber();
            ram.RAM_Type = pm.getMemoryType();
            ramSet.add(ram);
        }
        for (RAMmember ram : ramSet) {
            System.out.println(ram);
        }
        return ramSet;
    }
}