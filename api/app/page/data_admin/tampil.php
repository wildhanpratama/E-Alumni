<?php 
require_once('../../../include/all_include.php');
$resp = [];
$resp["status"]="success";
$resp["result"] = array();

if (isset($_POST['berdasarkan']) && !empty($_POST['berdasarkan']) && isset($_POST['isi']) && !empty($_POST['isi']))
{
	$berdasarkan =  mysql_real_escape_string($_POST['berdasarkan']);
	$isi =  mysql_real_escape_string($_POST['isi']);
	$limit =  mysql_real_escape_string($_POST['limit']);
	$hal =  mysql_real_escape_string($_POST['hal']);
	if (isset($_POST['dari']) && !empty($_POST['dari']) && isset($_POST['sampai']) && !empty($_POST['sampai']))
	{
		$dari =  mysql_real_escape_string($_POST['dari']);
		$sampai =  mysql_real_escape_string($_POST['sampai']);
		$query="SELECT * FROM data_admin where $berdasarkan like '%$isi%'";
	}
	else
	{
		$query="SELECT * FROM data_admin where $berdasarkan like '%$isi%'";
	}
}
else
{
	$query = "select * from data_admin";
}

$proses = mysql_query($query);	
  while($data = mysql_fetch_array($proses))
  {
	
	$id_admin = $data["id_admin"];	
    $hasil['id_admin'] = $id_admin;
	$hasil['nama_depan'] = $data["nama_depan"];
	$hasil['nama_belakang'] = $data["nama_belakang"];
	$hasil['alamat'] = $data["alamat"];
	$hasil['email'] = $data["email"];
	$hasil['no_telepon'] = $data["no_telepon"];
	$hasil['hak_akses'] = $data["hak_akses"];
	$hasil['id_sekolah'] = $data["id_sekolah"];
	$hasil['status_pekerjaan'] = $data["status_pekerjaan"];
	$hasil['foto'] = $data["foto"];
	$hasil['username'] = $data["username"];
	$hasil['password'] = $data["password"];

    array_push($resp["result"], $hasil);
  }
  
json_print($resp);
?>
