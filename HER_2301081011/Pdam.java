/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HER_2301081011;

/**
 *
 * @author Rasihan Yusri Mazid
 */
public class Pdam {
    private String kodePembayaran;
    private String namaPelanggan;
    private String jenisPelanggan;
    private String tanggal;
    private int meterBulanIni;
    private int meterBulanLalu;
    private int totalBayar;

    public Pdam(String kodePembayaran, String namaPelanggan, String jenisPelanggan, String tanggal, int meterBulanIni, int meterBulanLalu) {
        this.kodePembayaran = kodePembayaran;
        this.namaPelanggan = namaPelanggan;
        this.jenisPelanggan = jenisPelanggan;
        this.tanggal = tanggal;
        this.meterBulanIni = meterBulanIni;
        this.meterBulanLalu = meterBulanLalu;
        this.totalBayar = hitungTotalBayar();
    }

    public int getMeterPakai() {
        return meterBulanIni - meterBulanLalu;
    }

    private int hitungTotalBayar() {
        int meterPakai = getMeterPakai();
        int biaya = 0;

        switch (jenisPelanggan.toUpperCase()) {
            case "GOLD":
                if (meterPakai <= 10) {
                    biaya = meterPakai * 5000;
                } else if (meterPakai <= 20) {
                    biaya = (10 * 5000) + ((meterPakai - 10) * 10000);
                } else {
                    biaya = (10 * 5000) + (10 * 10000) + ((meterPakai - 20) * 20000);
                }
                break;
            case "SILVER":
                if (meterPakai <= 10) {
                    biaya = meterPakai * 4000;
                } else if (meterPakai <= 20) {
                    biaya = (10 * 4000) + ((meterPakai - 10) * 8000);
                } else {
                    biaya = (10 * 4000) + (10 * 8000) + ((meterPakai - 20) * 10000);
                }
                break;
            case "UMUM":
                if (meterPakai <= 10) {
                    biaya = meterPakai * 2000;
                } else if (meterPakai <= 20) {
                    biaya = (10 * 2000) + ((meterPakai - 10) * 3000);
                } else {
                    biaya = (10 * 2000) + (10 * 3000) + ((meterPakai - 20) * 5000);
                }
                break;
        }
        return biaya;
    }

    public String getKodePembayaran() {
        return kodePembayaran;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getJenisPelanggan() {
        return jenisPelanggan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getMeterBulanIni() {
        return meterBulanIni;
    }

    public int getMeterBulanLalu() {
        return meterBulanLalu;
    }

    public int getTotalBayar() {
        return totalBayar;
    }
}
