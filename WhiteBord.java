package Graphics;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
public class WhiteBord extends JFrame {

	
	private BordPanel p=new BordPanel();
	
	
	Color c=Color.black;
	String shape="line";
	
	public WhiteBord() {
		
		add(p);
	}
	class ButtonsPanel extends JPanel{
		JButton red =new JButton("RED");
		JButton blue=new JButton("BLUE");
		JButton erase=new JButton("ERASE");
		JButton new1=new JButton("NEW");
		
	  public ButtonsPanel(){
			
			setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
			red.setBackground(Color.RED);
			blue.setBackground(Color.BLUE);
			erase.setBackground(Color.white);
			
			red.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						   
						c=Color.red;
						shape="line";
						}
					}
					);
			blue.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							c=Color.blue;
							shape="line";
						}
					}
					);
			erase.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							c=p.getBackground();
							shape="rectangle";
						}
					}
					);
			
			new1.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							restart();
						}
					}
					);
			add(red);
			add(blue);
			add(erase);
			add(new1);
			setBackground(Color.WHITE);
		}
	}
	class BordPanel extends JPanel{
		
		int x1=0;
		int y1=0;
		int x2=0;
		int y2=0;
		ButtonsPanel b=new  ButtonsPanel();
		public BordPanel() {
			
			setLayout(new BorderLayout(5,5));
			addMouseListener(
					new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							
							x1=e.getX();
							y1=e.getY();
							x2=x1;
							y2=y1;
							
							repaint();
							
						}
					}
					);
			addMouseMotionListener(
					new MouseMotionAdapter() {
						public void mouseDragged(MouseEvent e) {
							x1=x2;
							y1=y2;
							x2=e.getX();
							y2=e.getY();
							
							repaint();
							
						}
					}
					
					);
			add(b,BorderLayout.NORTH);
			setBackground(Color.white);
		}
		
	protected void paintComponent(Graphics g)
		{
	      g.setColor(c); 
		  if(shape=="line")
			g.drawLine(x1, y1, x2, y2);
		  else {
			g.drawRect(x2, y2,30, 30);
			g.fillRect(x2, y2, 30, 30);
		  }
		}
		
		
	}
	public void restart() {
		this.repaint();
	}
   
	public static void main(String[] args) {
		
	    WhiteBord B=new WhiteBord();
		B.setTitle("White Bord");
		B.setSize(600,600);
		B.setLocationRelativeTo(null);
		B.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		B.setVisible(true);
		B.setBackground(Color.WHITE);
		
	}
	
	
	
}
