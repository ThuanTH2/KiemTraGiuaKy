/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nguyentienthuan
 */
public class SanPham {
    public int masp,giasp,manhom;
    public String tensp,hinhanhsp,gioithieusp;

    public SanPham() {
    }

    public SanPham(int masp, int giasp, int manhom, String tensp, String hinhanhsp, String gioithieusp) {
        this.masp = masp;
        this.giasp = giasp;
        this.manhom = manhom;
        this.tensp = tensp;
        this.hinhanhsp = hinhanhsp;
        this.gioithieusp = gioithieusp;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getGiasp() {
        return giasp;
    }

    public void setGiasp(int giasp) {
        this.giasp = giasp;
    }

    public int getManhom() {
        return manhom;
    }

    public void setManhom(int manhom) {
        this.manhom = manhom;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanhsp() {
        return hinhanhsp;
    }

    public void setHinhanhsp(String hinhanhsp) {
        this.hinhanhsp = hinhanhsp;
    }

    public String getGioithieusp() {
        return gioithieusp;
    }

    public void setGioithieusp(String gioithieusp) {
        this.gioithieusp = gioithieusp;
    }
    
    
}
