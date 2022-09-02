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

$id_akreditas = xss($_POST['id_akreditas']);
$nama_lengkap = xss($_POST['nama_lengkap']);
$nisn = xss($_POST['nisn']);
$kelas = xss($_POST['kelas']);
$tahun_lulus = xss($_POST['tahun_lulus']);
$email = xss($_POST['email']);
$status_pekerjaan = xss($_POST['status_pekerjaan']);


$query = mysql_query("update data_akreditas set 
nama_lengkap='$nama_lengkap',
nisn='$nisn',
kelas='$kelas',
tahun_lulus='$tahun_lulus',
email='$email',
status_pekerjaan='$status_pekerjaan'

where id_akreditas='$id_akreditas' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
