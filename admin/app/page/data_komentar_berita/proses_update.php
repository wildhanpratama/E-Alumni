<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_komentar_berita'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_komentar_berita = xss($_POST['id_komentar_berita']);
$id_berita = xss($_POST['id_berita']);
$id_alumni = xss($_POST['id_alumni']);
$tanggal = xss($_POST['tanggal']);
$komentar = xss($_POST['komentar']);


$query = mysql_query("update data_komentar_berita set 
id_berita='$id_berita',
id_alumni='$id_alumni',
tanggal='$tanggal',
komentar='$komentar'

where id_komentar_berita='$id_komentar_berita' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
