package Hangman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import javax.swing.*;

class WordPanel extends JPanel {
	private JTextField tf;
	private String word;
	private int len;
	private char[] buf;
	WordPanel() {
		add(new JLabel("Word : "));
		add(tf = new JTextField(12));
		tf.setEditable(false);
		tf.setHorizontalAlignment(JTextField.CENTER);
	}
	void setWord(String word) {
		this.word = word;
		len = word.length();
		buf = new char[len];
		for(int i=0; i<len; i++)
			buf[i] = '_';
		tf.setText(new String(buf));
	}
	String getWord() {
		return word;
	}
	int getWordLength() {
		return len;
	}
	boolean match(char c) {
		boolean found = false;
		for (int i=0; i<len; i++)
			if(word.charAt(i) == c) 
				buf[i] = c;
				found = true;
		tf.setText(new String(buf));
		return found;
	}
	boolean isAllMatched() {
		for(int i=0; i<len; i++)
			if(buf[i] == '_')
				return false;
		return true;
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
	private WordPanel wp;
	private JButton btn;
	private String s = "programming";
	private int cnt;
	MyPanel() {
		setLayout(new GridLayout(2,1));
		add(wp = new WordPanel());
		wp.setWord(s);
		JPanel p = new JPanel();
		p.add(btn = new JButton("OK"));
		add(p);
		btn.addActionListener(this);
		if(wp.getWordLength() != s.length())
			btn.setEnabled(false);
	}
	public void actionPerformed(ActionEvent e) {
		if (wp.isAllMatched()) {
			wp.setWord(s);
			cnt = 0;
		}
		else if (!wp.match(s.charAt(cnt++)))
			btn.setEnabled(false);
	}
}