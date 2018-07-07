package lambdasinaction.chap1;

public class ButtonGUIEvent {
	public static void main(String[] args) {
		Button button = new Button("Send");
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				label.setText("Sent!!");
			}
		});

inventory.sort(new Comparator<Apple>() {
	public int compare(Apple a1, Apple a2) {
		return a1.getWeight().compareTo(a2.getWeight());
	}
});

Thread t = new Thread(new Runnable() {
    public void run{
        System.out.println("Hello world");
    }
});


	}
}
