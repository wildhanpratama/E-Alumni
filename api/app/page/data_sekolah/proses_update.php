<?php 
require_once('../../../include/all_include.php');

$id_sekolah=isset($_POST["id_sekolah"]) ? $_POST["id_sekolah"]:"";
$nama_sekolah=isset($_POST["nama_sekolah"]) ? $_POST["nama_sekolah"]:"";
$alamat=isset($_POST["alamat"]) ? $_POST["alamat"]:"";
$email=isset($_POST["email"]) ? $_POST["email"]:"";
$no_telepon=isset($_POST["no_telepon"]) ? $_POST["no_telepon"]:"";
$kota=isset($_POST["kota"]) ? $_POST["kota"]:"";
$deskripsi=isset($_POST["deskripsi"]) ? $_POST["deskripsi"]:"";


$sql = "UPDATE data_sekolah SET 
nama_sekolah=?,
alamat=?,
email=?,
no_telepon=?,
kota=?,
deskripsi=?,

WHERE id_sekolah=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$nama_sekolah,
$alamat,
$email,
$no_telepon,
$kota,
$deskripsi,

$id_sekolah]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
