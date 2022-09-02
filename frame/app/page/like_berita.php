<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';

$id_like_berita = id_otomatis("data_like_berita", "id_like_berita", "10");
$id_berita=xss($_GET['id_berita']);
$id_alumni=xss($_GET['id_alumni']);
$tanggal=date('Y-m-d');
$status = $_GET['status'];

if ($status == "like")
{
    $query = mysql_query("insert into data_like_berita values (
    '$id_like_berita'
     ,'$tanggal'
     ,'$id_berita'
     ,'$id_alumni'
    )");
}
else
{
    $query=mysql_query("delete from data_like_berita where id_berita='$id_berita' and id_alumni='$id_alumni'");
}

?>

<Script>
    window.location.href = "index.php?id=<?php echo $id_alumni;?>";
</Script>