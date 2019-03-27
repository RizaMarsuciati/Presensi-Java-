/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Riza
 */
public class Kasus {
    private String id_kasus;
    private String nis;
    private String id_pelanggaran;
    private String kasus_pelanggaran;
    private String poin_pelanggaran;

    public String getId_kasus() {
        return id_kasus;
    }

    public void setId_kasus(String id_kasus) {
        this.id_kasus = id_kasus;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getId_pelanggaran() {
        return id_pelanggaran;
    }

    public void setId_pelanggaran(String id_pelanggaran) {
        this.id_pelanggaran = id_pelanggaran;
    }

    public String getKasus_pelanggaran() {
        return kasus_pelanggaran;
    }

    public void setKasus_pelanggaran(String kasus_pelanggaran) {
        this.kasus_pelanggaran = kasus_pelanggaran;
    }

    public String getPoin_pelanggaran() {
        return poin_pelanggaran;
    }

    public void setPoin_pelanggaran(String poin_pelanggaran) {
        this.poin_pelanggaran = poin_pelanggaran;
    }
    
    
}
