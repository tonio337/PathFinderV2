package com.rpgfoundation.Secondary;

import com.rpgfoundation.Character.Person;
import com.rpgfoundation.Secondary.Modify.SpellEffect;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Brandon on 1/5/2017.
 */

@XmlRootElement
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

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
    @XmlElement
    public void setDuration(int duration) {
        this.duration = duration;
    }
    @XmlElement
    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }
    @XmlElement
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

    public void readFile(File files)
    {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(SpellHolder.class);
            Unmarshaller breakdown = jaxbContext.createUnmarshaller();
            Spell paladinSpell = (Spell) breakdown.unmarshal(files);
            System.out.println(paladinSpell.getDescription());

        }catch(JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
class SpellHolder{
    private List<Spell> spellList;

    @XmlElement
    public List<Spell> getSpellList(){
        return spellList;
    }
}