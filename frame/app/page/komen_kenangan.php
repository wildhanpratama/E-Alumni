<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';

$id_komentar_kenangan = id_otomatis("data_komentar_kenangan", "id_komentar_kenangan", "10");
$id_kenangan=xss($_GET['id_kenangan']);
$id_alumni=xss($_GET['id_alumni']);
$tanggal=date('Y-m-d');
$komentar=xss($_GET['komentar']);


$query = mysql_query("insert into data_komentar_kenangan values (
'$id_komentar_kenangan'
 ,'$id_kenangan'
 ,'$id_alumni'
 ,'$tanggal'
 ,'$komentar'

)");
?>

<Script>
    window.location.href = "detail_kenangan.php?id_kenangan=<?php echo $id_kenangan;?>&id_alumni=<?php echo $id_alumni;?>";
</Script>