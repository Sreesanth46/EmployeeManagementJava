package com.innovaturelabs.employee.service.impl;


import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import com.innovaturelabs.common.entity.Tasks;
import com.innovaturelabs.common.repository.ExportRepository;
import ch.qos.logback.classic.Logger;

@Service
public class CsvExportService {
    private static final Logger log = getLogger(CsvExportService.class);

    private final ExportRepository exportRepository;

    public CsvExportService(ExportRepository exportRepository) {
        this.exportRepository = exportRepository;
    }

    private static Logger getLogger(Class<CsvExportService> class1) {
        return null;
    }

    public void writeEmployeesToCsv(Writer writer) {

        List<Tasks> employees = exportRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Project Name","Task Id","Task Name","Task Status","Task Create Date");
            for (Tasks employee : employees) {
                csvPrinter.printRecord(employee.getPhaseSection().getProjectPhase().getProject().getProjectName(),employee.getTaskId(),employee.getTaskName(),employee.getTaskStatus(),employee.getCreateDate());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}
