import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private Resolution size;
    BufferedImage img;
    

    //getter & setter for size
    public Resolution getSize() {
        return size;  
    } 
    public void setSize(Resolution size) {
        this.size = size;
    }

    //getter & setter for Image
    public BufferedImage getImg() {
    
        return img;
    }
    public void setImg(BufferedImage img) {

        this.img = img;
    }

    //constructor
    public Image(String name) throws InterruptedException {
        try
        {
            File input = new File(name); //name este numele fisierului. se creeaza un obiect de tip File ce va fi prelucrat
            img = ImageIO.read(input); //pentru citirea din fisier se foloseste o metoda din clasa ImageIO
            size = new Resolution(img.getHeight(), img.getWidth()); //luam dimensiunile imaginii
        }

        catch (IOException e) //tratarea exceptiilor
        {
            System.out.println("Fisierul nu exista.");
            System.exit(0);
        }
    }

    //constructor no parameters
    public Image()  {
        size = new Resolution(img.getHeight(), img.getWidth());
    }

    public void writeInFile(String path)  throws InterruptedException { //pentru obtinerea rezultatului in urma transformarii
        try {
            ImageIO.write(img, "BMP", new File(path)); //se scrie rezultatul in fisierul dat
        }
        catch (IOException e) //tratarea exceptiilor
        {
            System.out.println("Fisierul nu exista.");
            System.exit(0);
        }
    }
    }
