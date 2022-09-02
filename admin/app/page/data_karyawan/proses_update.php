<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_karyawan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_karyawan = xss($_POST['id_karyawan']);
$nama_depan = xss($_POST['nama_depan']);
$nama_belakang = xss($_POST['nama_belakang']);
$alamat = xss($_POST['alamat']);
$email = xss($_POST['email']);
$no_telepon = xss($_POST['no_telepon']);
$kategori = xss($_POST['kategori']);
$kota = xss($_POST['kota']);
$tahun_masuk = xss($_POST['tahun_masuk']);
$tahun_keluar = xss($_POST['tahun_keluar']);
$bidang_keahlian = xss($_POST['bidang_keahlian']);
$id_sekolah = xss($_POST['id_sekolah']);
$linkedin = xss($_POST['linkedin']);
$instagram = xss($_POST['instagram']);
$facebook = xss($_POST['facebook']);
$foto=($_FILES['foto']['name']); if (empty($foto)){$foto = $_POST['foto1'];} else { $foto = upload('foto');};
$username = xss($_POST['username']);
$password = md5($_POST['password']);


$query = mysql_query("update data_karyawan set 
nama_depan='$nama_depan',
nama_belakang='$nama_belakang',
alamat='$alamat',
email='$email',
no_telepon='$no_telepon',
kategori='$kategori',
kota='$kota',
tahun_masuk='$tahun_masuk',
tahun_keluar='$tahun_keluar',
bidang_keahlian='$bidang_keahlian',
id_sekolah='$id_sekolah',
linkedin='$linkedin',
instagram='$instagram',
facebook='$facebook',
foto='$foto',
username='$username',
password='$password'

where id_karyawan='$id_karyawan' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
