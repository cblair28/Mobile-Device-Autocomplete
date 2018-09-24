import java.util.Comparator;


// Used to sort during the "getWords" method in AutocompleteProvider
public class CandIntComparator implements Comparator<Candidate> {
	
	public int compare(Candidate c1, Candidate c2) {
		
		//If confidence is the same, sort ASCIIbetically
		if (c1.getConfidence().equals(c2.getConfidence())) {
			return c1.getWord().compareTo(c2.getWord());
		}
		
		//Else output in descending order, higher confidence first
		else return -(c1.getConfidence().compareTo(c2.getConfidence()));
		
	}

}
