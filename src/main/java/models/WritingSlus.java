package models;

import utilities.Alerts;

import java.io.File;
import java.io.RandomAccessFile;

public class WritingSlus {
    public static void write(byte value, long position, File slus) {
        try (RandomAccessFile raf = new RandomAccessFile(slus, "rw")) {
            raf.seek(position);
            raf.writeByte(value);
            Alerts.alertDoneWrite();
            System.out.println("El archivo se escribió correctamente.");
        } catch (Exception e) {
            Alerts.alertInvalidWrite();
            System.out.println("No se pudo escribir el archivo.");
            e.printStackTrace();
        }
    }
}
