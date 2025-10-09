package org.example;

import java.util.Set;
import java.util.stream.Collectors;

public class GPUdataProcess extends GPUdata {
    public static Set<GPUmember> processGPUdata() {
        Set<GPUmember> unprocessedData = getGPUdata();

        return unprocessedData.stream()
            .collect(Collectors.toCollection(java.util.LinkedHashSet::new));
    }

    public static void printProcessedGPUdata() {
        processGPUdata().forEach(System.out::println);
    }
}