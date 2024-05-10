package model;

import java.util.ArrayList;

//un intero pasto al ristorante
//un ordine al cameriere
public class Meal 
{
    private Integer id;
    //--------------- INIZIO RELAZIONE----------------------------------
    //1 PROPRIETÀ QUI
    private ArrayList<Dish> dishes;

    public Meal(String row) 
    {
        String[] parts = row.split(",");
        this.id = Integer.parseInt(parts[0]);
        this.dishes  = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    } 

    public void setId(Integer id) {
        if(id<0)
            System.out.println("NON CI PENSO NEMMENO");
        this.id = id;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish d)
    {
        dishes.add(d);//aggiunge figlio alla lista del padre 
        d.setMeal(this);//imposta questo come padre del dish
    }
    //---------------FINE RELAZIONE----------------------------------

    //METODI CHE FANNO USO DEI FIGLI
    public Double getPrice()
    {
        double res = 0;

        for(Dish d : dishes)
            res+=d.getPrice();

        return res;
    }
}
