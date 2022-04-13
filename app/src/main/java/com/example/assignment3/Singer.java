package com.example.assignment3;

public class Singer extends Person{
    private String debutAlbum;
    private Date debutAlbumReleaseDate;

    public Singer(String name, Date birthDate, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {
        super(name, birthDate, gender, difficulty);
        this.debutAlbum = debutAlbum;
        this.debutAlbumReleaseDate = debutAlbumReleaseDate;
    }



    public Singer(Singer singer) {
        super(singer.getName(), singer.getBorn(), singer.getGender(), singer.getDifficulty());
        this.debutAlbum = singer.debutAlbum;
        this.debutAlbumReleaseDate = singer.debutAlbumReleaseDate;
    }



    public String entityType() {
        String toRet = "This entity is a Singer!";
        return toRet;
    }

    public String getDebutAlbum() {
        return debutAlbum;
    }

    public Date debutAlbumReleaseDate() {
        return new Date(debutAlbumReleaseDate); // safe access
    }


    public Entity clone() {
        return new Singer (this);
    }

    public String toString() {
        String toRet = ("Name: " + getName() +"\n" + "Born at: " + getBorn() + "\n" + "Gender: " + getGender() + "\n" + "Debut Album" + getDebutAlbum() + "\n" + "Release Date: " + debutAlbumReleaseDate().toString() + "\n");
        return toRet;
    }

}
