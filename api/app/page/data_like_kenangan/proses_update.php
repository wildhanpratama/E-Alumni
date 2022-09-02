<?php 
require_once('../../../include/all_include.php');

$id_like_kenangan=isset($_POST["id_like_kenangan"]) ? $_POST["id_like_kenangan"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$id_kenangan=isset($_POST["id_kenangan"]) ? $_POST["id_kenangan"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";


$sql = "UPDATE data_like_kenangan SET 
tanggal=?,
id_kenangan=?,
id_alumni=?,

WHERE id_like_kenangan=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$tanggal,
$id_kenangan,
$id_alumni,

$id_like_kenangan]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
