package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.Dish;
import model.Meal;

public class MealRepository 
{
    private Database db;

    public MealRepository(Database db)
    {
        this.db = db;
    }

    public ArrayList<Meal> selectAll()
    {
        ArrayList<String> rows = db.select("SELECT * FROM meals");
        ArrayList<Meal> res = new ArrayList<>();

        for(String row : rows)
            res.add(new Meal(row));

        return res;
    }

    public Meal selectById(int id)
    {
        ArrayList<String> rows = db.select("SELECT * FROM meals WHERE id="+id);
        return new Meal(rows.get(0));
    }

    public ArrayList<Meal> selectWhere(String condizione)
    {
        ArrayList<String> rows = db.select("SELECT * FROM meals WHERE "+condizione);
        ArrayList<Meal> res = new ArrayList<>();

        for(String row : rows)
            res.add(new Meal(row));//creo nuova Room e la aggiungo alla lista

        return res;
    }  
    //CRUD + servizio di linking
    public void link(Dish son)
    {
        ArrayList<String> rows = db.select("SELECT * FROM meals JOIN dishes ON meals.id=dishes.meal_id WHERE dishes.id="+son.getId());

        Meal h = new Meal(rows.get(0));//converto l'unica riga letta
        h.addDish(son);//le collego
    }

   
    public void linkAll(ArrayList<Dish> sons)
    {
        ArrayList<Integer> meals_id = new ArrayList<>();

        for(Dish r : sons)
        {
            if(!meals_id.contains(r.getMeal_id()))
                meals_id.add(r.getMeal_id());
        }

        String valoriIn =   meals_id
                            .toString()
                            .replace("[", "(")
                            .replace(", ", ",")
                            .replace("]", ")");

        ArrayList<Meal> fathers = selectWhere("id IN "+valoriIn);
        for(Meal h : fathers)//scorri tutte le case
        {
            for(Dish r : sons)//per ogni casa scorri tutte le stanze
            {
                if(r.getMeal_id().equals(h.getId()))//se PREDICATO JOIN TRUE, rooms.FK = houses.PK
                    h.addDish(r);//collega
            }
        }
        //4) riga 74-81 -> scorro tutte le case lette, aggiungo alle loro stanze le stanze con la FK
    }
}
