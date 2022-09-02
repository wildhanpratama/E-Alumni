<?php 
require_once('../../../include/all_include.php');

$id_sekolah=isset($_POST["id_sekolah"]) ? $_POST["id_sekolah"]:"";
$nama_sekolah=isset($_POST["nama_sekolah"]) ? $_POST["nama_sekolah"]:"";
$alamat=isset($_POST["alamat"]) ? $_POST["alamat"]:"";
$email=isset($_POST["email"]) ? $_POST["email"]:"";
$no_telepon=isset($_POST["no_telepon"]) ? $_POST["no_telepon"]:"";
$kota=isset($_POST["kota"]) ? $_POST["kota"]:"";
$deskripsi=isset($_POST["deskripsi"]) ? $_POST["deskripsi"]:"";


$query=mysql_query("insert into data_sekolah values (
'$id_sekolah'
,'$nama_sekolah'
,'$alamat'
,'$email'
,'$no_telepon'
,'$kota'
,'$deskripsi'

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
