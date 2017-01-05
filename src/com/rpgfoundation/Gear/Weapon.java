package com.rpgfoundation.Gear;

import com.rpgfoundation.Secondary.Attribute;

/**
 * Created by Brandon on 1/1/2017.
 */
public class Weapon {
    private double weaponSpeed;
    private double weaponMin;
    private double weaponMax;

    private Attribute attribute;

    public Weapon(double weaponSpeed, double weaponMin, double weaponMax, Attribute attribute) {
        this.weaponSpeed = weaponSpeed;
        this.weaponMin = weaponMin;
        this.weaponMax = weaponMax;
        this.attribute = attribute;
    }

    public double getWeaponSpeed() {
        return weaponSpeed;
    }
    public double getWeaponMin() {
        return weaponMin;
    }
    public double getWeaponMax() {
        return weaponMax;
    }
    public Attribute getAttribute() {
        return attribute;
    }

    public void setWeaponSpeed(double weaponSpeed) {
        this.weaponSpeed = weaponSpeed;
    }
    public void setWeaponMin(double weaponMin) {
        this.weaponMin = weaponMin;
    }
    public void setWeaponMax(double weaponMax) {
        this.weaponMax = weaponMax;
    }
}
