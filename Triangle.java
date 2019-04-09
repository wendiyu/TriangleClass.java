/****************************************************************************
 *
 * Created by: Wendi Yu
 * Created on: April 08 2018
 * Created for: ICS4U
 * This program for triangle class
 *
 ****************************************************************************/
    
//Site the source: https://gist.github.com/brysonian/116503

import java.text.DecimalFormat;
import java.util.Scanner;

public class Triangle {
	public static void main(String args[]){
		Scanner userInput = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("##.00");
		
		String type;
		int info1 = 0;
		int info2 = 0;
		int info3 = 0;
		
		System.out.println("Choose One of the below options.\n \n 1) SSS for 3 Sides.\n "
							+ "2) SAS for 1 Side then 1 Angel and 1 Side (angel is in between two sides).\n "
							+ "3) ASA for 1 Angle 1 Side and 1 Angle.\n "
							+ "4) SSA for 1 Side 1 Side and 1 Angle (not an angle between the sides).\n "
							+ "5) AAS 2 Angles and 1 Side.\n");
		
		System.out.println("Enter one of the abberivations for selection. (Ex.'SSS' for Side Side Side): ");
		// what you are solving for
		type = userInput.nextLine(); 
		
		if (type.equalsIgnoreCase("SSS")){
			System.out.println("\n'SSS' is when you have 3 sides of a Triangle.\n"); 
			System.out.print("Enter in side 1 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in side 2 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in side 3 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);
			
			//Calculations

				
		}else if(type.equalsIgnoreCase("SAS")){
			System.out.println("\n'SAS' is when we know two sides and the angle between them.\n");
			System.out.print("Enter in side 2 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in angle 1 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in side 3 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);
			
			//Calculations
			obj.getSide2cos();
			
		}else if(type.equalsIgnoreCase("ASA")){
			System.out.println("\nASA Triangle is when we know two angles and a side between the angles.\n ");
			System.out.print("Enter in angle 1 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in side 2 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in angle 3 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);
			
			//Calculations
			//Find Missing Angle
			obj.missingAngle3(); 
			//Fine side1
			obj.side1sin(); 
			obj.side2sin();

		}else if (type.equalsIgnoreCase("AAS")) {
			System.out.println("\n"  + 	"\"AAS\" is when we know two angles and one side (which is not between the angles).\n ");
			System.out.print("Enter in angle 1 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in angle 3 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in side 3 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);

			
			//Calculations
			obj.missingAngle2();
			obj.side1sinAAS();
			obj.side2sinAAS();
			
		}else if(type.equalsIgnoreCase("SSA")){
			System.out.println("\n'SSA' is when we know two sides and an angle that is not the angle between the sides.\n");
			System.out.print("Enter in side 2 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in side 3 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in angle 2 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);
			
			//Calculations
			obj.LASfindC();
			obj.missingAngle1();
			obj.side1sinAAS();


			
		}else{
			System.out.println("Please Enter one of the presets above, Note it is case sensitive");
		}
		
		Secondary obj = new Secondary(type, info1, info2, info3);
		
		//Calculation
		int valid = obj.isTriangleValid(); 
		if (valid == 1) {
			System.out.println("\nIn our universe we cannot have that triangle, please try again.");
			System.exit(0);
		}else {
			System.out.println("\nThis is a real Triangle");
		}
		int triangleType = obj.GetName();
		
		if (triangleType == 1) {
			System.out.println("This triangle is an Acute Isosceles triangle"); 
		}else if (triangleType == 2) {
			System.out.println("This triangle is an Obtuse Isosceles triangle");
		}else if (triangleType == 3) {
			System.out.println("This triangle is an Equilateral triangle"); 
		}else if (triangleType == 4) {
			System.out.println("This triangle is an Acute Squalene triangle"); 
		}else if (triangleType == 5) {
			System.out.println("This triangle is an Obtuse Squalene triangle"); 
		}else if (triangleType == 6) {
			System.out.println("You should not be here."); 
		}
		
		//Perimeter	
		double permCalc = obj.perimeterCalc();
		System.out.println("The Perimeter of the triangle is " + f.format(permCalc) + " units^2");
		
		//Area
		double semiperm = obj.semiPerimeter();
		double area = obj.heronFormula(semiperm);
	    System.out.println("The Area of the triangle is " + f.format(area) + " units^2");
		
		//Height
		double height3 = obj.heightAngle3();
		System.out.println("\n" + f.format(height3) + " This is the height of Angle 3.");
		double height2 = obj.heightAngle2();
		System.out.println(f.format(height2) + " This is the height of Angle 2.");
		double height1 = obj.heightAngle2();
		System.out.println(f.format(height1) + " This is the height of Angle 1.");
		
		//Radius
		double radiusInCircle = obj.radiusIncircle();
		System.out.println("\nThe radius in circle is " + f.format(radiusInCircle));
		double SCalc = obj.SCalc();
		double outerRadius = obj.OuterRadis(SCalc);
		System.out.println("The radius outside the circle is " + f.format(outerRadius));
	}
 }
