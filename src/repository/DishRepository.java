package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.Dish;
import model.Meal;

//COSA È UNA REPOSITORY?
//La parte del programma che fornisce i servizi di CRUD verso il db, per una determinata ENTITÀ
public class DishRepository 
{
    private Database db;

    public DishRepository(Database db)
    {
        this.db = db;
    }

    

    //CRUD + servizio di linking

     public void link(Meal father)
    {
        ArrayList<String> rows = db.select("SELECT * FROM dishes JOIN meals ON meals.id=dishes.meal_id WHERE dishes.id="+father.getId());

        for(String row : rows)
            father.addDish(new Dish(row));//prendi il padre, aggiungi alle sue stanze una nuova stanza creata convertendo la riga letta da db
    }

      /**
     * Legge dal db le stanze figlie e le collega
     * @param father
     */
    public void linkAll(ArrayList<Meal> fathers)
    {
        for(Meal father : fathers)
            link(father);
    }
}
