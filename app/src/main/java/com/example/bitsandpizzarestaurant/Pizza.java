package com.example.bitsandpizzarestaurant;

public class Pizza {
    private String name ;
    private  int imageResourceId;
    private int details;

    public static final Pizza[] pizzas = {
        new Pizza("Americana",R.drawable.americana,R.string.americanaDetails),
        new Pizza("Cambozola",R.drawable.cambozola,R.string.cambozolaDetails),
        new Pizza("Florentine",R.drawable.florentine,R.string.florentineDetails),
        new Pizza("Funghi",R.drawable.funghi,R.string.funghiDetails),
            new Pizza("Hawaiian",R.drawable.hawaiian,R.string.haiiwanDetails),
            new Pizza("Margherita",R.drawable.margherita,R.string.margeritaDetails),
            new Pizza("Marinara",R.drawable.marinara,R.string.marinaraDetails),
            new Pizza("Sicilian",R.drawable.sicilian,R.string.sicilianDetails)

    };

    public Pizza(String name, int imageResourceId, int details) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.details = details;
    }




    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getDetails() {
        return details;
    }
}
