/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import ligacoes.Diagonal;
import ligacoes.Horizontal;
import ligacoes.Vertical;
import vo.Area;
import vo.Carbono;
import java.util.Random;

/**
 *
 * @author nicol
 */
public class Tela extends JPanel { //parei em: fazer os desenhos de simples, dupla e triplas. E ai ajusta isso no clique da hitbox pra aparece a ligação e ganhamo.

    Area[][] a = new Area[14][6];
    int selemt = 0;
    int sliga = 0;
    Point crt = new Point();

    Carbono carbono = new Carbono(0, 725);

    ImageIcon ligacoes = new ImageIcon();

    Horizontal[][] h = new Horizontal[13][6];
    Vertical[][] v = new Vertical[14][5];
    Diagonal[][] d = new Diagonal[26][5];
    
    Random rand = new Random();

    public Tela() {
        ClickListener clickListener = new ClickListener();
        this.addMouseListener(clickListener);
        carbono = new Carbono(0, 725);
        ligacoes = new ImageIcon(this.getClass().getResource("/imagens/ligacoes.png"));

        int xi = 0;
        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 6; y++) {
                a[x][y] = new Area(x * 114, y * 114);
            }
        } //Inicializa as areas

        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 6; y++) {
                h[x][y] = new Horizontal(x * 114, y * 114);
            }
        } //Inicializa os campos horizontais

        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 5; y++) {
                v[x][y] = new Vertical(x * 114, y * 114);
            }
        } //Inicializa os campos verticais

        for (int y = 0; y < 5; y++) {
            xi = 0;
            for (int x = 0; x < 26; x = x + 2) {
                d[x][y] = new Diagonal(xi * 114, y * 114, x);
                d[x + 1][y] = new Diagonal(xi * 114, y * 114, x + 1);
                xi++;
            }
        }//cada espaço vazio podera ter sua forma de simples, dupla ou tripla ligação
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ligacoes.paintIcon(this, g, 20, 10);
        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 6; y++) {
                a[x][y].getOct().paintIcon(this, g, a[x][y].getXd(), a[x][y].getYd());
                if (a[x][y].getElmt() != 0) {
                    a[x][y].getElmto().paintIcon(this, g, a[x][y].getXd() + 25, a[x][y].getYd() + 25);
                    if (y - 1 >= 0 && a[x][y - 1].getElmt() != 0) {
                        v[x][y - 1].setPossivel(true);
                    }
                    if (y - 1 >= 0 && x + 1 < 14 && a[x + 1][y - 1].getElmt() != 0) {
                        d[x * 2 + 1][y - 1].setPossivel(true);
                    }
                    if (x + 1 < 13 && a[x + 1][y].getElmt() != 0) {
                        h[x][y].setPossivel(true);
                    }
                    if (y < 5 && x + 1 < 14 && a[x + 1][y + 1].getElmt() != 0) {
                        d[x * 2][y].setPossivel(true);
                    }
                    if (y + 1 < 5 && a[x][y + 1].getElmt() != 0) {
                        v[x][y].setPossivel(true);
                    }
                    if (x - 1 >= 0 && x - 1 < 26 && y + 1 < 5 && a[x - 1][y + 1].getElmt() != 0) {
                        d[x * 2 - 1][y].setPossivel(true);
                    }
                    if (x - 1 >= 0 && a[x - 1][y].getElmt() != 0) {
                        h[x - 1][y].setPossivel(true);
                    }
                    if (x - 1 >= 0 && y - 1 >= 0 && a[x - 1][y - 1].getElmt() != 0) {
                        d[x * 2 - 2][y - 1].setPossivel(true);
                    }

                }
            }
        } //desenha area e os elementos dentro dela

        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 6; y++) {
                if (h[x][y].isPossivel()) {
                    h[x][y].getLiga().paintIcon(this, g, h[x][y].getXd(), h[x][y].getYd());
                }
            }
        } //desenha horizontais de ligação

        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 5; y++) {
                if (v[x][y].isPossivel()) {
                    v[x][y].getLiga().paintIcon(this, g, v[x][y].getXd(), v[x][y].getYd());
                }
            }
        } //desenha verticais de ligação

        for (int x = 0; x < 26; x++) {
            for (int y = 0; y < 5; y++) {
                if (d[x][y].isPossivel()) {
                    if (x % 2 != 0 && d[x][y].getLigintimp() == 0) {
                        d[x][y].setLiga(new ImageIcon(this.getClass().getResource("/imagens/ligacaovaziadimpar.png")));
                    }
                    d[x][y].getLiga().paintIcon(this, g, d[x][y].getXd(), d[x][y].getYd());
                }
            }
        } //desenha diagonais de ligação

        carbono.getCarbon().paintIcon(this, g, 0, 725); //Desenha o carbono elemento pegavel

    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            crt = e.getPoint();
            for (int x = 0; x < 14; x++) {
                for (int y = 0; y < 6; y++) {
                    if ((crt.getX() > a[x][y].getLimit1().getX() && crt.getY() > a[x][y].getLimit1().getY()) && (crt.getX() <= a[x][y].getLimit2().getX() && crt.getY() <= a[x][y].getLimit2().getY()) && (selemt != 0)) {
                        a[x][y].setElmt(selemt);
                        a[x][y].liga();
                        selemt = 0;
                        repaint();
                    }
                }
            } //Hitbox das areas(COM ELEMENTO SELECIONADO)
            for (int x = 0; x < 13; x++) {
                for (int y = 0; y < 6; y++) {
                    if ((crt.getX() > h[x][y].getLimit1().getX() && crt.getY() > h[x][y].getLimit1().getY()) && (crt.getX() <= h[x][y].getLimit2().getX() && crt.getY() <= h[x][y].getLimit2().getY())) {
                        if (h[x][y].isPossivel()) {
                            if (h[x][y].getLigint() != 0) {

                            } else {
                                h[x][y].setLigint(sliga);
                                h[x][y].liga();
                                sliga = 0;
                                repaint();
                            }
                        }
                    }
                }
            } //Hitbox das horizontais
            for (int x = 0; x < 14; x++) {
                for (int y = 0; y < 5; y++) {
                    if ((crt.getX() > v[x][y].getLimit1().getX() && crt.getY() > v[x][y].getLimit1().getY()) && (crt.getX() <= v[x][y].getLimit2().getX() && crt.getY() <= v[x][y].getLimit2().getY())) {
                        if (v[x][y].isPossivel()) {
                            if (v[x][y].getLigint() != 0) {

                            } else {
                                v[x][y].setLigint(sliga);
                                v[x][y].liga();
                                sliga = 0;
                                repaint();
                            }
                        }
                    }
                }
            } //Hitbox das verticais
            for (int x = 0; x < 26; x++) {
                for (int y = 0; y < 5; y++) {
                    if (((crt.getX() > d[x][y].getLimit1().getX() && crt.getY() > d[x][y].getLimit1().getY()) && (crt.getX() <= d[x][y].getLimit2().getX() && crt.getY() <= d[x][y].getLimit2().getY())) || ((crt.getX() > d[x][y].getLimit3().getX() && crt.getY() > d[x][y].getLimit3().getY()) && (crt.getX() <= d[x][y].getLimit4().getX() && crt.getY() <= d[x][y].getLimit4().getY()))) {
                        if (d[x][y].isPossivel()) {
                            if (d[x][y].getLigint() != 0 || d[x][y].getLigintimp() != 0) {

                            } else {
                                if (x % 2 != 0) {
                                    d[x][y].setLigintimp(sliga);
                                    d[x][y].liga();
                                    System.out.println("s");
                                    sliga = 0;
                                    repaint();
                                } else {
                                    d[x][y].setLigint(sliga);
                                    d[x][y].liga();
                                    System.out.println("h");
                                    sliga = 0;
                                    repaint();
                                }
                            }
                        } //falta diagonal, ai so corta no paint usa o % e cabo 
                    }
                }
            } //Hitbox das diagonais

            if ((crt.getX() > carbono.getLimit1().getX() && crt.getY() > carbono.getLimit1().getY()) && (crt.getX() <= carbono.getLimit2().getX() && crt.getY() <= carbono.getLimit2().getY())) {
                selemt = 1;
            } //Hitbox do carbono

            if ((crt.getX() > 20 && crt.getY() > 10) && (crt.getX() <= 79 && crt.getY() <= 39)) {
                sliga = 1;
            } //Hitbox da seleção simples
            if ((crt.getX() > 92 && crt.getY() > 10) && (crt.getX() <= 151 && crt.getY() <= 39)) {
                sliga = 2;
            } //Hitbox da seleção simples
            if ((crt.getX() > 164 && crt.getY() > 10) && (crt.getX() <= 223 && crt.getY() <= 39)) {
                sliga = 3;
            } //Hitbox da seleção simples
        }

        public void mouseReleased(MouseEvent e) {

        }
    }
    // Parei nas hitbox, falta pegar os IDs dos elementos e ai os A recebe o id e gg. E ai ao receber o id ele verificar se os envolta tem id!=0, aqueles
    //que tiverem, nos 8 if, tera o campo de ligação respectivo;
}
