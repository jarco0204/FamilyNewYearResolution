import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class makes the code follow the GRASP principles by lowering the coupling and making the GUI components separated from
 * the logic.
 */

public class FamilyMembersPane extends JPanel {

    //Fields
    private JButton btnManuel,btnPaola,btnJulian,btnJohan,btnManolo;
    private String userClicked;
    private mainGUI masFrame;

    public FamilyMembersPane(mainGUI masterFrame){
        setBounds(0,0,450,300);
        masFrame=masterFrame;
        setBackground(Color.ORANGE);
        setLayout(null);

        btnManuel = new JButton("Manuel");
        btnManuel.setBounds(85, 79, 114, 25);
        btnManuel.addActionListener(this::actionPerformed);

        add(btnManuel);

        btnPaola = new JButton("Paola");
        btnPaola.setBounds(248, 79, 114, 25);
        btnPaola.addActionListener(this::actionPerformed);
        add(btnPaola);

        btnJulian = new JButton("Julian");
        btnJulian.setBounds(175, 116, 114, 25);
        btnJulian.addActionListener(this::actionPerformed);
        add(btnJulian);

        btnJohan = new JButton("Johan");
        btnJohan.setBounds(85, 153, 114, 25);
        btnJohan.addActionListener(this::actionPerformed);
        add(btnJohan);

        btnManolo = new JButton("Manolo");
        btnManolo.setBounds(284, 153, 114, 25);
        btnManolo.addActionListener(this::actionPerformed);
        add(btnManolo);

        JLabel lblSelectFamilyMember = new JLabel("Select Member To Add/See Goals");
        lblSelectFamilyMember.setBounds(80, 33, 270, 41);
        add(lblSelectFamilyMember);
        setVisible(true);
    }

    /**
     * Function to return the name of the family member to use for GoalsPane
     * @return String familyMember
     */
    public String getUserClicked() {
        return userClicked;
    }

    //@Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == btnJohan)
        {
            userClicked= btnJohan.getText();


        }
        else if(actionEvent.getSource() == btnJulian)
        {
            userClicked= btnJulian.getText();
        }
        else if(actionEvent.getSource() == btnManolo)
        {
            userClicked= btnManolo.getText();
        }
        else if(actionEvent.getSource() == btnManuel)
        {
            userClicked= btnManuel.getText();
        }
        else if(actionEvent.getSource() == btnPaola)
        {
            userClicked= btnPaola.getText();
        }
        masFrame.setRoutes("Goals");
    }
}
