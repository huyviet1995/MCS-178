 public class GuitarHeroVisualizer {
      public static void main(String[] args) {
    	  String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    	  GuitarString[] arrayOfString = new GuitarString[37];
    	  for (int i=0;i<37;i++) {
    		  arrayOfString[i] = new GuitarString(440*Math.pow(1.05956,i-24));
    		  
    	  }
    	  int radius=10;
    	  StdDraw.setXscale(-radius,radius);
		  StdDraw.setYscale(-radius,radius);
		  
    	  while (true) {
    		  
    		  if (StdDraw.hasNextKeyTyped()) {
    			  char key = StdDraw.nextKeyTyped();
    			  GuitarString string = arrayOfString[keyboard.indexOf(key)];
    			  string.pluck();  
    			  
    			  //visualize it on the screen
    			  for (int i = 0; i<string; i++)
    			  {
    				  
    			  }
    			  
    		  }
    		  double sample=0;
    		  for (int i=0;i<37;i++) {
    			  sample+=arrayOfString[i].sample();
    		  } 	
    		  //System.out.println(sample);
    		  StdAudio.play(sample);
    		  for (int i=0;i<37;i++) {
    			  arrayOfString[i].tic();
    			  double x=0;
    			  }
    		  }
    		  double y = 
          }
       }
  }