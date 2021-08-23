
public class Resolution {
	private int height;
    private int width;
    
    //no parameters constructor
    Resolution() {
    	height = 0;
    	width = 0;
    }
    
    //constructor with two parameters
    Resolution(int height, int width) {
    	this.height = height;
    	this.width = width;
    }
    
    //getter and setter for height
    public int getHeight() {
    	return height;   
    }  
    public void setHeight(int height) {
    	this.height = height;
    }
    
    //getter and setter for width
    public int getWidth() {
    	return width;
    }
    public void setWidth(int width) {
    	this.width = width;
    }
}
