package com.rpgfoundation.Control;

import com.rpgfoundation.Character.Person;
import com.rpgfoundation.Secondary.Modify.SpellHolder;
import com.rpgfoundation.Secondary.Spell;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Brandon on 1/2/2017.
 */
public class IO {

    public static int inputInt()
    {
        Scanner input = new Scanner(System.in);
        int choice;
        
        while (true) {
            try{
                choice = input.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Choose again but with a integer!!!!");
                continue;
            }
            return choice;
        }
    }

    public static void printHeader(String s) {
        System.out.println("\n******************************\n" +
                s +
                "\n******************************");

    }
    public static void printHeaderName(String s) {
        System.out.println("\n************************************************\n" +
                s +
                "\n************************************************");

    }

    public static Person findTarget() {

        IO.printHeader("Character List");
        for(int i = 0; i < BattleEngine.characterList.size(); i++)
        {
            System.out.println(i + 1 + ". " + BattleEngine.characterList.get(i).getName() + " = " +
                    BattleEngine.characterList.get(i).getTeam() + " - " +
                    BattleEngine.characterList.get(i).getStatus());
        }

        System.out.println("Choose a target: ");
        int value = IO.inputInt();
        if(value-1 < BattleEngine.characterList.size()+1 && value > 0) {
            if(BattleEngine.characterList.get(value - 1).getStatus() == Person.PersonStatus.DEAD ||
                    BattleEngine.characterList.get(value - 1).getStatus() == Person.PersonStatus.FLEE)
            {
                System.out.println("Target can't be attack.");
                return findTarget();
            }
            return BattleEngine.characterList.get(value-1);
        }
        else {
            System.out.println("Please choose within the limits!");
            return findTarget();
        }
    }

    public static void actionChoice(Person player) {
        nameHeader(player);
        System.out.println("1. Attack");
        System.out.println("2. Spell");
        System.out.println("3. Gear");
        System.out.println("4. Run");
        System.out.println("Choose your move: ");

        switch (IO.inputInt())
        {
            case 1:                     //Will call the normal attack function
                //player.attack(findTarget());
                break;
            case 2:                     //Will call the spell attack function base off the jobType.
                player.getJobType().spell(player);
                break;
            case 3:                     //Gear System later on
                break;
            case 4:                     //Run function
                run(player);
                break;
            default:
                System.out.println("Please choose within the limit of 1-4 ");
                actionChoice(player);          //Continuous loop if the right press is not correct.
        }
    }

    public static void spellCall(Person player)
    {
        IO.printHeader(player.getSpecialty() + " Moves Set");
        for(int i = 0; i < player.getSpell().size(); i++)
        {
            System.out.println(i+1 + ". " + player.getSpell().get(i).getName());
        }

        player.getSpell().get(inputInt()-1).cast(player,findTarget());
    }
    public static void nameHeader(Person player)
    {
        IO.printHeaderName(player.getName() + " - " + player.getSpecialty() +
                " - (HEALTH: " + player.getCurrent_Health() + "/" + player.getHealth() +
                " | " + player.getResourceType() + ": " + player.getCurrent_Resource() +
                "/" + player.getResource() + ")");
    }


    public static void damageReport(Person player, Person target, int damage)
    {
        System.out.println(target.getName() + " Health Pool is: " + target.getHealth());
        if(player.getName() == target.getName())
        {
            System.out.println(player.getName() + " attack themselves out of confusion for: " +
                    damage + " physical damage.");
        }
        else if(player.getTeam() == target.getTeam())
        {
            System.out.println(player.getName() + " has attack their teammate for: " + damage + " physical damage.");
        }
        else{System.out.println(player.getName() + " is attacking "  + target.getName() + " for " +
                damage + " physical damage.");}

        if(player.getSpecialty() == Person.ClassRole.WARRIOR)
        {
            player.setResource(player.getCurrent_Resource()+5);
        }
        if(target.getCurrent_Health() <= 0)
        {
            deathSetter(target);
        }
        else System.out.println(target.getName() + " remaining health is: " + target.getCurrent_Health());
    }

    public static void deathSetter(Person target)
    {
        System.out.println(target.getName() + " has died");
        target.setStatus(Person.PersonStatus.DEAD);
    }

    public static void run(Person player) {
        System.out.println(player.getName() + " has flee");
        player.setStatus(Person.PersonStatus.FLEE);
    }


    public static ArrayList<Spell> readFile(File files,ArrayList<Spell> mainList)
    {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SpellHolder.class);
            Unmarshaller breakdown = jaxbContext.createUnmarshaller();
            SpellHolder spellListHolder = (SpellHolder) breakdown.unmarshal(files);
            for (Spell spe : spellListHolder.getSpellSet())
                mainList.add(spe);
            return mainList;
        }catch(JAXBException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static void createFile(Object set)
    {
        try{
            File testFile = new File("src/input.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(SpellHolder.class);
            Marshaller jabMarshaller = jaxbContext.createMarshaller();

            jabMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jabMarshaller.marshal(set, testFile);
            jabMarshaller.marshal(set,System.out);
        }catch(JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
