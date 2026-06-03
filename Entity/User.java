package Entity;
public class User {
    String namaDepan;
    String namaBelakang;
    public User(String namaDepan, String namaBelakang) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }
    
    public String getNamaDepan() {
        return namaDepan;
    }
    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }
    public String getNamaBelakang() {
        return namaBelakang;
    }
    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }
    
}
