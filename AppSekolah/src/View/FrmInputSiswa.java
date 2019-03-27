/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.Dao.DAOSiswa;
import Entity.Siswa;
import Factory.DAOFactorySiswa;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author candraka21
 */
public class FrmInputSiswa extends javax.swing.JFrame {
    private DefaultTableModel dtm;
    private DAOSiswa daosiswa;
    private String[] tblHeader;
    private List<Siswa> listSiswa, listIDkategoriKelas, listIDKelas, listIDThang;
    private int baris;
    private String pesan;
    private String proses;
    private boolean status;
    private Siswa siswa;
    
    private void aturButton (boolean b){
        BtnTambah.setEnabled(b);
        BtnEdit.setEnabled(b);
        BtnSimpan.setEnabled(!b);
        BtnHapus.setEnabled(b);
        BtnBatal.setEnabled(!b);
    }
    
    private void aturText (boolean b){
        TxtNIS.setEnabled(b);
        CmbKelas.setEnabled(b);
        CmbThang.setEnabled(b);
        TxtNama.setEnabled(b);
        CmbJenkel.setEnabled(b);
        TxTempatLahir.setEnabled(b);
        CldTanggal.setEnabled(b);
        TxtAlamat.setEnabled(b);
        TxtNoTelp.setEnabled(b);
        CmbKategoriKelas.setEnabled(b);
    }
    
