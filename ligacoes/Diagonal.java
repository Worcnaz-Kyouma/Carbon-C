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
public class Diagonal {

    private boolean possivel = false; //Torna disponivel a hitbox e o clique
    private int ligint = 0, ligintimp=0, xd, yd; //Lig int = tipo de ligação
    private ImageIcon liga; //Execulta a ligação ao ser clicada
    private Point limit1 = new Point();
    private Point limit2 = new Point();
    private Point limit3 = new Point();
    private Point limit4 = new Point();

    public Diagonal(int x, int y, int h) {
        xd = x + 80;
        yd = y + 130;

        if (h  % 2 != 0) {
            limit1 = new Point(getXd()+30, getYd());  
            limit2 = new Point(getXd()+53, getYd() + 23);
            limit3 = new Point(getXd(), getYd() + 30);
            limit4 = new Point(getXd()+23, getYd() + 53);
        } else {
            limit1 = new Point(getXd(), getYd());  
            limit2 = new Point(getXd()+23, getYd() + 23);
            limit3 = new Point(getXd()+30, getYd() + 30);
            limit4 = new Point(getXd()+53, getYd() + 53);
        }
        //mudar

        ImageIcon l1 = new ImageIcon(this.getClass().getResource("/imagens/ligacaovaziadpar.png"));
        Image l2 = l1.getImage();
        Image l3 = l2.getScaledInstance(54, 54, java.awt.Image.SCALE_SMOOTH);
        liga = new ImageIcon(l3);

    }

    public void liga() {
        ImageIcon l1;
        Image l2;
        Image l3;
        if(ligint !=0){
        switch (getLigint()) { //da esquerda pra direita
            case 1:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/diagonalpar(simples).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(63, 63, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd-5;
                yd = yd-5;
                break;
            case 2:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/diagonalpar(dupla).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(76, 76, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd-11;
                yd = yd-12;
                break;
            case 3:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/diagonalpar(tripla).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(76, 78, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd-11;
                yd = yd-12;
                break;
        }
        }
        else{
        switch (getLigintimp()) {//da direita pra esquerda
            case 1:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/diagonalimp(simples).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(63, 63, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd-4;
                yd = yd-3;
                break;
            case 2:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/diagonalimp(dupla).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(76, 76, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd-11;
                yd = yd-12;
                break;
            case 3:
                l1 = new ImageIcon(this.getClass().getResource("/imagens/diagonalimp(tripla).png"));
                l2 = l1.getImage();
                l3 = l2.getScaledInstance(76, 78, java.awt.Image.SCALE_SMOOTH);
                setLiga(new ImageIcon(l3));
                xd = xd-11;
                yd = yd-12;
                break;
        }
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

    /**
     * @return the limit3
     */
    public Point getLimit3() {
        return limit3;
    }

    /**
     * @param limit3 the limit3 to set
     */
    public void setLimit3(Point limit3) {
        this.limit3 = limit3;
    }

    /**
     * @return the limit4
     */
    public Point getLimit4() {
        return limit4;
    }

    /**
     * @param limit4 the limit4 to set
     */
    public void setLimit4(Point limit4) {
        this.limit4 = limit4;
    }

    /**
     * @return the ligintimp
     */
    public int getLigintimp() {
        return ligintimp;
    }

    /**
     * @param ligintimp the ligintimp to set
     */
    public void setLigintimp(int ligintimp) {
        this.ligintimp = ligintimp;
    }

}
