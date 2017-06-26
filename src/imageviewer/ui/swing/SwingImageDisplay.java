package imageviewer.ui.swing;

import imageviewer.model.Image;
import imageviewer.ui.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay{

    private Image image;

    public SwingImageDisplay() {
        super(new BorderLayout());
    }
    
    @Override
    public void display(Image image) {
        this.image = image;
        this.removeAll();
        this.add(imagePanel());
        this.updateUI();
        
    }

    private Component imagePanel() {
    
        return new JPanel(){
            @Override
            public void paint(Graphics g) {
                 g.drawImage(bitmap(), 0, 0, this.getWidth(),this.getHeight(),null);
            }
            private java.awt.Image bitmap(){
                try {
                    return ImageIO.read(new ByteArrayInputStream(image.bitmap()));
                } catch (IOException ex) {
                    return null;
                }
            }
            
        };
    
    }

    @Override
    public Image currentImage() {
        return image;
    }
    
}
