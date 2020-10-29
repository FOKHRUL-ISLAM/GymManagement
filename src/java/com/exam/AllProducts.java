
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
public class AllProducts {
    Connection con;
    PreparedStatement ps;
    private int id;
    private String name;
    private String category;
    private String price;
    private String qty;
    private String des;
    private int selectedid;
    private List<AllProducts> pro= new ArrayList<>();
    public AllProducts() {
    }

    public AllProducts(int id, String name, String category, String price, String qty, String des) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.qty = qty;
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
    public List<AllProducts> getPro() {
        return pro;
    }

    public void setPro(List<AllProducts> pro) {
        this.pro = pro;
    }
    public int getSelectedid() {
        return selectedid;
    }

    public void setSelectedid(int selectedid) {
        this.selectedid = selectedid;
    }
    public void insert(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String inst="insert into addproducts values(?,?,?,?,?,?)";
            ps=con.prepareStatement(inst);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setString(4, price);
            ps.setString(5, qty);
            ps.setString(6, des);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public List<Integer> getDoLoad() {
        
        List<Integer> proLoad = new ArrayList<Integer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            ps= con.prepareStatement("select * from addproducts");
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                AllProducts ad = new AllProducts(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                setId(rs.getInt(1));
                setName(rs.getString(2));               
                setCategory(rs.getString(3));
                setPrice(rs.getString(4));
                setQty(rs.getString(5));
                setDes(rs.getString(6));
                
                proLoad.add(ad.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proLoad;
    }
    public void ajaxList() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            ps= con.prepareStatement("select * from addproducts where id=?");
            ps.setInt(1, selectedid);
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                setId(rs.getInt(1));
                setName(rs.getString(2));               
                setCategory(rs.getString(3));
                setPrice(rs.getString(4));
                setQty(rs.getString(5));
                setDes(rs.getString(6));  
            }
        } catch (Exception e) {
        }
    }
    
    public List<AllProducts> show(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String query="select * from addproducts";
            ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            pro.clear();
            while (rs.next()){
            AllProducts a= new AllProducts(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            pro.add(a);
            }
        }catch (Exception e) {
        }
        return pro;
    }
    public void delete(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String del="delete from addproducts where id=?";
             ps=con.prepareStatement(del);
             ps.setInt(1, selectedid);
             ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void update(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String upda="update addproducts set name=?,catagory=?, price=?, quantity=?, des=? where id=?";
            ps=con.prepareStatement(upda);
            ps.setString(1, name);            
            ps.setString(2, category);
            ps.setString(3, price);
            ps.setString(4, qty);
            ps.setString(5, des);
            ps.setInt(6, selectedid); 
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
