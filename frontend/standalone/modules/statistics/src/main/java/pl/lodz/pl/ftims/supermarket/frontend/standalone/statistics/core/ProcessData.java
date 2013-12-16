package pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core;
import java.util.List;

import backend.api.Statistics;
import backend.core.model.Monitoring;
import backend.core.model.MonitoringWorkers;
import backend.core.model.FinanceRegister;

public class ProcessData {
	private
		List<Monitoring> monitoring;
		List<MonitoringWorkers> monitorWorkers;
		List<FinanceRegister> financeRegister;
		
		Statistics statistics = new Statistics();
		
		void processMonitoring() {
			monitoring = statistics.getRecords();
		}
		
		void processMonitorWorkers() {
			monitorWorkers = statistics.getRecordsMonitoringWorkers();
		}
		
		void processFinanceRegister() {
			//financeRegister = statistics.getFinanceRegisterRecord();
		}
}
