package GUI;

import java.awt.*;

import javax.swing.*;

public class InterfaceConnexion extends JFrame {

    public InterfaceConnexion() {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);

        JPanel header;
        JPanel content;
        JPanel footer;

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0.2;
        c.gridy = 0;

        header = new JPanel();
        header.setBackground(Color.ORANGE);
        getContentPane().add(header,c);

        content = new JPanel();
        c.weighty = 0.6;
        c.gridy = 1;
        getContentPane().add(content,c);

        footer = new JPanel();
        footer.setBackground(Color.GRAY);
        c.weighty = 0.2;
        c.gridy = 2;
        getContentPane().add(footer,c);

        pack();
        validate();

        setTitle("Maison Intelligente");
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }
}