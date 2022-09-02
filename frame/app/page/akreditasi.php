<?php
include '../../../admin/include/koneksi/koneksi.php';
include '../../../admin/include/function/all.php';
//if (isset($_GET['page']))
//{
//    if ($_GET['page'] == "kategori")
//    {
//        header("Location: kategori.php");
//    }
//    else if ($_GET['page'] == "diskusi")
//    {
//        header("Location: diskusi.php");
//    }
//    else if ($_GET['page'] == "profil")
//    {
//        header("Location: profil.php?id=".$_GET['id']);
//    }
//}

if (isset($_GET['id']))
{
    setcookie('id_user',$_GET['id'], time() + (6000 * 6000), '/');
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
            <div class="toolbar tabbar tabbar-labels toolbar-bottom">
                <div class="toolbar-inner">

                </div>
            </div>
            <div class="tabs">
                <div id="tab-home" class="tab tab-active tab-home">
                    <div class="navbar navbar-home" style="background-color: #9F0D34;color: white;">
                        <div class="navbar-inner">

                            <div class="title">
                                <h2 style="color:white">Akreditasi </h2>
                            </div>
                            <div class="right">

                            </div>
                        </div>
                    </div>

                    <br>

                    Akreditasi
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