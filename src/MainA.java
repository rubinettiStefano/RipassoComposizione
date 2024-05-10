import model.Dish;
import model.Meal;
import repository.DatabaseHandler;

public class MainA 
{
    public static void main(String[] args) 
    {
        
       DatabaseHandler dbh = new DatabaseHandler();

       System.out.println("Inserisci id del pasto che vuoi leggere");
       int idInseritoDaUtente = 1;//scanner nextLine parsato

       Meal letto = dbh.selectMealById(idInseritoDaUtente);
       
    }
}
