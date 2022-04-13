package com.example.assignment3;

public class Person extends Entity{
    private String gender;

    public Person(String name, Date birthDate , String gender, double difficulty) {
        super(name, birthDate, difficulty);
        this.gender = gender;
    }



    public Person(Person person) {
        super(person.getName(), person.getBorn(), person.getDifficulty());
        this.gender = person.gender;
    }



    public String getGender() {
        return gender;
    }


    public String entityType() {
        String toRet = "This entity is a Person!";
        return toRet;
    }


    public Entity clone() {
        return new Person (this);
    }

    public String toString() {
        String toRet = ("Name: " + getName() +"\n" + "Born at: " + getBorn() + "\n" + "Gender: " + getGender() + "\n");
        return toRet;
    }
}

