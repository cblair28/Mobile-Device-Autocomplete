
/*
 * Main method used for testing the Candidate and AudocompleteProvider objects.
 */

public class AutocompleteMain {

	public static void main(String[] args) {

		AutocompleteProvider a = new AutocompleteProvider();
		
		a.train("The third thing that I need to tell you is that this thing does not think thoroughly.");
		
		System.out.println(a.getWords("thi"));
		System.out.println(a.getWords("nee"));
		System.out.println(a.getWords("th"));
		
	}

}
