/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class Food {
    private int IDFood; 
    private String nameFood;
    private float priceFood;
    private String typeFood;
    private String Description;

    public int getIDFood() {
        return IDFood;
    }

    public void setIDFood(int IDFood) {
        this.IDFood = IDFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public float getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(float priceFood) {
        this.priceFood = priceFood;
    }

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Food() {
    }

    public Food(int IDFood, String nameFood, float priceFood, String typeFood, String Description) {
        this.IDFood = IDFood;
        this.nameFood = nameFood;
        this.priceFood = priceFood;
        this.typeFood = typeFood;
        this.Description = Description;
    }
    public Object[] toObjects(){
        return new Object[]{
            IDFood, nameFood, priceFood,typeFood, Description
        };
    }
}
