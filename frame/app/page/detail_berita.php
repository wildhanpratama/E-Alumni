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
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,500i,700,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="f7/css/framework7.bundle.css">
    <link rel="stylesheet" href="f7/css/font-awesome.css">
    <link rel="stylesheet" href="f7/css/style.css">

</head>
<body>

<div id="app">

    <div class="view view-main view-init ios-edges" data-url="/">


            <div class="navbar navbar-home" style="background-color: #056925;color: white;">

            </div>
        <div class="navbar navbar-"><div class="navbar-inner sliding navbar-current">
                <div class="left" style="">
                    <a href="#" class="link back" onclick="window.location.href='index.php'">
                        <i class="fas fa-arrow-left"></i>
                    </a>
                </div>
                <div class="title" style="left: -142px;">
                    Detail Berita
                </div>
            </div></div>

        <div class="page page-current">

            <div class="page-content">
                <!-- product details -->
                <div class="product-details segments">
                    <div class="container">
                        <!-- slider product details -->
                        <div class="slider-p-details">
                            <div data-pagination="{&quot;el&quot;: &quot;.swiper-pagination&quot;}"
                                 data-space-between="10"
                                 class="swiper-container swiper-init swiper-container-horizontal swiper-container-initialized swiper-container-android">
                                <div class="swiper-pagination swiper-pagination-bullets"><span
                                            class="swiper-pagination-bullet swiper-pagination-bullet-active"></span><span
                                            class="swiper-pagination-bullet"></span><span
                                            class="swiper-pagination-bullet"></span></div>
                                <div class="swiper-wrapper" style="transform: translate3d(0px, 0px, 0px);">

                                    <?php
                                    $id_berita = $_GET['id_berita'];
                                    $id_alumni = $_GET['id_alumni'];

                                    $querytabel = "SELECT * FROM data_berita where id_berita='$id_berita'";
                                    $proses = mysql_query($querytabel);
                                    $data = mysql_fetch_array($proses);
                                    $id_berita = $data['id_berita'];
                                    $diposting = baca_database("","nama_depan","select * from data_alumni where id_alumni='$data[id_alumni]'")." ".baca_database("","nama_belakang","select * from data_alumni where id_alumni='$data[id_alumni]'");
                                    ?>
                                    <div class="swiper-slide swiper-slide-active"
                                         style="width: 336px; margin-right: 10px;">
                                        <div class="content">
                                            <div class="mask"></div>
                                            <img src="../../../admin/upload/<?php echo $data['foto'];?>" alt="" class="">
                                        </div>
                                    </div>

                                </div>
                                <span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span></div>
                        </div>
                        <!-- end slider product details -->

                        <!-- wrap content product details -->
                        <div class="wrapper-content">
                            <div class="wrap-title-product wrap-c-margin">
                                <h4 style="color:black"><?php echo $data['caption'];?></h4>
                                <p  class="title-product"><i class="fas fa-user"> </i>&nbsp;&nbsp;<?php echo $diposting;?></p>
                            </div>
                            <div class="freeship">
                                <p> <?php echo  format_indo($data['tanggal']);?></p>
                            </div>

                                <div class="section-title">
                                    <br>
                                    <br>
                                    <h3 class="">Komentar</h3>
                                </div>

                            <?php

                            $querytabel2 = "SELECT * FROM data_komentar_berita where id_berita='$id_berita' order by id_komentar_berita desc";
                            $proses2 = mysql_query($querytabel2);
                            while ($data2 = mysql_fetch_array($proses2)) {
                                $id_alumni_komen = $data2['id_alumni'];
                                $nama_komentar = baca_database("","nama_depan","select * from data_alumni where id_alumni='$id_alumni_komen'")." ".baca_database("","nama_belakang","select * from data_alumni where id_alumni='$id_alumni_komen'");


                            ?>
                                <div class="content">
                                    <img src="images/user-buyer2.png" alt="">
                                    <div class="text">
                                        <h6><i class="fas fa-comment-alt"> </i>&nbsp;&nbsp;<?php echo $nama_komentar;?></h6>

                                        <p class="date"><?php echo format_indo($data2['tanggal']);?></p>

                                        <p><?php echo $data2['komentar'];?></p>
                                    </div>
                                </div>
                                <div class="divider-line-half"></div>

                            <?php } ?>


                            <div class="wrap-info">

                                    <div class="item-inner">
                                        <br>
                                        <br>
                                        <div class="item-input-wrap">
                                            <form action="komen_berita.php">
                                                <input  type="hidden" value="<?php echo $_GET['id_berita'];?>" name="id_berita">
                                                <input  type="hidden" value="<?php echo $_GET['id_alumni'];?>" name="id_alumni">
                                                <textarea name="komentar" placeholder="Silahkan Masukkan Komentar.."style="max-width: 100%;width: 100%;border-block-color: revert;border: 10px;border-color: red;"></textarea>
                                                <br>
                                            <div class="col"><input type="submit" class="button secondary-button" style="color: grey;border: 1px solid grey;" value="Kirim Komentar" >
                                                <br>
                                                <br>
                                                <br>
                                                <br>
                                            </div>
                                            </form>

                                        </div>
                                    </div>

                            </div>
                        </div>
                        <!-- end wrap content product details -->
                    </div>
                    <!-- wrap store -->

                





                </div>
                <!-- end product details -->


            </div>
        </div>
    </div>

</div>

<script src="f7/js/framework7.bundle.min.js"></script>
<script src="f7/js/routes.js"></script>
<script src="f7/js/app.js"></script>

</body>
</html>