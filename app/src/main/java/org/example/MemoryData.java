package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
        //public String RAM_PartNumber;
        //public String RAM_SerialNumber;

        @Override
        public String toString() {
            return String.format(
                "Ramslot: %s, Capacity: %d, Clockspeed: %d, Manufacturer: %s, Type: %s",
                RAM_BankLabel, RAM_Capacity / (1024 * 1024 * 1024), RAM_ClockSpeed / 1000000, RAM_Manufacturer, RAM_Type
            );
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            RAMmember that = (RAMmember) obj;
            return RAM_Capacity == that.RAM_Capacity &&
            RAM_ClockSpeed == that.RAM_ClockSpeed &&
            Objects.equals(RAM_BankLabel, that.RAM_BankLabel) &&
            Objects.equals(RAM_Manufacturer, that.RAM_Manufacturer) &&
            Objects.equals(RAM_Type, that.RAM_Type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(
                RAM_BankLabel, RAM_Capacity, RAM_ClockSpeed, RAM_Manufacturer, RAM_Type
            );
        }
    }

    public static Set<RAMmember>getStaticMemoryData() {
        SystemInfo si = new SystemInfo();
        GlobalMemory memory = si.getHardware().getMemory();
        Set<RAMmember> ramSet = new HashSet<>();

        for (PhysicalMemory pm : memory.getPhysicalMemory()) {
            RAMmember ram = new RAMmember();
            ram.RAM_BankLabel = pm.getBankLabel();
            ram.RAM_Capacity = pm.getCapacity();
            ram.RAM_ClockSpeed = pm.getClockSpeed();
            ram.RAM_Manufacturer = pm.getManufacturer();
            //ram.RAM_PartNumber = pm.getPartNumber();
            //ram.RAM_SerialNumber = pm.getSerialNumber();
            ram.RAM_Type = pm.getMemoryType();
            ramSet.add(ram);
        }
        /*
        for (RAMmember ram : ramSet) {
            System.out.println(ram);
        } */
        return ramSet;
    }
}