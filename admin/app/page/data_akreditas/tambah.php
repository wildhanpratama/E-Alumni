<?php

use data_akreditas\helpers;

include 'helpers.php';
?>
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI KEHALAMAN SEBELUMNYA'); ?>
</a>

<div class="col-sm-12" style="margin-bottom: 20px; margin-top: 20px;">
    <div class="alert alert-success">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <strong>Tambah Data Akreditas </strong>
        <hr class="message-inner-separator">
        <p>Silahkan input Data Akreditas dibawah ini.</p>
    </div>
</div>

<div class="content-box">
    <form action="proses_simpan.php" enctype="multipart/form-data" method="post">
        <div class="content-box-content">
            <div id="postcustom">
                <table <?php tabel_in(100, '%', 0, 'center'); ?>>
                    <tbody>
                        <!--h
                        <tr>
                            <td width="25%" class="leftrowcms">					
                                <label >Id Akreditas  <span class="highlight">*</span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                              <?php echo id_otomatis("data_akreditas", "id_akreditas", "10"); ?>  		
                            </td>
                        </tr>
                        h-->
                        <input type="hidden" class="form-control" readonly value="<?php echo id_otomatis("data_akreditas", "id_akreditas", "10"); ?>" name="id_akreditas" placeholder="Id Akreditas " id="id_akreditas" required="required">

                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Nama Lengkap <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <!--
                                <input class="form-control" style="width:50%" type="varchar" name="nama_lengkap" id="nama_lengkap" placeholder="Nama Lengkap " required="required">
-->
                                <select class="form-control" style="width:50%" type="varchar" name="nama_lengkap" id="nama_lengkap" placeholder="Nama Lengkap " required="required">
                                    <?php
                                    helpers\combo_database2("data_alumni", "id_alumni", "nama_depan", "nama_belakang", "");
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
                                <input class="form-control" style="width:50%" type="varchar" name="nisn" id="nisn" placeholder="Nisn " required="required">
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Kelas <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input class="form-control" style="width:50%" type="varchar" name="kelas" id="kelas" placeholder="Kelas " required="required">
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Tahun Lulus <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input class="form-control" style="width:50%" type="varchar" name="tahun_lulus" id="tahun_lulus" placeholder="Tahun Lulus " required="required">
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Email <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input class="form-control" style="width:50%" type="email" name="email" id="email" placeholder="Email " required="required">
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label>Status Pekerjaan <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="status_pekerjaan" id="status_pekerjaan" placeholder="Status Pekerjaan " required="required">
                                    <option></option><?php combo_enum('data_akreditas', 'status_pekerjaan', ''); ?>
                                </select>
                            </td>
                        </tr>



                    </tbody>
                </table>
                <div class="content-box-content">
                    <center>
                        <?php btn_simpan(' PROSES SIMPAN DATA'); ?>
                    </center>
                </div>
            </div>
        </div>
    </form>
