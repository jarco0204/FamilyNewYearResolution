import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FamilyGoalsPane extends JPanel {
    //Fields
    private JTextField personalGoal;
    private JTextField homeGoal;
    private JLabel lblNameOfFamily;
    private JLabel message;

    public FamilyGoalsPane(mainGUI masterFrame){
        setBackground(Color.GREEN);
        setLayout(null);

        lblNameOfFamily = new JLabel("");
        lblNameOfFamily.setFont(new Font("FreeSerif", Font.BOLD, 18));
        lblNameOfFamily.setBounds(119, 12, 204, 45);
        add(lblNameOfFamily);

        personalGoal = new JTextField();
        personalGoal.setBounds(199, 69, 200, 19);
        add(personalGoal);
        personalGoal.setColumns(10);

        homeGoal = new JTextField();
        homeGoal.setBounds(199, 141, 200, 19);
        add(homeGoal);
        homeGoal.setColumns(10);

        JLabel lblPersonalGoal = new JLabel("Personal Goal");
        lblPersonalGoal.setBackground(new Color(139, 0, 139));
        lblPersonalGoal.setBounds(28, 71, 99, 17);
        add(lblPersonalGoal);

        JLabel lblHomeGoal = new JLabel("Home Goal");
        lblHomeGoal.setBackground(new Color(255, 0, 0));
        lblHomeGoal.setBounds(28, 142, 92, 17);
        add(lblHomeGoal);

        JButton btnBack = new JButton("Back");
        btnBack.setBackground(new Color(0, 255, 255));
        btnBack.setBounds(70, 245, 114, 25);
        btnBack.addActionListener(e->{
            setVisible(false);
            masterFrame.setRoutes("Init");
        });
        add(btnBack);
        JButton saveButton= new JButton("Save");
        saveButton.setBackground(new Color(0, 255, 255));
        saveButton.setBounds(170, 245, 114, 25);
        saveButton.addActionListener(e-> {
            if(homeGoal.getText().length() ==0 || personalGoal.getText().length()==0)
            {

                message.setVisible(true);
            }
            else {
                saveData();
                }
        });
        add(saveButton);
        message = new JLabel("Write Both Goals");
        message.setBackground(Color.BLUE);
        message.setVisible(false);
        message.setBounds(120,215,150,25);
        add(message);
    }

    /**
     * Method to set the label containing the family member selected from previous pane
     */
    public void setLblNameOfFamily(String familyMember)
    {
        lblNameOfFamily.setText(familyMember);
    }
    /**
     * Method to set whether or nor the user can edit or see goals
     */
    public void setStateTextLabels(boolean verdad)
    {
        personalGoal.setEditable(verdad);
        homeGoal.setEditable(verdad);
    }
    /**
     * Method to set the personal goal of the family member
     */
    public void setPersonalGoal(String personalG)
    {
        personalGoal.setText(personalG);
    }
    /**
     * Method to set the home goal of the family member
     */
    public void setHomeGoal(String homeG)
    {
        homeGoal.setText(homeG);
    }
    /**
     * Function to save the input data into a text file
     */
    private void saveData()
    {
        String fileName = "savedDataFinal.txt";// . is for current directory
        File file = new File(fileName);
        SaveManager save = new SaveManager(fileName,true);
        try {
            save.writeToFile(lblNameOfFamily.getText() +":"+personalGoal.getText()+":"+homeGoal.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
