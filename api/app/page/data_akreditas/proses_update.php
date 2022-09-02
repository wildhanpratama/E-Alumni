<?php 
require_once('../../../include/all_include.php');

$id_akreditas=isset($_POST["id_akreditas"]) ? $_POST["id_akreditas"]:"";
$nama_lengkap=isset($_POST["nama_lengkap"]) ? $_POST["nama_lengkap"]:"";
$nisn=isset($_POST["nisn"]) ? $_POST["nisn"]:"";
$kelas=isset($_POST["kelas"]) ? $_POST["kelas"]:"";
$tahun_lulus=isset($_POST["tahun_lulus"]) ? $_POST["tahun_lulus"]:"";
$email=isset($_POST["email"]) ? $_POST["email"]:"";
$status_pekerjaan=isset($_POST["status_pekerjaan"]) ? $_POST["status_pekerjaan"]:"";


$sql = "UPDATE data_akreditas SET 
nama_lengkap=?,
nisn=?,
kelas=?,
tahun_lulus=?,
email=?,
status_pekerjaan=?,

WHERE id_akreditas=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$nama_lengkap,
$nisn,
$kelas,
$tahun_lulus,
$email,
$status_pekerjaan,

$id_akreditas]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
