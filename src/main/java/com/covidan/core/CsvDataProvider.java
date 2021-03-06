package com.covidan.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

import com.covidan.data.objects.Company;
import com.covidan.data.objects.ErrorMessage;
import com.covidan.data.objects.User;

public class CsvDataProvider {

	@DataProvider(name = "CsvDataProviderAsObject")
	public static Iterator<Object[]> provideDataAsObject(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathname = "test_data" + File.separator
				+ method.getDeclaringClass().getSimpleName() + "."
				+ method.getName() + ".csv";
		File file = new File(pathname);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) {
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					User user = new User()
						.setUsername(testData.get("username"))
						.setPassword(testData.get("password"));
					ErrorMessage msg = new ErrorMessage()
						.setMessage(testData.get("error_message"));
					list.add(new Object[] { user, msg });
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathname + " was not found.\n"
					+ e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathname
					+ " file.\n" + e.getStackTrace().toString());
		}
		return list.iterator();
	}
	
	@DataProvider(name = "ProvideCompanyAndUser")
	public static Iterator<Object[]> provideCompanyAndUser(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathname = "test_data" + File.separator
				+ method.getDeclaringClass().getSimpleName() + "."
				+ method.getName() + ".csv";
		File file = new File(pathname);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) {
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					Company company = new Company()
						.setCompanyName(testData.get("company_name"));
					User user = new User()
						.setUsername(testData.get("username"))
						.setPassword(testData.get("password"));
					list.add(new Object[] { company, user });
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathname + " was not found.\n"
					+ e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathname
					+ " file.\n" + e.getStackTrace().toString());
		}
		return list.iterator();
	}

}
