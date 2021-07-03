import java.util.Comparator;

public class QCompare implements Comparator<QS>{
	
	@Override
	public int compare(QS o1, QS o2) {
		// TODO Auto-generated method stub
		return o1.numberInQueue - o2.numberInQueue;
	}

	
	
}
