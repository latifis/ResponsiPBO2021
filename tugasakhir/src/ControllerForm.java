import javax.swing.JOptionPane;
public class ControllerForm {
    private ModelForm mo;
    
    public void setMo(ModelForm mo){
        this.mo = mo;
    }
    
    public void submitForm(MainView mainView){
        String Judul = mainView.getJudul();
        String Genre = mainView.getGenre();
        String Penulis = mainView.getPenulis();
        String Penerbit = mainView.getPenerbit();
        String Lokasi = mainView.getLokasi();
        String Stok = mainView.getStok();
        
      //  String JK = mainView.getJK(); Pakai RB abil data
        
        if (Judul.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Judul Masih Kosong !");
        }
        else if (Genre.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Genre Masih Kosong !");
        }
        else if (Penulis.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Penulis Masih Kosong !");
        }
        else if (Penerbit.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Penerbit Kelamin Masih Kosong !");
        }
        else if (Lokasi.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Lokasi Masih Kosong !");
        }
        else if (Stok.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Stok Masih Kosong !");
        }
        else{
            if(JOptionPane.showConfirmDialog(null, "Anda Yakin?", "Simpan Data", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                mo.submitForm(mainView);
                mo.resetForm();  
            }
            else{
            } 
        }
    }
    
    public void updateForm(MainView mainView){
        String Judul = mainView.getJudul();
        String Genre = mainView.getGenre();
        String Penulis = mainView.getPenulis();
        String Penerbit = mainView.getPenerbit();
        String Lokasi = mainView.getLokasi();
        String Stok = mainView.getStok();
        
      //  String JK = mainView.getJK(); Pakai RB abil data
        
        if (Judul.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Judul Masih Kosong !");
        }
        else if (Genre.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Genre Masih Kosong !");
        }
        else if (Penulis.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Penulis Masih Kosong !");
        }
        else if (Penerbit.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Penerbit Kelamin Masih Kosong !");
        }
        else if (Lokasi.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Lokasi Masih Kosong !");
        }
        else if (Stok.trim().equals("")) {
            JOptionPane.showMessageDialog(mainView,"Stok Masih Kosong !");
        }
        else{
            if(JOptionPane.showConfirmDialog(null, "Anda Yakin?", "Update Data", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                mo.updateForm(mainView);
                mo.resetForm();  
            }
            else{
            } 
        }
    }
    
    public void deleteForm(MainView mainView){
        String pKey = mainView.getPKey();
        if (pKey == null) {
            JOptionPane.showMessageDialog(mainView,"Data belum dipilih !");
        }
        else {
            if(JOptionPane.showConfirmDialog(null, "Anda Yakin?", "Hapus Data", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                mo.deleteForm(mainView);
                mo.resetForm();
            }
        }
    }
    
    public void resetForm(MainView mainView){
        String Judul = mainView.getJudul();
        String Genre = mainView.getGenre();
        String Penulis = mainView.getPenulis();
        String Penerbit = mainView.getPenerbit();
        String Lokasi = mainView.getLokasi();
        String Stok = mainView.getStok();
        
        if (Judul.equals("")&&Genre.equals("")&&Penulis.equals("")&&Penerbit.equals("")&&Lokasi.equals("")&&Stoks.equals("")) {
        }
        else{
            mo.resetForm();
        }
    }
    
    public void resetFormUbah(MainView mainView){
        String Judul = mainView.getJudulUbah();
        String Genre = mainView.getGenreUbah();
        String Penulis = mainView.getPenulisUbah();
        String Penerbit = mainView.getPenerbitUbah();
        String Lokasi = mainView.getLokasiUbah();
        String Stok = mainView.getStokUbah();
        
        if (Judul.equals("")&&Genre.equals("")&&Penulis.equals("")&&Penerbit.equals("")&&Lokasi.equals("")&&Stoks.equals("")) {
        }
        else{
            mo.resetForm();
        }
    }
    
}
