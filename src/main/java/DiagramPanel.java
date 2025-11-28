import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

/**
 * A panel rendering a PlantUML diagram from a given UML source string.
 *
 * @author javiergs
 * @version 2.0
 */
public class DiagramPanel extends JPanel {
	
	private BufferedImage image;
	
	public DiagramPanel(String umlSource) {
		setBackground(Color.WHITE);
		if (umlSource == null || umlSource.isBlank()) {
			image = null;
		} else {
			image = renderUmlToImage(umlSource);
		}
		revalidate();
		repaint();
	}
	
	private BufferedImage renderUmlToImage(String umlSource) {
		SourceStringReader reader = new SourceStringReader(umlSource);
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			// Generate the diagram as PNG into the output stream
			reader.outputImage(os, new FileFormatOption(FileFormat.PNG));
			byte[] data = os.toByteArray();
			try (ByteArrayInputStream is = new ByteArrayInputStream(data)) {
				return ImageIO.read(is);
			}
		} catch (IOException e) {
			return null;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, this);
		} else {
			g.setColor(Color.GRAY);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		if (image != null) {
			return new Dimension(image.getWidth(), image.getHeight());
		}
		return super.getPreferredSize();
	}
}