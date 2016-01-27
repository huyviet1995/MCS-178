import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import appropriate library

public class Nbody {
public static void main (String[] args) throws FileNotFoundException {
	double big_t=Double.parseDouble(args[0]);
	double delta_t=Double.parseDouble(args[1]);
	
	String resourceFolder="resources/";
	String fileName = resourceFolder+args[2];
	FileInputStream fileInput = new FileInputStream (fileName);
	
	System.setIn(fileInput);
	
	//initialize all appropriate variables
	int numPlanets=StdIn.readInt();
	double universeRadius=StdIn.readDouble();
	String[] image= new String[numPlanets];
	double[] x_position = new double[numPlanets];
	double[] y_position = new double[numPlanets];
	double[] x_velocity = new double[numPlanets];
	double[] y_velocity = new double[numPlanets];
	double[] mass= new double[numPlanets];
	double[] r_x= new double[numPlanets];
	double[] r_y= new double[numPlanets];
	double[] v_x = new double[numPlanets];
	double[] v_y = new double[numPlanets];
	double delta_x=0,delta_y=0,distance=0,netForce=0,force_x=0,force_y=0,a_x=0,a_y=0,netForce_x=0,netForce_y=0;
	double G=6.67e-11;
	double k=0;
	//initialize the array that take values from the text file
	
	for (int i=0;i<numPlanets;i++)
	{
		x_position[i]=StdIn.readDouble();
		y_position[i]=StdIn.readDouble();
		x_velocity[i]=StdIn.readDouble();
		y_velocity[i]=StdIn.readDouble();
		mass[i]=StdIn.readDouble();
		image[i]="resources/"+StdIn.readString();
	}
	
	//assign values to each variables;
	//draw the background
	StdDraw.setXscale(-universeRadius,+universeRadius);
	StdDraw.setYscale(-universeRadius,+universeRadius);
	
	
	StdAudio.play("resources/2001.mid");
	while (k<=big_t)
	{
		for (int i=0;i<numPlanets;i++)
		{
			netForce_x=0;
			netForce_y=0;
			//calculate the net force acting on the planet;
			for (int j=0;j<numPlanets;j++)
			{	
				if (j!=i)
				{
					delta_x=x_position[j]-x_position[i];
					delta_y=y_position[j]-y_position[i];
					distance = Math.pow(delta_x, 2) + Math.pow(delta_y,2);
					netForce=G*mass[i]*mass[j]/distance;
					force_x = netForce*delta_x/Math.sqrt(distance);
					force_y = netForce*delta_y/Math.sqrt(distance);
					netForce_x+=force_x;
					netForce_y+=force_y;
				}
			
			}
			a_x=netForce_x/mass[i];
			a_y=netForce_y/mass[i];
			v_x[i]=x_velocity[i]+delta_t*a_x;
			v_y[i]=y_velocity[i]+delta_t*a_y;
			r_x[i]=x_position[i]+v_x[i]*delta_t;
			r_y[i]=y_position[i]+v_y[i]*delta_t;	
			//if the planet hits the border of the screen, it will bounce back
			if ((r_x[i]>=universeRadius) || (r_x[i]<=-universeRadius))
			{
				v_x[i]=-v_x[i];
				
			}
			if ((r_y[i]>=universeRadius) || (r_y[i]<=-universeRadius))
			{
				v_y[i]=-v_y[i];
				
			}
			//if the planets collide, then there will be elastic emotion
			
			
			
		}
		//after everything is done, write all of those in one array
		StdDraw.picture(0, 0, "resources/starfield.jpg");
		for (int h=0;h<numPlanets;h++) {
			
			StdDraw.picture(r_x[h],r_y[h],image[h]);	
			
		}
		
		StdDraw.show(5);
		
		//after everything is drawn, set new values to the arrays
		for (int q=0;q<numPlanets;q++) 
		{
			x_position[q]=r_x[q];
			y_position[q]=r_y[q];
			x_velocity[q]=v_x[q];
			y_velocity[q]=v_y[q];
			
		}	
		k=k+delta_t;
		StdDraw.clear();
		
		
	}
			
}
}