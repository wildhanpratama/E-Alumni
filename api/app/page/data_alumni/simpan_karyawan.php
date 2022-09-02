<?php

use data_alumni\helpers;

require 'helpers.php';

$id_karyawan = id_otomatis("data_karyawan", "id_karyawan", "20"); //isset($_POST["id_karyawan"]) ? $_POST["id_karyawan"] : "";
$nama_depan = isset($_POST["nama_depan"]) ? $_POST["nama_depan"] : "";
$nama_belakang = isset($_POST["nama_belakang"]) ? $_POST["nama_belakang"] : "";
$alamat = isset($_POST["alamat"]) ? $_POST["alamat"] : "";
$email = isset($_POST["email"]) ? $_POST["email"] : "";
$no_telepon = isset($_POST["no_telepon"]) ? $_POST["no_telepon"] : "";
$kategori = isset($_POST["kategori"]) ? $_POST["kategori"] : "";
$kota = isset($_POST["kota"]) ? $_POST["kota"] : "";
$tahun_masuk = isset($_POST["tahun_masuk"]) ? $_POST["tahun_masuk"] : "";
$tahun_keluar = isset($_POST["tahun_keluar"]) ? $_POST["tahun_keluar"] : "";
$bidang_keahlian = isset($_POST["bidang_keahlian"]) ? $_POST["bidang_keahlian"] : "";
$id_sekolah = isset($_POST["id_sekolah"]) ? $_POST["id_sekolah"] : "";
$linkedin = isset($_POST["linkedin"]) ? $_POST["linkedin"] : "";
$instagram = isset($_POST["instagram"]) ? $_POST["instagram"] : "";
$facebook = isset($_POST["facebook"]) ? $_POST["facebook"] : "";
$foto = helpers\upload('foto');
$username = isset($_POST["username"]) ? $_POST["username"] : "";
$password = isset($_POST["password"]) ? $_POST["password"] : "";
$password = md5($password);

$query = mysql_query("insert into data_karyawan values (
'$id_karyawan'
,'$nama_depan'
,'$nama_belakang'
,'$alamat'
,'$email'
,'$no_telepon'
,'$kategori'
,'$kota'
,'$tahun_masuk'
,'$tahun_keluar'
,'$bidang_keahlian'
,'$id_sekolah'
,'$linkedin'
,'$instagram'
,'$facebook'
,'$foto'
,'$username'
,'$password'

)");

$resp = [];
if ($query) {
    $resp["status"] = "success";
} else {
    $resp["status"] = "gagal";
    $resp["error"] = mysql_error();
}

echo (json_encode($resp));
