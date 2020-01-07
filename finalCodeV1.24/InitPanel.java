import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class InitPanel extends JPanel {
    //Fields
    private String[] familyMembers={"JOHAN","PAOLA","MANUEL","MANOLO","JULIAN"};
    private String userLogIn;
    private mainGUI masterGUI;
    private JTextField textField;
    private JLabel accessDenied;


    public InitPanel(mainGUI masterFrame){
        masterGUI = masterFrame;
        setBackground(Color.CYAN);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);
        setBounds(0,0,450,300);

        textField = new JTextField();
        textField.setBackground(Color.LIGHT_GRAY);
        textField.setBounds(155, 120, 124, 19);
        add(textField);
        textField.setColumns(10);

        JLabel lblEnterNameTo = new JLabel("Enter Name To Continue");
        lblEnterNameTo.setBounds(130, 78, 191, 42);
        add(lblEnterNameTo);

        accessDenied= new JLabel("Not A Family Member");
        accessDenied.setBackground(Color.RED);
        accessDenied.setVisible(false);
        accessDenied.setBounds(130,190,190,19);

        add(accessDenied);

        Button button = new Button("Continue");
        button.setBackground(Color.YELLOW);
        button.setBounds(166, 165, 86, 23);
        button.addActionListener(this::actionPerformed);


        add(button);

        JLabel lblArcosMendezNew = new JLabel("Arcos Mendez New Year's Resolution");
        lblArcosMendezNew.setFont(new Font("Dyuthi", Font.BOLD | Font.ITALIC, 24));
        lblArcosMendezNew.setBounds(31, 0, 419, 108);
        add(lblArcosMendezNew);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(Arrays.asList(familyMembers).contains(textField.getText().toUpperCase()))
        {
            userLogIn = textField.getText();
            masterGUI.setRoutes("Init");


        }
        else
        {
            accessDenied.setVisible(true);
        }

    }

    public String getUserLogIn() {
        return userLogIn;
    }
}
