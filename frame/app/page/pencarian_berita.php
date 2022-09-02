<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';

if (isset($_GET['id']))
{
    setcookie('id',$_GET['id'], time() + (6000 * 6000), '/');
    $id = $_GET['id'];
}
else{
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
                    Pencarian <?php echo $_GET['cari'];?>
                </div>
            </div></div>
        <div class="page page-current">


            <div class="recommended product segments-bottom">
                <div class="container">
                    <div class="section-title">
                        <br>
                        <br>
                        <h3>

                        </h3>
                    </div>
                    <div class="row">

                        <?php
                        $no = 0;
                        if (isset($_GET['cari']))
                        {
                            $cari = $_GET['cari'];
                            $querytabel = "SELECT * FROM data_berita where caption like '%$cari%' order by tanggal desc LIMIT 0,10";
                        }
                        else
                        {
                            $querytabel = "SELECT * FROM data_berita order by tanggal desc LIMIT 0,10";
                        }

                        $proses = mysql_query($querytabel);
                        while ($data = mysql_fetch_array($proses)) {
                            $no = $no +1;
                            $id_berita = $data['id_berita'];

                            ?>

                            <div class="col-100" style=" margin-top: 21px;">
                                <div class="content content-shadow-product">

                                    <img onclick="alert('detail');" src="../../../admin/upload/<?php echo $data['foto'];?>" alt="product">
                                    <div class="text">
                                        <p  class="title-product"><i class="fas fa-user"> </i>&nbsp;&nbsp;Fajarudin sidik</p>
                                        <p class="price" style="color: orange;"  ><?php echo substr($data['caption'],0,150);?></p>

                                        <?php
                                        $cek = cek_database("","","","select * from data_like_berita where id_berita='$id_berita' and id_alumni='$id'");
                                        if ($cek == "ada")
                                        { ?>
                                            <i onclick="window.location.href='like_berita.php?id_berita=<?php echo $id_berita;?>&id_alumni=<?php echo $id;?>&status=unlike';" class="fas fa-heart" style="font-size: 18px;color:red"></i>
                                            <?php
                                        } else { ?>
                                            <i onclick="window.location.href='like_berita.php?id_berita=<?php echo $id_berita;?>&id_alumni=<?php echo $id;?>&status=like';" class="fas fa-heart" style="font-size: 18px;"></i>
                                        <?php } ?>

                                        &nbsp;&nbsp;&nbsp;
                                        <i  onclick="window.location.href='detail.php?id_berita=<?php echo $id_berita;?>&id_alumni=<?php echo $id;?>';" class="fa fa-comment" style="font-size: 18px;"></i>
                                        <br>
                                        <br>
                                        <p  class="location" style="font-size: 10px;font-weight: 100;">Tampilkan <?php total("","select * from data_komentar_berita where id_berita='$id_berita'");?> Komentar</p>

                                    </div>

                                </div>
                            </div>

                        <?php } ?>

                    </div>

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