package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class InterfaceInscription extends JFrame {
    JTextField nomField;
    JTextField prenomField;
    JTextField telField;
    JTextField emailField;
    JTextField adresseField;
    JTextField loginField;
    JTextField passwordField;

        public void Header(JPanel header, GridBagConstraints c) {

            c.fill = GridBagConstraints.BOTH;
            c.weightx = 1;
            c.weighty = 0.2;
            c.gridy = 0;
            String imagePath = "..\\MaisonIntelligente\\src\\GUI\\images\\logo2.png";
            int desiredWidth = 151;
            int desiredHeight = 65;


            ImageIcon img = new ImageIcon(imagePath);
            Image image = img.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledImg = new ImageIcon(image);

            FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
            header.setLayout(flowLayout);
            header.setBorder(new EmptyBorder(5, 0, 5, 0));
            JLabel logo = new JLabel(scaledImg);
            header.add(logo);
            JLabel pagename= new JLabel("S'inscrire");
            pagename.setFont(new Font("Arial", Font.BOLD, 25));
            pagename.setBorder(new EmptyBorder(0, 50, 0, 0));
            header.add(pagename);

            header.setBackground(Color.decode("#EFFA76"));
            getContentPane().add(header,c);
        }
        public void Content(JPanel content, GridBagConstraints c) {

            c.weighty = 0.6;
            c.gridy = 1;
            int hgap=20;
            int vgap=10;
            getContentPane().add(content, c);

            content.setLayout(new GridLayout(7, 2,hgap,vgap));
            content.setBorder(new EmptyBorder(0, 100, 0, 100));

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
            passwordField = new JTextField();
            passwordField.setFont(new Font("Arial",Font.PLAIN, 20));
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
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setResizable(false);
                setLocationRelativeTo(null);
            }
            }

