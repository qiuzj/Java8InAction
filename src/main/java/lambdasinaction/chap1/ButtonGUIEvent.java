package lambdasinaction.chap1;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ButtonGUIEvent {
	public static void main(String[] args) {
		Button button = new Button("Send");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// do something
			}
		});

		List<Apple> inventory = new ArrayList<>();
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});

		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello world");
			}
		});

	}
}
