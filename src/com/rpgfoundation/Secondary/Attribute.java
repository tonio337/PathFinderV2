package com.rpgfoundation.Secondary;

/**
 * Created by Brandon on 1/1/2017.
 */
public class Attribute {
    private int strength;
    private int intellect;
    private int dexterity;
    private int constitution;
    private int resistance;
    private int wisdom;

    public Attribute(int strength, int intellect, int dexterity, int constitution, int resistance, int wisdom) {
        this.strength = strength;
        this.intellect = intellect;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.resistance = resistance;
        this.wisdom = wisdom;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getResistance() {
        return resistance;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
}
