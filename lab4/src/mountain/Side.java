package mountain;

public class Side {

	private Point a, b, mitt;
	
	public Side(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	public Point getp1(){
		return a;
		
	}
	
	public Point getp2(){
		return b;
		
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Side) {
			Side s = (Side) obj;
			return getp1() == s.getp1() && getp2() == s.getp2() || getp2() == s.getp1() && getp1() == s.getp2();
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return getp1().hashCode() + getp2().hashCode();
	}
	

}
