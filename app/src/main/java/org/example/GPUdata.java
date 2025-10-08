package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;

public class GPUdata {
    static class GPUmember {
        public String GPUid;
        public String GPUname;
        public String GPUvendor;
        public String GPUversionInfo;
        public long GPUvRam;

        @Override
        public String toString() {
            return String.format(
                "GPU: %S (%S)\n ID: %s\n Version: %s\n VRAM: %s\n",
                GPUname, GPUvendor, GPUid, GPUversionInfo, GPUvRam / (1024 * 1024 * 1024)
            );
        }
    }

    public static Set<GPUmember> getGPUdata() {
        SystemInfo si = new SystemInfo();
        List<GraphicsCard> gpu = si.getHardware().getGraphicsCards();
        Set<GPUmember> gpuSet = new HashSet<>();

        for (GraphicsCard gc : gpu) {
            GPUmember gpus = new GPUmember();
            gpus.GPUid = gc.getDeviceId();
            gpus.GPUname = gc.getName();
            gpus.GPUvendor = gc.getVendor();
            gpus.GPUversionInfo = gc.getVersionInfo();
            gpus.GPUvRam = gc.getVRam();
            gpuSet.add(gpus);
        }
        for (GPUmember ggg : gpuSet) {
            System.out.println(ggg);
        }
        return gpuSet;
    }
}