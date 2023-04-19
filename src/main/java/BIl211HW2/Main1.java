package BIl211HW2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Main1 {
	static long startTime;
	static long endTime;
	static long oyun_suresi;
	static boolean oyun_bitti_mi = false;
	static Thread[] myThreads = new Thread[4];

	public static void main(String args[]) {

		Main1 m = new Main1();

		myThreads[0] = new Thread(new Runnable() {
			JLabel nesne = mavi_nesne;
			int wait_mil_sec = 500;
			String priority = "x";

			public void run() {
				startTime = System.currentTimeMillis();
				takip_et(nesne, wait_mil_sec, priority, this);

				endTime = System.currentTimeMillis();
				m.new SkorEkrani();

			}
		});
		myThreads[1] = new Thread(new Runnable() {
			JLabel nesne = yesil_nesne;
			int wait_mil_sec = 750;
			String priority = "y";

			public void run() {

				takip_et(nesne, wait_mil_sec, priority, this);
			}
		});
		myThreads[2] = new Thread(new Runnable() {
			JLabel nesne = kirmizi_nesne;
			int wait_mil_sec = 1000;
			String priority = "y";

			public void run() {

				takip_et(nesne, wait_mil_sec, priority, this);

			}
		});
		myThreads[3] = new Thread(new Runnable() {
			JLabel nesne = turuncu_nesne;
			int wait_mil_sec = 1250;
			String priority = "x";

			public void run() {

				takip_et(nesne, wait_mil_sec, priority, this);

			}
		});

		for (Thread thread : myThreads) {
			thread.start();

		}

	}

	public static void takip_et(JLabel nesne, long l, String priority, Runnable thread) {

		if (priority == "x") {
			try {

				while (!oyun_bitti_mi) {
					if (kacan_nesne.getX() == nesne.getX()) {
						if (kacan_nesne.getY() == nesne.getY()) {
							oyun_bitti_mi = true;
							endTime = System.currentTimeMillis();
							break;
							// GAME OVER
						} else if (kacan_nesne.getY() < nesne.getY()) {
							nesne.setLocation(nesne.getX(), nesne.getY() - 10);
						} else {
							nesne.setLocation(nesne.getX(), nesne.getY() + 10);
						}
					} else if (kacan_nesne.getX() < nesne.getX()) {
						nesne.setLocation(nesne.getX() - 10, nesne.getY());
					} else {
						nesne.setLocation(nesne.getX() + 10, nesne.getY());
					}
					synchronized (thread) {
						thread.wait(l);
					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (priority == "y") {
			try {

				while (!oyun_bitti_mi) {
					if (kacan_nesne.getY() == nesne.getY()) {
						if (kacan_nesne.getX() == nesne.getX()) {
							// Game Over
							oyun_bitti_mi = true;
							endTime = System.currentTimeMillis();
							break;
						}else if (kacan_nesne.getX() < nesne.getX()) {
							nesne.setLocation(nesne.getX() - 10, nesne.getY());
						}else {
							nesne.setLocation(nesne.getX() + 10, nesne.getY());
						}
					}
					else if (kacan_nesne.getY() < nesne.getY()) {
						nesne.setLocation(nesne.getX(), nesne.getY() - 10);
					} else {
						nesne.setLocation(nesne.getX(), nesne.getY() + 10);
					}
					synchronized (thread) {
						thread.wait(l);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
		}
	}

	static JLabel yesil_nesne = new JLabel();
	static JLabel turuncu_nesne = new JLabel();
	static JLabel mavi_nesne = new JLabel();
	static JLabel kacan_nesne = new JLabel();
	static JLabel kirmizi_nesne = new JLabel();
	MyFrame frame = new MyFrame();

	Main1() {

		kacan_nesne.setBackground(Color.BLACK);
		kacan_nesne.setOpaque(true);

		mavi_nesne.setBackground(Color.BLUE);
		mavi_nesne.setOpaque(true);

		kirmizi_nesne.setBackground(Color.RED);
		kirmizi_nesne.setOpaque(true);

		turuncu_nesne.setBackground(Color.ORANGE);
		turuncu_nesne.setOpaque(true);

		yesil_nesne.setBackground(Color.GREEN);
		yesil_nesne.setOpaque(true);

		yesil_nesne.setBounds(490, 490, 10, 10);
		mavi_nesne.setBounds(490, 0, 10, 10);
		kirmizi_nesne.setBounds(0, 0, 10, 10);
		turuncu_nesne.setBounds(0, 490, 10, 10);
		kacan_nesne.setBounds(250, 250, 10, 10);

	}

	class MyFrame extends JFrame implements KeyListener {
		boolean bool = true;

		MyFrame() {
			setSize(500, 520);
			setResizable(false);
			setLayout(null);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setVisible(true);

			addKeyListener(this);
			add(yesil_nesne);
			add(mavi_nesne);
			add(kirmizi_nesne);
			add(turuncu_nesne);
			add(kacan_nesne);
		}

		public void keyTyped(KeyEvent e) {

		}

		public void keyPressed(KeyEvent e) {

			switch (e.getKeyCode()) {
			case 37:

				if (kacan_nesne.getX() != 0 && !oyun_bitti_mi && bool)
					kacan_nesne.setLocation(kacan_nesne.getX() - 10, kacan_nesne.getY());

				break;
			case 38:

				if (kacan_nesne.getY() != 0 && !oyun_bitti_mi && bool)
					kacan_nesne.setLocation(kacan_nesne.getX(), kacan_nesne.getY() - 10);

				break;
			case 39:

				if (kacan_nesne.getX() != 490 && !oyun_bitti_mi && bool)
					kacan_nesne.setLocation(kacan_nesne.getX() + 10, kacan_nesne.getY());

				break;
			case 40:

				if (kacan_nesne.getY() != 490 && !oyun_bitti_mi && bool)
					kacan_nesne.setLocation(kacan_nesne.getX(), kacan_nesne.getY() + 10);

				break;

			}
			bool = false;

		}

		public void keyReleased(KeyEvent e) {
			bool = true;
		}

	}

	class SkorEkrani {
		JLabel yazi = new JLabel();
		JFrame innerFrame = new JFrame();
		JButton kapat = new JButton("Kapat");

		SkorEkrani() {
			oyun_suresi = endTime - startTime;
			yazi.setText(String.format("Skorunuz: %.0f saniye", (double) oyun_suresi / 1000));
			yazi.setFont(new Font("MV Boli", Font.PLAIN, 20));
			innerFrame.setSize(300, 200);
			innerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			innerFrame.setLayout(null);
			kapat.addActionListener(new myInnerActionListener());
			innerFrame.add(yazi);
			yazi.setBounds(45, 30, 250, 70);
			innerFrame.add(kapat);
			kapat.setBounds(200, 120, 70, 20);
			innerFrame.setVisible(true);

		}

		class myInnerActionListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				innerFrame.dispose();
				frame.dispose();
			}
		}
	}
}
