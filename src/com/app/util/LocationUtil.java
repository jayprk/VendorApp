package com.app.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class LocationUtil {

	// 1. to create pie chart
	public void createPie(List<Object[]> data, String path) {
		// data set
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] obs : data) {
			dataset.setValue(obs[0].toString(), new Double(obs[1].toString()));
		}
		// jFreeChart obj
		JFreeChart chart = ChartFactory.createPieChart3D("Location Report",
				dataset, true, true, false);

		// save as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path
					+ "/reportLocationPie.jpg"), chart, 500, 500);
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
		JFreeChart chart = ChartFactory.createBarChart3D("Location Report",
				"Location Type", "Count", dataset);

		// save as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path
					+ "/reportLocationBar.jpg"), chart, 500, 500);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
