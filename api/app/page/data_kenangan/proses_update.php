<?php 
require_once('../../../include/all_include.php');

$id_kenangan=isset($_POST["id_kenangan"]) ? $_POST["id_kenangan"]:"";
$caption=isset($_POST["caption"]) ? $_POST["caption"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$foto=isset($_POST["foto"]) ? $_POST["foto"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";
$jumlah_like=isset($_POST["jumlah_like"]) ? $_POST["jumlah_like"]:"";
$jumlah_komen=isset($_POST["jumlah_komen"]) ? $_POST["jumlah_komen"]:"";


$sql = "UPDATE data_kenangan SET 
caption=?,
tanggal=?,
foto=?,
id_alumni=?,
jumlah_like=?,
jumlah_komen=?,

WHERE id_kenangan=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$caption,
$tanggal,
$foto,
$id_alumni,
$jumlah_like,
$jumlah_komen,

$id_kenangan]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
