import Diablo.*;  // 이렇게 해도 되긴 하지만 실무에서는 하나하나 import 한다.

import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Sorceress s1 = new Sorceress();
        Barbarian b1 = new Barbarian();
        Bow windForce = new Bow();
        s1.setWeapon(windForce);
        s1.performWeapon();
        b1.setWeapon(()-> System.out.println("뿡뿡"));

        b1.performWeapon();
    }
}
