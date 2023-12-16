package GUI;

import java.awt.*;

import javax.swing.*;

public class InterfaceConnexion extends JFrame {


    public void Header(JPanel header, GridBagConstraints c){
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0.2;
        c.gridy = 0;

        header.setBackground(Color.ORANGE);
        getContentPane().add(header,c);
    }
    public void Content(JPanel content, GridBagConstraints c){

        c.weighty = 0.6;
        c.gridy = 1;
        getContentPane().add(content,c);
    }
    public void Footer(JPanel footer, GridBagConstraints c){
        footer.setBackground(Color.GRAY);
        c.weighty = 0.2;
        c.gridy = 2;
        getContentPane().add(footer,c);
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
    public InterfaceConnexion(String title) {
        setTitle(title);


        this.Window();
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }
}
