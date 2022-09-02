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


$id_jawaban_akreditas = id_otomatis("data_jawaban_akreditas", "id_jawaban_akreditas", "10");
              $id_pertanyaan_akreditas=xss($_POST['id_pertanyaan_akreditas']);
              $jawaban=xss($_POST['jawaban']);
              $id_alumni=xss($_POST['id_alumni']);


$query = mysql_query("insert into data_jawaban_akreditas values (
'$id_jawaban_akreditas'
 ,'$id_pertanyaan_akreditas'
 ,'$jawaban'
 ,'$id_alumni'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
