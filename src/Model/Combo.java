/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Combo {
    private int IdCombo;
    private String NameCombo;
    private ArrayList<Food> lstFood;
    private float priceCombo;
    private String description;

    public int getIdCombo() {
        return IdCombo;
    }

    public void setIdCombo(int IdCombo) {
        this.IdCombo = IdCombo;
    }

    public String getNameCombo() {
        return NameCombo;
    }

    public void setNameCombo(String NameCombo) {
        this.NameCombo = NameCombo;
    }

    public ArrayList<Food> getLstFood() {
        return lstFood;
    }

    public void setLstFood(ArrayList<Food> lstFood) {
        this.lstFood = lstFood;
    }



    public float getPriceCombo() {
        return priceCombo;
    }

    public void setPriceCombo(float priceCombo) {
        this.priceCombo = priceCombo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Combo(int IdCombo, String NameCombo, ArrayList<Food> lstFood, float priceCombo, String description) {
        this.IdCombo = IdCombo;
        this.NameCombo = NameCombo;
        this.lstFood = lstFood;
        this.priceCombo = priceCombo;
        this.description = description;
    }

    public Combo() {
    }
    public Object[] toObjects(){
        return new Object[]{
            IdCombo, NameCombo, lstFood, priceCombo, description
        };
    }
    
}
