import java.util.ArrayList;
import java.util.Random;

public class Dispatcher extends Proc {

	public Proc sendTo;    //Anger till vilken process de genererade kunderna ska skickas
	public double lambda;  //Hur m�nga per sekund som ska generas
	ArrayList<QS> list;
	int i = 0;
	Random slump = new Random();
	
	
	public Dispatcher(ArrayList<QS> list) {
		this.list = list;
	}
	@Override
	public void TreatSignal(Signal x) {
		switch(x.signalType) {
			case READY:{
				//I:/*
				/*
				SignalList.SendSignal(ARRIVAL, list.get(slump.nextInt(5)), time);
				*/
				//II:
				/*
				SignalList.SendSignal(ARRIVAL, list.get(i%5), time);
				i++;
				*/
				//III: 
				list.sort(new QCompare());
				SignalList.SendSignal(ARRIVAL, list.get(0), time);
				
				//Betjänarr
				SignalList.SendSignal(READY, this, time + (2.0/lambda)*slump.nextDouble());

			}
		}
	}
	
	

}
