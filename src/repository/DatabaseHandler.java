package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.Dish;
import model.Meal;

public class DatabaseHandler 
{
    private Database db = new Database("config.txt");
    private DishRepository dishRepo = new DishRepository(db);
    private MealRepository mealRepo = new MealRepository(db);

    public Meal selectMealById(int id)
    {
        Meal incompleto = mealRepo.selectById(id);
        dishRepo.link(incompleto);
        return incompleto;
    }

    // public Dish selectDishById(int id)
    // {
    //     Dish incompleto = dishRepo.selectById(id);
    //     mealRepo.link(incompleto);
    //     return incompleto;
    // }

    public ArrayList<Meal> selectAllMeals()
    {
        ArrayList<Meal> listaMealsIncompleti = mealRepo.selectAll();
        dishRepo.linkAll(listaMealsIncompleti);
        return listaMealsIncompleti;
    }
}
