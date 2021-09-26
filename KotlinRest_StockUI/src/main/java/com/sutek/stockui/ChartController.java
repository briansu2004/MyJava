package com.sutek.stockui;

import com.sutek.stockclient.WebClientStockClient;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import org.springframework.stereotype.Component;

@Component
public class ChartController {
	@FXML
	public LineChart<String, Double> chart;
	private WebClientStockClient webClientStockClient;

	public ChartController(WebClientStockClient webClientStockClient) {
		this.webClientStockClient = webClientStockClient;
	}
}
