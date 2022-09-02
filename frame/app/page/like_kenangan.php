<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';

$id_like_kenangan = id_otomatis("data_like_kenangan", "id_like_kenangan", "10");
$id_kenangan=xss($_GET['id_kenangan']);
$id_alumni=xss($_GET['id_alumni']);
$tanggal=date('Y-m-d');
$status = $_GET['status'];

if ($status == "like")
{
    $query = mysql_query("insert into data_like_kenangan values (
    '$id_like_kenangan'
     ,'$tanggal'
     ,'$id_kenangan'
     ,'$id_alumni'
    )");
}
else
{
    $query=mysql_query("delete from data_like_kenangan where id_kenangan='$id_kenangan' and id_alumni='$id_alumni'");
}

?>

<Script>
    window.location.href = "kenangan.php?id=<?php echo $id_alumni;?>";
</Script>