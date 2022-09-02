<?php
require_once('../../../include/all_include.php');

$login_sebagai = isset($_POST['login_sebagai']) ? $_POST['login_sebagai'] : "";

if ($login_sebagai == "alumni") {
    include "simpan_alumni.php";
} else if ($login_sebagai == "guru/karyawan") {
    include "simpan_karyawan.php";
} else {
    http_response_code(404);
}
