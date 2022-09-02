<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <meta http-equiv="Content-Security-Policy" content="default-src * 'self' 'unsafe-inline' 'unsafe-eval' data: gap:">
    <link rel="icon" href="f7/images/favicon.png">
    <title>E-Alumni</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,500i,700,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="f7/css/framework7.bundle.css">
    <link rel="stylesheet" href="f7/css/font-awesome.css">
    <link rel="stylesheet" href="f7/css/style.css">
    <style>
        .page-content {
            margin: 10px;
            margin-bottom: 100px;
        }
    </style>
</head>

<body>

    <div id="app">

        <div class="view view-main view-init ios-edges" data-url="/">


            <div class="navbar navbar-home" style="background-color: #056925;color: white;">

            </div>
            <div class="navbar navbar-">
                <div class="navbar-inner sliding navbar-current">
                    <div class="left" style="">
                        <a href="index.php" class="link back" onclick="history.back()">
                            <i class="fas fa-arrow-left"></i>
                        </a>
                    </div>
                    <div class="title" style="left: -142px;">
                        Ubah Profil
                    </div>
                </div>
            </div>
            <?php
            $sebagai = $_GET['sebagai'];
            if ($sebagai == "data_alumni") {
                include "form_data_alumni.php";
            } else { // data_karyawan
                include "form_data_karyawan.php";
            }
            ?>
        </div>

    </div>

    <script src="f7/js/framework7.bundle.min.js"></script>
    <script src="f7/js/routes.js"></script>
    <script src="f7/js/app.js"></script>

    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="https://malsup.github.io/jquery.form.js"></script>

    <script>
        $(document).ready(function() {
            const $form_upload = $("#my-form");
            const $tombol_simpan = $("#tombol-simpan");

            $tombol_simpan.on("click", function() {
                $form_upload.ajaxForm({
                        target: '.preview',
                        dataType: 'json',
                        // beforeSend: function() {
                        //     progressbar.html('0%');
                        // },
                        // uploadProgress: function(event, position, total, percentComplete) {
                        //     // console.log(percentComplete);
                        //     progressbar.html(percentComplete + '%');
                        // },
                        success: function(data) {
                            console.log(`response: ${JSON.stringify(data)}`);
                            window.location.reload();
                        },
                        error: function(data) {
                            // progressbar.html("upload gagal");
                        },
                    })
                    .submit();
            });
        });
    </script>
</body>

</html>
