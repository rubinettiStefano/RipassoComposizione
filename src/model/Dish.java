package model;

//una portata ordinata
public class Dish 
{

    private Integer id;
    private String name, type;
    private Double price;

     //--------------- INIZIO RELAZIONE----------------------------------
    //2 proprietà QUI
    //RIFERIMENTO E FK
    private Meal meal;
    private Integer meal_id;

    public Dish(String csv) {
        //TODO Auto-generated constructor stub
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) 
    {
        this.meal = meal;
        this.meal_id =meal.getId();
    }

    public Integer getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(Integer meal_id) {
        this.meal_id = meal_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    
}
