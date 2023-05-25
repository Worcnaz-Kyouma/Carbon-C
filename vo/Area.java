/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author nicol
 */
public class Area {

    private ImageIcon oct;
    private ImageIcon elmto;
    private Point limit1  = new Point();
    private Point limit2  = new Point();
    private int elmt = 0, xd, yd;
    private int[] ligas = new int[8];

    public Area(int x, int y) {
        ImageIcon oct1 = new ImageIcon(this.getClass().getResource("/imagens/oct.png"));
        Image oct2 = oct1.getImage();
        Image oct3 = oct2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        oct = new ImageIcon(oct3);

        xd = x;
        yd = y+50;
        for (int c = 0; c < ligas.length; c++) {
            ligas[c] = 0; //tipo de ligação dos arredores 
        };
        
        limit1 = new Point(xd,yd);
        limit2 = new Point(xd+100,yd+100);

        

    }

    public void liga() {
        ImageIcon a1;
        Image a2;
        Image a3;
        switch (getElmt()) {
            case 1:
                a1 = new ImageIcon(this.getClass().getResource("/imagens/fixcarbon.png"));
                a2 = a1.getImage();
                a3 = a2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                setElmto(new ImageIcon(a3));
                break;
            case 2:
                a1 = new ImageIcon(this.getClass().getResource("/imagens/oct.png"));
                a2 = a1.getImage();
                a3 = a2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                setElmto(new ImageIcon(a3));
                break;
        }

    }

    /**
     * @return the oct
     */
    public ImageIcon getOct() {
        return oct;
    }

    /**
     * @param oct the oct to set
     */
    public void setOct(ImageIcon oct) {
        this.oct = oct;
    }

    /**
     * @return the elmto
     */
    public ImageIcon getElmto() {
        return elmto;
    }

    /**
     * @param elmto the elmto to set
     */
    public void setElmto(ImageIcon elmto) {
        this.elmto = elmto;
    }


    /**
     * @return the elmt
     */
    public int getElmt() {
        return elmt;
    }

    /**
     * @param elmt the elmt to set
     */
    public void setElmt(int elmt) {
        this.elmt = elmt;
    }

    /**
     * @return the xd
     */
    public int getXd() {
        return xd;
    }

    /**
     * @param xd the xd to set
     */
    public void setXd(int xd) {
        this.xd = xd;
    }

    /**
     * @return the yd
     */
    public int getYd() {
        return yd;
    }

    /**
     * @param yd the yd to set
     */
    public void setYd(int yd) {
        this.yd = yd;
    }

    /**
     * @return the ligas
     */
    public int[] getLigas() {
        return ligas;
    }

    /**
     * @param ligas the ligas to set
     */
    public void setLigas(int[] ligas) {
        this.ligas = ligas;
    }

    /**
     * @return the limit1
     */
    public Point getLimit1() {
        return limit1;
    }

    /**
     * @param limit1 the limit1 to set
     */
    public void setLimit1(Point limit1) {
        this.limit1 = limit1;
    }

    /**
     * @return the limit2
     */
    public Point getLimit2() {
        return limit2;
    }

    /**
     * @param limit2 the limit2 to set
     */
    public void setLimit2(Point limit2) {
        this.limit2 = limit2;
    }
}
