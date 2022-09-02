<?php

use data_akreditas\helpers;

include 'helpers.php';
?>
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI KE HALAMAN SEBELUMNYA'); ?>
</a>

<div class="col-sm-12" style="margin-bottom: 20px; margin-top: 20px;">
    <div class="alert alert-warning">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <strong>Edit Data Akreditas </strong>
        <hr class="message-inner-separator">
        <p>Silahkan Update Data Akreditas dibawah ini.</p>
    </div>
</div>


<div class="content-box">
    <form action="proses_update.php" enctype="multipart/form-data" method="post">
        <div class="content-box-content">
            <div id="postcustom">
                <table <?php tabel_in(100, '%', 0, 'center'); ?>>
                    <tbody>
                        <?php
                        if (!isset($_GET['proses'])) {
                        ?>
                            <script>
                                alert("AKSES DITOLAK");
                                location.href = "index.php";
                            </script>
                        <?php
                            die();
                        }
                        $proses = decrypt(mysql_real_escape_string($_GET['proses']));
                        $sql = mysql_query("SELECT * FROM data_akreditas where id_akreditas = '$proses'");
                        $data = mysql_fetch_array($sql);
                        ?>
                        <!--h
                    <tr>
                        <td width="25%" class="leftrowcms">					
                            <label >Id Akreditas  <font color="red">*</font></label>
                        </td>
                        <td width="2%">:</td>
                        <td>
                           <?php echo $data['id_akreditas']; ?>	
                        </td>
                    </tr>
                    h-->
                        <input type="hidden" class="form-control" name="id_akreditas" value="<?php echo $data['id_akreditas']; ?>" readonly id="id_akreditas" required="required">

                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Nama Lengkap <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <!--
                                <input class="form-control" style="width:50%" type="varchar" name="nama_lengkap" id="nama_lengkap" placeholder="Nama Lengkap " required="required" value="<?php echo ($data['nama_lengkap']); ?>">
-->
                                <select class="form-control" style="width:50%" type="varchar" name="nama_lengkap" id="nama_lengkap" placeholder="Nama Lengkap " required="required" value="<?php echo ($data['nama_lengkap']); ?>">
                                    <option value="<?php echo ($data['nama_lengkap']); ?>" selected>
                                        -- <?php
                                        $nama_depan = baca_database("data_alumni", "nama_depan", "SELECT * FROM data_alumni WHERE id_alumni = '$data[nama_lengkap]'");
                                        $nama_belakang = baca_database("data_alumni", "nama_belakang", "SELECT * FROM data_alumni WHERE id_alumni = '$data[nama_lengkap]'");
                                        echo "$data[nama_lengkap] ( $nama_depan $nama_belakang )";
                                        ?> --
                                    </option>
                                    <?php
                                    helpers\combo_database2("data_alumni", "id_alumni", "nama_depan", "nama_belakang", "SELECT * FROM data_alumni WHERE id_alumni <> '$data[nama_lengkap]'");
                                    ?>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Nisn <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input class="form-control" style="width:50%" type="varchar" name="nisn" id="nisn" placeholder="Nisn " required="required" value="<?php echo ($data['nisn']); ?>">
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Kelas <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input class="form-control" style="width:50%" type="varchar" name="kelas" id="kelas" placeholder="Kelas " required="required" value="<?php echo ($data['kelas']); ?>">
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Tahun Lulus <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input class="form-control" style="width:50%" type="varchar" name="tahun_lulus" id="tahun_lulus" placeholder="Tahun Lulus " required="required" value="<?php echo ($data['tahun_lulus']); ?>">
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Email <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input value="<?php echo ($data['email']); ?>" class="form-control" style="width:50%" type="text" name="email" id="email" placeholder="Email " required="required">
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Status Pekerjaan <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="status_pekerjaan" id="status_pekerjaan" placeholder="Status Pekerjaan " required="required">
                                    <option value="<?php echo ($data['status_pekerjaan']); ?>">- <?php echo ($data['status_pekerjaan']); ?> -</option><?php combo_enum('data_akreditas', 'status_pekerjaan', ''); ?>
                                </select>
                            </td>
                        </tr>


                    </tbody>
                </table>
                <div class="content-box-content">
                    <center>
                        <?php btn_update(' PROSES UPDATE DATA'); ?>
                    </center>
                </div>
            </div>
        </div>
    </form>
