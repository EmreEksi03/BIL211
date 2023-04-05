package Inheritance;

public class FamilyMember extends Person{
    public FamilyMember(int age, String name, String race) {
        this.age = age;
        this.name = name;
        this.race = race;
    }

    public void display(){
        System.out.println("Age: " + age + " name: " + name + " race: " + race);
    }

    public static void main(String[] args) {
        FamilyMember emre = new FamilyMember(19,"Emre","Brown");
        emre.display();
    }
}
