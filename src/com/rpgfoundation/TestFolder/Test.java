package com.rpgfoundation.TestFolder;

import com.rpgfoundation.Secondary.Modify.SpellEffect;
import com.rpgfoundation.Secondary.Spell;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by Brandon on 1/5/2017.
 */

public class Test {

    public void main(String[] args){
        Spell testingSpell = new Spell();
        testingSpell.setName("Judgement");
        testingSpell.setManaCost(15);
        testingSpell.setCoolDown(1);
        testingSpell.setDamageModifier(5);
        testingSpell.setEffect(SpellEffect.Mechanic.DAMAGE);
        testingSpell.setType(SpellEffect.TargetType.ENEMYPARTY);

        try{
            File testFile = new File("C:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Spell.class);
            Marshaller jabMarshaller = jaxbContext.createMarshaller();
        }catch(JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
