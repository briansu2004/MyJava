package com.sutek.stockui;

import com.sutek.stockclient.StockPrice;
import com.sutek.stockclient.WebClientStockClient;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

import static java.lang.String.valueOf;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.scene.chart.XYChart.Data;
import static javafx.scene.chart.XYChart.Series;

@Component
public class ChartController implements Consumer<StockPrice> {
	@FXML
	public LineChart<String, String> chart;
	//public LineChart<String, Double> chart;

	private WebClientStockClient webClientStockClient;

	public ChartController(WebClientStockClient webClientStockClient) {
		this.webClientStockClient = webClientStockClient;
	}

	@FXML
	public void initialize() {
		String symbol1 = "SYMBOL1";
		final PriceSubscriber priceSubscriber1 = new PriceSubscriber(symbol1);
		webClientStockClient.priceFor(symbol1).subscribe(priceSubscriber1);

		String symbol2 = "SYMBOL2";
		final PriceSubscriber priceSubscriber2 = new PriceSubscriber(symbol2);
		webClientStockClient.priceFor(symbol2).subscribe(priceSubscriber2);

		//ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();
		ObservableList<Series<String, String>> data = observableArrayList();
		data.add(priceSubscriber1.getSeries());
		data.add(priceSubscriber2.getSeries());
		chart.setData(data);
	}

	@Override
	public void accept(StockPrice stockPrice) {

	}

	@Override
	public Consumer<StockPrice> andThen(Consumer<? super StockPrice> after) {
		return Consumer.super.andThen(after);
	}

	private static class PriceSubscriber implements Consumer<StockPrice> {
		//private ObservableList<XYChart.Data<String, Double>> seriesData = FXCollections.observableArrayList();
		private final ObservableList<Data<String, String>> seriesData = observableArrayList();
		private final Series<String, String> series;
		//private String symbol;

		public PriceSubscriber(String symbol) {
			//this.symbol = symbol;
			series = new Series<>(symbol, seriesData);
		}

		@Override
		public void accept(StockPrice stockPrice) {
			Platform.runLater(() ->
//				seriesData.add(new XYChart.Data<>(String.valueOf(stockPrice.getTime().getSecond()),
//					18.503391168822013)) //stockPrice.getPrice()))
					seriesData.add(new Data<>(valueOf(stockPrice.getTime().getSecond()), valueOf(stockPrice.getPrice())))
			);
		}

		public Series<String, String> getSeries() {
			return series;
		}
	}
}
