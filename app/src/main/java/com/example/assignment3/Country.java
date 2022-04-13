package com.example.assignment3;

public class Country extends Entity{
    private String capital;



    public Country(String name, Date birthDate, String capital, double difficulty) {
        super(name, birthDate, difficulty);
        this.capital = capital;
    }



    public Country(Country country) {
        super(country.getName(), country.getBorn(), country.getDifficulty());
        this.capital = country.capital;
    }


    public String getCapital() {
        return capital;
    } // every new instance variable needs a getter, good convention


    public String entityType() {
        String toRet = "This entity is a Country!";
        return toRet;
    }


    public Entity clone() {
        return new Country (this);
    }

    public String toString() {
        String toRet = ("Name: " + getName() +"\n" + "Born at: " + getBorn() + "\n" + "Capital: " + getCapital() + "\n");
        return toRet;
    } // need custom late binding toString for each subClass, this applies to all other subClasses
}
