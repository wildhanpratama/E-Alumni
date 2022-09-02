<?php 
require_once('../../../include/all_include.php');


$caption=isset($_POST["caption"]) ? $_POST["caption"]:"";
$tanggal=isset($_POST["tanggal"]) ? $_POST["tanggal"]:"";
$foto=isset($_POST["foto"]) ? $_POST["foto"]:"";
$id_alumni=isset($_POST["id_alumni"]) ? $_POST["id_alumni"]:"";
$jumlah_like="0";
$jumlah_komen="0";
$tgl = date('Y-m-d');

if ($tanggal == "Berita")
{
	$id_berita=id_otomatis("data_berita", "id_berita", "10");
	$query=mysql_query("insert into data_berita values (
'$id_berita'
,'$caption'
,'$tgl'
,'$foto'
,'$id_alumni'
,'$jumlah_like'
,'$jumlah_komen'

)");
}
else
{
	$id_berita=id_otomatis("data_kenangan", "id_kenangan", "10");
	$query=mysql_query("insert into data_kenangan values (
'$id_berita'
,'$caption'
,'$tgl'
,'$foto'
,'$id_alumni'
,'$jumlah_like'
,'$jumlah_komen'

)");
}


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
