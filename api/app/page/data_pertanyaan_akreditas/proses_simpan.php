<?php 
require_once('../../../include/all_include.php');

$id_pertanyaan_akreditas=isset($_POST["id_pertanyaan_akreditas"]) ? $_POST["id_pertanyaan_akreditas"]:"";
$id_sekolah=isset($_POST["id_sekolah"]) ? $_POST["id_sekolah"]:"";
$pertanyaan=isset($_POST["pertanyaan"]) ? $_POST["pertanyaan"]:"";


$query=mysql_query("insert into data_pertanyaan_akreditas values (
'$id_pertanyaan_akreditas'
,'$id_sekolah'
,'$pertanyaan'

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
