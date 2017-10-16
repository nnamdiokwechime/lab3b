package lab3b;

/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class StudentEventModel implements CourseListener
{
	private String name;
	private Date midterm;

	public StudentEventModel(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}
	
	public void midtermAnnounced(CourseEvent e) {
		ProfEventModel p = (ProfEventModel) e.getSource();
		study(p.getMidterm());
	}
	
	public void midtermPostponed(CourseEvent e) {
		ProfEventModel p = (ProfEventModel) e.getSource();
		party(p.getMidterm());
	}
}