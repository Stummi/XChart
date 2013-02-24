/**
 * Copyright 2011-2013 Xeiam LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xeiam.xchart.demo.charts.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.SwingWrapper;
import com.xeiam.xchart.demo.charts.ExampleChart;

/**
 * Millisecond Scale
 * 
 * @author timmolter
 */
public class DateChart01 implements ExampleChart {

  public static void main(String[] args) {

    ExampleChart exampleChart = new DateChart01();
    Chart chart = exampleChart.getChart();
    new SwingWrapper(chart).displayChart();
  }

  @Override
  public Chart getChart() {

    // Create Chart
    Chart chart = new ChartBuilder().width(800).height(600).title("Millisecond Scale").build();
    chart.getStyleManager().setLegendVisible(false);

    Random random = new Random();

    // generate data
    Collection<Date> xData = new ArrayList<Date>();
    Collection<Number> yData = new ArrayList<Number>();

    DateFormat sdf = new SimpleDateFormat("ss.S");
    Date date = null;
    for (int i = 1; i <= 14; i++) {

      try {
        date = sdf.parse("31." + (100 * i + random.nextInt(20)));
      } catch (ParseException e) {
        e.printStackTrace();
      }
      xData.add(date);
      yData.add(Math.random() * i);
    }

    chart.addDateSeries("blah", xData, yData);

    return chart;

  }
}
