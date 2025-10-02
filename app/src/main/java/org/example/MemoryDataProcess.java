package org.example;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
public class MemoryDataProcess extends MemoryData{
    public static Set<RAMmember> processMemoryData() {
        Set<RAMmember> unprocessedData = getStaticMemoryData();

        return unprocessedData.stream()
            .sorted(Comparator.comparing(a -> a.RAM_BankLabel))
            .collect(Collectors.toCollection(java.util.LinkedHashSet::new));
    }

    public static void printProcessedData() {
        processMemoryData().forEach(System.out::println);
    }
}