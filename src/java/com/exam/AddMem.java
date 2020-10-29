
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
public class AddMem {
     Connection con;
     PreparedStatement ps;
    
    private int mem_no;
    private String name;
    private String sex;
    private String con_no;
    private String city;
    private String weight;
    private String status;
    private String duration;
    private String email;
    private String reg_d;
    private String occu;
    private String address;
    private String fee_m;
    private String start_d;
    private String end_d;
    private int paid_fee;
    private int selectedmem_no;
    private List<AddMem> prolist= new ArrayList<>();
    private List<AddMem> proload= new ArrayList<>();
    public AddMem() {
    }

    public AddMem(int mem_no,String name, String sex, String con_no, String city, String weight, String status, String duration, String email, String reg_d, String occu, String address, String fee_m, String start_d, String end_d, int paid_fee) {
        
        this.mem_no = mem_no;
        this.name = name;
        this.sex = sex;
        this.con_no = con_no;
        this.city = city;
        this.weight = weight;
        this.status = status;
        this.duration = duration;
        this.email = email;
        this.reg_d = reg_d;
        this.occu = occu;
        this.address = address;
        this.fee_m = fee_m;
        this.start_d = start_d;
        this.end_d = end_d;
        this.paid_fee = paid_fee;
    }
public int getMem_no() {
        return mem_no;
    }

    public void setMem_no(int mem_no) {
        this.mem_no = mem_no;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCon_no() {
        return con_no;
    }

    public void setCon_no(String con_no) {
        this.con_no = con_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReg_d() {
        return reg_d;
    }

    public void setReg_d(String reg_d) {
        this.reg_d = reg_d;
    }

    public String getOccu() {
        return occu;
    }

    public void setOccu(String occu) {
        this.occu = occu;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFee_m() {
        return fee_m;
    }

    public void setFee_m(String fee_m) {
        this.fee_m = fee_m;
    }

    public String getStart_d() {
        return start_d;
    }

    public void setStart_d(String start_d) {
        this.start_d = start_d;
    }

    public String getEnd_d() {
        return end_d;
    }

    public void setEnd_d(String end_d) {
        this.end_d = end_d;
    }

    public int getPaid_fee() {
        return paid_fee;
    }

    public void setPaid_fee(int paid_fee) {
        this.paid_fee = paid_fee;
    }
    public int getSelectedmem_no() {
        return selectedmem_no;
    }

    public void setSelectedmem_no(int selectedmem_no) {
        this.selectedmem_no = selectedmem_no;
    }
    public List<AddMem> getProlist() {
        return prolist;
    }

    public void setProlist(List<AddMem> prolist) {
        this.prolist = prolist;
    }
    public List<AddMem> getProload() {
        return proload;
    }

    public void setProload(List<AddMem> proload) {
        this.proload = proload;
    }
    
    public void insert() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String ins = "insert into addmember values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(ins);
            ps.setInt(1, mem_no);
            ps.setString(2, name);           
            ps.setString(3, sex);
            ps.setString(4, con_no);
            ps.setString(5, city);
            ps.setString(6, weight);
            ps.setString(7, status);
            ps.setString(8, duration);
            ps.setString(9, email);
            ps.setString(10, reg_d);
            ps.setString(11, occu);
            ps.setString(12, address);
            ps.setString(13, fee_m);
            ps.setString(14, start_d);
            ps.setString(15, end_d);
            ps.setInt(16, paid_fee);
            ps.executeUpdate();
        } catch (Exception e) {
        }        
    }
    public List<Integer> getDoLoad() {
        
        List<Integer> proLoad = new ArrayList<Integer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            ps= con.prepareStatement("select * from addmember");
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                AddMem ad = new AddMem(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16));
                setMem_no(rs.getInt(1));
                setName(rs.getString(2));               
                setSex(rs.getString(3));
                setCon_no(rs.getString(4));
                setCity(rs.getString(5));
                setWeight(rs.getString(6));
                setStatus(rs.getString(7));
                setDuration(rs.getString(8));
                setEmail(rs.getString(9));
                setReg_d(rs.getString(10));
                setOccu(rs.getString(11));
                setAddress(rs.getString(12));
                setFee_m(rs.getString(13));
                setStart_d(rs.getString(14));
                setEnd_d(rs.getString(15));
                setPaid_fee(rs.getInt(16));
                
                proLoad.add(ad.getMem_no());
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
            ps= con.prepareStatement("select * from addmember where mem_no=?");
            ps.setInt(1, selectedmem_no);
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                setMem_no(rs.getInt(1));
                setName(rs.getString(2));               
                setSex(rs.getString(3));
                setCon_no(rs.getString(4));
                setCity(rs.getString(5));
                setWeight(rs.getString(6));
                setStatus(rs.getString(7));
                setDuration(rs.getString(8));
                setEmail(rs.getString(9));
                setReg_d(rs.getString(10));
                setOccu(rs.getString(11));
                setAddress(rs.getString(12));
                setFee_m(rs.getString(13));
                setStart_d(rs.getString(14));
                setEnd_d(rs.getString(15));
                setPaid_fee(rs.getInt(16));
            }
        } catch (Exception e) {
        }
    }
    public void delete(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String del="delete from addmember where mem_no=?";
             ps=con.prepareStatement(del);
             ps.setInt(1, selectedmem_no);
             ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void update(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String upda="update addmember set name=?,sex=?, con_no=?, city=?, weight=?, status=?, duration=?, email=?, reg_date=?, occup=?, address=?, fees_m=?, start_d=?, end_d=?, paid_fee=? where mem_no=?";
            ps=con.prepareStatement(upda);
            ps.setString(1, name);            
            ps.setString(2, sex);
            ps.setString(3, con_no);
            ps.setString(4, city);
            ps.setString(5, weight);
            ps.setString(6, status);
            ps.setString(7, duration);
            ps.setString(8, email);
            ps.setString(9, reg_d);
            ps.setString(10, occu);
            ps.setString(11, address);
            ps.setString(12, fee_m);
            ps.setString(13, start_d);
            ps.setString(14, end_d);
            ps.setInt(15, paid_fee);
            ps.setInt(16, selectedmem_no);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<AddMem> show(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String query="select * from addmember";
            ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            prolist.clear();
            while (rs.next()){
            AddMem ad = new AddMem( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16));
            prolist.add(ad);
            }
        }catch (Exception e) {
        }
        return prolist;
    }
    public List<AddMem> search(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String query="select * from addmember where mem_no=?";
            ps=con.prepareStatement(query);
            ps.setInt(1, mem_no);
            ResultSet rs=ps.executeQuery();
            proload.clear();
            while (rs.next()){
            AddMem ad = new AddMem( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16));
            proload.add(ad);
            }
        }catch (Exception e) {
        }
        return proload;
    }
    
}
