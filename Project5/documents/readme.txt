/**********************************************************************
 *  readme template
 *  Global Sequence Alignment
 **********************************************************************/

Name:Viet Dang

Hours to complete assignment (optional):
About 3 hours

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
The only problem I encountered was trying to track down table (it took me some time to figure out)

/**********************************************************************
 *  Make a table of values showing running times for the method
 *  recursiveEditDistance when given two random DNA strings of length
 *  N, where N from 1 to about 10 or 12.  To do this properly, it would
 *  be best to repeat the test several times for each value of N, and
 *  average the times.
 *
 *  What can you say about the growth of this time as a function of N?
 *  
 **********************************************************************/
N 	 		8	9	10	11	12	14
Recursive running time  0.003s	0.015s	0.07s	0.369s	0.382s	65.665s

Because each recursive function has to compare other 3 other deeper levels. Therefore, the total function it has to run is about 3^N with N be the length of string x

/**********************************************************************
 *  For each data file, fill in the edit distance computed by your
 *  program and the amount of time it takes to compute it.
 **********************************************************************/

data file           distance       time (seconds)
-------------------------------------------------
ecoli3000.txt       125			0.177s	
ecoli7000.txt	    160			0.851s	
ecoli10000.txt	    223 		1.864s	


/**********************************************************************
 *  Because the dynamic programming version does a fixed amount of
 *  computation for each element in the two-dimensional table,
 *  we expect that the time complexity should be quadratic.  Does the
 *  data above seem to support this hypothesis?   Use the doubling
 *  hypothesis to explain how you arrived at your answer.
 **********************************************************************/
It seems so. Let t be the running time for the program to process a table of size (n+1)*(n+1). Therefore, to process a table of size 3001*3001, it is gonna take 3001*3001*t and 7001*7001t for a table of size 7000*7000.
The ratio is 3001^2*11/7001^2*11=0.184. While 0.177/0.851=0.208. The two ratios are very close so we can conclude that the data support this hypothesis 


/**********************************************************************
 *  As a function of the string length N (assume M = N), estimate the
 *  running time of your program (and the sample) in seconds. Your answer
 *  should have the form a * N^2 for some constant a.
 *
 *  What is the largest N your program can handle if it is limited to 1
 *  day of computation? Assume you have as much main memory as you need.
 **********************************************************************/
If we do not count in the recursive function, there will be a total of 11 steps in the main bottom function. The small steps in other function are not significant enough to affect the total running time of the program
a = 11. I count there are about 130 lines of codes which are not in the main bottom up function.
The estimated number of steps taken of this program is around 130+11*N^2. 

If Ecoli 3000 takes about 0.177s to run, each step is gonna take 0.177/(130+11*3000^2)=1.78E-9s
One day=86400s => No. of steps = 86400/1.78E-9=4.85E13 steps => N~sqrt(4.85E13/11)=2100834
largest N = 2100834




/**********************************************************************
 *  List whatever help (if any) that you received. You don't need to
 *  include the course materials or lectures, but do include any
 *  additional help your received from people other than course staff,
 *  and include their names.
 **********************************************************************/
No, I only asked one question about the stopwatch. I have done the rest myself

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/