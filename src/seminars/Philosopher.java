package seminars;
import java.util.*;

/**
 * A philosopher object models limited behaviours of a philosopher.
 * A philosopher can speak. However, when making a speech, 
 * random "Ah-Hem!" introduced into their speech.
 *  
 * @author Sylvia Wong
 * @version 29-09-2020
 */
/* !!!! Modify the class declaration to define the
 * 		realisation relationship between classes Philosopher and Speaker.  
 */
public class Philosopher implements Speaker {
	// the name of the philosopher
	private String name;
	
	/**
	 * Constructor
	 * @param name	the name of the philosopher
	 */
	public Philosopher(String name) {
		this.name = name;
	}
	
	/**
	 * Introduce myself. A Philosopher doesn't go "Ah-Hem!" 
	 * while introducing himself/herself.
	 */
	public String introduceOneself() {
		String intro = "";
		// my name is...
		intro += Speaker.nameIntro + name + ". ";
		// thanks
		intro += Speaker.thanks;
		// no "Ah-Hem!" in self-introduction.
		return intro;
	}

	/* !!!! When a Philosopher has a realisation relation with a Speaker,
	 * it inherits all methods specified in the interface Speaker. 
	 * You might like to add the missing method here.
	 * 
	 * Philosophers like to clear their throats when they make a speech. 
	 * Every time they clear their throats, an “Ah-Hem!” is uttered. 
	 * Hence, when a philosopher delivers a speech, “Ah-Hem!” is scattered 
	 * throughout the speech in a random manner. For example, if a 
	 * philosopher wants to say “Today is a sunny day. We are going to look 
	 * at how the global climate affects our lives.”, you may hear 
	 * “Today Ah-Hem! is a sunny day. We Ah-Hem! are going to look at how 
	 * the global climate Ah-Hem! affects our lives.”.
	 */

	public String speak(String speech) {
		// split the text string into word tokens
		String[] text = speech.split(" ");

		String mySpeech = "";

		for(String word: text) {
			double randomDouble = new Random().nextDouble();
			if(randomDouble < 0.4) {
				mySpeech += " Ah-Hem! ";
			}
			mySpeech += " " + word + " ";
		}

		return mySpeech;
	}

	/**
	 * The Main: for quick unit testing
	 * @param args
	 */
	public static void main(String[] args) {
		Philosopher p = new Philosopher("Doctor Loo");
		System.out.println(p.introduceOneself());
//		System.out.println(p.speak("In general, polymorphism describes multiple possible states for a single property (it is said to be polymorphic)."));

	}

}
