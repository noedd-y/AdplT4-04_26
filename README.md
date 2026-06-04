Topik - Sistem Manajemen Perpustakaan
Sistem ini mengelola koleksi buku (menambah, menghapus, mencari, melacak riwayatpeminjaman), anggota perpustakaan, serta transaksi peminjaman dan pengembalikanbuku.

End User
- Librarian
- User (Member)
- Admin (opsional)

Entitas (Selain End User)
- Buku 
- Database perpus yang menyimpan buku yang pernah ada, anggota perpustakaan, semua transaksi/peminjaman 
- Transaksi Riwayat peminjaman/pengembalian

User dapat:
- Meminjam buku (Borrow)
- Mengreservasi buku (Reserve)
- Mengembali buku (Return)
- Mencari buku dan datanya (lokasi di rak, jika bisa di pinjam)
- Filter kategori

Librarian dapat:
- Menambah buku
- Menghapus (Soft delete) buku
- Melacak transaksi (riwayat peminjaman)
- Mencari buku dan datanya
- Filter kategori
- Sorting judul
- Edit buku

Database dapat:
- Menyimpan semua buku yang ada
- Menyimpan semua transaksi
- Menyimpan data user/member
- Operasi CRUD ke entitas tersebut.

Buku dapat:
- Buku mempunyai lokasi di rak perpus
- berganti status jika: ada, dipinjam, direserve, atau hilang (tidak ada)/rusak (tidak layak)
- buku dapat di sort secara kategori

---------------------------------------

Ide Pattern Strategy yang mencakupi minimum requirement:
- Singleton (creational), karena hanya akan mengunakan 1 database (untuk sementara)
- State (behaviorial), untuk implementasi status buku
- Factory (creational), untuk implementasi tipe buku
- Strategy (behavioral), untuk sorting buku dari bbrp kategori
- Facade (structure), untuk abstraksi semua logic
- command (behavioral), karena banyak perintah

Tambahan:
- Builder, karena buku mungkin punya attribut yang lainya tidak butuh 
- Decorator, untuk buku yang memiliki fitur beda

--------------------------------------

Note 1:
Factory untuk implementasi buku tidak terlalu efektif karena, dengan asumsi semua buku di perpus adalah buku fisik, tidak ada yang membedakan atribut atau method baru buku dengan satu sama lain.

--------------------------------------

Note 2:
Dengan adanya transaksi yang dibuat untuk semua transaksi buku yang ada (e.g. meminjam, mereservasi, mengembalikan), awalnya dibuat dengan mencatat date transaksi dan return date (untuk return). Dengan diskusi lebih lanjut dinyatakan transaksi bisa dibuat multiple tipe dan mengimplementasikan pattern design factory, karena meminjam belum tentu ada return date, atau mereservasi bisa mempunyai date untuk mengambil dan bisa dicancel.
