	package ac.one;
	
	import java.io.BufferedReader; //Used to read data from the CSV files
	import java.io.FileReader; //Used for identifying a file and read data from it.
	import java.io.IOException; //Used for identifying if an error has occurred.
	import java.io.PrintStream; //Used for outputting new CSV file
	import java.util.Scanner; //Used for scanning in user input
	
	public class Assignment1 {
	
		public static void main(String[] args) throws IOException {
	
			//Declaring variables
			int userInputWeight = 0; //Double used for allowing the user to enter the weight of CWK1
			int weight100 = 100; //Double used for finding out the weight of CWK2
			int CWK1Weight = 0; //Double used for storing the course work 1 weight
			int CWK2Weight = 0; //Double used for storing the course work 1 weight
			int StudentID[] = new int[30]; //Array used for storing the Students ID's from stduentList.csv
			String fullname[] = new String[30]; //Array used for storing the full names of students from stduentList.csv
			int CWK1[] = new int[30]; //Array used for storing the course work 1 marks of students from stduentList.csv
			int CWK2Tutor1[] = new int[30]; //Array used for storing the course work 2 marks of students from Tutor1Marks.csv
			int CWK2Tutor2[] = new int[30]; //Array used for storing the course work 2 marks of students from Tutor2Marks.csv
			int CWK2Tutor3[] = new int[30]; //Array used for storing the course work 2 marks of students from Tutor3Marks.csv
			int CWK2Average[] = new int[30]; //Array used for storing the averages of CWK2 of each student from the three tutors
			int finalMarks[] = new int[30]; //Array used for storing the final marks of CWK1 and CWK2 with weights added on
			String finalResults; //String used for the new CSV file 
			
			int Tutor1ID[] = new int[30]; //Array used for storing the Students ID's from Tutor1Marks.csv
			int Tutor2ID[] = new int[30]; //Array used for storing the Students ID's from Tutor2Marks.csv
			int Tutor3ID[] = new int[30]; //Array used for storing the Students ID's from Tutor3Marks.csv
			
			int Tutor1sorted[] = new int[30]; //Array used for storing the Students ID's from Tutor1Marks.csv
			int Tutor2sorted[] = new int[30]; //Array used for storing the Students ID's from Tutor2Marks.csv
			int Tutor3sorted[] = new int[30]; //Array used for storing the Students ID's from Tutor3Marks.csv
	
			BufferedReader studentList = new BufferedReader(new FileReader("raw/studentList.csv"));
			BufferedReader Tutor1Marks = new BufferedReader(new FileReader("raw/Tutor1Marks.csv"));
			BufferedReader Tutor2Marks = new BufferedReader(new FileReader("raw/Tutor2Marks.csv"));
			BufferedReader Tutor3Marks = new BufferedReader(new FileReader("raw/Tutor3Marks.csv"));
	
	
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter a weight percentage for coursework one: ");
			userInputWeight = in.nextInt();
	
	
			studentList.readLine(); //This will skip the first line
			int i = 0; //Will be used for the array index
			int count = 0;//for knowing how many values there are
			String line; //Used for reading each line of file
			while ((line = studentList.readLine()) != null) { //keep reading line by line until there is no line.		  
				String splits[] = line.split(","); //Splitting each line into three columns
				StudentID[i] =Integer.parseInt(splits[0]); //The first column will be holding StudentID
				fullname[i] = (splits[1]); //The second column will be holding fullname
				CWK1[i] = Integer.parseInt(splits[2]); //The third column will be holding the CWK1 marks
				i++; //Increment value of i 
				count++;
			}//end of tutor 1
			studentList.close(); //close the file
			
			
			Tutor1Marks.readLine();
			int a = 0; //Will be used for the array index
			String line2;
			while ((line2 = Tutor1Marks.readLine()) != null) {    //keep reading line by line until there is no line.
				String splits[] = line2.split(",");
				Tutor1ID[a] = Integer.parseInt(splits[0]); //The first column will be holding StudentID
				CWK2Tutor1[a] = Integer.parseInt(splits[1]); //The second column will hold CWK2 marks from first Tutor
				a++;
			}
			Tutor1Marks.close();

	
			Tutor2Marks.readLine();
			int b = 0; //Will be used for the array index
			String line3;
			while ((line3 = Tutor2Marks.readLine()) != null) { //keep reading line by line until there is no line.
				String splits[] = line3.split(",");
				Tutor2ID[b] = Integer.parseInt(splits[0]); //The first column will be holding StudentID
				CWK2Tutor2[b] = Integer.parseInt(splits[1]); //Currently fourth column will hold CWK2 marks from third Tutor
				b++;
			}
			Tutor2Marks.close();
			
	
			Tutor3Marks.readLine();
			int c = 0; //Will be used for the array index
			String line4;
			while ((line4 = Tutor3Marks.readLine()) != null) {  //keep reading line by line until there is no line.
				String splits[] = line4.split(",");
				Tutor3ID[c] = Integer.parseInt(splits[0]); //The first column will be holding StudentID
				CWK2Tutor3[c] = Integer.parseInt(splits[1]); //Currently fourth column will hold CWK2 marks from third Tutor
				c++;
			}
			Tutor3Marks.close();
	
	
			//Map all StudentID's together so that the program matches CWK1 and CWK2Average results together for all students
			for(int h=0;h<StudentID.length;++h){
				int Student_ID = StudentID[h];
				for (int z = 0; z < Tutor1ID.length; ++z) {
						int Tutor_ID = Tutor1ID[z];
						boolean matchI = false;
						if (Student_ID == Tutor_ID){
							matchI = true;
							Tutor1sorted[z]  = CWK2Tutor1 [z];
							break;
					}
				}
			}
			
				
			for(int x=0;x<StudentID.length;++x){
				int Student2_ID = StudentID[x];
				for (int y = 0; y < Tutor2ID.length; ++y) {
						int Tutor2_ID = Tutor2ID[y];
					boolean matchII = false;
						if (Student2_ID == Tutor2_ID){
							matchII = true;
							Tutor2sorted[y]  = CWK2Tutor2 [y];
							break;
						}
					}
			}
			
	
			for(int f=0;f<StudentID.length;++f){
					int Student3_ID = StudentID[f];
					for (int d = 0; d < Tutor3ID.length; ++d) {
							int Tutor3_ID = Tutor3ID[d];
							boolean matchIII = false;
							if (Student3_ID == Tutor3_ID){
								matchIII = true;
								Tutor3sorted[d]  = CWK2Tutor3 [d];
								break;
						}
					}					
			}
			


			//Calculate the averages of CWK2 from all three teachers
			for (int j = 0; j < count; j++) {
				int temp = (int) (Tutor1sorted[j] + Tutor2sorted[j] + Tutor3sorted[j]) / 3; //Temporary variable temp used for averages
				CWK2Average[j] = temp; //The average for CWK2 - now temp = CWK2Average[j]
				//System.out.println("Average " + CWK2Average[j]); //Print all the averages of CWK2 marked by three tutors
			}


			//calculate the weights for CWK1 and CWK2 these will go into the finalMarks[]
			System.out.println("There are a total of 25 students inputted");
			System.out.println();
			CWK1Weight = userInputWeight;
			CWK2Weight = (weight100 - CWK1Weight);
			System.out.println("The Coursework 1 weight is " + CWK1Weight);
			System.out.println("The Coursework 2 weight is " + CWK2Weight);
			for (int j = 0; j < count; ++j) {
				double temp = (CWK1[j] * CWK1Weight + CWK2Average[j] * CWK2Weight) / 100;
				finalMarks[j] = (int) temp;
				//System.out.println("Final Marks " + finalMarks[j]); //you need to store this final averaged in an array
			}

			
			//generate the new CSV file
			finalResults = "raw/finalResults.csv"; //New CSV file 
			PrintStream write = new PrintStream(finalResults); //Outputting new CSV
			String line0 = ("StudentID" + "," + "fullname" + "," + "CWK1" + "," + "CWK2Average" + "," + "finalMarks");
			write.println(line0);
			{
				for (int j = 0; j < 25; j++){
					line = StudentID[j] + "," + fullname[j] + "," + CWK1[j] + "," + CWK2Average[j] + "," + finalMarks[j];
					write.println(line); //Output line
				}
			}
			write.close(); //Close the file
			System.out.println();
			System.out.println("A file called finalResults.csv has been generated. You can view this in the raw folder.");
		}//main
}//class

