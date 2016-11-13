package Hangman;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
class CountPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lb_cnt;
	private int count;
	CountPanel() {
		add(new JLabel("Count Down : "));
		add(lb_cnt = new JLabel());
	}
	void setCount(int count) {
		lb_cnt.setText(String.valueOf(this.count =count));
	}
	int decrement() {
		lb_cnt.setText(String.valueOf(--count));
		return count;
	}
}
class MyPanel extends JPanel implements ActionListener {
	private CountPanel cp;
	private JButton btn;
	MyPanel() {
		setLayout(new GridLayout(2,1));
		add(cp = new CountPanel());
		JPanel p = new JPanel();
		p.add(btn = new JButton("OK"));
		add(p);
		cp.setCount(10);
		btn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(cp.decrement()<=0)
			btn.setEnabled(false);
	}
}
