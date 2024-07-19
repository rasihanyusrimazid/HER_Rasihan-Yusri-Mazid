/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HER_2301081011;

/**
 *
 * @author Rasihan Yusri Mazid
 */
import java.util.ArrayList;
import java.util.List;

public class PdamDao {
    private List<Pdam> data = new ArrayList<>();

    public PdamDao() {
        // Contoh data awal
        // data.add(new Pdam("P123", "Siti", "GOLD", "10-JUNI-2024", 50, 40));
        // data.add(new Pdam("P124", "Nur", "SILVER", "20-JUNI-2024", 30, 20));
    }

    public void insert(Pdam pdam) {
        data.add(pdam);
    }

    public void update(int index, Pdam pdam) {
        if (index >= 0 && index < data.size()) {
            data.set(index, pdam);
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < data.size()) {
            data.remove(index);
        }
    }

    public Pdam getPdam(int index) {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        }
        return null;
    }

    public List<Pdam> getAll() {
        return data;
    }
}

