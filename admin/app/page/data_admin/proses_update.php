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

$id_admin = xss($_POST['id_admin']);
$nama_depan = xss($_POST['nama_depan']);
$nama_belakang = xss($_POST['nama_belakang']);
$alamat = xss($_POST['alamat']);
$email = xss($_POST['email']);
$no_telepon = xss($_POST['no_telepon']);
$hak_akses = xss($_POST['hak_akses']);
$id_sekolah = xss($_POST['id_sekolah']);
$status_pekerjaan = xss($_POST['status_pekerjaan']);
$foto=($_FILES['foto']['name']); if (empty($foto)){$foto = $_POST['foto1'];} else { $foto = upload('foto');};
$username = xss($_POST['username']);
$password = md5($_POST['password']);


$query = mysql_query("update data_admin set 
nama_depan='$nama_depan',
nama_belakang='$nama_belakang',
alamat='$alamat',
email='$email',
no_telepon='$no_telepon',
hak_akses='$hak_akses',
id_sekolah='$id_sekolah',
status_pekerjaan='$status_pekerjaan',
foto='$foto',
username='$username',
password='$password'

where id_admin='$id_admin' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
