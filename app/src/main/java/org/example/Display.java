package org.example;

import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Display {
    public static void createsDisplay() {
        JFrame frame = new JFrame();
        frame.setSize(1200, 1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        Set<MemoryData.RAMmember> set = MemoryDataProcess.processMemoryData();

        StringBuilder sb = new StringBuilder("<html>");

        for (MemoryData.RAMmember x : set) {
            sb.append(x.toString()).append("<br>");
        }

        JLabel label = new JLabel(sb.toString(), JLabel.CENTER);
        frame.add(label);

    }
}