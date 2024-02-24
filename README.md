> Fari Hafizh Ramadhan - 2206083691

# Modul 3: Maintainability & OO Principles

## Refleksi

1. Prinsip yang saya gunakan sebagai berikut:
- Prinsip Tanggung Jawab Tunggal (SRP): Saya memisahkan fungsi-fungsi yang memiliki tugas atau tanggung jawab yang berbeda ke dalam kelas-kelas terpisah sehingga setiap kelas hanya fokus pada satu tugas spesifik. Sebagai contoh, saya memisahkan CarController dari ProductController dan ProductFinder dari ProductRepository. 

- Prinsip Segregasi Interface (ISP): Setiap kelas diimplementasikan dengan antarmuka yang relevan dengan fungsinya. Sebagai contoh, CarRepository mengimplementasikan CarRepoInterface, dan ProductRepository mengimplementasikan ProductRepoInterface. Begitu pula dengan implementasi antarmuka pada layanan, seperti ProductService dan CarService.

- Prinsip Inversi Ketergantungan (DIP): Kelas seharusnya bergantung pada antarmuka atau kelas abstrak, bukan kelas konkret. Sebagai contoh, pada CarController, carService seharusnya menggunakan antarmuka CarService, bukan langsung menggunakan CarServiceImpl.

2. Beberapa manfaat sebagai berikut:
- Kode Lebih Mudah Dimengerti
Contoh: CarController untuk logika kendaraan, ProductController untuk logika produk.
- Ketergantungan Terbalik
Membuat proyek lebih mudah diuji dan dikonfigurasi ulang.
- Penggunaan Kembali Kode
Memungkinkan penggunaan kembali kode tanpa banyak modifikasi.

3. Beberapa kerugian sebagai berikut:
- Kesulitan Pemeliharaan
Contoh: Satu kelas Controller yang menangani banyak logika terkait.
- Ketergantungan yang Kuat
Contoh: CarController yang bergantung langsung pada CarServiceImpl.
- Duplikasi Kode
Contoh: Fungsi yang serupa diimplementasikan berulang kali dalam kelas yang berbeda.
# Modul 2: CI/CD & DevOps

## Refleksi

1. Setelah dilakukan *code scanning* terlihat beberapa *issue* yang ditemukan, beberapa diantaranya:
   - **Unused import**:
   Dengan menghapus import - import yang tidak digunakan.

   - **Maintained**:
   Dengan melakukan *maintenance* rutin terhadap kode kita.
   

2. Menurut saya, implementasi yang saya lakukan sudah memenuhi prinsip CI/CD.
   untuk *continuous integration* saya terapkan dengan menggunakan *workflows* seperti `ci.yml`, `scorecard.yml`, dan `pmd_action.yml`.
   untuk *continuous deployment* saya menggunakan `koyeb` untuk melakukan *auto-deployment* saat ada perubahan di branch main.

# Modul 1: Coding Standards

## Refleksi 1

Setelah melalui perkuliahan minggu pemrograman lanjut pada minngu ini, saya menulis kode dengan lebih memerhatikan
kejelasan kode saya, diantaranya

- Penulisan variabel yang mendeskripsikan dan ***to the point***
- Penggunaan fungsi yang di dalamnya hanya mengerjakan 1 pekerjaan saja
- Tidak berlebihan menuliskan komen

Untuk kode saya dalam lab ini, saya menyadari bahwa saya tidak menerapkan ***secure coding*** yang artinya tidak ada
filtering terhadap informasi yang terpaparkan. Hal ini tentunya akan berbahaya
saat kita membuat program yang menyimpan data pribadi seseorang. Hal tersebut dapat dihindari
dengan menerapkan autentikasi yang lebih baik.

## Refleksi 2

1. Setelah menulis uji unit, saya merasa lebih percaya diri dengan kode saya.
   Untuk uji unit sendiri sebisanya tergantung kompleksnya suatu kelas dan fungsi.
   Uji unit juga diusahakan dapat mencakup banyak skenario dan kasus untuk mengurangi
   terjadinya *bug*. 100% *code coverage* belum menjamin kesempurnaan kode, pasti *bug* atau *error*masih sangat mungkin terjadi. Dasaranya masih banyak aspek - aspek lain yang dapat menentukan sebuh kode bebas dari *bug*.


2. Ketika membuat *functional test* baru dengan prosedur dan variabel yang sama, ada kemungkinan kita merusak *code cleanliness*.
   Dalam pembuatannya kita harus mempertimbangkan berbagai hal, seperti menghindari duplikasi kode, memastikan keterbacaan dan
   pemeliharaan dengan format penamaan yang konsisten, serta menjaga isolasi uji untuk mencegah ketergantungan. Dengan memerhatikan hal - hal
   tersebut, kita bisa menjaga *code cleanliness*.