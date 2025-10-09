package org.example;

import java.awt.GridLayout;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display {
    public static void createsDisplay() {
        JFrame frame = new JFrame();
        frame.setSize(1200, 1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        Set<MemoryData.RAMmember> set1 = MemoryDataProcess.processMemoryData();
        Set<GPUdata.GPUmember> set2 = GPUdataProcess.processGPUdata();

        StringBuilder sb1 = new StringBuilder("<html>");
        StringBuilder sb2 = new StringBuilder("<html>");

        for (MemoryData.RAMmember x : set1) {
            sb1.append(x.toString().replace("\n", "<br>")).append("<br>");
        }
        sb1.append("</html>");

        for (GPUdata.GPUmember x : set2) {
            sb2.append(x.toString().replace("\n", "<br>")).append("<br>");
        }
        sb2.append("</html>");

        JLabel label1 = new JLabel(sb1.toString(), JLabel.CENTER);
        frame.add(label1);

        JLabel label2 = new JLabel(sb2.toString(), JLabel.CENTER);
        frame.add(label2);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(label1);
        panel.add(label2);

        frame.add(panel);

        frame.setVisible(true);
    }
}