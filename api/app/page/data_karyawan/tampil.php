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
		$query="SELECT * FROM data_karyawan where $berdasarkan like '%$isi%'";
	}
	else
	{
		$query="SELECT * FROM data_karyawan where $berdasarkan like '%$isi%'";
	}
}
else
{
	$query = "select * from data_karyawan";
}

$proses = mysql_query($query);	
  while($data = mysql_fetch_array($proses))
  {
	
	$id_karyawan = $data["id_karyawan"];	
    $hasil['id_karyawan'] = $id_karyawan;
	$hasil['nama_depan'] = $data["nama_depan"];
	$hasil['nama_belakang'] = $data["nama_belakang"];
	$hasil['alamat'] = $data["alamat"];
	$hasil['email'] = $data["email"];
	$hasil['no_telepon'] = $data["no_telepon"];
	$hasil['kategori'] = $data["kategori"];
	$hasil['kota'] = $data["kota"];
	$hasil['tahun_masuk'] = $data["tahun_masuk"];
	$hasil['tahun_keluar'] = $data["tahun_keluar"];
	$hasil['bidang_keahlian'] = $data["bidang_keahlian"];
	$hasil['id_sekolah'] = $data["id_sekolah"];
	$hasil['linkedin'] = $data["linkedin"];
	$hasil['instagram'] = $data["instagram"];
	$hasil['facebook'] = $data["facebook"];
	$hasil['foto'] = $data["foto"];
	$hasil['username'] = $data["username"];
	$hasil['password'] = $data["password"];

    array_push($resp["result"], $hasil);
  }
  
json_print($resp);
?>
