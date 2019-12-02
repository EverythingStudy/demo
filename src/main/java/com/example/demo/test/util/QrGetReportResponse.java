/**
 * 
 */
package com.util;

import java.util.List;

/**
 * @author chenly
 * 
 */
public class QrGetReportResponse {
	public String patName;
	public Integer patSex;
	public String patAge;
	public List<String> report;

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public Integer getPatSex() {
		return patSex;
	}

	public void setPatSex(Integer patSex) {
		this.patSex = patSex;
	}

	public String getPatAge() {
		return patAge;
	}

	public void setPatAge(String patAge) {
		this.patAge = patAge;
	}

	public List<String> getReport() {
		return report;
	}

	public void setReport(List<String> report) {
		this.report = report;
	}

}
