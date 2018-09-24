
/*
 * This is the class that will store the candidates for the autocompletion algorithm.
 * Candidate objects will have a word field and confidence field. 
 */


public class Candidate {
	
	private Integer confidence;
	private String word;
	
	//Constructor
	public Candidate(String s) {
		word = s;
		confidence = 1;
	}
	
	//Copy constructor
	public Candidate(Candidate c) {
		this.word = c.word;
		this.confidence = c.confidence;
	}
	
	//Called every time word is encountered
	public void updateConfidence() {
		confidence += 1;
	}
	
	public String getWord() {
		return word;
	}
	
	public Integer getConfidence() {
		return confidence;
	}
	
	//Equality is determined by the word field
	public boolean equals(Candidate c) {
		return this.getWord().equals(c.getWord());
	}
	
	//Aids in printing the getWords list
	public String toString() {
		return word + " " + "(" + confidence.toString() + ")";
	}
	
}
