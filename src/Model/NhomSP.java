/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nguyentienthuan
 */
public class NhomSP {
    public int manhom;
    public String tennhom;

    public NhomSP() {
    }

    public NhomSP(int manhom, String tennhom) {
        this.manhom = manhom;
        this.tennhom = tennhom;
    }

    public int getManhom() {
        return manhom;
    }

    public void setManhom(int manhom) {
        this.manhom = manhom;
    }

    public String getTennhom() {
        return tennhom;
    }

    public void setTennhom(String tennhom) {
        this.tennhom = tennhom;
    }
    
}
