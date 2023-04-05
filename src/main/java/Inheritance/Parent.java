package Inheritance;

public class Parent extends FamilyMember{
    String which;
    public Parent(int age, String name, String race,String which) {
        super(age, name, race);
        this.which = which;
    }
    @Override
    public void display(){
        System.out.println("Age: " + age + " name: " + name + " race: " + race + " which parent: " + which);
    }

    public static void main(String[] args) {
        FamilyMember baba = new Parent(48,"Tonguc","Brown","Baba");
        baba.display();
        FamilyMember anne = new FamilyMember(47,"Gonca","White");
        anne.display();
    }
}
