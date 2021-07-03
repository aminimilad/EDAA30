package mountain;

import java.util.HashMap;

import fractal.Fractal;
import fractal.TurtleGraphics;


public class kMountain extends Fractal {

	private Point first;
	private Point second;
	private Point third;
	private Side side;
	private HashMap<Side, Point> map;
	private RandomUtilities rand = new RandomUtilities();
	private double dev;
	
	public kMountain(double dev, Point first, Point second, Point third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
		this.dev = dev;
	
		map = new HashMap<Side, Point>();
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Mountain";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		// TODO Auto-generated method stub'
		map.clear();
		dTriangle(turtle, order, first, second, third, dev);
		
	}
	
	public void dTriangle(TurtleGraphics turtle, int order, Point first, Point second, Point third, double dev) {
		if(order == 0) {
			turtle.moveTo(first.getX(), first.getY());
			turtle.penDown();
			turtle.forwardTo(second.getX(), second.getY());
			turtle.forwardTo(third.getX(), third.getY());
			turtle.forwardTo(first.getX(), first.getY());
			turtle.penUp();
			
		}
		else {
			//innan beräkna mittpunkt: sök om den finns i mappen?
			//Om finns? använd den
			//Om inte finns? skapa en ny mittpunkt
			
			Point newFirst = getMid(first,second, dev);
			Point newSecond = getMid(second,third, dev);
			Point newThird = getMid(third,first, dev);
			

			dTriangle(turtle, order-1, first, newFirst, newThird, dev/2);
			dTriangle(turtle, order-1, newFirst, second, newSecond, dev/2);
			dTriangle(turtle, order-1, newThird, newSecond, third, dev/2);
			dTriangle(turtle, order-1, newFirst, newSecond, newThird, dev/2);

		}
		
		
	}
	
	private Point getMid(Point a, Point b, double dev) {
		side = new Side(a,b);
		//!side.equals(map.get(side)))
		if(!map.containsKey(side)) {
			Point p = new Point((a.getX() + b.getX())/2, (int) ((a.getY() + b.getY())/2 + rand.randFunc(dev)));
			map.put(side, p);
			System.out.print("hej");
			return p;
		}
		else {
		
			Point p = map.get(side);
			map.remove(side);
			
			return p;
		}
	}
	
	public static double randFunc(double dev) {
		double t = dev * Math.sqrt(-2 * Math.log(Math.random()));
		if (Math.random() < 0.5) {
		t = -t;
		}
		return t;
		}

	
	
}
