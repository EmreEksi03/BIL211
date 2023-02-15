package Lab;

public class Attacker extends Player{
    private int shootingSkill;

    public int getShootingSkill() {
        return shootingSkill;
    }

    public void setShootingSkill(int shootingSkill) {
        if (shootingSkill>=1&&shootingSkill<=5)
            this.shootingSkill = shootingSkill;
        else {
            System.out.println("invalid skill value");
            this.shootingSkill = 1;
        }
    }
    public int overallSkill(){
        return getAttackingSkill() + getDefendingSkill() + getGoalkeepingSkill() + shootingSkill;
    };
}
