
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
public class Payments {
     Connection con;
     PreparedStatement ps;
    private int mem_no;
    private String name;
    private String con_no;
    private String start_d;
    private String end_d;
    private String total_a;
    private String Paid_a;
    private String due_a;
    private String pay;
    private List<Payments> p1= new ArrayList<>();
    public Payments() {
    }

    public Payments(int mem_no, String name, String con_no, String start_d, String end_d, String total_a, String Paid_a, String due_a, String pay) {
        this.mem_no = mem_no;
        this.name = name;
        this.con_no = con_no;
        this.start_d = start_d;
        this.end_d = end_d;
        this.total_a = total_a;
        this.Paid_a = Paid_a;
        this.due_a = due_a;
        this.pay = pay;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
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

    public String getCon_no() {
        return con_no;
    }

    public void setCon_no(String con_no) {
        this.con_no = con_no;
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

    public String getTotal_a() {
        return total_a;
    }

    public void setTotal_a(String total_a) {
        this.total_a = total_a;
    }

    public String getPaid_a() {
        return Paid_a;
    }

    public void setPaid_a(String Paid_a) {
        this.Paid_a = Paid_a;
    }

    public String getDue_a() {
        return due_a;
    }

    public void setDue_a(String due_a) {
        this.due_a = due_a;
    }
    

    public List<Payments> getP1() {
        return p1;
    }

    public void setP1(List<Payments> p1) {
        this.p1 = p1;
    }
    public List<Payments> getShow(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String query="select * from paidtable";
            ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            p1.clear();
            while (rs.next()){
            Payments m1 = new Payments(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            p1.add(m1);
            }
        }catch (Exception e) {
        }
        return p1;
    }
    
    
}
