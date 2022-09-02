<?php 
require_once('../../../include/all_include.php');

$id_jawaban_akreditas=isset($_POST["id_jawaban_akreditas"]) ? $_POST["id_jawaban_akreditas"]:"";
$id_pertanyaan_akreditas=isset($_POST["id_pertanyaan_akreditas"]) ? $_POST["id_pertanyaan_akreditas"]:"";
$jawaban=isset($_POST["jawaban"]) ? $_POST["jawaban"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";


$query=mysql_query("insert into data_jawaban_akreditas values (
'$id_jawaban_akreditas'
,'$id_pertanyaan_akreditas'
,'$jawaban'
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
