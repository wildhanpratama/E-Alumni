<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';

$sebagai = isset($_GET['sebagai']) ? $_GET['sebagai'] : '';
$id = isset($_GET['id']) ? $_GET['id'] : '';
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

</head>

<body>

    <div id="app">

        <div class="view view-main view-init ios-edges" data-url="/">


            <div class="navbar navbar-home" style="background-color: #056925;color: white;">

            </div>
            <div class="navbar navbar-">
                <div class="navbar-inner sliding navbar-current">
                    <div class="left">
                        <a href="index.php" class="link back" onclick="history.back()">
                            <i class="fas fa-arrow-left"></i>
                        </a>
                    </div>
                    <div class="title" style="left: -142px;">
                        Profil
                    </div>
                </div>
            </div>
            <?php
            $proses = $_GET['id'];
            if ($_GET['sebagai'] == 'data_alumni') {

                $sql = mysql_query("SELECT * FROM data_alumni where id_alumni = '$proses'");
            } else {
                $sql = mysql_query("SELECT * FROM data_karyawan where id_karyawan = '$proses'");
            }
            $data = mysql_fetch_array($sql);
            ?>
            <div class="page page-current">
                <div class="page-content">
                    <div class="account-buyer segments">
                        <div class="container">
                            <form id="form-upload" action="../../../api/app/page/data_alumni/upload.php" enctype="multipart/form-data" method="post">
                                <input style="display: none;" name="foto" id="inp-foto" type="file">
                                <input type="hidden" name="sebagai" value="<?php echo $sebagai ?>">
                                <input type="hidden" name="id" value="<?php echo $id ?>">
                            </form>
                            <div class="header-account content-shadow" id="update_foto">
                                <div style="display: flex; flex-direction: column;">
                                    <div style="width: 50px; height: 50px;">
                                        <img src="../../../admin/upload/<?= $data['foto'] ?>" alt="" class="">
                                    </div>
                                    <a>Ubah foto <span id="progress"></span></a>
                                </div>
                                <div class="title-name">
                                    <h5><?php echo $data['nama_depan']; ?></h5>
                                    <p><i class="fas fa-map-marker-alt"></i><?php echo $data['alamat']; ?></p>
                                </div>
                            </div>
                        </div>

                        <div class="account-menu">
                            <div class="list media-list">
                                <ul>

                                    <li>
                                        <a href="" class="item-link item-content">
                                            <div class="item-media">
                                                <i class="fas fa-user"></i>
                                            </div>
                                            <div class="item-inner">
                                                <div class="item-title-row">
                                                    <div class="item-title">Nama</div>
                                                </div>
                                                <div class="item-subtitle"><?php echo $data['nama_depan']; ?></div>
                                            </div>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="" class="item-link item-content">
                                            <div class="item-media">
                                                <i class="fas fa-edit"></i>
                                            </div>
                                            <div class="item-inner">
                                                <div class="item-title-row">
                                                    <div class="item-title">Alamat</div>
                                                </div>
                                                <div class="item-subtitle"><?php echo $data['alamat']; ?></div>
                                            </div>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="" class="item-link item-content">
                                            <div class="item-media">
                                                <i class="fas fa-phone"></i>
                                            </div>
                                            <div class="item-inner">
                                                <div class="item-title-row">
                                                    <div class="item-title">No telepon</div>
                                                </div>
                                                <div class="item-subtitle"><?php echo $data['no_telepon']; ?></div>
                                            </div>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="" class="item-link item-content">
                                            <div class="item-media">
                                                <i class="fas fa-list"></i>
                                            </div>
                                            <div class="item-inner">
                                                <div class="item-title-row">
                                                    <div class="item-title">Email</div>
                                                </div>
                                                <div class="item-subtitle"><?php echo $data['email']; ?></div>
                                            </div>


                                        </a>
                                    </li>

                                    <li>
                                        <a href="" class="item-link item-content" onclick="window.location = 'detail.php?<?= http_build_query($_GET) ?>'">
                                            <div class="item-media">
                                                <i class="fas fa-ellipsis-h"></i>
                                            </div>
                                            <div class="item-inner">
                                                <div class="item-title-row">
                                                    <div class="item-title">Lanjutan</div>
                                                </div>
                                                <div class="item-subtitle">Pengaturan detail akun</div>
                                            </div>


                                        </a>
                                    </li>


                                    <li>
                                        <a href="index.php?page=action&logout=" class="item-link item-content">
                                            <div class="item-media">
                                                <i class="fas fa-power-off"></i>
                                            </div>
                                            <div class="item-inner" onclick="window.location.href='index.php?page=action&logout='">
                                                <div class="item-title-row">
                                                    <div class="item-title">Logout</div>
                                                </div>

                                            </div>
                                        </a>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="f7/js/framework7.bundle.min.js"></script>
    <script src="f7/js/routes.js"></script>
    <script src="f7/js/app.js"></script>

    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="https://malsup.github.io/jquery.form.js"></script>

    <script>
        $(document).ready(function() {
            const $update_foto = $("#update_foto");
            const progressbar = $("#progress")
            const $inp_foto = $("#inp-foto");
            const $form_upload = $("#form-upload");

            $update_foto.on("click", function() {
                $inp_foto.trigger("click");
            });

            $inp_foto.on("change", function() {
                $form_upload.ajaxForm({
                        target: '.preview',
                        dataType: 'json',
                        beforeSend: function() {
                            progressbar.html('0%');
                        },
                        uploadProgress: function(event, position, total, percentComplete) {
                            // console.log(percentComplete);
                            progressbar.html(percentComplete + '%');
                        },
                        success: function(data) {
                            // console.log(`response: ${data}`);
                            window.location.reload();
                        },
                        error: function(data) {
                            progressbar.html("upload gagal");
                        },
                    })
                    .submit();
            });
        });
    </script>

</body>

</h
