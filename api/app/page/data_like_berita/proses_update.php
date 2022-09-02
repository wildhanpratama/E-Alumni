<?php 
require_once('../../../include/all_include.php');

$id_like_berita=isset($_POST["id_like_berita"]) ? $_POST["id_like_berita"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$id_berita=isset($_POST["id_berita"]) ? $_POST["id_berita"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";


$sql = "UPDATE data_like_berita SET 
tanggal=?,
id_berita=?,
id_alumni=?,

WHERE id_like_berita=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$tanggal,
$id_berita,
$id_alumni,

$id_like_berita]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
