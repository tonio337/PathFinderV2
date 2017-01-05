package com.rpgfoundation;

import com.rpgfoundation.Character.Human;
import com.rpgfoundation.Character.Person;
import com.rpgfoundation.Control.BattleEngine;
import com.rpgfoundation.Control.IO;
import com.rpgfoundation.Gear.Weapon;
import com.rpgfoundation.JobType.Paladin;
import com.rpgfoundation.Secondary.Attribute;


public class Main {

    public static void main(String[] args)
    {
        game();

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
        Weapon testWep = new Weapon(2,5,2.6, new Attribute(0,0,0,0,0,0));       //Test Weapon
        int npcGenerate = 2; //(int)(Math.random()*10)+2;                       //From the range of 2-12 since it can randomly only do 1 character at a time.
        Person[] characterNumber = new Person[npcGenerate];               //Creating an object array using the Character class.

        for(int i = 0; i < npcGenerate; i++)
        {
            characterNumber[i] = new Human("NPC " + i+1, 1,testWep, Person.Side.getRandomSide(), Person.ClassRole.getRandomRole());
        }
    }
}
