package Main;
import java.awt.*;
import javax.swing.*;

import GameMedia.Media;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		JFrame window = new JFrame("Lunar Lander");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);			
	}
}
