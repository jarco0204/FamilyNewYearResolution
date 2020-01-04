public class FamilyMember {
    //Fields
    private String name;
    private String personalGoal;
    private String homeGoal;

    public FamilyMember(String name, String personal, String home)
    {
        this.name= name;
        personalGoal= personal;
        homeGoal=home;
    }
    //Methods


    public String getName() {
        return name;
    }

    public String getHomeGoal() {
        return homeGoal;
    }

    public String getPersonalGoal() {
        return personalGoal;
    }

    public void setHomeGoal(String homeGoal) {
        this.homeGoal = homeGoal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalGoal(String personalGoal) {
        this.personalGoal = personalGoal;
    }
}
