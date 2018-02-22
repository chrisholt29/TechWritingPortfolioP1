package testshape2;
import java.util.Scanner;
import java.text.DecimalFormat;
abstract class Shape {
    public abstract String area();
    public abstract String perimeter();
    public abstract void scale(double scaleFactor);
}

class Circle extends Shape {
    double radius;
    private static int decPlaces=2;
    DecimalFormat df=new DecimalFormat("#0.0");
    public Circle(double radius){
        this.radius=radius;
    }
    public String getRadius(){
        return format(radius);
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    @Override
    public String area(){
        double area=(Math.PI*Math.pow(radius, 2));
        return format(area);
    }
    @Override
    public String perimeter(){
        double perimeter= Math.PI*(2*radius);
        return format(perimeter);
    }
    @Override
    public void scale(double scaleFactor){
        this.radius=radius*scaleFactor;
    }
    public String format(double value){
        df.setMaximumFractionDigits(decPlaces);
        df.setMinimumFractionDigits(decPlaces);
        String formatted=df.format(value);
        return formatted;
    }
    @Override
    public String toString(){
        String output=("Circle("+format(radius)+")");
        return output;
    }    
    public static void setDecPlaces(int decPlaces){
        Circle.decPlaces=decPlaces;
    }
}
class Rectangle extends Shape {
    double width, height;
    private static int decPlaces=2;
    DecimalFormat df=new DecimalFormat("#0.0");
    public Rectangle(double width,double height){
        this.width=width;
        this.height=height;
    }
    public String getWidth(){
        return format(width);
    }
    public void setWidth(double width){
        this.width=width;
    }
    public String getHeight(){
        return format(height);
    }
    public void setHeight(double height){
        this.height=height;
    }
    @Override
    public String area(){
        double area=(width*height);
        return format(area);
    }
    @Override
    public String perimeter(){
        double perimeter=((width+height)*2);
        return format(perimeter);
    }
    public String diagonalLength(){
        double dL=Math.sqrt((width*width)+(height*height));
        return format(dL);
    }
    @Override
    public void scale(double scaleFactor){
        this.height*=scaleFactor;
        this.width*=scaleFactor;
    }
    public String format(double value){
        df.setMaximumFractionDigits(decPlaces);
        df.setMinimumFractionDigits(decPlaces);
        String formatted=df.format(value);
        return formatted;
    }
    @Override
    public String toString(){
        String output=("Rectangle("+format(width)+", "+format(height)+")");
        return output;
    }
    public static void setDecPlaces(int decPlaces){
        Rectangle.decPlaces=decPlaces;
    }
}
class EquiTriangle extends Shape {
    double commonSide;
    private static int decPlaces=2;
    DecimalFormat df=new DecimalFormat("#0.0");
    public EquiTriangle(double commonSide){
        this.commonSide=commonSide;
    }
    public String getCommonSide(){
        return format(commonSide);
    }
    public void setCommonSide(double commonSide){
        this.commonSide=commonSide;
    }
    @Override
    public String area(){
        double a=(.5*commonSide);
        double height=Math.sqrt((Math.pow(commonSide,2))-(Math.pow(a,2)));
        double area=(.5*commonSide*height);
        return format(area);
    }
    @Override
    public String perimeter(){
        double perimeter=(commonSide*3);
        return format(perimeter);
    }
    public String altitude(){
        double height=Math.sqrt((Math.pow(commonSide,2))-(Math.pow((.5*commonSide),2)));
        return format(height);
    }
    @Override
    public void scale(double scaleFactor){
        this.commonSide*=scaleFactor;
    }
    public String format(double value){
        df.setMaximumFractionDigits(decPlaces);
        df.setMinimumFractionDigits(decPlaces);
        String formatted=df.format(value);
        return formatted;
    }
    @Override
    public String toString(){
        String output=("EquiTriangle("+format(commonSide)+")");
        return output;
    }
    public static void setDecPlaces(int decPlaces){
        EquiTriangle.decPlaces=decPlaces;
    }
}
public class TestShape2 {    
    public static void main(String[] args) {
        Scanner read= new Scanner(System.in);
        Shape[] shape=new Shape[10]; 
        while(read.hasNext()){
            String readLine=read.nextLine();
            readLine=readLine.trim();
            String[] inputLine=readLine.split(" ");
            if (inputLine[0].equals("create")&&inputLine[1].equals("circle")){
                int position=Integer.parseInt(inputLine[2]);
                double radius=Double.parseDouble(inputLine[3]);
                Circle newCir= new Circle(radius);
                shape[position]=newCir;
            }
            else if (inputLine[0].equals("create")&&inputLine[1].equals("rectangle")){
                int position=Integer.parseInt(inputLine[2]);
                double width=Double.parseDouble(inputLine[3]);
                double height=Double.parseDouble(inputLine[4]);
                Rectangle newRec= new Rectangle(width,height);
                shape[position]=newRec;
            }
                        else if (inputLine[0].equals("create")&&inputLine[1].equals("equilateral")&&inputLine[2].equals("triangle")){
                int position=Integer.parseInt(inputLine[3]);
                double commonSide=Double.parseDouble(inputLine[4]);
                EquiTriangle newTri= new EquiTriangle(commonSide);
                shape[position]=newTri;
            }
            else if (inputLine[0].equals("count")&&inputLine[1].equals("circles")){
                int count=0;
                for (Object item:shape){
                    if (item instanceof Circle){
                        count+=1;
                    }
                }
                System.out.println("Number of circle objects: "+count);
            }
            else if (inputLine[0].equals("count")&&inputLine[1].equals("rectangles")){
                int count=0;
                for (Object item:shape){
                    if (item instanceof Rectangle){
                        count+=1;
                    }
                }
                System.out.println("Number of rectangle objects: "+count);
            }
            else if (inputLine[0].equals("count")&&inputLine[1].equals("equilateral")&&inputLine[2].equals("triangles")){
                int count=0;
                for (Object item:shape){
                    if (item instanceof EquiTriangle){
                        count+=1;
                    }
                }
                System.out.println("Number of equilateral triangle objects: "+count);
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("area")){
                int position= Integer.parseInt(inputLine[2]);
                if (shape[position] instanceof Circle){
                    System.out.println("Area: "+((Circle)shape[position]).area());
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Area: "+((Rectangle)shape[position]).area());
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Area: "+((EquiTriangle)shape[position]).area());
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("scale")){
                int position= Integer.parseInt(inputLine[1]);
                double scaleFactor=Double.parseDouble(inputLine[2]);
                if (shape[position] instanceof Circle){
                    Circle scaleCir=(Circle)shape[position];
                    scaleCir.scale(scaleFactor);
                    shape[position]=scaleCir;
                }
                else if(shape[position] instanceof Rectangle){
                    Rectangle scaleRec=(Rectangle)shape[position];
                    scaleRec.scale(scaleFactor);
                    shape[position]=scaleRec;
                }
                else if(shape[position] instanceof EquiTriangle){
                    EquiTriangle scaleTri=(EquiTriangle)shape[position];
                    scaleTri.scale(scaleFactor);
                    shape[position]=scaleTri;
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("perimeter")){
                int position= Integer.parseInt(inputLine[2]);
                if (shape[position] instanceof Circle){
                    System.out.println("Perimeter: "+((Circle)shape[position]).perimeter());
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Perimeter: "+((Rectangle)shape[position]).perimeter());
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Perimeter: "+((EquiTriangle)shape[position]).perimeter());
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("radius")){
                int position= Integer.parseInt(inputLine[2]);
                if (shape[position] instanceof Circle){
                    System.out.println("Radius: "+((Circle)shape[position]).getRadius());
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Not a circle in this position");
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Not a circle in this position");
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("width")){
                int position= Integer.parseInt(inputLine[2]);
                if (shape[position] instanceof Circle){
                    System.out.println("Not a rectangle in this position");
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Width: "+((Rectangle)shape[position]).getWidth());
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Not a rectangle in this position");
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("height")){
                int position= Integer.parseInt(inputLine[2]);
                if (shape[position] instanceof Circle){
                    System.out.println("Not a rectangle in this position");
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Height: "+((Rectangle)shape[position]).getHeight());
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Not a rectangle in this position");
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("diagonal")&&inputLine[2].equals("length")){
                int position= Integer.parseInt(inputLine[3]);
                if (shape[position] instanceof Circle){
                    System.out.println("Not a rectangle in this position");
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Diagonal length: "+((Rectangle)shape[position]).diagonalLength());
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Not a rectangle in this position");
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("side")){
                int position= Integer.parseInt(inputLine[2]);
                if (shape[position] instanceof Circle){
                    System.out.println("Not an equilateral triangle in this position");
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Not an equilateral triangle in this position");
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Side: "+((EquiTriangle)shape[position]).getCommonSide());
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("altitude")){
                int position= Integer.parseInt(inputLine[2]);
                if (shape[position] instanceof Circle){
                    System.out.println("Not an equilateral triangle in this position");
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Not an equilateral triangle in this position");
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Altitude: "+((EquiTriangle)shape[position]).altitude());
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("type")){
                int position= Integer.parseInt(inputLine[2]);
                if (shape[position] instanceof Circle){
                    System.out.println("Type: Circle");
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println("Type: Rectangle");
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println("Type: EquiTriangle");
                }
                else{
                    System.out.println("No object in this position");
                }
            }
            else if(inputLine[0].equals("show")&&inputLine[1].equals("all")){
                int position=0;
                boolean empty = true;
                for (int i=0; i<shape.length; i++) {
                    if (shape[i] != null) {
                        empty = false;
                        break;
                    }    
                }
                if (empty==true){
                    System.out.println("Array is empty");
                }
                else{
                    for (Object item:shape){                    
                        if (item==null){}                        
                        else{
                            System.out.println("Index "+position+": "+item.toString());
                        }
                        position++;
                    }   
                }    
            }
            else if(inputLine[0].equals("decimal")){
                int decPlaces= Integer.parseInt(inputLine[1]);
                Circle.setDecPlaces(decPlaces);
                Rectangle.setDecPlaces(decPlaces);
                EquiTriangle.setDecPlaces(decPlaces);
            }    
            else if(inputLine[0].equals("clear")){
                int position= Integer.parseInt(inputLine[1]);
                shape[position]=(null);
            }    
            else if(inputLine[0].equals("show")){
                int position= Integer.parseInt(inputLine[1]);
                if (shape[position] instanceof Circle){
                    System.out.println(((Circle)shape[position]).toString());
                }
                else if(shape[position] instanceof Rectangle){
                    System.out.println(((Rectangle)shape[position]).toString());
                }
                else if(shape[position] instanceof EquiTriangle){
                    System.out.println(((EquiTriangle)shape[position]).toString());
                }
                else{
                    System.out.println("No object in this position");
                }
            }
        }        
    }    
}
