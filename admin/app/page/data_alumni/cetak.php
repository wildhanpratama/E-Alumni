<?php
if (isset($_GET['input'])) {
    echo "<h3> Cetak Laporan ";
    tabelnomin();
    echo "</h3>";
    ?>
    <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new.css">
    <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new2.css">
    <?php
    action_cetak("data_alumni");
} else {

    function location() {
        return "cetak";
    }

    include '../../../include/all_include.php';
    proses_action_cetak("data_alumni");
    ?>
    <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new.css">
    <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new2.css">


    <!-- HEADER -->
    <table border="0" style="width: 100%">
        <?php
        if (isset($_GET['export'])) {
            
        } else {
            ?>
            <tr>
                <td class="auto-style1" rowspan="3" width="101">
                    <img alt="" height="100" src="<?php echo $logo_laporan1; ?>" width="100"></td>

                <td class="auto-style1">
            <center>
                <h2 class="auto-style1"><?php echo $judul; ?></h2>
            </center>
        </td>

        <td class="auto-style1" rowspan="3" width="101">
            <img alt="" height="100" src="<?php echo $logo_laporan2; ?>" width="100"></td>
        </tr>
    <?php } ?>

    <tr>
        <td class="auto-style2">
    <center>
        <strong>LAPORAN

            <?php
            $tabelnya = "data_alumni";
            $tabelnya = str_replace("_", " ", $tabelnya);
            $tabelnya = str_replace("data", "", $tabelnya);
            $tabelnya = strtoupper($tabelnya);
            echo $tabelnya;
            ?>

        </strong>
    </center>
    </td>
    </tr>

    <tr>
        <td class="auto-style2"><?php echo $alamat; ?></td>
    </tr>
    </table>
    <!-- HEADER -->

    <!-- BODY -->
    <table width="100%"  class="tblcms2">
        <tr>
            <th class="th_border cell">No</th>
           <!--h <th class="th_border cell">Id Alumni </th> h-->
                <th align="center" class="th_border cell"  >Nama Depan </th>
                <th align="center" class="th_border cell"  >Nama Belakang </th>
                <th align="center" class="th_border cell"  >Alamat </th>
                <th align="center" class="th_border cell"  >Email </th>
                <th align="center" class="th_border cell"  >No Telepon </th>
                <th align="center" class="th_border cell"  >Nisn </th>
                <th align="center" class="th_border cell"  >Nama Sekolah </th>
                <th align="center" class="th_border cell"  >Jurusan </th>
                <th align="center" class="th_border cell"  >Tahun Masuk </th>
                <th align="center" class="th_border cell"  >Tahun Keluar </th>
                <th align="center" class="th_border cell"  >Jalur Penerimaan </th>
                <th align="center" class="th_border cell"  >Jenjang </th>
                <th align="center" class="th_border cell"  >Linkedin </th>
                <th align="center" class="th_border cell"  >Instagram </th>
                <th align="center" class="th_border cell"  >Facebook </th>
                <th align="center" class="th_border cell"  >Tempat Kerja </th>
                <th align="center" class="th_border cell"  >Jabatan Kerja </th>
                <th align="center" class="th_border cell"  >Alamat Kerja </th>
                <th align="center" class="th_border cell"  >Tahun Masuk Kerja </th>
                <th align="center" class="th_border cell"  >Tahun Resign </th>
                <th align="center" class="th_border cell"  >Foto </th>
                <th align="center" class="th_border cell"  >Username </th>
                <th align="center" class="th_border cell"  >Password </th>


        </tr>

        <tbody>
            <?php
            $no = 0;
            if (isset($_GET['isi']) && !empty($_GET['isi'])) {
                //BERDASARKAN
                $Berdasarkan = mysql_real_escape_string($_GET['Berdasarkan']);
                $isi = mysql_real_escape_string($_GET['isi']);
                echo '<center> Cetak berdasarkan <b>' . $Berdasarkan . '</b> : <b>' . $isi . '</b></center>';
                $querytabel = "SELECT * FROM data_alumni where $Berdasarkan like '%$isi%'";
            } else if (isset($_GET['tanggal1']) && !empty($_GET['tanggal1'])) {
                //PERIODE
                $Berdasarkan = mysql_real_escape_string($_GET['Berdasarkan']);
                $tanggal1 = mysql_real_escape_string($_GET['tanggal1']);
                $tanggal2 = mysql_real_escape_string($_GET['tanggal2']);
                $tanggal1_indo = format_indo($tanggal1);
                $tanggal2_indo = format_indo($tanggal2);
                echo '<center> Cetak Berdasarkan <b>' . $Berdasarkan . '</b> Dari Tanggal <b>' . $tanggal1_indo . '</b> s/d <b>' . $tanggal2_indo . '</b></center>';
                $querytabel = "SELECT * FROM data_alumni where ($Berdasarkan BETWEEN '$tanggal1' AND '$tanggal2')";
            } else {
                //SEMUA
                $querytabel = "SELECT * FROM data_alumni";
            }
            $proses = mysql_query($querytabel);
            while ($data = mysql_fetch_array($proses)) {
                ?>
                <tr class="event2">
                    <td align="center" width="50"><?php $no = $no + 1; echo $no; ?></td>
                    <!--h <td align="center"><?php echo $data['id_alumni']; ?></td> h-->
                        <td align="center"><?php echo $data['nama_depan']; ?></td>
                        <td align="center"><?php echo $data['nama_belakang']; ?></td>
                        <td align="center"><?php echo $data['alamat']; ?></td>
                        <td align="center"><?php echo $data['email']; ?></td>
                        <td align="center"><?php echo $data['no_telepon']; ?></td>
                        <td align="center"><?php echo $data['nisn']; ?></td>
                        <td align="center"><?php echo baca_database("","nama_sekolah","select * from data_sekolah where id_sekolah='$data[id_sekolah]'")  ?></td>
                        <td align="center"><?php echo $data['jurusan']; ?></td>
                        <td align="center"><?php echo $data['tahun_masuk']; ?></td>
                        <td align="center"><?php echo $data['tahun_keluar']; ?></td>
                        <td align="center"><?php echo $data['jalur_penerimaan']; ?></td>
                        <td align="center"><?php echo $data['jenjang']; ?></td>
                        <td align="center"><?php echo $data['linkedin']; ?></td>
                        <td align="center"><?php echo $data['instagram']; ?></td>
                        <td align="center"><?php echo $data['facebook']; ?></td>
                        <td align="center"><?php echo $data['tempat_kerja']; ?></td>
                        <td align="center"><?php echo $data['jabatan_kerja']; ?></td>
                        <td align="center"><?php echo $data['alamat_kerja']; ?></td>
                        <td align="center"><?php echo $data['tahun_masuk_kerja']; ?></td>
                        <td align="center"><?php echo $data['tahun_resign']; ?></td>
                        <td align="center"><a href="../../../../admin/upload/<?php echo $data['foto']; ?>"><img onerror="this.src='../../../data/image/error/file.png'" width="50" height="30" src="../../../../admin/upload/<?php echo $data['foto']; ?>"></a></td>
                        <td align="center"><?php echo $data['username']; ?></td>
                        <td align="center"><?php echo $data['password']; ?></td>



                </tr>
    <?php } ?>
        </tbody>
    </table>
    <!-- BODY -->

    <!-- FOOTER -->
    <p class="auto-style3"><?php echo $formatwaktu; ?>
    </p>
    <p class="auto-style3"><?php echo $ttd; ?></p>
    <p class="auto-style3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </p>
    <p class="auto-style3"><?php echo $siapa; ?>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</p>
    <p class="auto-style3"></p>

<?php } ?>
