<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';

$id_komentar_berita = id_otomatis("data_komentar_berita", "id_komentar_berita", "10");
$id_berita=xss($_GET['id_berita']);
$id_alumni=xss($_GET['id_alumni']);
$tanggal=date('Y-m-d');
$komentar=xss($_GET['komentar']);


$query = mysql_query("insert into data_komentar_berita values (
'$id_komentar_berita'
 ,'$id_berita'
 ,'$id_alumni'
 ,'$tanggal'
 ,'$komentar'

)");
?>

<Script>
    window.location.href = "detail_berita.php?id_berita=<?php echo $id_berita;?>&id_alumni=<?php echo $id_alumni;?>";
</Script>