package imageviewer;

import imageviewer.control.NextImageCommand;
import imageviewer.control.PrevImageCommand;
import imageviewer.persistence.ImageLoader;
import imageviewer.persistence.files.FileImageLoader;


public class Main {

    public static void main(String[] args) {
        ImageLoader imageLoader = new FileImageLoader("images");
        MainFrame mainFrame = new MainFrame();
        mainFrame.add(new NextImageCommand(mainFrame.getImageDisplay()));
        mainFrame.add(new PrevImageCommand(mainFrame.getImageDisplay()));
        mainFrame.getImageDisplay().display(imageLoader.load());
                
    }

   
}
