import java.util.*;
import java.io.*;

//Denna klass �rver Global s� att man kan anv�nda time och signalnamnen utan punktnotation


public class MainSimulation extends Global{

    public static void main(String[] args) throws IOException {

    	//Signallistan startas och actSignal deklareras. actSignal �r den senast utplockade signalen i huvudloopen nedan.

    	Signal actSignal;
    	new SignalList();

    	//H�r nedan skapas de processinstanser som beh�vs och parametrar i dem ges v�rden.

    /*	QS Q1 = new QS();
    	QS Q2 = new QS();
    	QS Q3 = new QS();
    	Q1.sendTo =  Q2;
    	Q2.sendTo =  Q3;
    	Q3.sendTo =  null;



    	Gen Generator = new Gen();
    	Generator.lambda = 8; //Generator ska generera nio kunder per sekund
    	Generator.sendTo = Q1; //De genererade kunderna ska skickas till k�systemet QS

    	//H�r nedan skickas de f�rsta signalerna f�r att simuleringen ska komma ig�ng.

    	SignalList.SendSignal(READY, Generator, time);
    	SignalList.SendSignal(MEASURE, Q1, time);
    	SignalList.SendSignal(MEASURE, Q2, time);
    	SignalList.SendSignal(MEASURE, Q3, time);

    	// Detta �r simuleringsloopen:

    	while (time < 100000){
    		actSignal = SignalList.FetchSignal();
    		time = actSignal.arrivalTime;
    		actSignal.destination.TreatSignal(actSignal);
    	}

    	//Slutligen skrivs resultatet av simuleringen ut nedan:

    	System.out.println("Medelantal kunder i kösystem: " + 1.0*Q1.accumulated/Q1.noMeasurements);
    	System.out.println("Medelantal kunder i kösystem: " + 1.0*Q2.accumulated/Q2.noMeasurements);
    	System.out.println("Medelantal kunder i kösystem: " + 1.0*Q3.accumulated/Q3.noMeasurements);

    	*/
    	
    	//------------ f) 
    	
    	ArrayList<QS> list = new ArrayList<QS>();
    	for(int i = 0; i<5; i++) {
    		list.add(new QS());
    		list.get(i).sendTo = null;
    	}
    	
    	Dispatcher dp = new Dispatcher(list);
    	dp.lambda = 45;
    	
    	//H�r nedan skickas de f�rsta signalerna f�r att simuleringen ska komma ig�ng.
    	SignalList.SendSignal(READY, dp, time);
    	
    	for(QS qs:list) {
    		SignalList.SendSignal(MEASURE, qs, time);
    		
    	}

    	while (time < 100000){
    		actSignal = SignalList.FetchSignal();
    		time = actSignal.arrivalTime;
    		actSignal.destination.TreatSignal(actSignal);
    	}
    	
    	
    	//UTSKRIFT
    	double svar = 0;
    	for(QS qs:list) {
    		System.out.println("Medelantal kunder i ett kösystem: " + 1.0*qs.accumulated/qs.noMeasurements);
    		svar += 1.0*qs.accumulated/qs.noMeasurements;
    	}
    	System.out.print("Medelantal kunder i samtliga kösystem: " + svar);
    	
    }
}