
package com.exam;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;



@ManagedBean
@SessionScoped
public class FileUpload {
    Connection con;
     PreparedStatement ps;
    private List<FileUpload> prolist=new ArrayList<>();
    private List<FileUpload> proload=new ArrayList<>();
     
     private String name;
     private int con_no;
     private String email;
     private String dob;
     private String sex;
     private String occu;
     private String address;
     private String emergency_c;
     private String weight;
     private String duration;
     private String start_d;
     private String end_d;
     private int selectedcon_no;
     private Part uploadedFile;

    public FileUpload() {
    }

    public FileUpload(String name, int con_no, String email, String dob, String sex, String occu, String address, String emergency_c, String weight, String duration, String start_d, String end_d) {
        this.name = name;
        this.con_no = con_no;
        this.email = email;
        this.dob = dob;
        this.sex = sex;
        this.occu = occu;
        this.address = address;
        this.emergency_c = emergency_c;
        this.weight = weight;
        this.duration = duration;
        this.start_d = start_d;
        this.end_d = end_d;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCon_no() {
        return con_no;
    }

    public void setCon_no(int con_no) {
        this.con_no = con_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getEmergency_c() {
        return emergency_c;
    }

    public void setEmergency_c(String emergency_c) {
        this.emergency_c = emergency_c;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    public int getSelectedcon_no() {
        return selectedcon_no;
    }

    public void setSelectedcon_no(int selectedcon_no) {
        this.selectedcon_no = selectedcon_no;
    }

    public List<FileUpload> getProlist() {
        return prolist;
    }

    public void setProlist(List<FileUpload> prolist) {
        this.prolist = prolist;
    }

    public List<FileUpload> getProload() {
        return proload;
    }

    public void setProload(List<FileUpload> proload) {
        this.proload = proload;
    }
    public void uploadFile() {
        try {
            InputStream input = uploadedFile.getInputStream();
            String fileName = uploadedFile.getSubmittedFileName();
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String path = ec.getRealPath("/");
            path = path.substring(0, path.indexOf("\\build"));
            System.out.println("testme 1" + path);
            Files.copy(input, new File(path + "\\web\\resources\\images\\", fileName).toPath());
            saveToDB("resources/images/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveToDB(String s) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String ins = "insert into addmember values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(ins);
            ps.setString(1, name);  
            ps.setInt(2, con_no);
            ps.setString(3, email);
            ps.setString(4, dob);
            ps.setString(5, sex);
            ps.setString(6, occu);
            ps.setString(7, address);
            ps.setString(8, emergency_c);
            ps.setString(9, weight);
            ps.setString(10, duration);
            ps.setString(11, start_d);
            ps.setString(12, end_d);
            ps.setString(13, s);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }
    
    public List<FileUpload> show(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String query="select * from addmember";
            ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            prolist.clear();
            while (rs.next()){
                FileUpload f1= new FileUpload(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
            prolist.add(f1);
            }
        }catch (Exception e) {
        }
        return prolist;
    }
    public List<Integer> getDoLoad() {
        
        List<Integer> proLoad = new ArrayList<Integer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            ps= con.prepareStatement("select * from addmember");
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                FileUpload f1= new FileUpload(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
                
                setName(rs.getString(1));
                setCon_no(rs.getInt(2));
                setEmail(rs.getString(3));
                setDob(rs.getString(4));
                setSex(rs.getString(5));
                setOccu(rs.getString(6));
                setAddress(rs.getString(7));
                setEmergency_c(rs.getString(8));
                setWeight(rs.getString(9));
                setDuration(rs.getString(10));
                setStart_d(rs.getString(11));
                setEnd_d(rs.getString(12));
                
                proLoad.add(f1.getCon_no());
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
            ps= con.prepareStatement("select * from addmember where con_no=?");
            ps.setInt(1, selectedcon_no);
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                setName(rs.getString(1));
                setCon_no(rs.getInt(2));
                setEmail(rs.getString(3));
                setDob(rs.getString(4));
                setSex(rs.getString(5));
                setOccu(rs.getString(6));
                setAddress(rs.getString(7));
                setEmergency_c(rs.getString(8));
                setWeight(rs.getString(9));
                setDuration(rs.getString(10));
                setStart_d(rs.getString(11));
                setEnd_d(rs.getString(12));
            }
        } catch (Exception e) {
        }
    }
    public void update(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String upda="update addmember set name=?,email=?,dateobirth=?,sex=?,occu=?,address=?,emergencyc=?,weight=?,duration=?,start_d=?, end_d=? where con_no=?";
            ps=con.prepareStatement(upda);
            ps.setString(1, name);            
           ps.setString(2, email);
            
            ps.setString(3, dob);
            ps.setString(4, sex);
            ps.setString(5, occu);
            ps.setString(6, address);
            ps.setString(7, emergency_c);
            ps.setString(8, weight);
            ps.setString(9, duration);
            ps.setString(10, start_d);
            ps.setString(11, end_d);
            ps.setInt(12, selectedcon_no);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void delete(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String del="delete from addmember where con_no=?";
             ps=con.prepareStatement(del);
             ps.setInt(1, selectedcon_no);
             ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<FileUpload> search(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymproject", "root", "apcl123456");
            String query="select * from addmember where con_no=?";
            ps=con.prepareStatement(query);
            ps.setInt(1, con_no);
            ResultSet rs=ps.executeQuery();
            proload.clear();
            while (rs.next()){
                FileUpload f2= new FileUpload(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
            proload.add(f2);
            }
        }catch (Exception e) {
        }
        return proload;
    }

    
}
