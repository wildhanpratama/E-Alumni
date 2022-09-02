<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_pertanyaan_akreditas'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_pertanyaan_akreditas = xss($_POST['id_pertanyaan_akreditas']);
$id_sekolah = xss($_POST['id_sekolah']);
$pertanyaan = xss($_POST['pertanyaan']);


$query = mysql_query("update data_pertanyaan_akreditas set 
id_sekolah='$id_sekolah',
pertanyaan='$pertanyaan'

where id_pertanyaan_akreditas='$id_pertanyaan_akreditas' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
