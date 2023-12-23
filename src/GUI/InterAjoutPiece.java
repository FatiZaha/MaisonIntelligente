package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InterAjoutPiece extends JFrame {

    public JTextField searchField;

    public JTextField nameField;

    public JPanel InsertionInfoMaison(){
        JPanel content =new JPanel(new GridLayout(2,1,0,40));


        // Create the nested panels with GridBagLayout for each column
        JPanel row1 = new JPanel(new BorderLayout());
        JPanel row2 = new JPanel(new BorderLayout());

        // Create constraints for the GridBagLayout



        // Add the nested panels to the content panel

        content.setBorder(new EmptyBorder(0, 0, 160, 0));

        JLabel nameLabel= new JLabel("Nom");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        row1.add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial",Font.PLAIN, 24));
        nameField.setPreferredSize(new Dimension(350, 40));

        row2.add(nameField);
        row2.setBorder(new EmptyBorder(0, 40, 0, 0));
        content.add(row1,0);
        content.add(row2,1);
        return content;
    }

    public void Theme(JPanel content){
        JPanel gridPanel = new JPanel(new GridLayout(0, 4, 10, 10)); // 3 columns, 10 pixels horizontal and vertical gap

        // Create and add elements to the grid
        for (int i = 1; i <= 18; i++) {
            JButton button = new JButton("Button " + i);
            gridPanel.add(button);
            button.setPreferredSize(new Dimension(50, 150));
        }



        // Add the grigPanel area to a JScrollPane with a vertical scrollbar
        JScrollPane scrollPane = new JScrollPane(gridPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setViewportView(gridPanel);
        // Create a vertical scrollbar
        //JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(800, 320));
        JPanel global=new JPanel(new GridLayout(2,1,0,-120));
        JLabel titre=new JLabel("Thèmes");
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        global.add(titre,0);
        global.add(scrollPane,1);
        global.setBorder(new EmptyBorder(0,200,50,0));
        content.add(global);
    }
    public void Content(JPanel content, GridBagConstraints c){

        c.weighty = 1;
        c.gridy = 1;

        content.setLayout(new FlowLayout(2));
        content.setBorder(new EmptyBorder(0, 20, 50, 20));

        JPanel infoPane=this.InsertionInfoMaison();
        content.add(infoPane);
        this.Theme(content);
        // Add components to the content panel
        //content.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(content, c);
    }
    public void Footer(JPanel footer, GridBagConstraints c){
        //footer.setBackground(Color.GRAY);

        c.weighty = 0;
        c.gridy = 2;
        getContentPane().add(footer,c);
        footer.setLayout(new FlowLayout(1, 50, FlowLayout.CENTER));

        footer.setBorder(new EmptyBorder(30, 0, 30, -880));

        JButton annulerBtn = new JButton("Annuler");
        annulerBtn.setFont(new Font("Arial", Font.BOLD, 36));
        annulerBtn.setBackground(Color.decode("#ABEAAB"));

        JButton ajouterBtn = new JButton("Ajouter");
        ajouterBtn.setFont(new Font("Arial", Font.BOLD, 36));
        ajouterBtn.setBackground(Color.decode("#ABEAAB"));

        //int buttonGap = 10;
        annulerBtn.setBorder(new EmptyBorder(2, 30, 2, 30));

        ajouterBtn.setBorder(new EmptyBorder(2, 30, 2, 30));

        footer.add(annulerBtn);
        footer.add(ajouterBtn);

    }
    public void Window(){
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel header= InterHeader.createHeaderPanel("Ajouter Chambre",c);
        getContentPane().add(header,c);
        JPanel content= new JPanel();
        JPanel footer= new JPanel();


        this.Content(content,c);
        this.Footer(footer,c);
        //pack();
        validate();
    }

    public InterAjoutPiece(String title){
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
