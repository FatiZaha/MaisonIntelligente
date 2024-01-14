package GUI;
import DAO.*;
//import metier.Abonnement;
import com.mysql.cj.protocol.Message;
import metier.Client;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class InterConnexion extends JFrame {

    JTextField loginField;
    JPasswordField passwordField;
    JButton connectBtn;
    JButton inscptionBtn;

    LesClients lesClients = new LesClients();
    LesAbonnements lesAbonnements;


    public void Content(JPanel content, GridBagConstraints c){

        c.weighty = 0.1;
        c.gridy = 1;
        getContentPane().add(content,c);

        content.setLayout(new GridLayout(2, 2,-700,70));

        // Create the nested panels with GridBagLayout for each column
        JPanel row1 = new JPanel(new BorderLayout());
        JPanel row2 = new JPanel(new BorderLayout());
        JPanel row3 = new JPanel(new BorderLayout());
        JPanel row4 = new JPanel(new BorderLayout());
        // Create constraints for the GridBagLayout



        // Add the nested panels to the content panel

        content.setBorder(new EmptyBorder(250, 350, 200, 100));

        JLabel loginLabel= new JLabel("Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        row1.add(loginLabel, BorderLayout.WEST);

        loginField = new JTextField();
        loginField.setFont(new Font("Arial",Font.PLAIN, 24));
        //loginField.setSize(100,50);
        row2.add(loginField);


        JLabel pwdLabel = new JLabel("Mot de passe");
        pwdLabel.setFont(new Font("Arial", Font.BOLD, 24));
        row3.add(pwdLabel, BorderLayout.WEST);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.BOLD, 24));
        row4.add(passwordField);


        content.add(row1);
        content.add(row2);
        content.add(row3);
        content.add(row4);

        // Set the content panel on the frame
        //content.getRootPane();
    }
    public void Footer(JPanel footer, GridBagConstraints c){
        //footer.setBackground(Color.GRAY);

        c.weighty = 0.1;
        c.gridy = 2;
        getContentPane().add(footer,c);
        footer.setLayout(new FlowLayout(1, 50, FlowLayout.CENTER));

        footer.setBorder(new EmptyBorder(0, 0, 50, -880));

        inscptionBtn = new JButton("Inscription");
        inscptionBtn.setFont(new Font("Arial", Font.BOLD, 36));
        inscptionBtn.setBackground(Color.decode("#ABEAAB"));

        connectBtn = new JButton("Connexion");
        connectBtn.setFont(new Font("Arial", Font.BOLD, 36));
        connectBtn.setBackground(Color.decode("#ABEAAB"));

        //int buttonGap = 10;
        connectBtn.setBorder(new EmptyBorder(2, 30, 2, 30));
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(lesClients.Connexion(loginField.getText(),passwordField.getText()) != null){

                    Client client = lesClients.Connexion(loginField.getText(),passwordField.getText());
                    lesAbonnements = new LesAbonnements(client.getId());
                    if (lesAbonnements != null && !lesAbonnements.testAbonnement()) {
                        InterMaisons maison = new InterMaisons("Les Maisons",client);
                        dispose();}
                    else {

                        Abonnement abonnement = new Abonnement("Abonnement",client);
                        dispose();}
                }
                else JOptionPane.showMessageDialog(null, "Login ou mot de passe incorrect !!");



                // Actions à effectuer lorsque le bouton est cliqué
                 // Fermer la fenêtre
            }
        });

        inscptionBtn.setBorder(new EmptyBorder(2, 30, 2, 30));

        inscptionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterInscription interfaceInscription = new InterInscription("Inscription");

                // Actions à effectuer lorsque le bouton est cliqué
                dispose(); // Fermer la fenêtre
            }
        });

        footer.add(inscptionBtn);
        footer.add(connectBtn);

    }

    public void Window() {

        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel header = InterHeader.createHeaderPanel("Se connecter", c);
        getContentPane().add(header, c);
        JPanel content = new JPanel();
        JPanel footer = new JPanel();

        //this.Header(header,c);
        this.Content(content, c);
        this.Footer(footer, c);
        //pack();
        validate();


    }

    public InterConnexion(String title) {
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
