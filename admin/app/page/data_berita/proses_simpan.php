<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_berita'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}


$id_berita = id_otomatis("data_berita", "id_berita", "10");
              $caption=xss($_POST['caption']);
              $tanggal=xss($_POST['tanggal']);
              $foto=upload('foto');
              $id_alumni=xss($_POST['id_alumni']);
              $jumlah_like=xss($_POST['jumlah_like']);
              $jumlah_komen=xss($_POST['jumlah_komen']);


$query = mysql_query("insert into data_berita values (
'$id_berita'
 ,'$caption'
 ,'$tanggal'
 ,'$foto'
 ,'$id_alumni'
 ,'$jumlah_like'
 ,'$jumlah_komen'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
