package com.rpgfoundation.Secondary.Modify;

import com.rpgfoundation.Secondary.Spell;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Brandon on 1/5/2017.
 */
@XmlRootElement
public class SpellEffect {
    public enum Mechanic{
        DAMAGE, HEAL, CURSE, BURN, SLEEP, STUN, INCREASESTATS, DECREASESTATS,
    }

    public enum TargetType{
        SELF,PARTY,ENEMYPARTY,TARGET;
    }

    protected Mechanic effect;
    protected TargetType type;

    public SpellEffect(Mechanic effect, TargetType type) {
        this.effect = effect;
        this.type = type;
    }
    public SpellEffect(){

    }

    @XmlAttribute
    public Mechanic getEffect() {
        return effect;
    }
    @XmlAttribute
    public TargetType getType() {
        return type;
    }

    public void setEffect(Mechanic effect) {
        this.effect = effect;
    }

    public void setType(TargetType type) {
        this.type = type;
    }
}
