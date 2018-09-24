MOBILE DEVICE KEYBOARD AUTOCOMPLETE

Corbett Blair
cblair28@terpmail.umd.edu

This is the code for the mobile keyboard autocorrect coding challenge.

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

Finally, AutocompleteMain is the main method to test the classes. To compile/run this code,
declare a new AutocompleteProvider in the main method, then use the train and getWords methods.
I've provided an example, where I put the example input and output. The input/output is:

train("The third thing that I need to tell you is that this thing does not think thoroughly.")

getWords("thi") --> [thing (2), think (1), third (1), this (1)]
getWords("nee") --> [need (1)]
getWords("th")  --> [that (2), thing (2), the (1), think (1), third (1), this (1), thoroughly (1)]