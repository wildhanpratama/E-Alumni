<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_akreditas'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}


$id_akreditas = id_otomatis("data_akreditas", "id_akreditas", "10");
              $nama_lengkap=xss($_POST['nama_lengkap']);
              $nisn=xss($_POST['nisn']);
              $kelas=xss($_POST['kelas']);
              $tahun_lulus=xss($_POST['tahun_lulus']);
              $email=xss($_POST['email']);
              $status_pekerjaan=xss($_POST['status_pekerjaan']);


$query = mysql_query("insert into data_akreditas values (
'$id_akreditas'
 ,'$nama_lengkap'
 ,'$nisn'
 ,'$kelas'
 ,'$tahun_lulus'
 ,'$email'
 ,'$status_pekerjaan'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
