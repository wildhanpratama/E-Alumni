<?php 
require_once('../../../admin/include/koneksi/koneksi.php');
$resp = [];
$resp["status"]="success";
$resp["result"] = array();
$hasil['id']    = "0";
$hasil['nama']  = "- Pilih Data -";
array_push($resp["result"], $hasil);

$query = "select * from data_sekolah";
$proses = mysql_query($query);	
  while($data = mysql_fetch_array($proses))
  {

    $hasil['id']    = $data['id_sekolah'];
    $hasil['nama']    = $data['nama_sekolah'];
	
    array_push($resp["result"], $hasil);
  }
echo (json_encode($resp)) 
?>
