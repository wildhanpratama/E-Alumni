<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_karyawan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}


$id_karyawan = id_otomatis("data_karyawan", "id_karyawan", "10");
              $nama_depan=xss($_POST['nama_depan']);
              $nama_belakang=xss($_POST['nama_belakang']);
              $alamat=xss($_POST['alamat']);
              $email=xss($_POST['email']);
              $no_telepon=xss($_POST['no_telepon']);
              $kategori=xss($_POST['kategori']);
              $kota=xss($_POST['kota']);
              $tahun_masuk=xss($_POST['tahun_masuk']);
              $tahun_keluar=xss($_POST['tahun_keluar']);
              $bidang_keahlian=xss($_POST['bidang_keahlian']);
              $id_sekolah=xss($_POST['id_sekolah']);
              $linkedin=xss($_POST['linkedin']);
              $instagram=xss($_POST['instagram']);
              $facebook=xss($_POST['facebook']);
              $foto=upload('foto');
              $username=xss($_POST['username']);
              $password=md5($_POST['password']);


$query = mysql_query("insert into data_karyawan values (
'$id_karyawan'
 ,'$nama_depan'
 ,'$nama_belakang'
 ,'$alamat'
 ,'$email'
 ,'$no_telepon'
 ,'$kategori'
 ,'$kota'
 ,'$tahun_masuk'
 ,'$tahun_keluar'
 ,'$bidang_keahlian'
 ,'$id_sekolah'
 ,'$linkedin'
 ,'$instagram'
 ,'$facebook'
 ,'$foto'
 ,'$username'
 ,'$password'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
