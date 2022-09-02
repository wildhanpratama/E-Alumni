<?php 
require_once('../../../include/all_include.php');

$id_akreditas=isset($_POST["id_akreditas"]) ? $_POST["id_akreditas"]:"";
$nama_lengkap=isset($_POST["nama_lengkap"]) ? $_POST["nama_lengkap"]:"";
$nisn=isset($_POST["nisn"]) ? $_POST["nisn"]:"";
$kelas=isset($_POST["kelas"]) ? $_POST["kelas"]:"";
$tahun_lulus=isset($_POST["tahun_lulus"]) ? $_POST["tahun_lulus"]:"";
$email=isset($_POST["email"]) ? $_POST["email"]:"";
$status_pekerjaan=isset($_POST["status_pekerjaan"]) ? $_POST["status_pekerjaan"]:"";


$query=mysql_query("insert into data_akreditas values (
'$id_akreditas'
,'$nama_lengkap'
,'$nisn'
,'$kelas'
,'$tahun_lulus'
,'$email'
,'$status_pekerjaan'

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
