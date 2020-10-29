
package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FeeDetails {
    private int id;
    private int duration;
    private int amount;
    private List<FeeDetails> fee= new ArrayList<>();
    Connection con;
    PreparedStatement ps;
    public FeeDetails() {
    }

    public FeeDetails(int id, int duration, int amount) {
        this.id = id;
        this.duration = duration;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public List<FeeDetails> getFee() {
        return fee;
    }

    public void setFee(List<FeeDetails> fee) {
        this.fee = fee;
    }
    
    public List<FeeDetails> see(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String query="select * from feedetail";
            ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            fee.clear();
            while (rs.next()) {                
                FeeDetails f1= new FeeDetails(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                fee.add(f1);
            }
        } catch (Exception e) {
        }
        return fee; 
    }

    
}
