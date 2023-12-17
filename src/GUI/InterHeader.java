package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InterHeader {
    public static JPanel createHeaderPanel(String title,GridBagConstraints c) {
        JPanel header = new JPanel();
        c.weightx = 0.05;
        c.weighty = 0.002;
        c.gridy = 0;
        String imagePath = "..\\MaisonIntelligente\\src\\GUI\\images\\logo2.png";
        int desiredWidth = 151;
        int desiredHeight = 65;


        ImageIcon img = new ImageIcon(imagePath);
        Image image = img.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImg = new ImageIcon(image);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        header.setLayout(flowLayout);
        header.setBorder(new EmptyBorder(5, 0, 5, 0));
        JLabel logo = new JLabel(scaledImg);
        header.add(logo);
        JLabel pagename= new JLabel(title);
        pagename.setFont(new Font("Arial", Font.BOLD, 36));
        pagename.setForeground(Color.decode("#4A4A49"));
        pagename.setBorder(new EmptyBorder(0, 50, 0, 0));
        header.add(pagename);

        header.setBackground(Color.decode("#EFFA76"));

        return header;
    }
}
