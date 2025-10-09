package org.example;

//.CentralProcessor.PhysicalProcessor.getPhysicalProcessorNumber - Gets the core id

import java.util.HashSet;
import java.util.Set;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.ProcessorIdentifier;

public class CPUdata {
    static class CPUmember {
        public String CPUfamily;
        public String CPUidentifier;
        public String CPUmodel;
        public String CPUid;
        public String CPUvendor;
        public long CPUfreq;

        @Override
        public String toString() {
            return String.format(
                "CPU: %s (%s, %s\n) Family: %s\n ID: %s\n Vendor: %s",
                CPUmodel, CPUidentifier, CPUfreq, CPUfamily, CPUid, CPUvendor
            );
        }
    }

    public Set<CPUmember> getCPUdata() {
        SystemInfo si = new SystemInfo();
        CentralProcessor cpu = si.getHardware().getProcessor();
        ProcessorIdentifier cpuId = cpu.getProcessorIdentifier();
        Set<CPUmember> cpuSet = new HashSet<>();

        CPUmember member = new CPUmember();
        member.CPUfamily = cpuId.getFamily();
        member.CPUidentifier = cpuId.getIdentifier();
        member.CPUmodel = cpuId.getModel();
        member.CPUid = cpuId.getProcessorID();
        member.CPUvendor = cpuId.getVendor();
        member.CPUfreq = cpuId.getVendorFreq();

        cpuSet.add(member);

        return cpuSet;
    }
}