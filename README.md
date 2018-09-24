MOBILE DEVICE KEYBOARD AUTOCOMPLETE

Corbett Blair

cblair28@terpmail.umd.edu

This project is an autocomplete program for a mobile device keyboard.
It learns as the user types, and returns a list of suggested words
if the user enters a word fragment, outputting words with a
higher confidence (most likely match) first.

It has four classes:
AutocompleteProvider contains the backing map that stores all seen words in a TreeMap.
It has two methods - getWords returns a list of possible candidates given an incomplete word, 
ordered by confidence, and train takes a String passage and enters/processes all the words within.
 
Candidate objects have two fields - a word String and a confidence Int. When a new word is encountered, 
a Candidate object is created for it, with the confidence set to 1. Confidence is equivalent with
"number of times seen." Each time that word is encountered again in the train method, 
the confidence is increased by 1. This way, the more a word appears, the higher on the list of 
suggestions it will be.

CandIntComparator is a comparator that is used to order the getWord list. It lists the candidate
objects from highest confidence to lowest confidence. If the confidence is the same, it orders
them asciibetically (according to ascending ascii value).

Finally, AutocompleteMain is a main method to run the program. To compile/run this code,
declare a new AutocompleteProvider in the main method, then use the train and getWords methods.
I've provided an example, where I put the sample input and output. The input/output is:

train("The third thing that I need to tell you is that this thing does not think thoroughly.")

getWords("thi") --> [thing (2), think (1), third (1), this (1)]

getWords("nee") --> [need (1)]

getWords("th")  --> [that (2), thing (2), the (1), think (1), third (1), this (1), thoroughly (1)]

I've included a junit test file where I made sure the program can be trained multiple times and update,
the sample input/output works, and it handles large blocks of text with punctuation + capitalization.

Because this needs to work fast, here is a short analysis of the time complexity of the program:

Training with a block of text iterates through all the words and enters them into a TreeMap, which
is backed by a red/black tree, resulting in an O(nlog(n)) complexity. 

For the getWords function, creating the submap is O(1), iterating through the elements and putting them
into a list is O(n), and sorting them in the list is O(nlog(n)). So, the entire operation takes 
O(nlog(n)) + O(n) + O(1), which simplifies to O(nlog(n)) as well.








