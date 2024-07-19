/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HER_2301081011;

/**
 *
 * @author Rasihan Yusri Mazid
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PdamController {
    private List<Pdam> pdamList;
    private PdamDao pdamDao;

    public PdamController() {
        this.pdamDao = new PdamDao();
        this.pdamList = pdamDao.getAll();
    }

    public void clearForm(JTextField txtKode, JTextField txtNama, JTextField txtTanggal, JTextField txtMeterBulanIni, JTextField txtMeterBulanLalu, JComboBox<String> cbJenis) {
        txtKode.setText("");
        txtNama.setText("");
        txtTanggal.setText("");
        txtMeterBulanIni.setText("");
        txtMeterBulanLalu.setText("");
        cbJenis.removeAllItems();
        cbJenis.addItem("GOLD");
        cbJenis.addItem("SILVER");
        cbJenis.addItem("UMUM");
    }

    public void tampil(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        for (Pdam pdam : pdamList) {
            Object[] row = {
                pdam.getKodePembayaran(),
                pdam.getNamaPelanggan(),
                pdam.getJenisPelanggan(),
                pdam.getTanggal(),
                pdam.getMeterBulanIni(),
                pdam.getMeterBulanLalu(),
                pdam.getTotalBayar()
            };
            tableModel.addRow(row);
        }
    }

    public void savePdam(String kode, String nama, String jenis, String tanggal, int meterBulanIni, int meterBulanLalu) {
        Pdam pdam = new Pdam(kode, nama, jenis, tanggal, meterBulanIni, meterBulanLalu);
        pdamDao.insert(pdam);
        JOptionPane.showMessageDialog(null, "Insert OK");
    }

    public void updatePdam(int index, String kode, String nama, String jenis, String tanggal, int meterBulanIni, int meterBulanLalu) {
        Pdam pdam = new Pdam(kode, nama, jenis, tanggal, meterBulanIni, meterBulanLalu);
        pdamDao.update(index, pdam);
        JOptionPane.showMessageDialog(null, "Update OK");
    }

    public void getPdam(int index, JTextField txtKode, JTextField txtNama, JTextField txtTanggal, JTextField txtMeterBulanIni, JTextField txtMeterBulanLalu, JComboBox<String> cbJenis) {
        Pdam pdam = pdamDao.getPdam(index);
        if (pdam != null) {
            txtKode.setText(pdam.getKodePembayaran());
            txtNama.setText(pdam.getNamaPelanggan());
            txtTanggal.setText(pdam.getTanggal());
            txtMeterBulanIni.setText(String.valueOf(pdam.getMeterBulanIni()));
            txtMeterBulanLalu.setText(String.valueOf(pdam.getMeterBulanLalu()));
            cbJenis.setSelectedItem(pdam.getJenisPelanggan());
        } else {
            JOptionPane.showMessageDialog(null, "Invalid index");
        }
    }

    public void deletePdam(int index) {
        pdamDao.delete(index);
        JOptionPane.showMessageDialog(null, "Delete OK");
    }
}
