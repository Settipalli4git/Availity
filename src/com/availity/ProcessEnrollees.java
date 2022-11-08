package com.availity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProcessEnrollees {

	public static void main(String[] args) {
		List<String> lineList = new ArrayList<>();
		try {
			BufferedReader br = Files
					.newBufferedReader(Paths.get("C:\\MyCode_Practies\\Availity\\enrolment_input.csv"));

			String line;
			int i = 0;

			while ((line = br.readLine()) != null) {
				if (i > 0) {
					lineList.add(line);
				}
				i++;
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		Set<Enrollee> set = new HashSet<>();
		for (int i = 0; i < lineList.size(); i++) {

			String line = (String) lineList.get(i);
			String lineToken[] = line.split(",");
			Enrollee enrollee = new Enrollee();
			enrollee.setUserId(lineToken[0]);
			enrollee.setFirstName(lineToken[1]);
			enrollee.setLastName(lineToken[2]);
			enrollee.setVersion(lineToken[3]);
			enrollee.setInsuranceCompany(lineToken[4]);

			set.add(enrollee);
		}
		try {
		
		List list = new ArrayList(set);
		for(int i =0; i< list.size();i++) {
			Enrollee enrollee = (Enrollee) list.get(i);
			String insuranceCompany = enrollee.getInsuranceCompany();
		    BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\\\MyCode_Practies\\\\Availity\\"+insuranceCompany+"_enrollee.csv"));

		    // write header record
		    writer.write("UserId,FirstName,LastName,Version,InsuranceCompany");
		    writer.newLine();
		    writer.write(enrollee.getUserId()+","+ enrollee.getFirstName()+","+ enrollee.getLastName()+","+enrollee.getVersion()+","+ enrollee.getInsuranceCompany());
	        writer.newLine();
		    writer.close();
		}
		}
		catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
}
