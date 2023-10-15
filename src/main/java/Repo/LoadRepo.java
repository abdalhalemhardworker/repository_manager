/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import Config.DBConfig;
import Entities.LoadModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C.m™ Lap Master
 */
public class LoadRepo {

    public static boolean updateLoad(int id, LoadModel newLoad) {
        try {
            Statement stmt = DBConfig.getConnection().createStatement();
            String sql = String.format("UPDATE load SET load_number = '%s' WHERE id = %d;", newLoad.getLoadNumber(), id);

//            stmt.setString(1, newLoad.getLoadNumber());
//            stmt.setInt(2, id);
            return stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public static boolean addNew(LoadModel newLoad) {
        try {
            String sql = "INSERT INTO load (load_number) VALUES (?);";
            PreparedStatement stmt = DBConfig.getConnection().prepareStatement(sql);
            stmt.setString(1, newLoad.getLoadNumber());

            return stmt.execute();
        } catch (Exception e) {
        }
        return false;
    }

    public static List<LoadModel> getAll() {
        List<LoadModel> data = new ArrayList<>();
        try {
            String sql = "SELECT id, load_number FROM load;";
            Statement stmt = DBConfig.getConnection().createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                data.add(new LoadModel(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
        }
        return data;
    }
}
