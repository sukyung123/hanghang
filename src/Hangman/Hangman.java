package Hangman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Hangman extends JFrame implements ActionListener{
	public static void main(String[] args) {
		new Hangman();
	}
	Hangman() {
		setSize(400,170);
		setTitle("Hangman");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		makeUI();
		setVisible(true);
	}
	static final int COUNT = 6;
	private WordPanel wp;
	private CountPanel cp;
	private JTextField tf;
	private DrawPanel dp;
	private MissPanel mp;
	private Words words;
	private void makeUI() {
		words = new Words();
		wp = new WordPanel();
		wp.setWord(words.getWord());
		cp = new CountPanel();
		cp.setCount(COUNT);
		
		JPanel gp = new JPanel();
		gp.add(new JLabel("Guess : "));
		gp.add(tf = new JTextField(1));
		tf.addActionListener(this);
		
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(4,1));
		right.add(wp);
		right.add(gp);
		right.add(mp = new MissPanel());
		right.add(cp);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		add(dp = new DrawPanel());
		add(right);
	}
	public void actionPerformed(ActionEvent e) {
		char c = tf.getText().charAt(0);
		tf.setText("");
		if(wp.match(c) == false){
			mp.add(c);
			dp.drawNext();
			if(cp.decrement() == 0){
			JOptionPane.showMessageDialog(this, "MissionFailed T^T\n" +  wp.getWord());
			reset();
		}
		}
		else if(wp.isAllMatched()){
			JOptionPane.showMessageDialog(this, "MissionSuccess ^*^\n" + wp.getWord());
			reset();
	}
	}
	private void reset() {
		wp.setWord(words.getWord());
		cp.setCount(6);
		dp.reset();
		mp.reset();
	}
	
}