package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InterInfoAppareil extends JFrame {

    public void NavBar(JPanel navBar, GridBagConstraints c){

        c.weighty = 0.002;
        //c.weightx = 20;
        c.gridy = 1;

        navBar.setBorder(new EmptyBorder(40,0,0,0));
        navBar.setLayout(new FlowLayout());
        navBar.setPreferredSize(new Dimension(1000, 80));
        //navFilter.setBackground(Color.LIGHT_GRAY);

        JButton returnButton = new JButton();

        String imagePath = "..\\MaisonIntelligente\\src\\GUI\\images\\back_icon.png";
        int desiredWidth = 32;
        int desiredHeight = 32;

        ImageIcon img = new ImageIcon(imagePath);
        Image image = img.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon returnIcon = new ImageIcon(image);

        returnButton.setIcon(returnIcon);
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(new EmptyBorder(0,0,0,0));

        JButton deleteButton = new JButton();

        String imagePath2 = "..\\MaisonIntelligente\\src\\GUI\\images\\delete_icon.png";
        int desiredWidth2 = 32;
        int desiredHeight2 = 32;

        ImageIcon img2 = new ImageIcon(imagePath2);
        Image image2 = img2.getImage().getScaledInstance(desiredWidth2, desiredHeight2, Image.SCALE_SMOOTH);
        ImageIcon deleteIcon = new ImageIcon(image2);

        deleteButton.setIcon(deleteIcon);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBorder(new EmptyBorder(0,1400,0,0));


        navBar.add(returnButton);
        navBar.add(deleteButton);
        getContentPane().add(navBar,c);
    }

    public void Content(JPanel content, GridBagConstraints c){
        c.weighty = 0.1;
        c.gridy = 2;

        content.setLayout(new FlowLayout());
        content.setBorder(new EmptyBorder(100, 0, 100, 0));
        content.setBackground(Color.GRAY);
        JButton etat =new JButton("button");
        etat.setPreferredSize(new Dimension(100, 150));
        content.add(etat);

        JPanel change = new JPanel(new GridBagLayout());
        change.setPreferredSize(new Dimension(1000, 300));
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;


        grid.weighty = 0.2;
        grid.gridy = 0;
        JLabel title = new JLabel("Changer nom Appareil");
        title.setFont(new Font("Arial", Font.BOLD, 32));

        change.add(title,grid);

        grid.gridy = 1;
        JPanel info = new JPanel(new FlowLayout());
        Label oldNameLabel = new Label("old name");
        oldNameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        JTextField oldNameField = new JTextField();
        oldNameField.setFont(new Font("Arial", Font.PLAIN, 24));
        info.add(oldNameLabel);
        info.add(oldNameField);
        change.add(info,grid);

        grid.gridy = 2;
        JPanel info2 = new JPanel(new FlowLayout());
        Label newNameLabel = new Label("new name");
        newNameLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        JTextField newNameField = new JTextField();
        newNameField.setFont(new Font("Arial", Font.PLAIN, 24));

        info2.add(newNameLabel);
        info2.add(newNameField);
        change.add(info2,grid);

        grid.gridy = 3;
        JButton validerBtn= new JButton("Valider");
        validerBtn.setFont(new Font("Arial", Font.BOLD, 32));
        validerBtn.setBorder(new EmptyBorder(2, 30, 2, 30));
        change.add(validerBtn,grid);
        content.add(change);

        getContentPane().add(content, c);
    }
    public void Window(){

        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel header= InterHeader.createHeaderPanel("Appareil",c);
        getContentPane().add(header,c);
        JPanel navBar= new JPanel();
        JPanel content= new JPanel();

        this.NavBar(navBar,c);
        this.Content(content,c);
        //this.Footer(footer,c);
        //pack();
        validate();

    }
    public InterInfoAppareil(String title){
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
