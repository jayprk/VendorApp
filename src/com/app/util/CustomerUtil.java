package com.app.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class CustomerUtil {

	// 1. to create pie chart
	public void createPie(List<Object[]> data, String path) {
		// data set
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] obs : data) {
			dataset.setValue(obs[0].toString(), new Double(obs[1].toString()));
		}
		// jFreeChart obj
		JFreeChart chart = ChartFactory.createPieChart3D("Customer Report",
				dataset, true, true, false);

		// save as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path
					+ "/reportCustomerPie.jpg"), chart, 500, 500);
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
		JFreeChart chart = ChartFactory.createBarChart3D("Customer Report",
				"Customer Type", "Count", dataset);

		// save as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path
					+ "/reportCustomerBar.jpg"), chart, 500, 500);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<String> getCustTypes() {
		return Arrays.asList("CONSUMER", "SELLER");
	}

	public void addUiComponents(ModelMap map) {
		map.addAttribute("custTypesUi", getCustTypes());
	//	map.addAttribute("locsUi", service.getAllLocations());

	}

}
