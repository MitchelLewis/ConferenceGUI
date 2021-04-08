package seminars;

/**
 * A Dog object models limited behaviours of a dog.
 * A Dog can speak, so it can introduce itself and even make a speech.
 * 
 * @author Sylvia Wong
 * @version 10-10-2020
 */
/* !!!! Modify the class declaration to define the
 * 		realisation relationship between classes Dog and Speaker.  
 */
public class Dog implements Speaker {

	// the name of this dog object
	private String name;
	
	/**
	 * Constructor for creating a Dog object
	 * @param name	the name of the dog
	 */
	public Dog(String name){
		this.name = name;
	}

	/**
	 * A dog introduces itself
	 * @return the self introduction statement 
	 */
	public String introduceOneself() {
		String intro = "";
		// my name is...
		intro += Speaker.nameIntro + name + ". ";
		// thanks
		intro += Speaker.thanks;
		return speak(intro);
	}

	/**
	 * Speak out an utterance with "Woof!"s in between.
	 * @param speech	the utterance for speaking out
	 * @return the uttered speech with a dog's speaking manner 
	 */
	public String speak(String speech) {
		// split the text string into word tokens
		String[] text = speech.split(" ");
		
		String mySpeech = "";
		
		/* !!!! Complete the implementation for generating the dog's
		 * utterance, i.e. the speech with the dog's speaker characteristics
		 * added.
		 * 
		 * A dog can speak like a human being(!). However, every now and then 
		 * the old speaking habits creep into its speech. Thus after a dog has 
		 * uttered five words, it will automatically utter a “Woof!”. 
		 * Hence, if a dog wants to say “My name is Super Dog. Thank you for 
		 * listening to me.”, you will hear “My name is Super Dog. Woof! 
		 * Thank you for listening to Woof! me.”.
		 * 
		 * You will need to insert "Woof!" after every five words in the dog's
		 * speech.
		 */
		for(int i = 0; i < text.length; i++) {
			if((i + 1) % 5 == 0) {
				mySpeech += " Woof! ";
			}
			mySpeech += " " + text[i] + " ";
		}
		
		
		
		return mySpeech;
	}

	/**
	 * The Main -- for a quick unit testing
	 * @param args
	 */
	public static void main(String[] args){
		Dog d = new Dog("Lucky");
		System.out.println(d.introduceOneself());
		System.out.println(d.speak("In general, polymorphism describes multiple possible states for a single property (it is said to be polymorphic)."));
	}
	
}
