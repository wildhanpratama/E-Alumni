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


$id_pertanyaan_akreditas = id_otomatis("data_pertanyaan_akreditas", "id_pertanyaan_akreditas", "10");
              $id_sekolah=xss($_POST['id_sekolah']);
              $pertanyaan=xss($_POST['pertanyaan']);


$query = mysql_query("insert into data_pertanyaan_akreditas values (
'$id_pertanyaan_akreditas'
 ,'$id_sekolah'
 ,'$pertanyaan'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
