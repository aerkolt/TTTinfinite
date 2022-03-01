/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tttinfinite;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author 811001
 */
public class MyButton extends JButton{
    private Character sign;
    private Integer num = 0;
    private Integer row;
    private Integer col;
    public MyButton(int r, int c){
    super();
        this.sign = ' ';
        this.row = r;
        this.col = c;
        this.setBackground(Color.CYAN);
        this.setBounds(10, 10, 10, 10);
        this.setSize(new Dimension(20,20));
    }
    public int getButtonRow(){
    return row;
    }
    public int getButtonCol(){
    return col;
    }
}
