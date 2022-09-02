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


$id_like_kenangan = id_otomatis("data_like_kenangan", "id_like_kenangan", "10");
              $tanggal=xss($_POST['tanggal']);
              $id_kenangan=xss($_POST['id_kenangan']);
              $id_alumni=xss($_POST['id_alumni']);


$query = mysql_query("insert into data_like_kenangan values (
'$id_like_kenangan'
 ,'$tanggal'
 ,'$id_kenangan'
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
