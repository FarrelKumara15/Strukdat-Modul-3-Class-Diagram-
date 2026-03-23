# Strukdat-Modul-3-Class-Diagram

### Deskripsi
Sebuah toko kecil selama ini melakukan pengelolaan karyawan secara manual menggunakan catatan. Metode tersebut memiliki beberapa masalah seperti:<br/>
1. Data karyawan diperbarui
2. Jadwal kerja kurang terorganisir
3. Perhitungan gaji kurang rapi
4. Sulir mengahapus atau mencari data tertentu
   
Dari masalah tersebut dapat dibuat program Sistem Manajemen Karyawan Toko berbasis Java dengan OOP, yang dapat mengelola:
1. Data karyawan
2. Jadwal kerja karyawan
3. penggajian karyawan

<br/>
## Class Diagram
![alt text](https://github.com/FarrelKumara15/Strukdat-Modul-3-Class-Diagram-/blob/main/Gambar/Manajemen%20Karyawan%20Toko.png)

<br/>
### Prinsip OOP 
**Encapsulation**

Atribut pada class disembunyikan menggunakan access modifier private.

```bash
private int id;
private String nama;
private String jabatan;
```

Atribut tersebut hanya dapat diakses melalui getter dan setter.

**Inheritance**

```bash
Class Karyawan, Jadwal, dan Gaji mewarisi class DataToko.

class Karyawan extends DataToko
class Jadwal extends DataToko
class Gaji extends DataToko
```
Hal ini memungkinkan subclass menggunakan method dari superclass.

**Polymorphism**

Polymorphism diterapkan dengan method overriding pada method tampil().
```bash
@Override
public void tampil()
```

Setiap class memiliki implementasi method tampil() yang berbeda.

**Abstraction**

Class Toko berfungsi sebagai konsep umum yang merepresentasikan data dalam sistem toko.
