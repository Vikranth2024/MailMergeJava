package pkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MailMerge {
	public static void mailmerge1(String fname1,String fname2) throws IOException {
		String[] li1 = fname1.split("\\.");
		File f1 = new File(fname1);
		File f2 = new File(fname2);
		FileWriter fw1 = new FileWriter(li1[0]+"_out.txt");
		Scanner sc1 = new Scanner(f1);
		Scanner sc2 = new Scanner(f2);
		String template1 = sc2.nextLine();
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> amounts = new ArrayList<>();
		ArrayList<String> dates = new ArrayList<>();
		
		while(sc1.hasNextLine()) {
			String line1 = sc1.nextLine();
			String[] arr1 = line1.split(",");
			names.add(arr1[0].replace(" ",""));
			amounts.add(arr1[1].replace(" ",""));
			dates.add(arr1[2].replace(" ",""));
		}
		for(int i=0;i<names.size();i++) {
			String temp1 = template1
					.replace("$1", names.get(i))
					.replace("$2",amounts.get(i))
					.replace("$3", dates.get(i));
			fw1.write(temp1+"\n");
		}
		fw1.close();
		sc1.close();
		sc2.close();
	}

	public static void main(String[] args) throws IOException{
		mailmerge1("names1.txt","template1.txt");
	}
}
