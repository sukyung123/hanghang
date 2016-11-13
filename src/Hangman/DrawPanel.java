package Hangman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import javax.swing.*;

class DrawPanel extends JPanel {
	private int stage = 0;
	DrawPanel(){
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(5,5,5,5), 
				BorderFactory.createLineBorder(Color.RED)));			
	}
	public Dimension getPreferredSize() {
		return new Dimension(90,120);
	}
	boolean drawNext() {
		stage++;
		repaint();
		if(stage > 6)
			return true;
		return false;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawLine(20,110,80,110);
		g.drawLine(70,10,70,110);
		g.drawLine(30,10,70,10);
		g.drawLine(30,10,30,30);
		
		if(stage > 0)
			g.drawOval(20, 30, 20, 20);
		if(stage > 1)
			g.drawLine(30, 50, 30, 80);
		if(stage > 2)
			g.drawLine(30, 58, 10, 50);
		if(stage > 3)
			g.drawLine(30, 58, 50, 50);
		if(stage > 4)
			g.drawLine(30, 80, 10, 100);
		if(stage > 5)
			g.drawLine(30, 80, 50, 100);
	}
	void reset() {
		stage = 0;
		repaint();
	}
}
class MyFrame extends JFrame {
	MyFrame() {
		setTitle("My Frame");
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel(), BorderLayout.CENTER);
		setVisible(true);
	}
}
class MyPanel extends JPanel implements ActionListener {
	private DrawPanel dp;
	private JButton btn;
	MyPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(dp = new DrawPanel());
		JPanel p = new JPanel();
		p.add(btn = new JButton("OK"));
		add(p);
		btn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (dp.drawNext())
			dp.reset();
	}
}
