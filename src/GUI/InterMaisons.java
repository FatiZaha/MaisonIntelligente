package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterMaisons extends JFrame {

    private JTextField searchField;
    public void NavFilter(JPanel navFilter, GridBagConstraints c){

        c.weighty = 0.01;
        c.gridy = 1;

        navFilter.setBorder(new EmptyBorder(40,500,60,500));
        navFilter.setLayout(new BorderLayout());
        navFilter.setPreferredSize(new Dimension(300, 80));
        //navFilter.setBackground(Color.LIGHT_GRAY);

        searchField = new JTextField();
        searchField.setFont(new Font("Arial",Font.PLAIN, 24));
        searchField.setBorder(new EmptyBorder(1,1,1,1));
        JButton searchButton = new JButton();

        String imagePath = "..\\MaisonIntelligente\\src\\GUI\\images\\search_icon.png";
        int desiredWidth = 32;
        int desiredHeight = 32;

        ImageIcon img = new ImageIcon(imagePath);
        Image image = img.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon searchIcon = new ImageIcon(image);

        searchButton.setIcon(searchIcon);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorder(new EmptyBorder(1,1,1,1));

        navFilter.add(searchField, BorderLayout.CENTER);
        navFilter.add(searchButton, BorderLayout.EAST);
        getContentPane().add(navFilter,c);
    }

    public void Content(JPanel content, GridBagConstraints c){
        c.weighty = 0.1;
        c.gridy = 2;
        JLabel test= new JLabel("hhhhh");
        getContentPane().add(content,c);
    }
    public void Window(){
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel header= InterHeader.createHeaderPanel("Maisons",c);
        getContentPane().add(header,c);
        JPanel navFilter= new JPanel();
        JPanel content= new JPanel();

        this.NavFilter(navFilter,c);
        this.Content(content,c);
        //this.Footer(footer,c);
        //pack();
        validate();
    }

    public InterMaisons(String title){
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
