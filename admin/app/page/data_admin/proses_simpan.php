<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_admin'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}


$id_admin = id_otomatis("data_admin", "id_admin", "10");
              $nama_depan=xss($_POST['nama_depan']);
              $nama_belakang=xss($_POST['nama_belakang']);
              $alamat=xss($_POST['alamat']);
              $email=xss($_POST['email']);
              $no_telepon=xss($_POST['no_telepon']);
              $hak_akses=xss($_POST['hak_akses']);
              $id_sekolah=xss($_POST['id_sekolah']);
              $status_pekerjaan=xss($_POST['status_pekerjaan']);
              $foto=upload('foto');
              $username=xss($_POST['username']);
              $password=md5($_POST['password']);


$query = mysql_query("insert into data_admin values (
'$id_admin'
 ,'$nama_depan'
 ,'$nama_belakang'
 ,'$alamat'
 ,'$email'
 ,'$no_telepon'
 ,'$hak_akses'
 ,'$id_sekolah'
 ,'$status_pekerjaan'
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
