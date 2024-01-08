package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class Abonnement extends JFrame{
    JTextField RIB;
    JTextField CodeCarteField;
    JTextField  Dateexpiration;
    JButton AnnulerBtn;
    JButton ValiderBtn;

    public void Header(JPanel header, GridBagConstraints c){

        c.weightx = 0.05;
        c.weighty = 0.002;
        c.gridy = 0;
        String imagePath = "..\\MaisonIntelligente\\src\\GUI\\images\\logo2.png";
        int desiredWidth = 78;
        int desiredHeight = 34;


        ImageIcon img = new ImageIcon(imagePath);
        Image image = img.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImg = new ImageIcon(image);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        header.setLayout(flowLayout);
        header.setBorder(new EmptyBorder(5, 0, 5, 0));
        JLabel logo = new JLabel(scaledImg);
        header.add(logo);

        header.setBackground(Color.decode("#EFFA76"));
        getContentPane().add(header,c);
    }

    public void Content(JPanel content, GridBagConstraints c){

        c.weighty = 0.1;
        c.gridy = 1;
        getContentPane().add(content,c);

        GridLayout gridLayout = new GridLayout(3, 2);
        //gridLayout.setHgap(10); /Hgap : margin entre colonnes // Set horizontal gap (margin)
        gridLayout.setVgap(30); //Vgap : margin entre lignes // Set vertical gap (margin)

        content.setLayout(gridLayout);
        content.setBorder(new EmptyBorder(50, 100, 50, 100));

        JLabel RIBLabel= new JLabel("RIB");
        RIBLabel.setFont(new Font("Arial", Font.BOLD, 20));
        content.add(RIBLabel);
        RIB = new JTextField();
        RIB.setFont(new Font("Arial",Font.PLAIN, 20));
        content.add(RIB);

        JLabel DateLabel = new JLabel("Date d'expiration");
        DateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        content.add(DateLabel);
        Dateexpiration = new JTextField();
        Dateexpiration.setFont(new Font("Arial", Font.BOLD, 20));
        content.add(Dateexpiration);

        JLabel CodeLabel= new JLabel("Code carte");
        CodeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        content.add(CodeLabel);
        CodeCarteField = new JTextField();
        CodeCarteField.setFont(new Font("Arial",Font.PLAIN, 20));
        content.add(CodeCarteField);



    }
    public void Footer(JPanel footer, GridBagConstraints c){
        //footer.setBackground(Color.GRAY);

        c.weighty = 0.1;
        c.gridy = 2;
        getContentPane().add(footer,c);
        footer.setLayout(new FlowLayout());

        footer.setBorder(new EmptyBorder(0, 0, 0, -200));

        AnnulerBtn = new JButton("Annuler");
        AnnulerBtn.setFont(new Font("Arial", Font.BOLD, 20));
        AnnulerBtn.setBackground(Color.decode("#7FC951"));
        footer.add(AnnulerBtn);

        ValiderBtn = new JButton("Valider");
        ValiderBtn.setFont(new Font("Arial", Font.BOLD, 20));
        ValiderBtn.setBackground(Color.decode("#7FC951"));

        ValiderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterConnexion connexion = new InterConnexion("Connexion");

                // Actions à effectuer lorsque le bouton est cliqué
                dispose(); // Fermer la fenêtre
            }
        });

        AnnulerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterInscription inscription = new InterInscription("Inscription");

                // Actions à effectuer lorsque le bouton est cliqué
                dispose(); // Fermer la fenêtre
            }
        });

        footer.add(ValiderBtn);

    }

    public void Window(){

        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);

        JPanel header= new JPanel();
        JPanel content= new JPanel();
        JPanel footer= new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        this.Header(header,c);
        this.Content(content,c);
        this.Footer(footer,c);
        //pack();
        validate();

    }
    public Abonnement(String title) {
        setTitle(title);

        this.Window();
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
    }

}
