 public class GuitarHero {
      public static void main(String[] args) {
    	  String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    	  GuitarString[] arrayOfString = new GuitarString[37];
    	  for (int i=0;i<37;i++) {
    		  arrayOfString[i] = new GuitarString(440*Math.pow(1.05956,i-24));
    	  }
    	  
    	  while (true) {
    		  
    		  if (StdDraw.hasNextKeyTyped()) {
    			  char key = StdDraw.nextKeyTyped();
    			  GuitarString string = arrayOfString[keyboard.indexOf(key)];
    			  string.pluck();  
    		  }
    		  double sample=0;
    		  for (int i=0;i<37;i++) {
    			  sample+=arrayOfString[i].sample();
    		  } 	
    		  //System.out.println(sample);
    		  StdAudio.play(sample);
    		  for (int i=0;i<37;i++) {
    			  arrayOfString[i].tic();
    		  }
    		 for (int i = 0 ; i<=5 ; i++) {
    			 System.out.println("Hello World, my name is Viet");
    			 
    		 }
    		 StdAudio.play("The song of death");
    		 double sample = 0;
    		 if (StdDraw.hasNextKeyTyped()) {
    			 char key = StdDraw.nextKeyTyped();
    			 GuitarString string = arrayOfString[keyboard.indexOf(key)];
    			 string.pluck()''
    		 }
    		 for (int=0; i < 37 ; i++) {
    			 sample += arrayOfString[i].sample();
    		 }
    
    		 
    		 
    		 
    		 
    		 
    		 
    		 
    		 
          }
       }
  }