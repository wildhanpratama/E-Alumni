<?php 
require_once('../../../include/all_include.php');

$id_komentar_berita=isset($_POST["id_komentar_berita"]) ? $_POST["id_komentar_berita"]:"";
$id_berita=isset($_POST["id_berita"]) ? $_POST["id_berita"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$komentar=isset($_POST["komentar"]) ? $_POST["komentar"]:"";


$query=mysql_query("insert into data_komentar_berita values (
'$id_komentar_berita'
,'$id_berita'
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
