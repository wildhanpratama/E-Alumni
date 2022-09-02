<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_jawaban_akreditas'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_jawaban_akreditas = xss($_POST['id_jawaban_akreditas']);
$id_pertanyaan_akreditas = xss($_POST['id_pertanyaan_akreditas']);
$jawaban = xss($_POST['jawaban']);
$id_alumni = xss($_POST['id_alumni']);


$query = mysql_query("update data_jawaban_akreditas set 
id_pertanyaan_akreditas='$id_pertanyaan_akreditas',
jawaban='$jawaban',
id_alumni='$id_alumni'

where id_jawaban_akreditas='$id_jawaban_akreditas' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
