/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author C.m™ Lap Master
 */
public class LoadModel {

    private int id;
    private String loadNumber;

    public LoadModel(int id, String loadNumber) {
        this.id = id;
        this.loadNumber = loadNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoadNumber() {
        return loadNumber;
    }

    public void setLoadNumber(String loadNumber) {
        this.loadNumber = loadNumber;
    }

    @Override
    public String toString() {
        return String.format("load (id:%d, load_number:%s)", getId(), getLoadNumber());
    }
}
