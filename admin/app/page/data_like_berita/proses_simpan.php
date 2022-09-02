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


$id_like_berita = id_otomatis("data_like_berita", "id_like_berita", "10");
              $tanggal=xss($_POST['tanggal']);
              $id_berita=xss($_POST['id_berita']);
              $id_alumni=xss($_POST['id_alumni']);


$query = mysql_query("insert into data_like_berita values (
'$id_like_berita'
 ,'$tanggal'
 ,'$id_berita'
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
