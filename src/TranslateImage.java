
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class TranslateImage extends TranslateImageAbstract{
	//constructor
	public TranslateImage(int x, int y, Image img) {
        super(x, y, img);
    }
	
	//creez o deep-copy a unui obiect de tip BufferedImage
	static BufferedImage deepCopy(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	//aici are loc translatarea propriu-zisa
	public Image translateImage() {
		
		BufferedImage copy = deepCopy(img.getImg());
		BufferedImage copy2 = deepCopy(img.getImg());
		int height = img.getSize().getHeight();		//height si width pentru imaginea primita
		int width = img.getSize().getWidth();
		
		// translatie pe OX pozitiv
		if(x >= 0) { //translatia are loc cu x pixeli - se translateaza coloanele(culorile din elemente)
	        for(int i = width - 1; i >= x; i-- ) {
	            for(int j = 0; j < height; j++ )
	            {
	                int p = img.getImg().getRGB(i - x , j);                  
	                img.getImg().setRGB(i, j, p);	                
	            }
	        }
	        
	        //nu vreau sa pierd informatie si salvez bucata de imagine pierduta in locul unde at fi pixeli
	        //de culoare alba
	        for(int i = 0; i < x; i++) {
	            for(int j = 0; j < height; j++ )
	            {
	                int p = copy.getRGB(width + i - x, j);                  
	                img.getImg().setRGB(i, j, p);	                
	            }
	        }
		}
		
		//translatare pe OX negativ	
		if(x < 0) {
			int positive = -x;
			for(int i = width - 1; i >= positive; i--) {
				for(int j = 0; j < height; j++) {
					int p = copy2.getRGB(i, j); 
					img.getImg().setRGB(i - positive, j, p);
				}
			}
			
			for(int i = 0; i < positive; i++) {
				for(int j = 0; j < height; j++) {
					int p = copy2.getRGB(i, j);
					img.getImg().setRGB(width - positive + i, j, p);
				}
			}
		}
		
		
		BufferedImage copy1 = deepCopy(img.getImg());	//copie a imaginii, deoarece dupa o translatie pe x
		//poate sa vina una pe y -- si trebuie modifica tot imaginea asupra careia a avut loc translatia pe OX
		
		//translatie pe OY pozitiv
		if(y >= 0) {			
			for(int i = 0; i < width; i++) {
				for(int j = height - 1; j >= y; j--) {
					int p = copy1.getRGB(i, j);  
					img.getImg().setRGB(i, j - y, p);
				}
			}
			
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < y; j++) {
					int p = copy1.getRGB(i, j);  
					img.getImg().setRGB(i, height - y + j, p);
				}
			}
		}
		
		//translatie pe OY negativ		
		if(y < 0) {
			int positive = -y;
			for(int i = 0; i < width; i++) {
				for(int j = height - 1; j >= positive; j--) {
					int p = copy1.getRGB(i, j - positive);                  
	                img.getImg().setRGB(i, j, p);
				}
			}
			
			for(int i = 0; i < width; i++) {
	            for(int j = 0; j < positive; j++ ) {
	                int p = copy1.getRGB(i, height - positive + j);                  
	                img.getImg().setRGB(i, j, p);
	                
	            }
	        }		
		}
        
                    
		return img; //returnez imagine cu modificarile date de translatii
	}
}
