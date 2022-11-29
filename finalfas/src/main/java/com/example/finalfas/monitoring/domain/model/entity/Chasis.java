package com.example.finalfas.monitoring.domain.model.entity;
import lombok.Getter;
import lombok.Setter;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.io.File;

@Getter
@Setter
public class Chasis {
    String CPUS;
    String MaxMemory;
    String TotalMemory;
    String FreeMemory;
    String TimeSec;
    String TotalSpaceC;
    String FreeSpaceC;

    public Chasis(){
        getMonitoring(null);
    }

    public void getMonitoring(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long start = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        int cpus = runtime.availableProcessors();
        long mmax = runtime.maxMemory() / 1024 / 1024;
        long mtotal = runtime.totalMemory() / 1024 / 1024;
        long mfree = runtime.freeMemory() / 1024 / 1024;
        File cDrive = new File("C:");
        System.out.println("Datos de JVM");
        System.out.println("CPUS:" + Integer.toString(cpus));
        System.out.println("Memoria Maxima:" + Long.toString(mmax));
        System.out.println("Memoria total:" + Long.toString(mtotal));
        System.out.println("Memoria Libre:" + Long.toString(mfree));
        // 1 s = 1,000 ms = 1,000,000 Âµs = 1,000,000,000 ns
        double elapseTime = (System.nanoTime() - start) / 1_000_000_000; /// *1.0e-9;
        System.out.println("Tiempo sec:" + Double.toString(elapseTime));
        System.out.println(String.format("Espacio total c: %.2f GB", (double) cDrive.getTotalSpace() / 1073741824));
        System.out.println(String.format("Espacio libre c: %.2f GB", (double) cDrive.getFreeSpace() / 1073741824));

        this.CPUS = Integer.toString(cpus);
        this.MaxMemory = Long.toString(mmax);
        this.TotalMemory = Long.toString(mtotal);
        this.FreeMemory = Long.toString(mfree);
        this.TimeSec = Double.toString(elapseTime);
        this.TotalSpaceC = (String.format("Espacio total c: %.2f GB", (double) cDrive.getTotalSpace() / 1073741824));
        this.FreeSpaceC = (String.format("Espacio libre c: %.2f GB", (double) cDrive.getFreeSpace() / 1073741824));

    }
}
