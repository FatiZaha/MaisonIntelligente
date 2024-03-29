package GUI;

import DAO.LesMaisons;
import metier.Client;
import metier.Maison;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterMaisons extends JFrame {

    private JTextField searchField;
    Client client;
    LesMaisons lesMaisons ;

    public void NavFilter(JPanel navFilter, GridBagConstraints c){

        c.weighty = 0.002;
        //c.weightx = 20;
        c.gridy = 1;

        navFilter.setBorder(new EmptyBorder(40,0,0,50));
        navFilter.setLayout(new FlowLayout());
        navFilter.setPreferredSize(new Dimension(1000, 80));
        //navFilter.setBackground(Color.LIGHT_GRAY);

        searchField = new JTextField();
        searchField.setFont(new Font("Arial",Font.PLAIN, 24));
        searchField.setBorder(new EmptyBorder(0,0,0,0));
        searchField.setPreferredSize(new Dimension(1000, 35));
        JButton searchButton = new JButton();

        String imagePath = "..\\MaisonIntelligente\\src\\GUI\\images\\search_icon.png";
        int desiredWidth = 32;
        int desiredHeight = 32;

        ImageIcon img = new ImageIcon(imagePath);
        Image image = img.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon searchIcon = new ImageIcon(image);

        searchButton.setIcon(searchIcon);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorder(new EmptyBorder(0,0,0,0));

        JButton addHomeButton = new JButton();
        addHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterAjoutMaison ajouterMaison = new InterAjoutMaison("Ajouter Maison",client);

                // Actions à effectuer lorsque le bouton est cliqué
                dispose(); // Fermer la fenêtre
            }
        });
        String imagePath2 = "..\\MaisonIntelligente\\src\\GUI\\images\\add_home.png";


        ImageIcon img2 = new ImageIcon(imagePath2);
        Image image2 = img2.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon searchIcon2 = new ImageIcon(image2);

        addHomeButton.setIcon(searchIcon2);
        addHomeButton.setContentAreaFilled(false);
        addHomeButton.setBorder(new EmptyBorder(0,70,0,0));

        String imagePath3 = "..\\MaisonIntelligente\\src\\GUI\\images\\back_icon.png";
        JButton backBtn= new JButton();
        ImageIcon img3 = new ImageIcon(imagePath3);
        Image image3 = img3.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon searchIcon3 = new ImageIcon(image3);

        backBtn.setIcon(searchIcon3);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorder(new EmptyBorder(0,0,0,0));

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterConnexion connexion = new InterConnexion("Connexion");

                // Actions à effectuer lorsque le bouton est cliqué
                dispose(); // Fermer la fenêtre
            }
        });

        navFilter.add(backBtn);
        navFilter.add(searchField);
        navFilter.add(searchButton);
        navFilter.add(addHomeButton);
        getContentPane().add(navFilter,c);
    }

    public void Content(JPanel content, GridBagConstraints c){

            c.weighty = 0.1;
            c.gridy = 2;

            content.setLayout(new BorderLayout());
            content.setBorder(new EmptyBorder(0, 200, 0, 200));

            JPanel gridPanel = new JPanel(new GridLayout(0, 3, 50, 30)); // 3 columns, 10 pixels horizontal and vertical gap

            lesMaisons = new LesMaisons(client.getId());
            // Create and add elements to the grid
        for (Maison maison: lesMaisons.m)  {
                JButton button = new JButton(maison.getNom());
                button.setSize(500,500);
            ImageIcon imageIcon = new ImageIcon(maison.theme.image); // Replace with the actual path to your image

            System.out.println(maison.theme.image);
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            button.setIcon(scaledImageIcon);
                gridPanel.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InterPieces pieces = new InterPieces(maison.getNom(),maison,client);

                        // Actions à effectuer lorsque le bouton est cliqué
                        dispose(); // Fermer la fenêtre
                    }
                });
                button.setPreferredSize(new Dimension(200, 200));
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

    public InterMaisons(String title, Client client){
        setTitle(title);
        this.client=client;
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
