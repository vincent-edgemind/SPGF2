package org.systemx.populationGenerator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.systemx.populationGenerator.GUI.MainFrame;
import org.systemx.populationGenerator.config.Config;
import org.systemx.populationGenerator.config.ConfigGroup;
import org.systemx.populationGenerator.supportClasses.Counter;
import org.systemx.populationGenerator.supportClasses.ProgressBar;


public class App {

	static String inputPath = "";

	static String pathPums = inputPath + "";
	static String pathConfig = inputPath + "";
	static String pathCantDepReg = inputPath + "";
	static String pathMarginalData = inputPath + "";
	static String pathRevenue = inputPath + "";

	static String pathPumsFil = inputPath + "";

	static String pathPUMSOut = inputPath + "";
	static String pathValdiation = inputPath + "";

	public static void main(String[] args) {
		String configPath = "../SPG/2014/conf_vincent.xml";
		configPath = "/home/vincent/edgemind/Projects/SYSTEMX-0006-Saclay/input-data/inputs/SPGF2/config_IdF-test.xml";
		if (args.length > 0) {
			configPath = args[0];
		}

		Config config;
		try {
			config = ConfigGroup.read(configPath);
			run(config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void run(Config config) {
		projectPopulationThread thread = new projectPopulationThread();
		thread.setConfig(config);
		thread.start();
	}
	

	public static void run(Config config, JProgressBar jProgressBar, JLabel jLabel,  JPanel jPanel) {
		ProgressBar.setProgressBar(jProgressBar);
		ProgressBar.setjLabel(jLabel);
		ProgressBar.setjPanel(jPanel);
		
		Counter.setProgressBar(jProgressBar);
		Counter.setjLabel(jLabel);
		Counter.setjPanel(jPanel);
		
		projectPopulationThread thread = new projectPopulationThread();
		thread.setConfig(config);
		thread.start();
	}



}
