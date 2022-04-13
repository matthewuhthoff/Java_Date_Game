package com.example.assignment3;

public class Politician extends Person{
    private String party;


    public Politician(String name, Date birthDate, String gender, String party, double difficulty) {
        super(name, birthDate, gender, difficulty);
        this.party = party;
    }



    public Politician(Politician politician) {
        super(politician.getName(), politician.getBorn(), politician.getGender(), politician.getDifficulty());
        this.party = politician.party;
    }



    public String entityType() {
        String toRet = "This entity is a Politician!";
        return toRet;
    }


    public String getParty() {
        return party;
    }

    public Entity clone() {
        return new Politician (this);
    }


    public String toString() {
        String toRet = ("Name: " + getName() +"\n" + "Born at: " + getBorn() + "\n" + "Gender: " + getGender() + "\n" + "Party: " + getParty() + "\n");
        return toRet;
    }


}
