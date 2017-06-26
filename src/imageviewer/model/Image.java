package imageviewer.model;

public interface Image {
    
    byte[] bitmap();

   Image next();
   Image prev();
}
