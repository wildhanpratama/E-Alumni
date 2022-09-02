<?php

/** helpers.php @author "Haryan DB <haryandb@gmail.com>" Date 15.08.2022  */

namespace data_alumni\helpers;

function upload($namafile)
{
    $time = time();
    $acak = rand(10000, 99999);
    $foto = $time . "-" . $acak . "-" . $_FILES[$namafile]['name'];
    $tmp_file = $_FILES[$namafile]['tmp_name'];
    $path = "../../../../admin/upload/" . $foto;
    global $ekstensi_dilarang;
    $nama = $_FILES[$namafile]['name'];
    $x = explode('.', $nama);
    $ekstensi = strtolower(end($x));
    if (in_array($ekstensi, $ekstensi_dilarang) === false) {
        move_uploaded_file($tmp_file, $path);
        return $foto;
    } else {
?>
        <script>
            alert("EKSTENSI FILE YANG DI UPLOAD TIDAK DI PERBOLEHKAN");
            window.history.back();
        </script>
<?php
        die();
    }
}
