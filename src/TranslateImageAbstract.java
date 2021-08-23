
public abstract class TranslateImageAbstract implements TranslateImageInterface{
	protected int x; //variabila pentru translatia pe OX
	protected int y; //variabila pentru translatia pe OY
    protected Image img;  //variabila pentru imagine

    //constructor cu parametri
    public TranslateImageAbstract(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    //getter & setter for x
    public void setX(int x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }
    
  //getter & setter for y
    public void setY(int y) {
        this.y = y;
    }
    public double getY() {
        return y;
    }

    //getter & setter for image
    public Image getImg() {
        return img;
    }
    public void setImg(Image img) {
        this.img = img;
    }
    
   
    //nu implementeaza functia 
    public abstract Image translateImage();
}
