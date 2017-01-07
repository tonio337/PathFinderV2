package com.rpgfoundation.Secondary.Modify;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;
import com.rpgfoundation.Secondary.Spell;

/**
 * Created by Brandon on 1/6/2017.
 */
@XmlRootElement(name = "Spells")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpellHolder {

        @XmlElement(name = "Spell")
        private List<Spell> spellSet;
        public List<Spell> getSpellSet(){
            return spellSet;
        }
        public void setSpellSet(List<Spell> set)
        {
            this.spellSet = set;
        }
}
