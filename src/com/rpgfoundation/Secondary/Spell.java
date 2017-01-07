package com.rpgfoundation.Secondary;

import com.rpgfoundation.Character.Person;
import com.rpgfoundation.Secondary.Modify.SpellEffect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Brandon on 1/5/2017.
 */

@XmlRootElement(name = "Spell")
@XmlAccessorType(XmlAccessType.FIELD)
public class Spell extends SpellEffect{

    private String name;
    private String description;
    private int manaCost;
    private int duration;
    private int coolDown;
    private int damageModifier;

    public Spell(Mechanic effect, TargetType type, String name, String description, int manaCost,
                 int duration, int coolDown, int damageModifier) {
        super(effect, type);
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.duration = duration;
        this.coolDown = coolDown;
        this.damageModifier = damageModifier;
    }

    public Spell()
    {

    }

    @Override
    public String toString() {
        return name;
    }
    public String getName() {
        return name;
    }
    public int getManaCost() {
        return manaCost;
    }
    public int getDuration() {
        return duration;
    }
    public int getCoolDown() {
        return coolDown;
    }
    public int getDamageModifier(){
        return damageModifier;
    }
    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }
    public void setDamageModifier(int damageModifier){
        this.damageModifier = damageModifier;
    }


    public void cast(Person caster, Person target)
    {
        caster.setCurrent_Resource(caster.getCurrent_Resource() - getManaCost());
        applySpell(caster, target);
    }

    public void applySpell(Person caster, Person target)
    {
        switch(getEffect())
        {
            case DAMAGE:
                break;
            case HEAL:
                break;
            case CURSE:
                break;
            case BURN:
                break;
            case SLEEP:
                break;
            case STUN:
                target.setStatus(Person.PersonStatus.STUN);
                break;
            case INCREASESTATS:
                break;
            case DECREASESTATS:
                break;
            default:
        }
    }
}
