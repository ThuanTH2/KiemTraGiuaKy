/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSDL;

import Model.SanPham;
import Model.TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author nguyentienthuan
 */
public class Database {
    private Connection cn;
    
    public Database(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/QuanLySanPham?useUnicode=true&characterEncoding=utf8", "root", "");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Kết nối thất bại !");
        }
        
    }
    public boolean checkLogin(TaiKhoan tk){
        boolean check = false;
        String sql;
            sql = "Select * From tbtaikhoan Where user = '"+tk.getUser()+"' AND password='"+tk.getPassword()+"'";
        try{
            System.out.println("sql"+sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                check = true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu với sql !");
        }
        return check; 
    }
     public Vector<SanPham> DSSanPham()
    {
        Vector<SanPham> dssp = new Vector<SanPham>();
        if(cn!=null)
        {
            String sql = "SELECT * FROM tbsanpham";
            try {
                Statement stm = cn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
                    SanPham sp = new SanPham();
                    sp.setMasp(rs.getInt("MaSP"));
                    sp.setTensp(rs.getString("TenSP"));
                    sp.setHinhanhsp(rs.getString("HinhanhSP"));
                    sp.setGioithieusp(rs.getString("GioithieuSP"));
                    sp.setGiasp(rs.getInt("GiaSP"));
                    sp.setManhom(rs.getInt("manhom"));
                    
                    dssp.add(sp);
                }
            } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }

        }
        return dssp;
    }
    public int Themsp(SanPham sp){
        if(cn==null)
            return -1;
        String sql = "INSERT INTO tbsanpham VALUES(NULL,?,?,?,?,?)";
            try {
                PreparedStatement stm = cn.prepareStatement(sql);
//                stm.setInt(1, sp.masp);
                stm.setString(1, sp.tensp);
                stm.setString(2, sp.hinhanhsp);
                stm.setString(3, sp.gioithieusp);
                stm.setInt(4, sp.giasp);
                stm.setInt(5, sp.manhom);
                int n = stm.executeUpdate();
                return n;
            }
               catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi thêm sp sql !");
               return -2;
            }
        
    }
    @SuppressWarnings("empty-statement")
    public int Suasp(SanPham sp){
        if(cn==null)
            return -1;
        String sql = "UPDATE tbsanpham SET TenSP='"+sp.tensp+"', HinhanhSP = '"+sp.hinhanhsp+"', GioithieuSP = '"+sp.gioithieusp+"', GiaSP = '"+sp.giasp+"' WHERE MaSP = '"+sp.masp+"'";
            try {
                Statement st = cn.createStatement();
                int n = st.executeUpdate(sql);
                return n;
            }
               catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi sửa sp sql !");
               return -2;
            }
        
    }
    public int Xoasp(int masp){
        if(cn==null)
            return -1;
        String sql = "DELETE FROM tbsanpham WHERE MaSP=?";
            try {
                PreparedStatement stm = cn.prepareStatement(sql);
                stm.setInt(1,masp);
                int n = stm.executeUpdate();
                return n;
            }
               catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi thêm sp sql !");
               return -2;
            }
        
    }
}
