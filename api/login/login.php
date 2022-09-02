<?php
require_once('../../admin/include/koneksi/koneksi.php');

$login_sebagai = isset($_POST['sebagai']) ? $_POST['sebagai'] : "";

if ($login_sebagai == 'alumni') {
    include "login_alumni.php";
} else if ($login_sebagai == 'karyawan') {
    include "login_karyawan.php";
} else {
    http_response_code(404);
}
