<?php 
require_once('../../../include/all_include.php');

$id_komentar_kenangan=isset($_POST["id_komentar_kenangan"]) ? $_POST["id_komentar_kenangan"]:"";
$id_kenangan=isset($_POST["id_kenangan"]) ? $_POST["id_kenangan"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$komentar=isset($_POST["komentar"]) ? $_POST["komentar"]:"";


$sql = "UPDATE data_komentar_kenangan SET 
id_kenangan=?,
id_alumni=?,
tanggal=?,
komentar=?,

WHERE id_komentar_kenangan=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$id_kenangan,
$id_alumni,
$tanggal,
$komentar,

$id_komentar_kenangan]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
