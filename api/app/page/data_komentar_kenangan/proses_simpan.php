<?php 
require_once('../../../include/all_include.php');

$id_komentar_kenangan=isset($_POST["id_komentar_kenangan"]) ? $_POST["id_komentar_kenangan"]:"";
$id_kenangan=isset($_POST["id_kenangan"]) ? $_POST["id_kenangan"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$komentar=isset($_POST["komentar"]) ? $_POST["komentar"]:"";


$query=mysql_query("insert into data_komentar_kenangan values (
'$id_komentar_kenangan'
,'$id_kenangan'
,'$id_alumni'
,'$tanggal'
,'$komentar'

)");

$resp = [];
if($query){
	$resp["status"]="success";
}
else
{
	$resp["status"]="gagal";
}

echo (json_encode($resp)) 
?>
