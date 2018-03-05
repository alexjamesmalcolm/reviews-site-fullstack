package org.wecancodeit.reviewssitefullstack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CSVReader {

	private String filePath;

	public CSVReader(String filePath) {
		this.filePath = filePath;
	}

	public Collection<String> parse() {
		String line = "";
		List<String> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}