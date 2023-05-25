/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import javax.swing.JFrame;

/**
 *
 * @author nicol
 */
public class jFrame extends JFrame {


    public jFrame() {
        this.add(new Tela());
        this.setTitle("ProtoII");
        this.setSize(1600, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new jFrame();
    }

}
