package GUI;

import javax.swing.*;
import java.awt.*;

public class InterAppareils extends JFrame{

    public void Window(){

        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);

        //JPanel header= new JPanel();;
        JPanel content= new JPanel();
        JPanel footer= new JPanel();

        GridBagConstraints c = new GridBagConstraints();
        c.fill =GridBagConstraints.BOTH;
        JPanel header= InterHeader.createHeaderPanel("Appareils",c);
        getContentPane().add(header,c);
        //this.Header(header,c);
       // this.Content(content,c);
        //pack();
        validate();
    }


    public InterAppareils(String title) {
        setTitle(title);
        this.Window();
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        String imagePath = "..\\MaisonIntelligente\\src\\GUI\\images\\logo2.png";
        ImageIcon icon = new ImageIcon(imagePath);
        setIconImage(icon.getImage());
    }
}
