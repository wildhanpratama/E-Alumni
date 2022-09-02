<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_like_kenangan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_like_kenangan = xss($_POST['id_like_kenangan']);
$tanggal = xss($_POST['tanggal']);
$id_kenangan = xss($_POST['id_kenangan']);
$id_alumni = xss($_POST['id_alumni']);


$query = mysql_query("update data_like_kenangan set 
tanggal='$tanggal',
id_kenangan='$id_kenangan',
id_alumni='$id_alumni'

where id_like_kenangan='$id_like_kenangan' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
