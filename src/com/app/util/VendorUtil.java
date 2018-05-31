package com.app.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.app.service.ILocationService;

@Component
public class VendorUtil {
	
	@Autowired
	private ILocationService service;

	// 1. to create pie chart
	public void createPie(List<Object[]> data, String path) {
		// data set
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] obs : data) {
			dataset.setValue(obs[0].toString(), new Double(obs[1].toString()));
		}
		// jFreeChart obj
		JFreeChart chart = ChartFactory.createPieChart3D("Vendor Report",
				dataset, true, true, false);

		// save as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path
					+ "/reportVendorPie.jpg"), chart, 500, 500);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// 1. to create Bar chart
	public void createBar(List<Object[]> data, String path) {
		// data set
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Object[] obs : data) {
			dataset.setValue(new Double(obs[1].toString()), obs[0].toString(),
					"");
		}
		// jFreeChart obj
		JFreeChart chart = ChartFactory.createBarChart3D("Vendor Report",
				"Vendor Type", "Count", dataset);

		// save as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path
					+ "/reportVendorBar.jpg"), chart, 500, 500);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<String> getVenTypes() {
		return Arrays.asList("CONTRACT", "FULL-TIME", "PART-TIME");
	}

	public List<String> getVenIdTypes() {
		return Arrays.asList("PAN CARD", "VOTER ID", "AADHAR CARD", "OTHER");
	}

	public void addUiComponents(ModelMap map) {
		map.addAttribute("venTypesUi", getVenTypes());
		map.addAttribute("venIdTypesUi", getVenIdTypes());
		map.addAttribute("locsUi",service.getAllLocations());
		
	}

}
