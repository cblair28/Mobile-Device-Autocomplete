import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AutocompleteTester {

	//Tests that list continually updates
	@Test
	public void testUpdate() {	
		
	AutocompleteProvider a = new AutocompleteProvider();
	
	a.train("Hello hello hello, testing one");
	
	Candidate c1 = new Candidate("hello", 3);
	
	List<Candidate> test1 = new ArrayList<Candidate>();
	test1.add(c1);
	
	assertEquals(test1, a.getWords("h"));
	
	a.train("Hello hello hello, testing two");
	
	Candidate c2 = new Candidate("testing", 2);
	Candidate c3 = new Candidate("two", 1);
	c1.updateConfidence(3);
	
	assertEquals(a.getWords("h"), test1);
	
	List<Candidate> test2 = new ArrayList<Candidate>();
	test2.add(c2);
	test2.add(c3);
	
	assertEquals(a.getWords("t"), test2);
	
	}
	
	//Tests example input
	@Test
	public void exampleInput() {
		
		AutocompleteProvider a = new AutocompleteProvider();
		
		a.train("The third thing that I need to tell you is that this thing does not think thoroughly.");
		
		Candidate c1 = new Candidate("thing", 2);
		Candidate c2 = new Candidate("think", 1);
		Candidate c3 = new Candidate("third", 1);
		Candidate c4 = new Candidate("this", 1);
		
		Candidate c5 = new Candidate("need", 1);
		
		Candidate c6 = new Candidate("that", 2);
		Candidate c7 = new Candidate("the", 1);
		Candidate c8 = new Candidate("thoroughly", 1);
		
		List<Candidate> test1 = new ArrayList<Candidate>();
		test1.add(c1);
		test1.add(c2);
		test1.add(c3);
		test1.add(c4);
		
		List<Candidate> test2 = new ArrayList<Candidate>();
		test2.add(c5);
		
		List<Candidate> test3 = new ArrayList<Candidate>();
		test3.add(c6);
		test3.add(c1);
		test3.add(c7);
		test3.add(c2);
		test3.add(c3);
		test3.add(c4);
		test3.add(c8);
		
		assertEquals(test1, a.getWords("thi"));
		assertEquals(test2, a.getWords("ne"));
		assertEquals(test3, a.getWords("th"));	

		
	}

	//Tests large input with lots of punctuation and capitalization
	@Test
	public void largeTest() {
		
		AutocompleteProvider a = new AutocompleteProvider();
		
		//Inserted "TESTCAPTURE" three times for algorithm to find
		a.train("These hypnagogic compositions tend to bury the reflex to keep time. "
				+ "Willner’s no stranger to longer compositions—many of his songs "
				+ "breach ten minutes—but Infinite Moment doesn’t ask the listener "
				+ "to take stock of each measure or unpack its composite parts. "
				+ "It doesn’t pull the body TESTCAPTURE into a pulse like dance music does; "
				+ "it washes over the body, surrounding it, lulling it into a closed "
				+ "environment. TESTCAPTURE It’s hard to find the motivation to count seconds. A "
				+ "track like “Something Left, Something Right, Something Wrong” could be "
				+ "three minutes or 30 if you’re hearing it without a clock in sight. It’s "
				+ "propelled by a simple beat, but Willner TESTCAPTURE destabilizes the bass drum with a "
				+ "shuffle of clipped synthesizers whose edges add polyrhythms."
				+ " There’s one kind of time, the downbeat, and then just beyond "
				+ "it there’s another, blurrier time shifting in and out of focus.");
		
		Candidate c1 = new Candidate("testcapture", 3);
		
		List<Candidate> test1 = new ArrayList<Candidate>();
		test1.add(c1);
		
		assertEquals(test1, a.getWords("testc"));
		
	}


}
