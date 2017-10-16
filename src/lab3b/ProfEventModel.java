package lab3b;

/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;

public class ProfEventModel 
{
	private String name;
	private Date midtermDate;
	//private ArrayList<StudentEventModel> students;
	private TeachingAssistantEventModel ta;
	private ArrayList<CourseListener> courseListeners;

	public ProfEventModel(String aName) {
		this.name = aName;
		//this.students = new ArrayList<StudentEventModel>();
		this.courseListeners = new ArrayList<CourseListener>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		/*for(StudentEventModel s: this.students){
			s.study(date);
		}
		ta.proctor(date);*/
		CourseEvent e = new CourseEvent(this);
		for(CourseListener cl : courseListeners) {
			cl.midtermAnnounced(e);
		}
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
	/*	for(StudentEventModel s: this.students){
			s.party(date);
		}
		ta.postpone(date);*/
		
		CourseEvent e = new CourseEvent(this);
		for(CourseListener cl : courseListeners) {
			cl.midtermPostponed(e);
		}
	}
	
	public void addCourseListener(CourseListener cl) {
		courseListeners.add(cl);
	}
	
	public void removeCourseListener(CourseListener cl) {
		courseListeners.remove(cl);
	}
	
	/*public void setTA(TeachingAssistantEventModel theTA){
		this.ta = theTA;
	}*/
	
	/*public void addStudent(StudentEventModel s){
		this.students.add(s);
	}*/


	public static void main(String[] args) {

		ProfEventModel p = new ProfEventModel("Babak");
		StudentEventModel s = new StudentEventModel("Homer");
		StudentEventModel s2 = new StudentEventModel("Bart");
		TeachingAssistantEventModel ta = new TeachingAssistantEventModel("Michael");
	
	
	/*	p.addStudent(s);
		p.addStudent(s2);
		p.setTA(ta);*/
		
		p.addCourseListener(s);
		p.addCourseListener(s2);
		p.addCourseListener(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}