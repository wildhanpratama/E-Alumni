<?php 
require_once('../../../include/all_include.php');

$id_komentar_berita=isset($_POST["id_komentar_berita"]) ? $_POST["id_komentar_berita"]:"";
$id_berita=isset($_POST["id_berita"]) ? $_POST["id_berita"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$komentar=isset($_POST["komentar"]) ? $_POST["komentar"]:"";


$sql = "UPDATE data_komentar_berita SET 
id_berita=?,
id_alumni=?,
tanggal=?,
komentar=?,

WHERE id_komentar_berita=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$id_berita,
$id_alumni,
$tanggal,
$komentar,

$id_komentar_berita]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
