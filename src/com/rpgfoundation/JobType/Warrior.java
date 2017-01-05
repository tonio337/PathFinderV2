package com.rpgfoundation.JobType;

import com.rpgfoundation.Secondary.Attribute;

/**
 * Created by Brandon on 1/2/2017.
 */
public class Warrior extends JobType{

    public Warrior()
    {
        this(generateStats(20,1));
    }
    //Superclass
    public Warrior(Attribute attribute) {
        super(attribute);
        title = "Warrior";
    }
}
