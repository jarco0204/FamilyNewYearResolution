import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class mainGUI extends JFrame {

    /**
     * Main function that runs the program
     * @param args
     */
    public static void main(String[] args)
    {
        mainGUI objectRun = new mainGUI();
    }

    //Fields
    public JPanel[] routes= {new InitPanel(this),new FamilyMembersPane(this),new FamilyGoalsPane(this)};
    //########################
    private InitPanel initPan;
    private FamilyMembersPane familyMemberPan;
    private FamilyGoalsPane familyGoals;
    private JPanel masterPanel;
    private CardLayout pleaseWork;
    private String userLogIn;
    private HashMap<String,String> dictFamily;
   // private FamilyMember[] familyMembs;

    /**
     * Constructor of class
     */
    public mainGUI()
    {
       // familyMembs= new FamilyMember[4];
        dictFamily= new HashMap<>();
        initPan = (InitPanel) routes[0];
        familyMemberPan= (FamilyMembersPane) routes[1];
        familyGoals= (FamilyGoalsPane)  routes[2];


        masterPanel= new JPanel();
        pleaseWork= new CardLayout();

        masterPanel.setLayout(pleaseWork);

        masterPanel.add(initPan, "initial");
        masterPanel.add(familyMemberPan,"members");
        masterPanel.add(familyGoals,"goals");

        pleaseWork.show(masterPanel,"initial");





        //Methods related to JFrame
        setTitle("Arcos Mendez Family 2020 Objectives");
        setLocationRelativeTo(null); // making it appear in the middle
        setResizable(false);
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); //maybe error is here
        setContentPane(masterPanel);
        setVisible(true);
        loadSavedFile();
    }
    /**
     * This function is public and sets the JPanel to display depending on the action
     */
    public void setRoutes(String route)
    {
       //Special Note: Using the switch statement gave me several issues
       if(route.equals("Init"))
       {
           pleaseWork.show(masterPanel,"members");

           userLogIn = initPan.getUserLogIn();
           System.out.println(userLogIn);

       }
       else
       {
           familyGoals.setLblNameOfFamily(familyMemberPan.getUserClicked());
           try {
               String dataUse = dictFamily.get(familyMemberPan.getUserClicked());
               String[] goals = dataUse.split(":");
               familyGoals.setHomeGoal(goals[1]);
               familyGoals.setPersonalGoal(goals[0]);
           }
           catch(NullPointerException e1)
           {
               familyGoals.setHomeGoal("");
               familyGoals.setPersonalGoal("");
               System.out.println("No data");
           }

           if(userLogIn.toUpperCase().equals(familyMemberPan.getUserClicked().toUpperCase()))
           {
               familyGoals.setStateTextLabels(true);
           }
           else
           {
               familyGoals.setStateTextLabels(false);
           }
           pleaseWork.show(masterPanel,"goals");
       }
    }
    /**
     * Function to return the name of the Family member that has logged in
     */
    public String getUserLogIn() {
        return userLogIn;
    }
    /**
     * Function to load and save the data read from a file about family members
     */
    private void loadSavedFile()
    {
        File file = new File("savedDataFinal.txt");
        try {
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();


            while(!line.equals(""))
            {


                String[] inputData= line.split(":",2); // item 0 will contain the name, item 1 will contain both goals
                System.out.println(Arrays.toString(inputData));
                dictFamily.put(inputData[0],inputData[1]);

                //int numberArray = 0;
                //familyMembs[numberArray]= new FamilyMember(inputData[0],inputData[1],inputData[2]);

                if (sc.hasNextLine())
                {
                    //numberArray++;
                    line = sc.nextLine();}
                else
                    break;
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
