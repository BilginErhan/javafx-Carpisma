/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafilfinal2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ERHAN
 */
class top{
    public int x,y;
    
    public top()
    {
        x=0;y=0;
    }
}
class Board extends JPanel implements ActionListener
{
    top t1,t2;
     
    Timer timer;
    public int DELAY = 10;
    
    public int sayac=0;
    public Board()
    {
        t1 = new top();
        t2 = new top();
        timer = new Timer(DELAY, this);
        timer.start();
    }
    private void doDrawing(Graphics g)
    {
        if(sayac==0)
        {
            t1.x=100;
            t2.x=getWidth()-100;
            sayac=1;
        }
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setPaint(Color.red);
        g2d.fillOval(t1.x, 50, 50, 50);
        g2d.fillOval(t2.x, 50, 50, 50);
        System.out.println("t1 = " + t1.x + " t2 = " + t2.x);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        doDrawing(g);
    }
    public void move()
    {
        t1.x+=1;
        t2.x+=-1;
        
    }
    public int carpisma()
    {
        if(Math.abs(t1.x-t2.x)<=50)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int carpis = carpisma();
        if(carpis==0)
        {
            move();
        }
        repaint();
    }
    
}
public class GrafilFinal2 extends JFrame{

    /**
     * @param args the command line arguments
     */
    public GrafilFinal2()
    {
        Board board = new Board();
        add(board);
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        GrafilFinal2 gf2 = new GrafilFinal2();
        gf2.setVisible(true);
    }
    
}
