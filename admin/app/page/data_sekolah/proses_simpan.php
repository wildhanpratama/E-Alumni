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


$id_sekolah = id_otomatis("data_sekolah", "id_sekolah", "10");
$nama_sekolah = xss($_POST['nama_sekolah']);
$alamat = xss($_POST['alamat']);
$email = xss($_POST['email']);
$no_telepon = xss($_POST['no_telepon']);
$kota = xss($_POST['kota']);
$deskripsi = xss($_POST['deskripsi']);


$query = mysql_query("insert into data_sekolah values (
'$id_sekolah'
 ,'$nama_sekolah'
 ,'$alamat'
 ,'$email'
 ,'$no_telepon'
 ,'$kota'
 ,'$deskripsi'

)");

if ($query) {
?>
    <script>
        location.href = "<?php index(); ?>?input=popup_tambah";
    </script>
<?php
} else {
    echo "GAGAL DIPROSES";
}
?>
