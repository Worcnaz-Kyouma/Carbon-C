/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligacoes;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author nicol
 */
public class Vertical {
    private boolean possivel=false;
    private int ligint = 0, xd, yd;
    private ImageIcon liga;
    private Point limit1 = new Point();
    private Point limit2 = new Point();

    public Vertical(int x, int y) {
        xd = x+42;
        yd = y+151;

        limit1 = new Point(getXd(), getYd());
        limit2 = new Point(getXd() + 16, getYd() + 12);

        ImageIcon l1 = new ImageIcon(this.getClass().getResource("/imagens/ligacaovaziav.png"));
        Image l2 = l1.getImage();
        Image l3 = l2.getScaledInstance(16, 12, java.awt.Image.SCALE_SMOOTH);
        liga = new ImageIcon(l3);

    }

    public void liga() {
        ImageIcon l1;
        Image l2;
        Image l3;
        switch (getLigint()) {
            case 1:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/vertical(simples).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(12, 50, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd+2;
                yd = yd-19;
                break;
            case 2:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/vertical(dupla).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(24, 50, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd-4;
                yd = yd-19;
                break;
            case 3:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/vertical(tripla).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(36, 50, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd-12;
                yd = yd-19;
                break;
        }
    }

    /**
     * @return the possivel
     */
    public boolean isPossivel() {
        return possivel;
    }

    /**
     * @param possivel the possivel to set
     */
    public void setPossivel(boolean possivel) {
        this.possivel = possivel;
    }

    /**
     * @return the ligint
     */
    public int getLigint() {
        return ligint;
    }

    /**
     * @param ligint the ligint to set
     */
    public void setLigint(int ligint) {
        this.ligint = ligint;
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
     * @return the liga
     */
    public ImageIcon getLiga() {
        return liga;
    }

    /**
     * @param liga the liga to set
     */
    public void setLiga(ImageIcon liga) {
        this.liga = liga;
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
