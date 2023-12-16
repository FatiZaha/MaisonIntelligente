package GUI;

import java.awt.*;
import java.nio.file.Path;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class InterfaceConnexion extends JFrame {


    public void Header(JPanel header, GridBagConstraints c){

        c.weightx = 0.05;
        c.weighty = 0.002;
        c.gridy = 0;
        String imagePath = "D:\\Program Files\\JAVA\\eclipse\\MaisonIntelligente\\src\\GUI\\images\\logo2.png";
        int desiredWidth = 150;
        int desiredHeight = 70;


        ImageIcon img = new ImageIcon(imagePath);
        Image image = img.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImg = new ImageIcon(image);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        header.setLayout(flowLayout);
        JLabel logo = new JLabel(scaledImg);
        header.add(logo);
        JLabel pagename= new JLabel("Se Connecter");
        pagename.setFont(new Font("Arial", Font.BOLD, 30));
        pagename.setBorder(new EmptyBorder(0, 50, 0, 0));
        header.add(pagename);

        header.setBackground(Color.ORANGE);
        getContentPane().add(header,c);
    }
    public void Content(JPanel content, GridBagConstraints c){

        c.weighty = 0.6;
        c.gridy = 1;
        getContentPane().add(content,c);
    }
    public void Footer(JPanel footer, GridBagConstraints c){
        footer.setBackground(Color.GRAY);
        c.weighty = 0.2;
        c.gridy = 2;
        getContentPane().add(footer,c);
    }

    public void Window(){

        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);

        JPanel header= new JPanel();;
        JPanel content= new JPanel();
        JPanel footer= new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        this.Header(header,c);
        this.Content(content,c);
        this.Footer(footer,c);
        pack();
        validate();

    }
    public InterfaceConnexion(String title) {
        setTitle(title);
        this.Window();
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }
}
