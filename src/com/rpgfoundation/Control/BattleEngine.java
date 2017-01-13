package com.rpgfoundation.Control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.rpgfoundation.Character.Person;
import com.rpgfoundation.Secondary.Spell;

/**
 * Created by Brandon on 1/2/2017.
 */
public class BattleEngine {

    public static ArrayList<Person> characterList = new ArrayList<Person>();

    public static void descendingOrder() {
        Collections.sort(characterList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.valueOf(o2.getAttribute().getDexterity()).compareTo(o1.getAttribute().getDexterity());
            }
        });
    }   //Function to sort it descending the arrayList via dexterity value


    public static void turnEnd(Person player) {
        if(!player.getBuffSystem().isEmpty())
        {
            for(int i = 0; i < player.getBuffSystem().size(); i++)
            {
                player.getBuffSystem().get(i).buffAfter(player);
            }
        }
        if (player.getHealth() <= 0) {
            player.setStatus(Person.PersonStatus.DEAD);
        }

    }

    public static void updateAfter() {
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).isStatus(Person.PersonStatus.FLEE))
                characterList.remove(characterList.get(i));
        }
        descendingOrder();
    }

    public static boolean checker() {
    //This function will be use to check to see if the game is over or not.
    //This will depend if there are any more players on an opposing team.
        int bad = 0;
        int good = 0;

        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).getTeam() == Person.Side.ENEMY &&
                    characterList.get(i).isNotStatus(Person.PersonStatus.DEAD)) {
                bad++;
            }
            if (characterList.get(i).getTeam() == Person.Side.PLAYER &&
                    characterList.get(i).isNotStatus(Person.PersonStatus.DEAD)) {
                good++;
            }
        }
        if (good == 0 || bad == 0)
            return false;
        else
            return true;
    }

    //Display the order that the special sorting function via dexterity value.
    public static void characterTurn() {
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).isStatus(Person.PersonStatus.DEAD) ||
                    characterList.get(i).isStatus(Person.PersonStatus.STUN)) {
                turnEnd(characterList.get(i));
            }
            IO.actionChoice(characterList.get(i));
        }
        updateAfter();
    }
}
