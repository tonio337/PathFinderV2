package com.rpgfoundation.Secondary.Modify;

import com.rpgfoundation.Secondary.Spell;

/**
 * Created by Brandon on 1/5/2017.
 */
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

    public Mechanic getEffect() {
        return effect;
    }
    public TargetType getType() {
        return type;
    }
}
