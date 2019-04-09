/****************************************************************************
 *
 * Created by: Wendi Yu
 * Created on: April 08 2018
 * Created for: ICS4U
 * This program for triangle class
 *
 ****************************************************************************/

import java.text.DecimalFormat;

public class Secondary {
	
	static DecimalFormat f = new DecimalFormat("##.00");
	private static double area;
	private static double semiPerm;
	private static int totalDegrees = 180;
	private static double _angle1;
	private static double _angle2;
	private static double _angle3;
	private static double _side1;
	private static double _side2;
	private static double _side3;
	private static double _info1;
	private static double _altAngle;
	private static double _altAngle1;
	private static double _side1alt;
	private static double _height3;
	private static double _height2;
	private static double _height1;
	private static double radiusIncircle;
	private static double S;
	private static double outerRadius;
	
	public Secondary (String type,
					  double info1,
					  double info2,
					  double info3) {
		if (type.equalsIgnoreCase("SSS")){
			this._side1 = info1;
			this._side2 = info2;
			this._side3 = info3;
		}else if (type.equalsIgnoreCase("SAS")){
			this._side1 = info1;
			this._angle2 = info2;
			this._side3 = info3;
		}else if (type.equalsIgnoreCase("ASA")){
			this._angle1 = info1;
			this._side3 = info2;
			this._angle2 = info3;
		}else if (type.equalsIgnoreCase("SSA")){
			this._side2 = info1;
			this._side3 = info2;
			this._angle2 = info3;
		}else if (type.equalsIgnoreCase("AAS")){
			this._angle1 = info1;
			this._angle3 = info2;
			this._side3 = info3;
		}
		
	}
	
	public static double heightAngle3(){
		_height3 = (area * 2) / _side3;
		return _height3;
		//
	}
	
	public static double heightAngle2(){
		_height2 = (area * 2) / _side2;
		return _height2;
	}
	
	public static double heightAngle1(){
		_height1 = (area * 2) / _side1;
		return _height1;
	}
	
	public static void LASfindC(){
		double HofS = (_side3 * (Math.sin(Math.toRadians(_angle2))) / _side2);
		double angleInRadians  = (Math.asin(HofS));
		_angle3 = angleInRadians / Math.PI * 180;
		
	}
	
	public static void side1sinAAS(){
		_side1 = (_side3 * (Math.sin(Math.toRadians(_angle1)))) /(Math.sin(Math.toRadians(_angle3)));
		
	}
	
	public static void side2sinAAS(){
		_side2 = (_side3 * (Math.sin(Math.toRadians(_angle2)))) / (Math.sin(Math.toRadians(_angle3)));
		
	}
	
	public static void side2sin(){
		_side2 = (_side3 / (Math.sin(Math.toRadians(_angle3)))) * ((Math.sin(Math.toRadians(_angle2))));
		
	}
	
	public static void side1sin() {
		_side1 = (_side3/(Math.sin(Math.toRadians(_angle3)))) * ((Math.sin(Math.toRadians(_angle1))));
		
	}
	
	public static void missingAngle1(){
		_angle1 = totalDegrees - _angle3 - _angle2;
	}
	
	
	public static void missingAngle3(){
		_angle3 = totalDegrees - _angle1 -_angle2;
		
	}
	
	public static void missingAngle2(){
		_angle2 = totalDegrees - _angle1 -_angle3;
		
	}
	
	public static double perimeterCalc(){
		double perimeter = _side1 + _side2 + _side3;
		return perimeter;
	}
	
	public static int GetName(){
		
		if(_side1 == _side2 && _side2 != _side3 || _side2 == _side3 && _side3 != _side1 || _side3 == _side1 && _side1 != _side2){
			
			if(_angle1 < 90 && _angle2 < 90 && _angle3 < 90){
				return 1;
				
			}else{
				return 2;
				
				}
		}else if(_side1 == _side2 && _side2 == _side3){
				return 3;
		
		}else if (_side1 != _side2 && _side2 != _side3 && _side1 != _side3){
			
			if(_angle1 < 90 && _angle2 < 90 && _angle3 <90){
				return 4;
				
			}else{
				return 5;
				
				}
		}else{
			return 6;
		}
	}
    
    public static void getSide2cos() {
        
    	_side2 = Math.sqrt(Math.pow(_side1, 2) + Math.pow(_side3, 2) - (2 * _side1 * _side3 * Math.cos(Math.toRadians(_angle2))));
    }
    
    public static void getSide3cos() {
        _side3 = Math.sqrt(Math.pow(_side1, 2) + Math.pow(_side2, 2) - 2 * _side1 * _side2 * Math.cos(Math.toRadians(_angle3)));
        
    }
    
    public static double semiPerimeter(){
    semiPerm = (_side1 + _side2 + _side3)/2;
    return semiPerm;
    }
    
    public static double heronFormula(double semiPerm){
    area = Math.sqrt(semiPerm*(semiPerm - _side1)*(semiPerm - _side2)*(semiPerm - _side3));
    return area;
    }
    
    public static double radiusIncircle() {
    radiusIncircle = area / semiPerm;
    return radiusIncircle;
    
    }
    
    public static double OuterRadis(double S) {
    	outerRadius = (_side1 + _side2 + _side3) / (4 * (Math.sqrt(S * (S -_side1) * (S - _side2) * (S - _side3))));
    	return outerRadius;
    }
    
    
    public static double SCalc() {
    	S = (_side1 + _side2 + _side3) / 2;
    	return S;
    }
    
    protected int isTriangleValid() {
		if (_side1 >= _side2 + _side3 || _side2 >= _side1 + _side3 || _side3 >= _side1 + _side2){
			return 1;
		}else{
			return 2;
		}
    }
}
