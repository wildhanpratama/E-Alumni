<?php

use function data_alumni\helpers\upload;

require_once('../../../include/all_include.php');

include "helpers.php";

$sebagai = isset($_POST['sebagai']) ? $_POST['sebagai'] : '';
$validate = true;
$error_message = [];

$foto = upload("foto");

if ($sebagai == 'data_alumni' && $validate) {
    $id = $_POST['id'];
    $stmt = $dbh->prepare("UPDATE data_alumni SET foto=? WHERE id_alumni=?");
    $stmt->execute([$foto, $id]);
    echo json_encode([
        'status' => 'berhasil',
    ]);
} else if ($sebagai == 'data_karyawan' && $validate) {
    $id = $_POST['id'];
    $stmt = $dbh->prepare("UPDATE data_karyawan SET foto=? WHERE id_karyawan=?");
    $stmt->execute([$foto, $id]);
    echo json_encode([
        'status' => 'berhasil',
    ]);
} else {
    $error_message[] = "required sebagai";
    echo json_encode([
        'status' => 'gagal',
        'message' => $error_message,
        'data' => $_POST
    ]);
}
