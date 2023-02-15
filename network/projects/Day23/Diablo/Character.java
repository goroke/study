package Diablo;

public abstract class Character {
    protected int hp, mp;
    // ...

    WeaponBehavior weapon;  // Association (◇ Aggregation)

    public void info(){
        System.out.println("HP: " + this.hp + "MP: " + this.mp);
    };

    public WeaponBehavior getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public final void performWeapon(){
        try {
            weapon.useWeapon();
        }
        catch (NullPointerException e){
            System.out.println("무기가 없다");
        }
    }
}
