import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

/**
 * An example demonstrating the use of UMLPanel to render PlantUML diagrams.
 *
 * @author javiergs
 * @version 2.0
 */
public class Driver extends JFrame {
	
	private final String UML =
		"@startuml\n" +
			"!pragma layout smetana\n" +
			
			"class Whiteboard\n" +
			"abstract class Person\n" +
			"class Student\n" +
			"class Professor\n" +
			"class Car\n" +
			"class Engine\n" +
			"class Wheel\n" +
			"interface Listener\n" +
			
			"Student --|> Person\n" +
			"Professor --|> Person\n" +
			"Professor ..|> Listener\n" +
			"Person --> Whiteboard\n" +
			"Student o-- Car \n" +
			"Car *-- Engine \n" +
			"Car o-- \" 4  \" Wheel \n" +
		
		"@enduml";
	
	public Driver() {
		setLayout(new GridLayout(1, 1));
		DiagramPanel diagramPanel = new DiagramPanel(UML);
		JScrollPane scrollPanel = new JScrollPane(diagramPanel);
		add(scrollPanel);
	}
	
	public static void main(String[] args) {
		Driver frame = new Driver();
		frame.setTitle("PlantUML Diagram Rendering");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}