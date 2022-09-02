<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';

$sebagai = isset($_GET['sebagai']) ? $_GET['sebagai'] : "";

if (isset($_GET['page'])) {
    if ($_GET['page'] == "berita") {
        header("Location: index.php");
    } else if ($_GET['page'] == "kenangan") {
        header("Location: kenangan.php");
    } else if ($_GET['page'] == "profil") {
        header("Location: profil.php?" . http_build_query($_GET));
    } else if ($_GET['page'] == "akreditasi") {
        header("Location: akreditasi.php?id=" . $_GET['id']);
    }
}

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    setcookie('sebagai', $sebagai, time() + (6000 * 6000), '/');
    setcookie('id', $id, time() + (6000 * 6000), '/');
} else {
    $sebagai = $_COOKIE['sebagai'];
    $id = $_COOKIE['id'];
}

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
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,500i,700,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="f7/css/framework7.bundle.css">
    <link rel="stylesheet" href="f7/css/font-awesome.css">
    <link rel="stylesheet" href="f7/css/style.css">

</head>

<body>

    <div id="app">

        <div class="view view-main view-init ios-edges" data-url="/">
            <div class="page page-home page-with-subnavbar">
                <!-- <div class="toolbar tabbar tabbar-labels toolbar-bottom">
                    <div class="toolbar-inner">

                    </div>
                </div> -->
                <div class="tabs">
                    <div id="tab-home" class="tab tab-active tab-home">
                        <div class="navbar navbar-home" style="background-color: #9F0D34;color: white;">
                            <div class="navbar-inner">

                                <div class="title">
                                    <h2 style="color:white">Berita </h2>
                                </div>
                                <div class="right">

                                </div>
                            </div>
                        </div>
                        <div class="subnavbar">
                            <form class="searchbar searchbar-init" action="pencarian_berita.php" method="get">
                                <div class="searchbar-inner">
                                    <div class="searchbar-input-wrap">
                                        <input id="myInput" type="search" placeholder="Pencarian Berita E-Alumni Surabaya">
                                        <i class="searchbar-icon"></i>
                                        <span class="input-clear-button" onkeypress=""></span>
                                    </div>
                                    <span class="searchbar-disable-button">Cancel</span>
                                </div>
                            </form>
                        </div>

                        <script>
                            var input = document.getElementById("myInput");
                            input.addEventListener("keypress", function(event) {
                                if (event.key === "Enter") {
                                    event.preventDefault();
                                    const cari = document.getElementById("myInput").value;
                                    window.location.href = 'pencarian_berita.php?cari=' + cari;
                                }
                            });
                        </script>




                        <br>
                        <br>
                        <br>


                        <style>
                            .price {
                                margin-bottom: 8px;
                                font-size: 14px;
                                font-weight: 700;
                                color: #000000 !important;
                            }
                        </style>

                        <div class="recommended product segments-bottom">
                            <div class="container">
                                <div class="section-title">
                                    <br>
                                    <br>
                                    <h3>Hai,

                                        <?php
                                        if ($sebagai == "data_alumni") {
                                            echo $nama = baca_database("", "nama_depan", "select * from data_alumni where id_alumni ='$id'");
                                        } else {
                                            echo $nama = baca_database("", "nama_depan", "select * from data_karyawan where id_karyawan ='$id'");
                                        }

                                        ?>

                                    </h3>
                                </div>
                                <div class="row">

                                    <?php
                                    $no = 0;
                                    if (isset($_GET['cari'])) {
                                        $cari = $_GET['cari'];
                                        $querytabel = "SELECT * FROM data_berita where caption like '%$cari%' order by id_berita desc LIMIT 0,10";
                                    } else {
                                        $querytabel = "SELECT * FROM data_berita order by id_berita desc LIMIT 0,10";
                                    }

                                    $proses = mysql_query($querytabel);
                                    while ($data = mysql_fetch_array($proses)) {
                                        $no = $no + 1;
                                        $id_berita = $data['id_berita'];

                                    ?>

                                        <div class="col-100" style=" margin-top: 21px;">
                                            <div class="content content-shadow-product">

                                                <img onclick="window.location.href='like_berita.php?id_berita=<?php echo $id_berita; ?>&id_alumni=<?php echo $id; ?>&status=like';" src="../../../admin/upload/<?php echo $data['foto']; ?>" alt="product">
                                                <div class="text">
                                                    <p class="title-product"><i class="fas fa-user"> </i>&nbsp;&nbsp;
                                                        <?php
                                                        baca_database("", "nama_depan", "SELECT * FROM data_alumni WHERE id_alumni = '$data[id_alumni]'")
                                                        ?>
                                                    </p>
                                                    <p class="price" style="color: orange;"><?php echo substr($data['caption'], 0, 150); ?></p>

                                                    <?php
                                                    $cek = cek_database("", "", "", "select * from data_like_berita where id_berita='$id_berita' and id_alumni='$id'");
                                                    if ($cek == "ada") { ?>
                                                        <i onclick="window.location.href='like_berita.php?id_berita=<?php echo $id_berita; ?>&id_alumni=<?php echo $id; ?>&status=unlike';" class="fas fa-heart" style="font-size: 18px;color:red"></i>
                                                    <?php
                                                    } else { ?>
                                                        <i onclick="window.location.href='like_berita.php?id_berita=<?php echo $id_berita; ?>&id_alumni=<?php echo $id; ?>&status=like';" class="fas fa-heart" style="font-size: 18px;"></i>
                                                    <?php } ?>

                                                    &nbsp;&nbsp;&nbsp;
                                                    <i onclick="window.location.href='detail_berita.php?id_berita=<?php echo $id_berita; ?>&id_alumni=<?php echo $id; ?>';" class="fa fa-comment" style="font-size: 18px;"></i>
                                                    <br>
                                                    <br>
                                                    <p onclick="window.location.href='detail_berita.php?id_berita=<?php echo $id_berita; ?>&id_alumni=<?php echo $id; ?>';" class="location" style="font-size: 10px;font-weight: 100;">Tampilkan <?php total("", "select * from data_komentar_berita where id_berita='$id_berita'"); ?> Komentar</p>

                                                </div>

                                            </div>
                                        </div>

                                    <?php } ?>

                                </div>

                            </div>
                        </div>




                        <!-- end home -->
                    </div>

                </div>
            </div>
        </div>

    </div>



    <script src="f7/js/framework7.bundle.min.js"></script>
    <script src="f7/js/routes.js"></script>
    <script src="f7/js/app.js"></script>


</body>

</html>
