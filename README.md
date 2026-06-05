Topik - Sistem Manajemen Perpustakaan
Sistem ini mengelola koleksi buku (menambah, menghapus, mencari, melacak riwayatpeminjaman), anggota perpustakaan, serta transaksi peminjaman dan pengembalikanbuku.

End User
- Librarian
- User (Member)

Entitas (Selain End User)
- Buku 
- Transaksi Riwayat peminjaman/pengembalian

Database perpus yang menyimpan buku yang pernah ada, anggota perpustakaan, semua transaksi/peminjaman 

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

Note 1.0:
Factory untuk implementasi buku tidak terlalu efektif karena, dengan asumsi semua buku di perpus adalah buku fisik, tidak ada yang membedakan atribut atau method baru buku dengan satu sama lain.

--------------------------------------

Note 2.0:
Dengan adanya transaksi yang dibuat untuk semua transaksi buku yang ada (e.g. meminjam, mereservasi, mengembalikan), awalnya dibuat dengan mencatat date transaksi dan return date (untuk return). Dengan diskusi lebih lanjut dinyatakan transaksi bisa dibuat multiple tipe dan mengimplementasikan pattern design factory, karena meminjam belum tentu ada return date, atau mereservasi bisa mempunyai date untuk mengambil dan bisa dicancel.

Note 2.1:
Factory ingin dibuat untuk 3 transaksi, namun mengembalilkan mungkin tidak terlalu terkena impact dan kurang efektif dari implementasi factory karena tidak ada bedanya dari concrete class dan abstract classnya. Namun factory masih akan digunakan karena reservasi dan meminjam masih butuh method dan attribut additional. mungkin return bisa ditambah jika bukunya rusak atau tidak.

Note 2.2:
Setelah konsiderasi lagi, karena transaksi adalah riwayat, dan bersifat immutable (read only, tidak bisa diubah), mungkin lebih baik transaksi di simpelkan menjadi 1 kelas lagi daripada membuat subclasses dan factory, dengan attribut yang dapat bersifat null (mengunakan method overloading) untuk tipe transaksi tertentu, dan tambahan variable untuk menyatakan tipe transaksinya.

------------

Note 3.0:
Setelah implementasi design pattern command, ternyata tidak terlalu efektif karena setiap command untuk setiap buku dan setiap user menjadi object baru yang biasanya hanya dipakai sekali, mungkin bisa dipertimbangkan

Note 3.1:
Implementasi command ditetapkan, karena command reservasi bisa di cancel (undo) dan jika command return book di undo, maka mengcancel return = extend borrow book, dan create new transaction karena memanggil method borrow book lagi (dari facade)

-----------

Note 4.0:
Implementasi proxy dipertimbangkan untuk membelah akses user biasa dengan librarian (admin), namun bisa juga membelah facade menjadi 2, user facade dan librarian (admin) facade. Jadi, akses untuk memanggil method sudah dibagi secara struktur kelas.
