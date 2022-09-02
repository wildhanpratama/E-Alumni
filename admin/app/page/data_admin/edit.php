
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI KE HALAMAN SEBELUMNYA'); ?>
</a>

    <div class="col-sm-12" style="margin-bottom: 20px; margin-top: 20px;">
    <div class="alert alert-warning">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <strong>Edit Data Admin </strong>
        <hr class="message-inner-separator">
            <p>Silahkan Update Data Admin  dibawah ini.</p>
        </div>
    </div>


<div class="content-box">
    <form action="proses_update.php"  enctype="multipart/form-data"  method="post">
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
                    $sql = mysql_query("SELECT * FROM data_admin where id_admin = '$proses'");
                    $data = mysql_fetch_array($sql);
                    ?>
                    <!--h
                    <tr>
                        <td width="25%" class="leftrowcms">					
                            <label >Id Admin  <font color="red">*</font></label>
                        </td>
                        <td width="2%">:</td>
                        <td>
                           <?php echo $data['id_admin']; ?>	
                        </td>
                    </tr>
                    h-->
                    <input type="hidden" class="form-control" name="id_admin" value="<?php echo $data['id_admin']; ?>" readonly  id="id_admin" required="required">

                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Nama Depan  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="varchar" name="nama_depan" id="nama_depan" placeholder="Nama Depan " required="required" value="<?php echo ($data['nama_depan']); ?>">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Nama Belakang  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="varchar" name="nama_belakang" id="nama_belakang" placeholder="Nama Belakang " required="required" value="<?php echo ($data['nama_belakang']); ?>">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Alamat  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="varchar" name="alamat" id="alamat" placeholder="Alamat " required="required" value="<?php echo ($data['alamat']); ?>">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Email  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input value="<?php echo ($data['email']); ?>" class="form-control" style="width:50%" type="text" name="email" id="email" placeholder="Email " required="required">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >No Telepon  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="varchar" name="no_telepon" id="no_telepon" placeholder="No Telepon " required="required" value="<?php echo ($data['no_telepon']); ?>">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Hak Akses  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="hak_akses" id="hak_akses" placeholder="Hak Akses " required="required">
                                <option value="<?php echo ($data['hak_akses']); ?>">- <?php echo ($data['hak_akses']); ?> -</option><?php combo_enum('data_admin','hak_akses',''); ?>
                                </select>
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Nama Sekolah  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="id_sekolah" id="id_sekolah" placeholder="Id Sekolah " required="required">
                                <option value="<?php echo ($data['id_sekolah']); ?>">- <?php echo baca_database("","nama_sekolah","select * from data_sekolah where id_sekolah='$data[id_sekolah]'"); ?> -</option><?php combo_database_v2('data_sekolah','id_sekolah','nama_sekolah',''); ?>
                                </select>
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Status Pekerjaan  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="status_pekerjaan" id="status_pekerjaan" placeholder="Status Pekerjaan " required="required">
                                <option value="<?php echo ($data['status_pekerjaan']); ?>">- <?php echo ($data['status_pekerjaan']); ?> -</option><?php combo_enum('data_admin','status_pekerjaan',''); ?>
                                </select>
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Foto  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                 <a href="../../../../admin/upload/<?php echo $data['foto']; ?>"><img onerror="this.src='../../../data/image/error/file.png'" width="100"  src="../../../../admin/upload/<?php echo $data['foto']; ?>"></a>
                                 <input value="<?php echo ($data['foto']); ?>" class="form-control" style="width:50%" type="hidden" name="foto1" id="foto1" placeholder="Foto  ">
                                 <input value="<?php echo ($data['foto']); ?>" class="form-control" style="width:50%" type="file" name="foto" id="foto" placeholder="Foto  ">

                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Username  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="varchar" name="username" id="username" placeholder="Username " required="required" value="<?php echo ($data['username']); ?>">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Password  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="password" name="password" id="password" placeholder="Password " required="required" value="<?php echo ($data['password']); ?>">
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
