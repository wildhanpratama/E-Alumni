<?php

use data_alumni\helpers;

require 'helpers.php';

$id_alumni = id_otomatis("data_alumni", "id_alumni", "20"); //isset($_POST["id_alumni"]) ? $_POST["id_alumni"] : "";
$nama_depan = isset($_POST["nama_depan"]) ? $_POST["nama_depan"] : "";
$nama_belakang = isset($_POST["nama_belakang"]) ? $_POST["nama_belakang"] : "";
$alamat = isset($_POST["alamat"]) ? $_POST["alamat"] : "";
$email = isset($_POST["email"]) ? $_POST["email"] : "";
$no_telepon = isset($_POST["no_telepon"]) ? $_POST["no_telepon"] : "";
$nisn = isset($_POST["nisn"]) ? $_POST["nisn"] : "";
$id_sekolah = isset($_POST["id_sekolah"]) ? $_POST["id_sekolah"] : "";
$jurusan = isset($_POST["jurusan"]) ? $_POST["jurusan"] : "";
$tahun_masuk = isset($_POST["tahun_masuk"]) ? $_POST["tahun_masuk"] : "";
$tahun_keluar = isset($_POST["tahun_keluar"]) ? $_POST["tahun_keluar"] : "";
$jalur_penerimaan = isset($_POST["jalur_penerimaan"]) ? $_POST["jalur_penerimaan"] : "";
$jenjang = isset($_POST["jenjang"]) ? $_POST["jenjang"] : "";
$linkedin = isset($_POST["linkedin"]) ? $_POST["linkedin"] : "";
$instagram = isset($_POST["instagram"]) ? $_POST["instagram"] : "";
$facebook = isset($_POST["facebook"]) ? $_POST["facebook"] : "";
$tempat_kerja = isset($_POST["tempat_kerja"]) ? $_POST["tempat_kerja"] : "";
$jabatan_kerja = isset($_POST["jabatan_kerja"]) ? $_POST["jabatan_kerja"] : "";
$alamat_kerja = isset($_POST["alamat_kerja"]) ? $_POST["alamat_kerja"] : "";
$tahun_masuk_kerja = isset($_POST["tahun_masuk_kerja"]) ? $_POST["tahun_masuk_kerja"] : "";
$tahun_resign = isset($_POST["tahun_resign"]) ? $_POST["tahun_resign"] : "";
// $foto=isset($_POST["foto"]) ? $_POST["foto"]:"";
$foto = helpers\upload('foto');
$username = isset($_POST["username"]) ? $_POST["username"] : "";
$password = isset($_POST["password"]) ? $_POST["password"] : "";
$password = md5($password);


$query = mysql_query("INSERT INTO data_alumni VALUES (
'$id_alumni'
,'$nama_depan'
,'$nama_belakang'
,'$alamat'
,'$email'
,'$no_telepon'
,'$nisn'
,'$id_sekolah'
,'$jurusan'
,'$tahun_masuk'
,'$tahun_keluar'
,'$jalur_penerimaan'
,'$jenjang'
,'$linkedin'
,'$instagram'
,'$facebook'
,'$tempat_kerja'
,'$jabatan_kerja'
,'$alamat_kerja'
,'$tahun_masuk_kerja'
,'$tahun_resign'
,'$foto'
,'$username'
,'$password'
,null
,''
,''
)");

$resp = [];
if ($query) {
    $resp["status"] = "success";
} else {
    $resp["status"] = "gagal";
    $resp["error"] = mysql_error();
}

echo (json_encode($resp));
