package lab3b;
/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observer;
import java.util.Observable;

public class TeachingAssistant implements Observer {
	private String name;
	private Date midterm;

	public TeachingAssistant(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void proctor(Date date){
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	public void postpone(Date date){
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}
	
	public void update(Observable o, Object arg) {
		String updateis = (String) arg; 
		if(updateis.equals("midterm")) {
			Prof updater = (Prof) o;
			proctor(updater.getMidterm());			
		}else {
			Prof p = (Prof) o;
			postpone(p.getMidterm());
		}
	}
}