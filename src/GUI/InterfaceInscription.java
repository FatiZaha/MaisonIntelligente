package GUI;
import java.awt.*;
import javax.swing.*;


    public class InterfaceInscription extends JFrame {

        public void Header(JPanel header, GridBagConstraints c) {

            c.fill = GridBagConstraints.BOTH;
            c.weightx = 1;
            c.weighty = 0.2;
            c.gridy = 0;

            header.setBackground(Color.ORANGE);
            getContentPane().add(header, c);
        }
        public void Content(JPanel content, GridBagConstraints c) {

            c.weighty = 0.6;
            c.gridy = 1;
            getContentPane().add(content, c);


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

        }
        public void Footer(JPanel footer, GridBagConstraints c) {

            footer.setBackground(Color.GRAY);
            c.weighty = 0.2;
            c.gridy = 2;
            getContentPane().add(footer, c);
        }

            public void Window(){

                GridBagLayout grid = new GridBagLayout();
                setLayout(grid);

                JPanel header= new JPanel();;
                JPanel content= new JPanel();
                JPanel footer= new JPanel();

                GridBagConstraints c = new GridBagConstraints();
                this.Header(header,c);
                this.Content(content,c);
                this.Footer(footer,c);
                pack();
                validate();
            }

            public InterfaceInscription(String title) {
                setTitle(title);


                this.Window();
                setVisible(true);
                setSize(500, 500);
                setLocationRelativeTo(null);
            }
            }

