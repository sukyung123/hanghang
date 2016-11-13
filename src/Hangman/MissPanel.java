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
class MyPanel extends JPanel implements ActionListener {
	private MissPanel mp;
	private JButton btn;
	private String s = "programming";
	private int cnt = 0;
	MyPanel() {
		setLayout(new GridLayout(2,1));
		add(mp = new MissPanel());
		JPanel p = new JPanel();
		p.add(btn = new JButton("OK"));
		add(p);
		btn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(cnt<s.length())
			mp.add(s.charAt(cnt++));
		else {
			mp.reset();
			cnt = 0;
		}
		
	}
}

class MissPanel extends JPanel {
	private JLabel misses;
	private boolean[] flag;
	static final int NUM_ALPHA = 26;
	MissPanel() {
		add(new JLabel ("Misses : "));	
		add(misses = new JLabel());
		flag = new boolean[NUM_ALPHA];
	}
	void add (char c) {
		flag[c-'a'] = true;
		misses.setText(scan());
	}
	void reset() {
		misses.setText("");
		for(int i=0; i<NUM_ALPHA; i++)
			flag[i] = false;
	}
	private String scan() {
		int i,j, len = 0;
		for (i=0; i<NUM_ALPHA; i++)
			if(flag[i] == true)
				len++;
		char[] buf = new char[len*2];
		for (i=j=0;i<NUM_ALPHA;i++)
			if(flag[i] == true) {
				buf[j++] = (char) (i + 'a');
				buf[j++] = ' ';
			}
	return new String(buf);
	}
}