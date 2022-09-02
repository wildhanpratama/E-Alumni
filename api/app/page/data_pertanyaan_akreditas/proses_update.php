<?php 
require_once('../../../include/all_include.php');

$id_pertanyaan_akreditas=isset($_POST["id_pertanyaan_akreditas"]) ? $_POST["id_pertanyaan_akreditas"]:"";
$id_sekolah=isset($_POST["id_sekolah"]) ? $_POST["id_sekolah"]:"";
$pertanyaan=isset($_POST["pertanyaan"]) ? $_POST["pertanyaan"]:"";


$sql = "UPDATE data_pertanyaan_akreditas SET 
id_sekolah=?,
pertanyaan=?,

WHERE id_pertanyaan_akreditas=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$id_sekolah,
$pertanyaan,

$id_pertanyaan_akreditas]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
