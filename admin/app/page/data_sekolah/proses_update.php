<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_sekolah'])) {
?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
<?php
    die();
}

$id_sekolah = xss($_POST['id_sekolah']);
$nama_sekolah = xss($_POST['nama_sekolah']);
$alamat = xss($_POST['alamat']);
$email = xss($_POST['email']);
$no_telepon = xss($_POST['no_telepon']);
$kota = xss($_POST['kota']);
$deskripsi = xss($_POST['deskripsi']);


$query = mysql_query("update data_sekolah set 
nama_sekolah='$nama_sekolah',
alamat='$alamat',
email='$email',
no_telepon='$no_telepon',
kota='$kota',
deskripsi='$deskripsi'

where id_sekolah='$id_sekolah' ") or die(mysql_error());

if ($query) {
?>
    <script>
        location.href = "<?php index(); ?>?input=popup_edit";
    </script>
<?php
} else {
    echo "GAGAL DIPROSES";
}
?>
