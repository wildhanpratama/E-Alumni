<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_alumni'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_alumni = xss($_POST['id_alumni']);
$nama_depan = xss($_POST['nama_depan']);
$nama_belakang = xss($_POST['nama_belakang']);
$alamat = xss($_POST['alamat']);
$email = xss($_POST['email']);
$no_telepon = xss($_POST['no_telepon']);
$nisn = xss($_POST['nisn']);
$id_sekolah = xss($_POST['id_sekolah']);
$jurusan = xss($_POST['jurusan']);
$tahun_masuk = xss($_POST['tahun_masuk']);
$tahun_keluar = xss($_POST['tahun_keluar']);
$jalur_penerimaan = xss($_POST['jalur_penerimaan']);
$jenjang = xss($_POST['jenjang']);
$linkedin = xss($_POST['linkedin']);
$instagram = xss($_POST['instagram']);
$facebook = xss($_POST['facebook']);
$tempat_kerja = xss($_POST['tempat_kerja']);
$jabatan_kerja = xss($_POST['jabatan_kerja']);
$alamat_kerja = xss($_POST['alamat_kerja']);
$tahun_masuk_kerja = xss($_POST['tahun_masuk_kerja']);
$tahun_resign = xss($_POST['tahun_resign']);
$foto=($_FILES['foto']['name']); if (empty($foto)){$foto = $_POST['foto1'];} else { $foto = upload('foto');};
$username = xss($_POST['username']);
$password = md5($_POST['password']);


$query = mysql_query("update data_alumni set 
nama_depan='$nama_depan',
nama_belakang='$nama_belakang',
alamat='$alamat',
email='$email',
no_telepon='$no_telepon',
nisn='$nisn',
id_sekolah='$id_sekolah',
jurusan='$jurusan',
tahun_masuk='$tahun_masuk',
tahun_keluar='$tahun_keluar',
jalur_penerimaan='$jalur_penerimaan',
jenjang='$jenjang',
linkedin='$linkedin',
instagram='$instagram',
facebook='$facebook',
tempat_kerja='$tempat_kerja',
jabatan_kerja='$jabatan_kerja',
alamat_kerja='$alamat_kerja',
tahun_masuk_kerja='$tahun_masuk_kerja',
tahun_resign='$tahun_resign',
foto='$foto',
username='$username',
password='$password'

where id_alumni='$id_alumni' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
