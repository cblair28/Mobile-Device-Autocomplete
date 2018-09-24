
/*
 * This is the class that will store the candidates for the autocompletion algorithm.
 * Candidate objects will have a word field and confidence field. 
 */


public class Candidate {
	
	private Integer confidence;
	private String word;
	
	//Constructors
	public Candidate(String s) {
		word = s;
		confidence = 1;
	}
	
	public Candidate(String s, Integer c) {
		word = s;
		confidence = c;
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
	
	//Updates confidence intervals at a time
	public void updateConfidence(Integer i) {
		confidence += i;
	}
	
	
	public String getWord() {
		return word;
	}
	
	public Integer getConfidence() {
		return confidence;
	}
	
	
	/*
	 * Overriding the equals, hashCode and toString methods
	 * for equality-testing purposes
	 */
	
	@Override
	public boolean equals(Object c) {
		
		if (c == null)
				return false;
		
		if (!(c instanceof Candidate))
			return false;
				
		else {			
			Candidate c1 = (Candidate) c;		
			return this.getWord().equals(c1.getWord()) 
					&& this.getConfidence().equals(c1.getConfidence());	
		}
	}
	
	@Override
	public int hashCode() {
		return word.hashCode() + confidence.hashCode();
	}
	
	//Aids in printing the getWords list
	public String toString() {
		return word + " " + "(" + confidence.toString() + ")";
	}
	
	
	
	
	
}
