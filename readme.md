### ***Finding the average using CSV file*** 

This project consisted of writing a simple java program where CSV files can be read by the program, the program needed various data manipulations so that a new separate CSV file could be generated & outputted, then saved with all the correct required processes. 

The current problem at hand is regarding a class of 25 students. A school has required a program which needs to read four separate files all at once, these four files are studentList.csv, Tutor1Marks.csv, Tutor2Marks.csv and Tutor3Marks.csv. The first CSV file holds the students CWK1 (coursework 1) results which has been marked by only one tutor. Within this CSV file information is separated into three columns these include; ‘StudentID’, fullName’ and ‘CWK1’. 
Secondly, the other three CSV files have been marked by three different tutors. Within these three CSV files there are only two columns these include; the ‘StudentID’ and the ‘CWK2’.

Having to calculate the CWK2 averages for every student currently by hand is time consuming and hard as many human errors could be included whilst doing the calculations. Thus, this could result in the overall mark for the students to be wrong.

#### Therefore, a simple java program needs to be written so that firstly, all these CSV files could be read and calculate the average marks for CWK2 (as this is marked by three different tutors) for every student in the class. 
#### Secondly, inside the CSV files as each student has its own ‘StudentID’ the program should automatically map all these together when reading data from the different files. 
#### Thirdly, the program should allow the user to enter the different weights percentage for the two coursework’s and then depending on what the user has entered the program should automatically perform calculations and provide the user with the final marks. 
#### Finally, there needs to be a CSV file that is generated and saved with all the new information stored.
