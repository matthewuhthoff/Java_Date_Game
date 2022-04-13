package com.example.assignment3;

public abstract class Entity {
    private String name;
    private Date born;
    private double difficulty;

    public Entity(String name, Date birthDate, double difficulty) {
        this.name = name;
        this.born = new Date(birthDate); //no privacy leak
        this.difficulty = difficulty;
    }

    public Entity(Entity entity) {
        this.name = entity.name;
        this.born = new Date(entity.born); //no privacy leak
        this.difficulty = entity.difficulty;
    }

    public int getAwardedTicketNumber() {
        return (int)(difficulty * 100);
    }


    public abstract String entityType();

    public abstract Entity clone();


    public String welcomeMessage() {
        String toRet = "Welcome! Let's start the game! this entity is a " + this.entityType();
        return toRet;
    }

    public String closingMessage() {
        String toRet = "Congradulations! The detailed information of the entity you guessed is: \n" + this.toString();
        return toRet;
    }


    public String getName() {
        return name;
    }



    public Date getBorn() {
        return new Date(born);
    }

    public double getDifficulty() {
        return difficulty;
    }

    public String toString() {
        return "Name: " + name+"\n" + "Born at: " + born.toString() + "\n";
    }
}
