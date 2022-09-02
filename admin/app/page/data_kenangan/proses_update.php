<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_kenangan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_kenangan = xss($_POST['id_kenangan']);
$caption = xss($_POST['caption']);
$tanggal = xss($_POST['tanggal']);
$foto=($_FILES['foto']['name']); if (empty($foto)){$foto = $_POST['foto1'];} else { $foto = upload('foto');};
$id_alumni = xss($_POST['id_alumni']);
$jumlah_like = xss($_POST['jumlah_like']);
$jumlah_komen = xss($_POST['jumlah_komen']);


$query = mysql_query("update data_kenangan set 
caption='$caption',
tanggal='$tanggal',
foto='$foto',
id_alumni='$id_alumni',
jumlah_like='$jumlah_like',
jumlah_komen='$jumlah_komen'

where id_kenangan='$id_kenangan' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
