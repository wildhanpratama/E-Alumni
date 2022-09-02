<?php 
require_once('../../../include/all_include.php');

$id_admin=isset($_POST["id_admin"]) ? $_POST["id_admin"]:"";
$nama_depan=isset($_POST["nama_depan"]) ? $_POST["nama_depan"]:"";
$nama_belakang=isset($_POST["nama_belakang"]) ? $_POST["nama_belakang"]:"";
$alamat=isset($_POST["alamat"]) ? $_POST["alamat"]:"";
$email=isset($_POST["email"]) ? $_POST["email"]:"";
$no_telepon=isset($_POST["no_telepon"]) ? $_POST["no_telepon"]:"";
$hak_akses=isset($_POST["hak_akses"]) ? $_POST["hak_akses"]:"";
$id_sekolah=isset($_POST["id_sekolah"]) ? $_POST["id_sekolah"]:"";
$status_pekerjaan=isset($_POST["status_pekerjaan"]) ? $_POST["status_pekerjaan"]:"";
$foto=isset($_POST["foto"]) ? $_POST["foto"]:"";
$username=isset($_POST["username"]) ? $_POST["username"]:"";
$password=isset($_POST["password"]) ? $_POST["password"]:"";


$query=mysql_query("insert into data_admin values (
'$id_admin'
,'$nama_depan'
,'$nama_belakang'
,'$alamat'
,'$email'
,'$no_telepon'
,'$hak_akses'
,'$id_sekolah'
,'$status_pekerjaan'
,'$foto'
,'$username'
,'$password'

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
