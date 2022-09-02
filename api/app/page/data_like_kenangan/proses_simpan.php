<?php 
require_once('../../../include/all_include.php');

$id_like_kenangan=isset($_POST["id_like_kenangan"]) ? $_POST["id_like_kenangan"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$id_kenangan=isset($_POST["id_kenangan"]) ? $_POST["id_kenangan"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";


$query=mysql_query("insert into data_like_kenangan values (
'$id_like_kenangan'
,'$tanggal'
,'$id_kenangan'
,'$id_alumni'

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
