/*
 *  Name: ImageBuilder
 *  Date: 1/23/2020
 *  Author: Sean Filer
 *  Purpose: Build an image based off a 2D array of integers.
 */
package computergraphicsproject1;
import java.awt.*;
import java.awt.image.*;
/**
 *
 * @author Sean
 */
public class ImageBuilder {

    private int imgSizeX;
    private int imgSizeY;
    
    public ImageBuilder(int sizeX, int sizeY){
        
        imgSizeX = sizeX;
        imgSizeY = sizeY;
    }
    
    public void setImageSize(int sizeX, int sizeY){
        imgSizeX = sizeX;
        imgSizeY = sizeY;
    }
    
    public BufferedImage buildImage(int[][] imageArray){
        int pixelValue;
        BufferedImage image = new BufferedImage(imgSizeX, imgSizeY, BufferedImage.TYPE_INT_RGB);
        for(int x = 0; x < imgSizeX; x++){
            for(int y = 0; y < imgSizeY; y++){
                pixelValue = imageArray[x][y];
                switch(pixelValue){
                    case 0:
                        pixelValue = Color.BLUE.getRGB();
                        break;
                    case 1:
                        pixelValue = Color.ORANGE.getRGB();
                        break;
                    default:
                        break;
                }
                image.setRGB(x, y, pixelValue);
            }
        }
        return image;
    }
    
    public int[][] generateBox2DArray(){
        int[][] box2DArray = new int[imgSizeX][imgSizeY];
        int pixelValue;
        
        for(int x = 0; x < imgSizeX; x++){
            if(x < 3 || x > 21){
                pixelValue = 1;
                for(int y = 0; y < imgSizeY; y++){
                    box2DArray[x][y] = pixelValue;
                }
            } else {
                for(int y = 0; y < imgSizeY; y++){
                    if(y < 3 || y > 21){
                        pixelValue = 1;
                    } else {
                        pixelValue = 0;
                    }
                    box2DArray[x][y] = pixelValue;
                }
            }
        }
        
        return box2DArray;
    }
    
    public int[][] generateTriangle2DArray(){
        int[][] triangle2DArray = new int[imgSizeX][imgSizeY];
        int pixelValue;
        int blankPixels = imgSizeX - 1;
        boolean secondRow = false;
        
        for(int y = imgSizeY - 1; y >= 0; y--){
            for(int x = 0; x < imgSizeX; x++){
                if(x > blankPixels/2 && x < imgSizeY - blankPixels/2){
                    pixelValue = 1;
                } else {
                    pixelValue = 0;
                }
                triangle2DArray[x][y] = pixelValue;
            }
            if(secondRow){
                blankPixels -= 2;
                secondRow = false;
            } else {
                secondRow = true;
            }
            
        }
        return triangle2DArray;
    }
    
    public int[][] generateDiamond2DArray(){
        int[][] diamond2DArray = new int[imgSizeX][imgSizeY];
        int pixelValue;
        int blankPixels = imgSizeX - 1;
        boolean secondHalf = false;
        
        for(int y = 0; y < imgSizeY; y++){
            for(int x = 0; x < imgSizeX; x++){
                if(x >= blankPixels/2 && x < imgSizeY - blankPixels/2){
                    pixelValue = 1;
                } else {
                    pixelValue = 0;
                }
                diamond2DArray[x][y] = pixelValue;
            }
            if(blankPixels == 0){
                secondHalf = true;
            }
            
            if(secondHalf){
                blankPixels += 2;
            } else {
                blankPixels -= 2;
            }
        }
        return diamond2DArray;
    }
}
