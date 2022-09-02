
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI KE HALAMAN SEBELUMNYA'); ?>
</a>

    <div class="col-sm-12" style="margin-bottom: 20px; margin-top: 20px;">
    <div class="alert alert-warning">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <strong>Edit Data Jawaban Akreditas </strong>
        <hr class="message-inner-separator">
            <p>Silahkan Update Data Jawaban Akreditas  dibawah ini.</p>
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
                    $sql = mysql_query("SELECT * FROM data_jawaban_akreditas where id_jawaban_akreditas = '$proses'");
                    $data = mysql_fetch_array($sql);
                    ?>
                    <!--h
                    <tr>
                        <td width="25%" class="leftrowcms">					
                            <label >Id Jawaban Akreditas  <font color="red">*</font></label>
                        </td>
                        <td width="2%">:</td>
                        <td>
                           <?php echo $data['id_jawaban_akreditas']; ?>	
                        </td>
                    </tr>
                    h-->
                    <input type="hidden" class="form-control" name="id_jawaban_akreditas" value="<?php echo $data['id_jawaban_akreditas']; ?>" readonly  id="id_jawaban_akreditas" required="required">

                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Id Sekolah  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="id_pertanyaan_akreditas" id="id_pertanyaan_akreditas" placeholder="Id Pertanyaan Akreditas " required="required">
                                <option value="<?php echo ($data['id_pertanyaan_akreditas']); ?>">- <?php echo baca_database("","id_sekolah","select * from data_pertanyaan_akreditas where id_pertanyaan_akreditas='$data[id_pertanyaan_akreditas]'"); ?> -</option><?php combo_database_v2('data_pertanyaan_akreditas','id_pertanyaan_akreditas','id_sekolah',''); ?>
                                </select>
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Jawaban  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="varchar" name="jawaban" id="jawaban" placeholder="Jawaban " required="required" value="<?php echo ($data['jawaban']); ?>">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Nama Depan  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="id_alumni" id="id_alumni" placeholder="Id Alumni " required="required">
                                <option value="<?php echo ($data['id_alumni']); ?>">- <?php echo baca_database("","nama_depan","select * from data_alumni where id_alumni='$data[id_alumni]'"); ?> -</option><?php combo_database_v2('data_alumni','id_alumni','nama_depan',''); ?>
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
