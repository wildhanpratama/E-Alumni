<?php 
require_once('../../../include/all_include.php');

$id_like_berita=isset($_POST["id_like_berita"]) ? $_POST["id_like_berita"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$id_berita=isset($_POST["id_berita"]) ? $_POST["id_berita"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";


$query=mysql_query("insert into data_like_berita values (
'$id_like_berita'
,'$tanggal'
,'$id_berita'
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
