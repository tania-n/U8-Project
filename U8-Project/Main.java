class Main {
  public static void main( String args[])
  { 
    
    Picture flower = new Picture("images/flower.jpg"); 
    Picture f = flower.scale(0.50, 0.50); 
    f.write("smallFlower.jpg"); 
    f.explore(); 
    f.mirrorHorizontal();
    f.explore(); 
  }
}  