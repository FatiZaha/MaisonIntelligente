package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class InterAppareils extends JFrame {
    private JTextField searchField;
    public void NavFilter(JPanel navFilter, GridBagConstraints c) {

        c.weighty = 0.002;
        //c.weightx = 20;
        c.gridy = 1;

        navFilter.setLayout(new FlowLayout());
        navFilter.setBorder(new EmptyBorder(40, 0, 0, 0));

        navFilter.setPreferredSize(new Dimension(1000, 80));
        //navFilter.setBackground(Color.LIGHT_GRAY);

        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 24));
        searchField.setBorder(new EmptyBorder(0, 0, 0, 0));
        searchField.setPreferredSize(new Dimension(800, 35));

        //searchButton :0

        JButton searchButton = new JButton();

        String imagePath = "..\\MaisonIntelligente\\src\\GUI\\images\\search_icon.png";
        int desiredWidth = 32;
        int desiredHeight = 32;

        ImageIcon img = new ImageIcon(imagePath);
        Image image = img.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon searchIcon = new ImageIcon(image);

        searchButton.setIcon(searchIcon);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorder(new EmptyBorder(0, 0, 0, 160));

 //addHomeButton :

        JButton addHomeButton = new JButton();

        String imagePath2 = "..\\MaisonIntelligente\\src\\GUI\\images\\add_home.png";
        int desiredWidth2 = 32;
        int desiredHeight2 = 32;

        ImageIcon img2 = new ImageIcon(imagePath2);
        Image image2 = img2.getImage().getScaledInstance(desiredWidth2, desiredHeight2, Image.SCALE_SMOOTH);
        ImageIcon searchIcon2 = new ImageIcon(image2);

        addHomeButton.setIcon(searchIcon2);
        addHomeButton.setContentAreaFilled(false);
        addHomeButton.setBorder(new EmptyBorder(0,0,0,0));


//backIconButton :

        JButton backIconButton = new JButton();

        String imagePath3 = "..\\MaisonIntelligente\\src\\GUI\\images\\back_icon.png";
        int desiredWidth3 = 32;
        int desiredHeight3 = 32;

        ImageIcon img3 = new ImageIcon(imagePath3);
        Image image3 = img3.getImage().getScaledInstance(desiredWidth3, desiredHeight3, Image.SCALE_SMOOTH);
        ImageIcon backIcon = new ImageIcon(image3);

        backIconButton.setIcon(backIcon);
        backIconButton.setContentAreaFilled(false);
        backIconButton.setBorder(new EmptyBorder(0,0,0,100));

        navFilter.add(searchField, FlowLayout.LEFT);
        navFilter.add(searchButton, FlowLayout.CENTER);
        navFilter.add(addHomeButton, FlowLayout.RIGHT);
        navFilter.add(backIconButton, FlowLayout.LEFT);
        getContentPane().add(navFilter,c);

    }



    public void Content(JPanel content, GridBagConstraints c) {
        c.weighty = 0.1;
        c.gridy = 2;

        content.setLayout(new BorderLayout());
        content.setBorder(new EmptyBorder(0, 200, 0, 200));

        JPanel gridPanel = new JPanel(new GridLayout(0, 3, 50, 30)); // 3 columns, 10 pixels horizontal and vertical gap

        // Create and add elements to the grid
        for (int i = 1; i <= 18; i++) {
            JButton button = new JButton("Button " + i);
            gridPanel.add(button);
            button.setPreferredSize(new Dimension(200, 250));
        }


        // Add the grigPanel area to a JScrollPane with a vertical scrollbar
        JScrollPane scrollPane = new JScrollPane(gridPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Create a vertical scrollbar
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();


        scrollPane.setBorder(new EmptyBorder(50,0,20,10));
        // Add components to the content panel
        content.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(content, c);
    }

    public void Window() {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel header = InterHeader.createHeaderPanel("Appareils", c);
        getContentPane().add(header, c);
        JPanel navFilter = new JPanel();
        JPanel content = new JPanel();

        this.NavFilter(navFilter, c);
        this.Content(content, c);

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