    private void isicombo(){
        listIDKelas = daosiswa.SelectKelas();
        CmbKelas.removeAllItems();
        for (Siswa data : listIDKelas) {
            CmbKelas.addItem(data.getId_kelas());
        }
        listIDkategoriKelas = daosiswa.SelectKategoriKelas();
        CmbKategoriKelas.removeAllItems();
        for (Siswa data :listIDkategoriKelas){
            CmbKategoriKelas.addItem(data.getId_kategori());
        }
        listIDThang = daosiswa.SelectThang();
        CmbThang.removeAllItems();
        for (Siswa data : listIDThang){
            CmbThang.addItem(data.getId_thang());
        }
    }    
    private void refreshIsiTable(){
        isicombo();
        if (proses.equalsIgnoreCase("")){ 
            listSiswa = daosiswa.SelectSiswa("", "");
        }else if (proses.equalsIgnoreCase("CARI")){
            listSiswa = daosiswa.SelectSiswa(TxtCari.getText(),TxtCari.getText());
        }
        dtm = (DefaultTableModel) TblSiswa.getModel();
        dtm.setRowCount(0);
        for (Siswa data : listSiswa){
            dtm.addRow(new Object[]{
                data.getNis(),
                data.getId_kelas(),
                data.getId_thang(),
                data.getNama(),
                data.getJenkel(),
                data.getTempat_lahir(),
                data.getTgl_lahir(),
                data.getAlamat(),
                data.getNo_telp(),
                data.getId_kategori()});
        }
        
        if (TblSiswa.getRowCount()>0){
            baris = TblSiswa.getRowCount()-1;
            TblSiswa.setRowSelectionInterval(baris, baris);
            aturButton(true);
            aturText(false);
        }
    }
    /**
     * Creates new form FrmSiswa
     */
    public FrmInputSiswa() {
        initComponents();
        proses = "";
        daosiswa = DAOFactorySiswa.getsiswaDAO();
        tblHeader = new String[]{"NIS","KELAS","Tahun Angkatan","NAMA","JENIS KELAMIN","TEMPAT LAHIR","TANGGAL LAHIR","ALAMAT","NO TELP","NAMA KELAS"};
        dtm = new DefaultTableModel(null, tblHeader);
        TblSiswa.setModel(dtm);
        TblSiswa.getSelectionModel().addListSelectionListener(
        new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           baris = TblSiswa.getSelectedRow();
           if (baris>=0){
               TxtNIS.setText(dtm.getValueAt(baris, 0).toString());
               CmbKelas.setSelectedItem(dtm.getValueAt(baris, 1).toString());
               CmbThang.setSelectedItem(dtm.getValueAt(baris, 2).toString());
               TxtNama.setText(dtm.getValueAt(baris, 3).toString());
               CmbJenkel.setSelectedItem(dtm.getValueAt(baris, 4).toString());
               TxTempatLahir.setText(dtm.getValueAt(baris, 5).toString());
               Date tgl = null;
               try {
                   tgl = new SimpleDateFormat("dd/MM/yyyy").parse(dtm.getValueAt(baris, 6).toString());
                   CldTanggal.setDate(tgl);
               } catch (ParseException ex){
                   Logger.getLogger(FrmPresensi.class.getName()).log(Level.SEVERE, null, ex);
               }
               TxtAlamat.setText(dtm.getValueAt(baris, 7).toString());
               TxtNoTelp.setText(dtm.getValueAt(baris,8).toString());
               CmbKategoriKelas.setSelectedItem(dtm.getValueAt(baris, 9).toString());

           }
            }
        });
        refreshIsiTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        BtnHapus = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSiswa = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        TxtCari = new javax.swing.JTextField();
        BtnCari = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        TxtNIS = new javax.swing.JTextField();
        CmbKelas = new javax.swing.JComboBox();
        CmbKategoriKelas = new javax.swing.JComboBox();
        CmbThang = new javax.swing.JComboBox();
        TxtNama = new javax.swing.JTextField();
        CmbJenkel = new javax.swing.JComboBox();
        TxTempatLahir = new javax.swing.JTextField();
        TxtNoTelp = new javax.swing.JTextField();
        BtnSimpan = new javax.swing.JButton();
        BtnTambah = new javax.swing.JButton();
        TxtAlamat = new javax.swing.JTextField();
        BtnRefresh = new javax.swing.JButton();
        CldTanggal = new com.toedter.calendar.JDateChooser();
        BtnTutup = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 5));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM TAMBAH SISWA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SMP Negeri 1 Jogonalan Klaten");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(237, 237, 237))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(270, 270, 270))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 0), 5));

        jPanel5.setBackground(new java.awt.Color(204, 153, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 5));

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1300258886_eraser--minus.png"))); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        TblSiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        jScrollPane1.setViewportView(TblSiswa);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Menampilkan Data");

        TxtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCariActionPerformed(evt);
            }
        });

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search_16x16.png"))); // NOI18N
        BtnCari.setText("Cari");
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(BtnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEdit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCari)
                .addGap(44, 44, 44))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCari))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHapus)
                    .addComponent(BtnEdit))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Tambah Siswa");

        jLabel25.setText("NIS");

        jLabel26.setText("Kelas");

        jLabel27.setText("Kategosi Kelas");

        jLabel28.setText("Tahun Angkatan");

        jLabel29.setText("Nama");

        jLabel30.setText("Jenis Kelamin");

        jLabel31.setText("Tempat Lahir");

        jLabel32.setText("Tanggal Lahir");

        jLabel33.setText("No Telp");

        jLabel34.setText("Alamat");

        CmbKelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        CmbJenkel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L", "P" }));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        BtnSimpan.setText("Simpan");
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        BtnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        BtnTambah.setText("Tambah");
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        BtnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1300682486_arrow_circle_double.png"))); // NOI18N
        BtnRefresh.setText("Refresh");
        BtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(277, 277, 277))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel33))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(CmbThang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CmbKategoriKelas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CmbKelas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TxtNIS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel32)
                                            .addComponent(jLabel34))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtAlamat)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(CldTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel29))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(CmbJenkel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(93, 93, 93))))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(BtnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnSimpan)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(TxtNIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(CmbJenkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbKategoriKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(TxTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(CldTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33))
                    .addComponent(jLabel34)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSimpan)
                            .addComponent(BtnTambah)
                            .addComponent(BtnRefresh))))
                .addGap(459, 459, 459))
        );

        BtnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        BtnTutup.setText("Tutup");
        BtnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTutupActionPerformed(evt);
            }
        });

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel.png"))); // NOI18N
        BtnBatal.setText("Batal");
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnTutup)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTutup)
                    .addComponent(BtnBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
      if (JOptionPane.showConfirmDialog(null, 
              "Apakah Yakin Ingin Menghapus Data Ini ?",
              "Konfirmasi", JOptionPane.YES_NO_OPTION)
              ==JOptionPane.YES_OPTION){
          status = daosiswa.deleteSiswa(TxtNIS.getText());
          
          if(status==false){
              pesan = "Hapus Data Gagal";
          }
          JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus",
                  "Informasi",JOptionPane.INFORMATION_MESSAGE);
      }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void TxtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCariActionPerformed

    
    private void BtnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTutupActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BtnTutupActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        proses = "UPDATE";
        aturButton(false);
        aturText(true);
        TxtNIS.setEnabled(false);
        CmbKelas.requestFocus();
        CmbThang.requestFocus();
        TxtNama.requestFocus();
        CmbJenkel.requestFocus();
        TxTempatLahir.requestFocus();
        CldTanggal.requestFocus();
        TxtAlamat.requestFocus();
        TxtNoTelp.requestFocus();
        CmbKategoriKelas.requestFocus();
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // TODO add your handling code here:
        proses ="";
        aturButton(true);
        aturText(false);
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        Date tanggal = new Date();
        TxtNIS.setText("");
        CmbKelas.setSelectedIndex(0);
        CmbThang.setSelectedIndex(0);
        TxtNama.setText("");
        CmbJenkel.setSelectedIndex(0);
        TxTempatLahir.setText("");
        CldTanggal.setDate(tanggal);
        TxtAlamat.setText("");
        TxtNoTelp.setText("");
        CmbKategoriKelas.setSelectedIndex(0);
        TxtNIS.requestFocus();
        proses = "INSERT";
        aturButton(false);
        aturText(true);
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        siswa = new Siswa();
        siswa.setNis(TxtNIS.getText());
        siswa.setId_kelas(CmbKelas.getSelectedItem().toString());
        siswa.setId_thang(CmbThang.getSelectedItem().toString());
        siswa.setNama(TxtNama.getText());
        siswa.setJenkel(CmbJenkel.getSelectedItem().toString());
        siswa.setTempat_lahir(TxTempatLahir.getText());
        String tgl = new SimpleDateFormat("dd/MM/yyyy").format(CldTanggal.getDate());
        siswa.setTgl_lahir(tgl);
        siswa.setAlamat(TxtAlamat.getText());
        siswa.setNo_telp(TxtNoTelp.getText());
        siswa.setId_kategori(CmbKategoriKelas.getSelectedItem().toString());

        if (proses.equalsIgnoreCase("INSERT")){
            status=daosiswa.insertSiswa(siswa);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else if (proses.equalsIgnoreCase("UPDATE")){
            status=daosiswa.updateSiswa(siswa);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }

        if (status==false){
             JOptionPane.showMessageDialog(null, "Penyimpanan Data Gagal",
                "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
                    
                    refreshIsiTable();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        // TODO add your handling code here:
        proses = "CARI";
        refreshIsiTable();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
        // TODO add your handling code here:
        refreshIsiTable();
    }//GEN-LAST:event_BtnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInputSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInputSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInputSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInputSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInputSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnRefresh;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JButton BtnTutup;
    private com.toedter.calendar.JDateChooser CldTanggal;
    private javax.swing.JComboBox CmbJenkel;
    private javax.swing.JComboBox CmbKategoriKelas;
    private javax.swing.JComboBox CmbKelas;
    private javax.swing.JComboBox CmbThang;
    private javax.swing.JTable TblSiswa;
    private javax.swing.JTextField TxTempatLahir;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JTextField TxtNIS;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTextField TxtNoTelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
