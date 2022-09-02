<?php 
require_once('../../../include/all_include.php');

$id_jawaban_akreditas=isset($_POST["id_jawaban_akreditas"]) ? $_POST["id_jawaban_akreditas"]:"";
$id_pertanyaan_akreditas=isset($_POST["id_pertanyaan_akreditas"]) ? $_POST["id_pertanyaan_akreditas"]:"";
$jawaban=isset($_POST["jawaban"]) ? $_POST["jawaban"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";


$sql = "UPDATE data_jawaban_akreditas SET 
id_pertanyaan_akreditas=?,
jawaban=?,
id_alumni=?,

WHERE id_jawaban_akreditas=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$id_pertanyaan_akreditas,
$jawaban,
$id_alumni,

$id_jawaban_akreditas]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
