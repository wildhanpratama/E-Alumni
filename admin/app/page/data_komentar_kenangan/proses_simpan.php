<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_komentar_kenangan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}


$id_komentar_kenangan = id_otomatis("data_komentar_kenangan", "id_komentar_kenangan", "10");
              $id_kenangan=xss($_POST['id_kenangan']);
              $id_alumni=xss($_POST['id_alumni']);
              $tanggal=xss($_POST['tanggal']);
              $komentar=xss($_POST['komentar']);


$query = mysql_query("insert into data_komentar_kenangan values (
'$id_komentar_kenangan'
 ,'$id_kenangan'
 ,'$id_alumni'
 ,'$tanggal'
 ,'$komentar'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
