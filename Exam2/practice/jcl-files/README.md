Exam #2 Practice - File I/O and Map
===================================

File ev-sales.dat alternates the name of each US state (and the District of Columbia) with the number of Electric Vehicles (EVs) sold in that state in 2022.

Write a main method that does the following:

1. Create a ``HashMap`` using the state name (a String) as the key and the number of EVs sold (an int) as the value.
2. Using try-with-resources, open file ev-sales.dat for input.
3. Read each state and its sales figure from the file.
   a. Add each to the ``HashMap``.
   b. Keep a running total of sales in all states.
5. If an error occurs, print an error message to the error channel, print a stack trace, and then exit with code -1.
6. Using try-with-resources, open file ev-percentages.dat for output.
7. Iterate over your ``HashMap``. 
   a. For each state, calculate the percentage of its sales compared to the entire US. For example, if Alabama sold 8,730 EVs and 2,442,270 EVs were sold across the US, the percentage is 6220 / 2442270 or 0.36%.
   b. Write the state, the sales figure, and then the percentage to the file on separate lines.
   c. Print the data to the console. For example, for Alabama print "Alabama bought   8730 EVs or  0.4%".
8. If an error occurs, print an error message to the error channel, print a stack trace, and then exit with code -2.
9. Print the total number of EVs bought in the US in 2022. For example, "Total EVs  bought  were  2442270".

The suggested solution is in the suggested-solution subdirectory.

