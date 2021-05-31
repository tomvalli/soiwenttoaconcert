package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profile {

    @Id
    @GeneratedValue
    private int profileId;

    public Profile() {};

}
