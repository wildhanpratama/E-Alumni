
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI KEHALAMAN SEBELUMNYA'); ?>
</a>	

    <div class="col-sm-12" style="margin-bottom: 20px; margin-top: 20px;">
    <div class="alert alert-success">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <strong>Tambah Data Kenangan </strong>
        <hr class="message-inner-separator">
            <p>Silahkan input Data Kenangan  dibawah ini.</p>
        </div>
    </div>

<div class="content-box">
    <form action="proses_simpan.php" enctype="multipart/form-data"  method="post">
        <div class="content-box-content">
            <div id="postcustom">	
                <table <?php tabel_in(100, '%', 0, 'center'); ?>>		
                    <tbody>
                        <!--h
                        <tr>
                            <td width="25%" class="leftrowcms">					
                                <label >Id Kenangan  <span class="highlight">*</span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                              <?php echo id_otomatis("data_kenangan", "id_kenangan", "10"); ?>  		
                            </td>
                        </tr>
                        h-->
                        <input type="hidden" class="form-control" readonly value="<?php echo id_otomatis("data_kenangan", "id_kenangan", "10"); ?>" name="id_kenangan" placeholder="Id Kenangan " id="id_kenangan" required="required">

                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Caption  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="varchar" name="caption" id="caption" placeholder="Caption " required="required">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Tanggal  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="date" name="tanggal" id="tanggal" placeholder="Tanggal " required="required">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Foto  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="file" name="foto" id="foto" placeholder="Foto " required="required">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Nama Depan  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="id_alumni" id="id_alumni" placeholder="Id Alumni " required="required">
                                <option></option><?php combo_database_v2('data_alumni','id_alumni','nama_depan',''); ?>
                                </select>
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Jumlah Like  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input onkeypress='return a(event)' class="form-control" style="width:50%" type="int" name="jumlah_like" id="jumlah_like" placeholder="Jumlah Like " required="required">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Jumlah Komen  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input onkeypress='return a(event)' class="form-control" style="width:50%" type="int" name="jumlah_komen" id="jumlah_komen" placeholder="Jumlah Komen " required="required">
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
