package com.rpgfoundation.JobType;

import com.rpgfoundation.Secondary.Attribute;

/**
 * Created by Brandon on 1/1/2017.
 */
public class Paladin extends JobType {

    public Paladin()
    {
        this(generateStats(20,1));
    }
    //Superclass
    public Paladin(Attribute attribute) {
        super(attribute);
        title = "Paladin";
    }
}
