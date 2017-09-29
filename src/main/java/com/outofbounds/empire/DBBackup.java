package com.outofbounds.empire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DBBackup {

    @Autowired
    private org.springframework.core.env.Environment env;

    @CrossOrigin(origins = {"http://localhost:8000"})
    @RequestMapping(method = RequestMethod.GET, value = "/backup/now")
    public @ResponseBody
    void Backupdbtosql() throws IOException {
        Process p = null;
        try {
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy.hh.mm.ss");
            String dbusername = env.getProperty("spring.datasource.username");
            String dbpassword = env.getProperty("spring.datasource.password");
            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec("mysqldump -u"+dbusername+" -p"+dbpassword+" --add-drop-database -B empire -r " + "C:\\DatabaseBackup\\" + ft.format(dNow) + ".sql");

            int processComplete = p.waitFor();

            if (processComplete == 0) {

                System.out.println("Succes: Backup created successfully!");

            } else {
                System.out.println("FAILED: No Backup created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

