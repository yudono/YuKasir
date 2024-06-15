package lib;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageScaler {
    private JPanel panel;
    private JLabel label;
    private String url;
    private int padding;

    public ImageScaler(JPanel panel, JLabel label, String url, int padding) {
        this.panel = panel;
        this.label = label;
        this.url = url;
        this.padding = padding;

        // Add a component listener to the panel to listen for resize events
        this.panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                scaleAndSetImage(); // Recalculate and set image on resize
            }
        });

        scaleAndSetImage(); // Initial setup
    }

    public ImageScaler(JPanel panel, JLabel label, String url) {
        this(panel, label, url, 0); // Default padding is 0
    }

    private void scaleAndSetImage() {
        // Load the image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(this.url));
        Image image = imageIcon.getImage();

        // Get dimensions of JPanel
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();

        // If panelWidth or panelHeight is 0, JPanel is not yet displayed
        if (panelWidth == 0 || panelHeight == 0) {
            return; // Cannot calculate size yet
        }

        // Calculate the aspect ratio of the original image
        int imageWidth = imageIcon.getIconWidth();
        int imageHeight = imageIcon.getIconHeight();
        double imageAspectRatio = (double) imageWidth / imageHeight;

        // Calculate the available width for the scaled image (considering padding)
        int availableWidth = panelWidth - this.padding;

        // Calculate the scaled width and height based on the panel width and aspect ratio
        int scaledWidth = availableWidth;
        int scaledHeight = (int) (scaledWidth / imageAspectRatio);

        // Ensure the scaled height does not exceed the panel height (considering padding)
        if (scaledHeight > panelHeight - this.padding) {
            scaledHeight = panelHeight - this.padding;
            scaledWidth = (int) (scaledHeight * imageAspectRatio);
        }

        // Scale the image
        Image scaledImage = image.getScaledInstance(panelWidth - padding, scaledHeight, Image.SCALE_SMOOTH);

        // Set the scaled image as the icon of the JLabel
        label.setIcon(new ImageIcon(scaledImage));

        // Resize the label to match the scaled image dimensions
        label.setSize(panelWidth - padding, scaledHeight);
        label.setPreferredSize(label.getSize()); // Ensure preferred size matches actual size
    }
}
