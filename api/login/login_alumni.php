<?php

$tabel_login = "data_alumni";

function cek_database($tabel, $field, $value, $query)
{
    if ($query == "") {
        $sql = "SELECT * FROM " . $tabel . " WHERE " . $field . " ='" . $value . "'";
    } else {
        $sql = $query;
    }

    $cek_user = mysql_num_rows(mysql_query($sql));
    if ($cek_user > 0) {
        $hasiltermantab = "ada";
    } else {
        $hasiltermantab = "nggak";
    }
    return $hasiltermantab;
}

$username = $_POST['username'];
$password = md5($_POST['password']);
$id = '';
$query = "SELECT * FROM $tabel_login where username='$username' and password='$password'";
$proses = mysql_query($query);
while ($data = mysql_fetch_array($proses)) {

    $id = $data["id_alumni"];
}


$statement = $dbh->prepare("SELECT * FROM $tabel_login where username='$username' and password='$password'");
$statement->execute();
$results = $statement->fetchAll(PDO::FETCH_ASSOC);
$resp = [];

$cek = cek_database("", "", "", "SELECT * FROM $tabel_login where username='$username' and password='$password'");
if ($cek == "ada") {
    $resp["status"] = "success";
} else {
    $resp["status"] = "gagal";
}

$resp['result'] = array(
    'id' => $id,
    'nama_pegawai' => $username,
    'jabatan'      => $tabel_login,
    'tkn'        => $id
);;


echo (json_encode($resp))
?>
