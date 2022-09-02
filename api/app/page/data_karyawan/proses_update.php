<?php
require_once('../../../include/all_include.php');

$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$id_karyawan = isset($_POST["id"]) ? $_POST["id"] : "";
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
$foto = isset($_POST["foto"]) ? $_POST["foto"] : "";
$username = isset($_POST["username"]) ? $_POST["username"] : "";
//$password=isset($_POST["password"]) ? $_POST["password"]:"";


$sql = "UPDATE data_karyawan SET 
nama_depan=?,
nama_belakang=?,
alamat=?,
email=?,
no_telepon=?,
kategori=?,
kota=?,
tahun_masuk=?,
tahun_keluar=?,
bidang_keahlian=?,
id_sekolah=?,
linkedin=?,
instagram=?,
facebook=?,
username=?

WHERE id_karyawan=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
    $nama_depan,
    $nama_belakang,
    $alamat,
    $email,
    $no_telepon,
    $kategori,
    $kota,
    $tahun_masuk,
    $tahun_keluar,
    $bidang_keahlian,
    $id_sekolah,
    $linkedin,
    $instagram,
    $facebook,
    $username,

    $id_karyawan
]);
$resp = [];
$resp["status"] = "success";
echo (json_encode($resp));
