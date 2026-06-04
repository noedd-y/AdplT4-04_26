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

Ide Pattern Strategy:
- Singleton, karena hanya akan mengunakan 1 database (untuk sementara)
- State, untuk implementasi status buku
