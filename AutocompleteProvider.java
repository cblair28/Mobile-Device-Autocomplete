import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * This autocomplete provider stores all the candidates in a TreeMap called dictionary.
 * It has two methods - getWords, which returns a List of all possible autocomplete suggestions
 * given a word fragment, and train, which takes a String and enters it into the dictionary, adding new
 * candidates and updating duplicates. 
 */


public class AutocompleteProvider {

	/*
	 * Backing map, stores Candidate objects with their "word" fields as keys.
	 * This allows them to be stored asciibetically and retrieved/updated.
	 */
	private TreeMap<String, Candidate> dictionary;
	
	
	//Constructor initializes TreeMap
	public AutocompleteProvider() {
		dictionary = new TreeMap<String, Candidate>();
	}
	
	//Copy constructor
	public AutocompleteProvider(AutocompleteProvider a) {
		this.dictionary = a.dictionary;
	}
	
	
	//Updates dictionary with words of a passage
	public void train(String passage) {
		
		/* 
		 * Splits the passage into individual words to be passed into the working
		 * dictionary. Splits on characters that aren't letters or numbers, so
		 * punctuation is removed and words separated something other than a space, 
		 * i.e. "heads/tails", will be input individually, on element for heads,
		 * one for tails. Note that words with numbers in them will count as valid. 
		 */	
			String[] input = passage.split("\\W+");
			
			//Iterates through each word of passage
			for (int i = 0; i < input.length; i++) {
				
				//Strings are case-insensitive, so this makes everything lowercase
				String lowered = input[i].toLowerCase();
				
				//If the word is already in the dictionary, increment the confidence.
				//Else, create a new candidate and add it.   
				if (dictionary.containsKey(lowered)) {
					dictionary.get(lowered).updateConfidence();
				} else {
					dictionary.put(lowered, new Candidate(lowered));
				}		
			}
		}
	
	
	
	/*
	 * Takes a word fragment and outputs a list of autocomplete suggestions, 
	 * sorted from highest to lowest confidence. In the event that the 
	 * fragment is a complete word, it will return null. 
	 * If the fragment doesn't match any of the already-trained words, 
	 * it will return an empty list.
	 */
	
	public List<Candidate> getWords(String fragment) {
	
		//If word is already complete, no suggestion is needed
		if (dictionary.containsKey(fragment)) {
			return null;
		}
		
		/*
		  * Uses the TreeMap's subMap function, create a subMap of all potential words.
		  * The lower bound of the submap will be the fragment with a "space" (asciibetically first)
		  * concatenated onto it, and the upper bound will have a "~" (asciibetically last) concatenated.
		  * Because when the train function strips the words of punctuation, every 
		  * viable candidate is guaranteed to be in between these bounds. 
		  */

		SortedMap<String, Candidate> sub = dictionary.subMap(fragment + " ", fragment + "~");
				
		//Turns submap into a list
		List<Candidate> candidates = new ArrayList<Candidate>(sub.values());
		
		//Sorts by confidence, then asciibetically
		Collections.sort(candidates, new CandIntComparator());		
		return candidates;
		
	}

}
