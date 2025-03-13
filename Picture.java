import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }

  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;

  }

  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  } 

  // sets red and green to 0 
  public void keepOnlyBlue(){ 
    Pixel[][] pixels = this.getPixels2D(); 
    for(Pixel[]  rowArray : pixels){ 
      for(Pixel pixelObj : rowArray){ 
        pixelObj.setRed(0); 
        pixelObj.setGreen(0);  
      }
    }
  } 

  public void negate(){ 
    Pixel[][] pixels = this.getPixels2D(); 
    for(Pixel[] rowArray : pixels){ 
      for(Pixel pixelObj : rowArray){ 
        // substracts the red, green, and blue values from 255 
        // sets red, green, and blue to the next values 
        pixelObj.setRed(255 - pixelObj.getRed()); 
        pixelObj.setGreen(255 - pixelObj.getGreen()); 
        pixelObj.setBlue(255 - pixelObj.getBlue()); 
      }
    }
  } 

  public void greyscale(){ 
    Pixel[][] pixels = this.getPixels2D(); 
    for(Pixel[] rowArray : pixels){  
      int temp = 0; 
      for(Pixel pixelObj : rowArray){ 
        // adds up the values of red, green, and blue and divides by 3 
        // sets value to temp 
        temp = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3; 
        // sets red, green, and blue to the new value 
        pixelObj.setRed(temp); 
        pixelObj.setGreen(temp); 
        pixelObj.setBlue(temp); 
      }
    }
  } 

  public void fixUnderWater(){ 
    Pixel[][] pixels = this.getPixels2D(); 
    for(Pixel[] rowArray : pixels){ 
      for(Pixel pixelObj : rowArray){ 
        // decreases red, green, and blue 
        pixelObj.setRed(pixelObj.getRed() - 90); 
        pixelObj.setGreen(pixelObj.getGreen() - 70); 
        pixelObj.setBlue(pixelObj.getBlue() - 60); 
      }
    }
  }

  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {

        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  } 

   // Mirrors picture from right to left 
  public void mirrorVerticalRightToLeft(){ 
    Pixel[][] pixels = this.getPixels2D(); 
    int width = pixels[0].length; 
    Pixel leftPixel = null; 
    Pixel rightPixel = null; 
    for(int row = 0; row < pixels.length; row++){ 
      for(int col = 0; col < width / 2; col++){ 
        leftPixel = pixels[row][col];  
        rightPixel = pixels[row][width - 1 - col];   
        leftPixel.setColor(rightPixel.getColor()); 

      }
    }
  } 

  // Mirrors picture from top to bottom 
  public void mirrorHorizontal(){ 
    Pixel[][] pixels = this.getPixels2D();
    Pixel bottomPixel = null;
    Pixel topPixel = null;
    int height = pixels.length;
    for(int row = 0; row < height / 2; row++){ 
      for(int col = 0; col < pixels[0].length; col++){ 
        bottomPixel = pixels[row][col]; 
        topPixel = pixels[height - 1 - row][col]; 
        topPixel.setColor(bottomPixel.getColor()); 
      } 
    }
  } 

  // Mirrors picture from bottom to top 
  public void mirrorHorizontalBotToTop(){ 
    Pixel[][] pixels = this.getPixels2D();
    Pixel bottomPixel = null;
    Pixel topPixel = null; 
    int height = pixels.length; 
    for(int row = 0; row < height / 2; row++){ 
      for(int col = 0; col < pixels[0].length; col++){ 
        bottomPixel = pixels[row][col]; 
        topPixel = pixels[height - 1 - row][col]; 
        bottomPixel.setColor(topPixel.getColor()); 
      }
    }
  } 

  // Mirrors arms on snowman 
  public void mirrorArms(){ 
    int mirrorPoint = 190; 
    Pixel leftPixel = null; 
    Pixel rightPixel = null; 
    Pixel[][] pixels = this.getPixels2D(); 

    // Loop2 from 155 to 189
    for(int row = 155; row < mirrorPoint; row++){  
      for(int col = 100; col < 170; col++){ 
        leftPixel = pixels[row][col]; 
        rightPixel = pixels[mirrorPoint - row + mirrorPoint][col]; 
        rightPixel.setColor(leftPixel.getColor()); 
      }
    } 
    mirrorPoint = 195;
    // Loops from 165 to 194
    for(int row = 165; row < mirrorPoint; row++){ 
      for(int col = 230; col < 300; col++){ 
        leftPixel = pixels[row][col]; 
        rightPixel = pixels[mirrorPoint - row + mirrorPoint][col]; 
        rightPixel.setColor(leftPixel.getColor()); 
      }
    } 
  }

  // Mirrors the seagull so theres two in the picture 
  public void mirrorGull(){ 
    int mirrorPoint = 350; 
    Pixel leftPixel = null; 
    Pixel rightPixel = null; 
    Pixel[][] pixels = this.getPixels2D(); 

    for(int row = 234; row < 327; row++){ 
      for(int col = 230; col < mirrorPoint; col++){ 
        leftPixel = pixels[row][col]; 
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint]; 
        rightPixel.setColor(leftPixel.getColor()); 
      }
    }
  }
  
  // Mirrors a square part of the picture from bottom left to top right 
  public void mirrorDiagonal(){ 
    Pixel[][] pixels = this.getPixels2D();
    Pixel bottomPixel = null;
    Pixel topPixel = null; 
    Pixel temp = null; 
    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels.length; col++){ 
        bottomPixel = pixels[row][col]; 
        topPixel = pixels[col][row]; 
        bottomPixel.setColor(topPixel.getColor()); 
      }
    } 
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }


  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

} // this } is the end of class Picture, put all new methods before this

