package com.rpgfoundation;

import com.rpgfoundation.Character.Human;
import com.rpgfoundation.Character.Person;
import com.rpgfoundation.Control.BattleEngine;
import com.rpgfoundation.Control.IO;
import com.rpgfoundation.Gear.Weapon;
import com.rpgfoundation.JobType.Paladin;
import com.rpgfoundation.Secondary.Attribute;
import com.rpgfoundation.Secondary.Modify.SpellEffect;
import com.rpgfoundation.Secondary.Spell;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Main {

    public static void main(String[] args)
    {
        Spell testingSpell = new Spell();
        testingSpell.setName("Judgement");
        testingSpell.setManaCost(15);
        testingSpell.setCoolDown(1);
        testingSpell.setDamageModifier(5);
        testingSpell.setEffect(SpellEffect.Mechanic.DAMAGE);
        testingSpell.setType(SpellEffect.TargetType.ENEMYPARTY);

        try{
            File testFile = new File("C:\\users\\brandon\\desktop\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Spell.class);
            //Marshaller jabMarshaller = jaxbContext.createMarshaller();

            //jabMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Unmarshaller breakdown = jaxbContext.createUnmarshaller();

            Spell paladinSpell = (Spell) breakdown.unmarshal(testFile);
            System.out.println(paladinSpell.getDescription());
            //jabMarshaller.marshal(testingSpell, testFile);
            //jabMarshaller.marshal(testingSpell, System.out);

        }catch(JAXBException e)
        {
            e.printStackTrace();
        }
        //game();

    }

    public static void game()
    {
        createPlayer();
        do {
            BattleEngine.descendingOrder();
            BattleEngine.characterTurn();
        }while(BattleEngine.checker() != false);

    }

    public static void createPlayer()   //Generating random character for testing purpose
    {
        Weapon testWep = new Weapon(2,5,2.6, new Attribute(0,0,0,0,0,0));
        //Test Weapon
        int npcGenerate = 2; //(int)(Math.random()*10)+2;
        // From the range of 2-12 since it can randomly only do 1 character at a time.
        Person[] characterNumber = new Person[npcGenerate];
        //Creating an object array using the Character class.

        for(int i = 0; i < npcGenerate; i++)
        {
            characterNumber[i] = new Human("NPC " + i+1, 1,testWep, Person.Side.getRandomSide(),
                    Person.ClassRole.getRandomRole());
        }
    }
}
