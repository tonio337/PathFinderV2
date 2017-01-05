package com.rpgfoundation.Gear;

import com.rpgfoundation.Secondary.Attribute;

/**
 * Created by Brandon on 1/1/2017.
 */
public class Armor{
    private String name;
    private int armor;

    private Attribute attribute;

    public Armor(String name, int armor, Attribute attribute) {
        this.name = name;
        this.armor = armor;
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }
    public int getArmor() {
        return armor;
    }
    public Attribute getAttribute() {
        return attribute;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
}
