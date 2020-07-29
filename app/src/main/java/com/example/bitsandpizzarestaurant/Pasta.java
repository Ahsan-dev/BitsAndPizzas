package com.example.bitsandpizzarestaurant;

public class Pasta  {

    private String name;
    private int imageResourceId;

    public static final Pasta[] pastas = {
            new Pasta("Bucatini",R.drawable.bucatini),
            new Pasta("Canneloni",R.drawable.canneloni),
            new Pasta("Cavatelli",R.drawable.cavatelli),
            new Pasta("Farfalle",R.drawable.farfalle),
            new Pasta("Fusilli",R.drawable.fusilli),
            new Pasta("Lasagna",R.drawable.lasagna),
            new Pasta("Orzo",R.drawable.orzo),
            new Pasta("Paccheri",R.drawable.paccheri)
    };


    public Pasta(String name, int imageResourceId) {

        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
