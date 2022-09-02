<?php

use function frame\helpers\combo_database2;

include "helpers.php";

$proses = $_GET['id'];
$sql = mysql_query("SELECT * FROM data_alumni where id_alumni = '$proses'");
$data = mysql_fetch_array($sql);
?>
<div class="page page-current">
    <div class="page-content">
        <form class="list" id="my-form" method="post" action="../../../api/app/page/data_alumni/proses_update.php">
            <input type="hidden" name="id" value="<?php echo $data['id_alumni'] ?>">
            <input type="hidden" name="sebagai" value="<?php echo $sebagai ?>">
            <ul>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Nama Depan</div>
                            <div class="item-input-wrap">
                                <input type="text" name="nama_depan" placeholder="Nama Depan" value="<?= $data['nama_depan'] ?>" />
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Nama Belakang</div>
                            <div class="item-input-wrap">
                                <input type="text" name="nama_belakang" placeholder="Nama Belakang" value="<?= $data['nama_belakang'] ?>" />
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Alamat</div>
                            <div class="item-input-wrap">
                                <textarea name="alamat" placeholder="Alamat"><?= $data['alamat'] ?></textarea>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Email</div>
                            <div class="item-input-wrap">
                                <input type="text" name="email" value="<?= $data['email'] ?>" placeholder="Email" />
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">No Telepon</div>
                            <div class="item-input-wrap">
                                <input type="text" name="no_telepon" value="<?= $data['no_telepon'] ?>" placeholder="No Telepon" />
                            </div>
                        </div>
                    </div>
                </li>

                <!-- <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Sekolah</div>
                            <div class="item-input-wrap">
                                <select type="text" name="id_sekolah" id="id_sekolah" placeholder="Sekolah">
                                    <option selected>
                                        - Pilih -
                                    </option>
                                    <?php
                                    combo_database2("data_sekolah", "id_sekolah", "nama_sekolah", "", ['kategori']);
                                    ?>
                                </select>

                            </div>
                        </div>
                    </div>
                </li> -->
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Nisn</div>
                            <div class="item-input-wrap">
                                <input type="text" name="nisn" value="<?= $data['nisn'] ?>" placeholder="Nisn" />
                            </div>
                        </div>
                    </div>
                </li>

                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Kuliah atau Kerja</div>
                            <div class="item-input-wrap">
                                <select type="text" name="kuliah_atau_kerja" id="kuliah_atau_kerja" placeholder="Kuliah atau Kerja">
                                <option value="<?= $data['kuliah_atau_kerja'] ?>">-<?= $data['kuliah_atau_kerja'] ?>-</option>
                                    <?php
                                    combo_enum("data_alumni", "kuliah_atau_kerja", "");
                                    ?>
                                </select>

                            </div>
                        </div>
                    </div>
                </li>
                <div id="form-kuliah">
                    <?php
                    include "form_kuliah.php";
                    ?>
                </div>
                <div id="form-kerja">
                    <?php
                    include "form_kerja.php";
                    ?>
                </div>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Kota</div>
                            <div class="item-input-wrap">
                                <input type="text" name="kota_kuliah_atau_kerja" value="<?= $data['kota_kuliah_atau_kerja'] ?>" placeholder="Kota" />
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Linkedin</div>
                            <div class="item-input-wrap">
                                <input type="text" name="linkedin" value="<?= $data['linkedin'] ?>" placeholder="Linkedin" />
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Instagram</div>
                            <div class="item-input-wrap">
                                <input type="text" name="instagram" value="<?= $data['instagram'] ?>" placeholder="Instagram" />
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Facebook</div>
                            <div class="item-input-wrap">
                                <input type="text" name="facebook" value="<?= $data['facebook'] ?>" placeholder="Facebook" />
                            </div>
                        </div>
                    </div>
                </li>
                <!--<li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Foto</div>
                            <div class="item-input-wrap">
                                <input type="file" name="foto" placeholder="Foto" />
                            </div>
                        </div>
                    </div>
                </li>-->

                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Username</div>
                            <div class="item-input-wrap">
                                <input type="text" name="username" value="<?= $data['username'] ?>" placeholder="Username" />
                            </div>
                        </div>
                    </div>
                </li>
                <!--<li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Password</div>
                            <div class="item-input-wrap">
                                <input type="password" name="password" placeholder="Password" />
                            </div>
                        </div>
                    </div>
                </li>-->
            </ul>
            <button type="button" id="tombol-simpan" class="button button-fill convert-form-to-data" href="#">
                <i class="fa fa-save"></i> Simpan Perubahan
            </button>
            <br>
        </form>
    </div>
</div>
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script>
    $(document).ready(function() {
        const $id_sekolah = $("#id_sekolah");
        const $kuliah_atau_kerja = $("#kuliah_atau_kerja");
        const view_kuliah_atau_kerja = {
            kuliah() {
                $("#form-kuliah").show("slow");
                $("#form-kerja").hide();
            },
            kerja() {
                $("#form-kuliah").hide();
                $("#form-kerja").show("slow");
            }
        };

        $kuliah_atau_kerja.on("change", function() {
            const kuliah_atau_kerja = $(this).val();
            if (kuliah_atau_kerja == "Kuliah") {
                view_kuliah_atau_kerja.kuliah();
            }
            if (kuliah_atau_kerja == "Kerja") {
                view_kuliah_atau_kerja.kerja();
            }
        });

        $kuliah_atau_kerja.trigger("change");

        $id_sekolah.on("change", function() {
            const id_sekolah = $(this).val();
        });
    });
</script>
