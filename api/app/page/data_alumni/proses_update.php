<?php

require_once('../../../include/all_include.php');

// akun
$id_alumni = isset($_POST["id"]) ? $_POST["id"] : "";
$nama_depan = isset($_POST["nama_depan"]) ? $_POST["nama_depan"] : "";
$nama_belakang = isset($_POST["nama_belakang"]) ? $_POST["nama_belakang"] : "";
$alamat = isset($_POST["alamat"]) ? $_POST["alamat"] : "";
$email = isset($_POST["email"]) ? $_POST["email"] : "";
$no_telepon = isset($_POST["no_telepon"]) ? $_POST["no_telepon"] : "";
$nisn = isset($_POST["nisn"]) ? $_POST["nisn"] : "";
$foto = isset($_POST["foto"]) ? $_POST["foto"] : "";
$username = isset($_POST["username"]) ? $_POST["username"] : "";
//$password = isset($_POST["password"]) ? $_POST["password"] : "";
$id_sekolah = isset($_POST["id_sekolah"]) ? $_POST["id_sekolah"] : "";

$kuliah_atau_kerja = isset($_POST["kuliah_atau_kerja"]) ? $_POST["kuliah_atau_kerja"] : "";

// sosmed
$linkedin = isset($_POST["linkedin"]) ? $_POST["linkedin"] : "";
$instagram = isset($_POST["instagram"]) ? $_POST["instagram"] : "";
$facebook = isset($_POST["facebook"]) ? $_POST["facebook"] : "";

// kuliah
$jenjang = isset($_POST["jenjang"]) ? $_POST["jenjang"] : "";
$swasta_atau_negeri = isset($_POST["swasta_atau_negeri"]) ? $_POST["swasta_atau_negeri"] : "";
$jalur_penerimaan = isset($_POST["jalur_penerimaan"]) ? $_POST["jalur_penerimaan"] : "";
$tahun_masuk = isset($_POST["tahun_masuk"]) ? $_POST["tahun_masuk"] : "";
$tahun_keluar = isset($_POST["tahun_keluar"]) ? $_POST["tahun_keluar"] : "";
$jurusan = isset($_POST["jurusan"]) ? $_POST["jurusan"] : "";

// kerja
$tempat_kerja = isset($_POST["tempat_kerja"]) ? $_POST["tempat_kerja"] : "";
$jabatan_kerja = isset($_POST["jabatan_kerja"]) ? $_POST["jabatan_kerja"] : "";
$alamat_kerja = isset($_POST["alamat_kerja"]) ? $_POST["alamat_kerja"] : "";
$tahun_masuk_kerja = isset($_POST["tahun_masuk_kerja"]) ? $_POST["tahun_masuk_kerja"] : "";
$tahun_resign = isset($_POST["tahun_resign"]) ? $_POST["tahun_resign"] : "";

// kuliah dan kerja
$kota_kuliah_atau_kerja = isset($_POST["kota_kuliah_atau_kerja"]) ? $_POST["kota_kuliah_atau_kerja"] : "";
$swasta_atau_negeri = isset($_POST["swasta_atau_negeri"]) ? $_POST["swasta_atau_negeri"] : "";

$sql = "UPDATE data_alumni SET 
nama_depan=?,
nama_belakang=?,
alamat=?,
email=?,
no_telepon=?,
nisn=?,
id_sekolah=?,

kuliah_atau_kerja=?,

jenjang=?,
swasta_atau_negeri=?,
jalur_penerimaan=?,
tahun_masuk=?,
tahun_keluar=?,
jurusan=?,
swasta_atau_negeri=?,

linkedin=?,
instagram=?,
facebook=?,

tempat_kerja=?,
jabatan_kerja=?,
alamat_kerja=?,
tahun_masuk_kerja=?,
tahun_resign=?,
kota_kuliah_atau_kerja=?,


username=?

WHERE id_alumni=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
    $nama_depan,
    $nama_belakang,
    $alamat,
    $email,
    $no_telepon,
    $nisn,
    $id_sekolah,

    $kuliah_atau_kerja,

    $jenjang,
    $swasta_atau_negeri,
    $jalur_penerimaan,
    $tahun_masuk,
    $tahun_keluar,
    $jurusan,
    $swasta_atau_negeri,

    $linkedin,
    $instagram,
    $facebook,

    $tempat_kerja,
    $jabatan_kerja,
    $alamat_kerja,
    $tahun_masuk_kerja,
    $tahun_resign,

    $kota_kuliah_atau_kerja,

    $username,
    $id_alumni
]);

$resp = [];
$resp["status"] = "success";
$resp["error"] = mysql_error();
$resp["data"] = $_POST;

echo (json_encode($resp));
