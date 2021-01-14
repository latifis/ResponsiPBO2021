
import java.sql.*;
import javax.swing.JOptionPane;
public class ModelForm {
    private String Id;
    private String Judul;
    private String Genre;
    private String Penulis;
    private String Penerbit;
    private String Lokasi;
    private String Stok;
    private String[][] data;
    private ListenerForm listenerForm;
    
    Connector connect = new Connector();
    
    protected void fireOnChange(){
        if (listenerForm != null) {
            listenerForm.onChange(this);
        }
    }
    
    public ListenerForm getFormListener(){
        return listenerForm;
    }
    public void setFormListener(ListenerForm listenerForm){
        this.listenerForm = listenerForm;
    }
    
    public String getId(){
        return Id;
    }
    public void setId(String Id){
        this.Id = Id;
        fireOnChange();
    }
    
    public String getJudul(){
        return Judul;
    }
    public void setJudul(String Judul){
        this.Judul = Judul;
        fireOnChange();
    }
    
    public String getGenre(){
        return Genre;
    }
    public void setGenre(String Genre){
        this.Genre = Genre;
        fireOnChange();
    }
    
    public String getPenulis(){
        return Penulis;
    }
    public void setPenulis(String Penulis){
        this.Penulis = Penulis;
        fireOnChange();
    }
    
    public String getPenerbit(){
        return Penerbit;
    }
    public void setPenerbit(String Penerbit){
        this.Penerbit = Penerbit;
        fireOnChange();
    }
    
    public String getLokasi(){
        return Lokasi;
    }
    public void setLokasi(String Lokasi){
        this.Lokasi = Lokasi;
        fireOnChange();
    }
    
    public String getStok(){
        return Stok;
    }
    public void setStok(String Stok){
        this.Stok = Stok;
        fireOnChange();
    }
    
    public String[][] getData(){
        BacaData();
        return data;
    }
    public void setData(String[][] data){
        this.data = data;
        fireOnChange();
    }
    
    void resetForm() {
        setJudul("");
        setGenre("");
        setPenulis("");
        setPenerbit("");
        setLokasi("");
        setStok("");
    }
    
    void submitForm(MainView mainView){
        String Id = mainView.getId();
        String Judul = mainView.getJudul();
        String Genre = mainView.getGenre();
        String Penulis = mainView.getPenulis();
        String Penerbit = mainView.getPenerbit();
        String Lokasi = mainView.getLokasi();
        String Stok = mainView.getStok();
        try{
            String query = "INSERT INTO `buku` (`id`, `judul`, `genre`, `penulis`, `penerbit`, `lokasi`, `stok`) VALUES('"+Id+"','"+Judul+"','"+Genre+"','"+Penulis+"','"+Penerbit+"','"+Lokasi+"','"+Stok+"')";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"\nInput Berhasil!!");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"\nInput Gagal!!");
            System.out.println("Error : "+ex);
        }
    }

    void updateForm(MainView mainView) {
        String Id = mainView.getIdUbah();
        String Judul = mainView.getJudulUbah();
        String Genre = mainView.getGenreUbah();
        String Penulis = mainView.getPenulisUbah();
        String Penerbit = mainView.getPenerbitUbah();
        String Lokasi = mainView.getLokasiUbah();
        String Stok = mainView.getStokUbah();
        try{
            String query = "UPDATE `buku` SET `id` = '"+id+"',  `Judul` = '"+judul+"',`Genre` = '"+genre+"', `Penulis` = '"+penulis+"', `Penerbit` = '"+penerbit+"', `Lokasi` = '"+lokasi+"', `Stok` = '"+stok+"' WHERE `buku`.`id` = '"+Id+"' ";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Berhasil !!");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Update Gagal!!\nError: "+ex);
            }
        
    }
    
    void deleteForm(MainView mainView) {
        String pkey = mainView.getPKey();
        try{
            String query = "DELETE FROM `buku` WHERE `buku`.`id` = \'"+pkey+"\'";
            // eksekusi query hapus data database
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Hapus Berhasil !!");
            // kosongkan form
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Hapus Gagal !!\n\nError: "+ex);
        }
    }
    // membaca data pada tabel siswa di database
    void BacaData(){  
        try{
            String row[][] = new String[getBanyakData()][7];
            String query = "SELECT * FROM buku";
            connect.statement = connect.koneksi.createStatement();
            ResultSet resultSet = connect.statement.executeQuery(query);
            int jmldata = 0;
            while(resultSet.next()){
                row[jmldata][0] = resultSet.getString("Id");
                row[jmldata][1] = resultSet.getString("Judul");
                row[jmldata][1] = resultSet.getString("Genre");
                row[jmldata][1] = resultSet.getString("Penulis");
                row[jmldata][2] = resultSet.getString("Penerbit");
                row[jmldata][3] = resultSet.getString("Lokasi");
                row[jmldata][4] = resultSet.getString("Stok");
                jmldata++;   
            }
            setData(row);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
    // menghitung jumlah baris data siswa pada database
    public int getBanyakData(){
        try{
            String query = "SELECT * FROM buku";
            connect.statement = connect.koneksi.createStatement();
            ResultSet resultSet = connect.statement.executeQuery(query);
            int jmldata = 0;
            while(resultSet.next()){
                jmldata++;   
            }
            return jmldata;
        }catch(SQLException e){
            System.out.println("SQL Error "+e);
            return 0;
        }
    }
}
