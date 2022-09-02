<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_like_berita'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_like_berita = xss($_POST['id_like_berita']);
$tanggal = xss($_POST['tanggal']);
$id_berita = xss($_POST['id_berita']);
$id_alumni = xss($_POST['id_alumni']);


$query = mysql_query("update data_like_berita set 
tanggal='$tanggal',
id_berita='$id_berita',
id_alumni='$id_alumni'

where id_like_berita='$id_like_berita' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
