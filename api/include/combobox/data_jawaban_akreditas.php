<?php 
require_once('../../../admin/include/koneksi/koneksi.php');
$resp = [];
$resp["status"]="success";
$resp["result"] = array();
$hasil['id']    = "0";
$hasil['nama']  = "- Pilih Data -";
array_push($resp["result"], $hasil);

$query = "select * from data_jawaban_akreditas";
$proses = mysql_query($query);	
  while($data = mysql_fetch_array($proses))
  {

    $hasil['id']    = $data['id_jawaban_akreditas'];
    $hasil['nama']    = $data['id_pertanyaan_akreditas'];
	
    array_push($resp["result"], $hasil);
  }
echo (json_encode($resp)) 
?>
