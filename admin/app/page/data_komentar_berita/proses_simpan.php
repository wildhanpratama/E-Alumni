<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_komentar_berita'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}


$id_komentar_berita = id_otomatis("data_komentar_berita", "id_komentar_berita", "10");
              $id_berita=xss($_POST['id_berita']);
              $id_alumni=xss($_POST['id_alumni']);
              $tanggal=xss($_POST['tanggal']);
              $komentar=xss($_POST['komentar']);


$query = mysql_query("insert into data_komentar_berita values (
'$id_komentar_berita'
 ,'$id_berita'
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
