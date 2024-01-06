package GUI;
import java.awt.*;
import javax.swing.*;

public class InterfaceInscription extends JFrame {

    public InterfaceInscription() {
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

        // Ajout des éléments à l'interface d'inscription
        content.setLayout(new GridLayout(7, 2));

        content.add(new JLabel("Nom:"));
        JTextField nomField = new JTextField();
        content.add(nomField);

        content.add(new JLabel("Prénom:"));
        JTextField prenomField = new JTextField();
        content.add(prenomField);

        content.add(new JLabel("Téléphone:"));
        JTextField telephoneField = new JTextField();
        content.add(telephoneField);

        content.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        content.add(emailField);

        content.add(new JLabel("Adresse:"));
        JTextField adresseField = new JTextField();
        content.add(adresseField);

        content.add(new JLabel("Login:"));
        JTextField loginField = new JTextField();
        content.add(loginField);

        content.add(new JLabel("Mot de passe:"));
        JPasswordField passwordField = new JPasswordField();
        content.add(passwordField);

        pack();
        validate();

        setTitle("Maison Intelligente");
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }
}