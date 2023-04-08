package Lab;

public class Defender extends Player{
    private int strengthSkill;

    public int getStrengthSkill() {
        return strengthSkill;
    }

    public void setStrengthSkill(int strengthSkill) {
        if (strengthSkill>=1&&strengthSkill<=5)
            this.strengthSkill = strengthSkill;
        else {
            System.out.println("invalid skill value");
            this.strengthSkill = 1;
        }
    }

    public int overallSkill(){
        return getAttackingSkill() + getDefendingSkill() + getGoalkeepingSkill() + strengthSkill;
    }
}
