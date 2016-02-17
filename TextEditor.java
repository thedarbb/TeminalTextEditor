import java.io.*;
import java.util.Scanner;

public class TextEditor {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = new String[100];

		System.out.println("Main Menu:" + "\n 1- Write file" + "\n 2- Read file" + "\n 3- Exit");

		for (int i = 0; i < 100;) {
			str[i] = br.readLine();
			if (str[i].equals("3"))
				break;
			if (str[i].equals("2")) {
				System.out.println("Please enter the file you would like to read: ");
				Scanner reader3 = new Scanner(System.in);
				String fileToRead = reader3.nextLine();
				String sCurrentLine;

				br = new BufferedReader(new FileReader(fileToRead));

				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
				}
				reader3.close();
			}
			if (str[i].equals("1")) {
				System.out.println("Please enter file name:");
				Scanner reader = new Scanner(System.in);
				String fileName = reader.nextLine();
				System.out.println("Now please write your content..");
				Scanner reader2 = new Scanner(System.in);
				String content = reader2.nextLine();

				File file = new File(fileName);

				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.close();
				reader.close();
				reader2.close();
	
				System.out.println("File " + fileName + " has been written successfully.");
			} 
					break;
		}
	}
}