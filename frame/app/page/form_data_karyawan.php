<?php
$proses = $_GET['id'];
$sql = mysql_query("SELECT * FROM data_karyawan where id_karyawan = '$proses'");
$data = mysql_fetch_array($sql);
?>
<div class="page page-current">
    <div class="page-content">
        <form class="list" id="my-form" method="post" action="../../../api/app/page/data_karyawan/proses_update.php">
            <input type="hidden" name="id" value="<?= $proses ?>">
            <ul>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Nama Depan</div>
                            <div class="item-input-wrap">
                                <input type="text" name="nama_depan" placeholder="Nama Depan" value="<?= $data['nama_depan'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Nama Belakang</div>
                            <div class="item-input-wrap">
                                <input type="text" name="nama_belakang" placeholder="Nama Belakang" value="<?= $data['nama_belakang'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Alamat</div>
                            <div class="item-input-wrap">
                                <input type="text" name="alamat" placeholder="Alamat" value="<?= $data['alamat'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Email</div>
                            <div class="item-input-wrap">
                                <input type="text" name="email" placeholder="Email" value="<?= $data['email'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">No Telepon</div>
                            <div class="item-input-wrap">
                                <input type="text" name="no_telepon" placeholder="No Telepon" value="<?= $data['no_telepon'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <!--<li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Kategori</div>
                            <div class="item-input-wrap">
                                <input type="text" name="kategori" placeholder="Kategori" value="<?= $data['kategori'] ?>">
                            </div>
                        </div>
                    </div>
                </li>-->
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Kota</div>
                            <div class="item-input-wrap">
                                <input type="text" name="kota" placeholder="Kota" value="<?= $data['kota'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Tahun Masuk</div>
                            <div class="item-input-wrap">
                                <input type="text" name="tahun_masuk" placeholder="Tahun Masuk" value="<?= $data['tahun_masuk'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Tahun Keluar</div>
                            <div class="item-input-wrap">
                                <input type="text" name="tahun_keluar" placeholder="Tahun Keluar" value="<?= $data['tahun_keluar'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Bidang Keahlian</div>
                            <div class="item-input-wrap">
                                <input type="text" name="bidang_keahlian" placeholder="Bidang Keahlian" value="<?= $data['bidang_keahlian'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Sekolah</div>
                            <div class="item-input-wrap">
                                <input type="text" name="id_sekolah" placeholder="Sekolah" value="<?= $data['id_sekolah'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Linkedin</div>
                            <div class="item-input-wrap">
                                <input type="text" name="linkedin" placeholder="Linkedin" value="<?= $data['linkedin'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Instagrainstagram</div>
                            <div class="item-input-wrap">
                                <input type="text" name="instagram" placeholder="Instagrainstagram" value="<?= $data['instagram'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Facebook</div>
                            <div class="item-input-wrap">
                                <input type="text" name="facebook" placeholder="Facebook" value="<?= $data['facebook'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <!--<li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">foto</div>
                            <div class="item-input-wrap">
                                <input type="text" name="foto" placeholder="foto" value="<?= $data['foto'] ?>">
                            </div>
                        </div>
                    </div>
                </li>-->
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Username</div>
                            <div class="item-input-wrap">
                                <input type="text" name="username" placeholder="Username" value="<?= $data['username'] ?>">
                            </div>
                        </div>
                    </div>
                </li>
                <!--<li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">Password</div>
                            <div class="item-input-wrap">
                                <input type="text" name="password" placeholder="Password">
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
