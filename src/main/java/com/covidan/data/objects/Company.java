package com.covidan.data.objects;

public class Company {
	
	private String companyName;
	
	public Company setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + "]";
	}
	
}