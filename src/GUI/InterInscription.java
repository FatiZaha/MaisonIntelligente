package GUI;
import DAO.LesClients;
import metier.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class InterInscription extends JFrame {
    JTextField nomField;
    JTextField prenomField;
    JTextField telField;
    JTextField emailField;
    JTextField adresseField;
    JTextField loginField;
    JPasswordField passwordField;
    JPasswordField chpasswordField;
    JButton creerBtn;
    JButton AnnulerBtn;

    LesClients lesClients = new LesClients();

        public void Content(JPanel content, GridBagConstraints c) {

            c.weighty = 2;
            c.gridy = 1;
            int hgap=-500;
            int vgap=20;
            getContentPane().add(content, c);
            content.setLayout(new GridLayout(8, 2,hgap,vgap));
            content.setBorder(new EmptyBorder(10, 100, 10, 100));

            JLabel nomLabel= new JLabel("Nom");
            nomLabel.setFont(new Font("Arial", Font.BOLD, 20));
            content.add(nomLabel);
            nomField = new JTextField();
            nomField.setFont(new Font("Arial",Font.PLAIN, 20));
            content.add(nomField);

            JLabel prenomLabel= new JLabel("Prénom");
            prenomLabel.setFont(new Font("Arial", Font.BOLD, 20));
            content.add(prenomLabel);
            prenomField = new JTextField();
            prenomField.setFont(new Font("Arial",Font.PLAIN, 20));
            content.add(prenomField);

            JLabel telLabel= new JLabel("Téléphone");
            telLabel.setFont(new Font("Arial", Font.BOLD, 20));
            content.add(telLabel);
            telField = new JTextField();
            telField.setFont(new Font("Arial",Font.PLAIN, 20));
            content.add(telField);

            JLabel emailLabel= new JLabel("Email");
            emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
            content.add(emailLabel);
            emailField = new JTextField();
            emailField.setFont(new Font("Arial",Font.PLAIN, 20));
            content.add(emailField);

            JLabel adresseLabel= new JLabel("Adresse");
            adresseLabel.setFont(new Font("Arial", Font.BOLD, 20));
            content.add(adresseLabel);
            adresseField = new JTextField();
            adresseField.setFont(new Font("Arial",Font.PLAIN, 20));
            content.add(adresseField);

            JLabel loginLabel= new JLabel("Login");
            loginLabel.setFont(new Font("Arial", Font.BOLD, 20));
            content.add(loginLabel);
            loginField = new JTextField();
            loginField.setFont(new Font("Arial",Font.PLAIN, 20));
            content.add(loginField);

            JLabel passwordLabel= new JLabel("Password");
            passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
            content.add(passwordLabel);
            passwordField = new JPasswordField();
            passwordField.setFont(new Font("Arial",Font.BOLD, 20));
            content.add(passwordField);

          JLabel checkpasswordLabel= new JLabel("Check password");
            checkpasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
            content.add(checkpasswordLabel);
            chpasswordField = new JPasswordField();
            chpasswordField.setFont(new Font("Arial",Font.BOLD, 20));
            content.add(chpasswordField);

        }
        public void Footer(JPanel footer, GridBagConstraints c) {

            //footer.setBackground(Color.GRAY);

            c.weighty = 0.1;
            c.gridy = 2;

            getContentPane().add(footer,c);
            footer.setLayout(new FlowLayout());

            footer.setBorder(new EmptyBorder(0, 0, 0, -880));


            AnnulerBtn = new JButton("Annuler");
            AnnulerBtn.setFont(new Font("Arial", Font.BOLD, 36));
            AnnulerBtn.setBackground(Color.decode("#ABEAAB"));


            creerBtn = new JButton("Créer");
            creerBtn.setFont(new Font("Arial", Font.BOLD, 36));
            creerBtn.setBackground(Color.decode("#ABEAAB"));
           // int buttonGap = 10;
           // creerBtn.setBorder(new EmptyBorder(buttonGap, buttonGap, buttonGap, buttonGap));
            creerBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(nomField.getText() == null || prenomField.getText() == null || telField.getText() == null
                    || emailField.getText() == null || loginField.getText()==null || adresseField.getText()==null
                    || passwordField.getText()==null || chpasswordField.getText() == null){
                        JOptionPane.showMessageDialog(null, "Veuiller remplir tous les champs !!");
                    }
                    else if (!passwordField.getText().equals(chpasswordField.getText())){
                        JOptionPane.showMessageDialog(null, "le check password doit être le même que password !!");
                    }
                    else {
                        Client client = new Client();
                        client.setNom(nomField.getText());
                        client.setPrenom(prenomField.getText());
                        client.setTel(telField.getText());
                        client.setAdresse(adresseField.getText());
                        client.setEmail(emailField.getText());
                        client.setNom_utilisateur(loginField.getText());
                        client.setMot_de_passe(passwordField.getText());
                        if(lesClients.Inscription(client))
                        {
                            Abonnement abonnement = new Abonnement("Abonnement",lesClients.Connexion(client.getNom_utilisateur(),client.getMot_de_passe()));
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "le client existe déjà !!");
                        }
                    }

                    // Actions à effectuer lorsque le bouton est cliqué
                    dispose(); // Fermer la fenêtre
                }
            });
           // AnnulerBtn.setBorder(new EmptyBorder(buttonGap, buttonGap, buttonGap, buttonGap));
            AnnulerBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InterConnexion connexion = new InterConnexion("Connexion");

                    // Actions à effectuer lorsque le bouton est cliqué
                    dispose(); // Fermer la fenêtre
                }
            });
            footer.add(AnnulerBtn);
            footer.add(creerBtn);
        }

        public void Window(){

            GridBagLayout grid = new GridBagLayout();
            setLayout(grid);

            //JPanel header= new JPanel();;
            JPanel content= new JPanel();
            JPanel footer= new JPanel();

            GridBagConstraints c = new GridBagConstraints();
            c.fill =GridBagConstraints.BOTH;
            JPanel header= InterHeader.createHeaderPanel("S'inscrire",c);
            getContentPane().add(header,c);
            //this.Header(header,c);
            this.Content(content,c);
            this.Footer(footer,c);
            //pack();
            validate();
        }

        public InterInscription(String title) {
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

