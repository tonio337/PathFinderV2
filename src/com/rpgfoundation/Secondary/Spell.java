package com.rpgfoundation.Secondary;

import com.rpgfoundation.Character.Person;
import com.rpgfoundation.Secondary.Modify.SpellEffect;

/**
 * Created by Brandon on 1/5/2017.
 */
public class Spell extends SpellEffect {

    private String name;
    private int manaCost;
    private int duration;
    private int coolDown;
    private int damageModifier;

    public Spell(Mechanic effect, TargetType type, String name, int manaCost, int duration, int coolDown, int damageModifier) {
        super(effect, type);
        this.name = name;
        this.manaCost = manaCost;
        this.duration = duration;
        this.coolDown = coolDown;
        this.damageModifier = damageModifier;
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
        ApplySpell(caster, target);
    }

    public void ApplySpell(Person caster, Person target)
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
