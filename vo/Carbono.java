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
 * @author 3info2021B
 */
public class Carbono {
    private int elmt=1;
    ImageIcon imag = new ImageIcon(this.getClass().getResource("/imagens/carbon.png"));
    Image imaged = imag.getImage();
    Image newimg = imaged.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
    private ImageIcon carbon = new ImageIcon(newimg);
    private Point limit1 = new Point();
    private Point limit2 = new Point();

    public Carbono(int x, int y){
        limit1 = new Point(x, y);
        limit2 = new Point(x+100, y+100);
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
     * @return the carbon
     */
    public ImageIcon getCarbon() {
        return carbon;
    }

    /**
     * @param carbon the carbon to set
     */
    public void setCarbon(ImageIcon carbon) {
        this.carbon = carbon;
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
