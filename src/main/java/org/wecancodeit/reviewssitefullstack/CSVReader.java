package org.wecancodeit.reviewssitefullstack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {
		// String file = "7817_1.csv";
		// try {
		// BufferedReader br = new BufferedReader(new FileReader(file));
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		String csvFile = "consumer-reviews-of-amazon-products-QueryResult.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				for (int i = 0; i < country.length; i++) {
					if (i == 0) {
						String item = country[i];
						System.out.print(item);
						System.out.print(" ");
					}
				}
				System.out.println();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String removeDoubleQuotes(String input) {
		return input.replaceAll("\"", "");
	}

}