-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2018 at 12:25 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sekolah`
--

-- --------------------------------------------------------

--
-- Table structure for table `kasus`
--

CREATE TABLE `kasus` (
  `id_kasus` varchar(5) NOT NULL,
  `nis` varchar(100) NOT NULL,
  `id_pelanggaran` varchar(10) NOT NULL,
  `ksus_pelanggaran` varchar(250) NOT NULL,
  `poin_pelanggaran` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kasus`
--

INSERT INTO `kasus` (`id_kasus`, `nis`, `id_pelanggaran`, `ksus_pelanggaran`, `poin_pelanggaran`) VALUES
('KS001', 'Candra Krisna Tri P', 'Pacaran', 'Mojok', '25'),
('KS002', 'Riza', 'Pacaran', 'Pacaran', '25');

-- --------------------------------------------------------

--
-- Table structure for table `kategorikelas`
--

CREATE TABLE `kategorikelas` (
  `id_kategori` varchar(5) NOT NULL,
  `daftar_kelas` varchar(2) NOT NULL,
  `id_kelas` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategorikelas`
--

INSERT INTO `kategorikelas` (`id_kategori`, `daftar_kelas`, `id_kelas`) VALUES
('KK001', 'A', 'VII'),
('KK002', 'B', 'VII'),
('KK003', 'C', 'VII'),
('KK004', 'D', 'VII'),
('KK005', 'E', 'VII'),
('KK006', 'A', 'VIII');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` varchar(5) NOT NULL,
  `nama_kelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `nama_kelas`) VALUES
('K0001', 'VII'),
('K0002', 'VIII'),
('K0003', 'IX');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggaran`
--

CREATE TABLE `pelanggaran` (
  `id_pelanggaran` varchar(10) NOT NULL,
  `jenis_pelanggaran` varchar(30) NOT NULL,
  `poin_pelanggaran` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggaran`
--

INSERT INTO `pelanggaran` (`id_pelanggaran`, `jenis_pelanggaran`, `poin_pelanggaran`) VALUES
('P0001', 'Pacaran', '25');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` varchar(15) NOT NULL,
  `nama_petugas` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama_petugas`, `password`, `level`) VALUES
('PTG01', 'Budi', 'budicaem', 'Guru');

-- --------------------------------------------------------

--
-- Table structure for table `presensi`
--

CREATE TABLE `presensi` (
  `id_presensi` varchar(10) NOT NULL,
  `nis` char(5) NOT NULL,
  `tgl_presensi` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `id_kategori` varchar(5) NOT NULL,
  `id_kelas` varchar(5) NOT NULL,
  `ket` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `presensi`
--

INSERT INTO `presensi` (`id_presensi`, `nis`, `tgl_presensi`, `status`, `id_kategori`, `id_kelas`, `ket`) VALUES
('PR01', 'Riza', '28062018', 'Izin', 'A', 'VII', 'Liburan'),
('PR02', 'Sandi', '27062018', 'Hadir', 'B', 'VIII', 'Hadir'),
('PR03', 'Cahya', '2606018', 'Alpha', 'C', 'IX', 'Bolos');

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `nis` varchar(100) NOT NULL,
  `id_kelas` varchar(5) DEFAULT NULL,
  `id_thang` varchar(5) DEFAULT NULL,
  `nama` varchar(100) NOT NULL,
  `jenkel` char(1) NOT NULL,
  `tempat_lahir` varchar(30) NOT NULL,
  `tgl_lahir` varchar(50) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `id_kategori` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`nis`, `id_kelas`, `id_thang`, `nama`, `jenkel`, `tempat_lahir`, `tgl_lahir`, `alamat`, `no_telp`, `id_kategori`) VALUES
('S001', 'VIII', '2003', 'Sandi', 'L', 'Klaten', '21012000', 'Klaten', '082220437430', 'B'),
('S002', 'VII', '2003', 'Riza', 'P', 'Solo', '03032000', 'Klaten', '082226620365', 'A'),
('S003', 'IX', '2003', 'Cahya', 'L', 'Magelang', '17042000', 'Magelang', '12345678910', 'C'),
('S004', 'VII', '2003', 'Candra Krisna Tri P', 'L', 'Sleman', '17082000', 'Yogyakarta', '0987654321', 'D'),
('S005', 'VIII', '2002', 'Suhada BudiSetiawan', 'L', 'Klaten', '10102000', 'Klaten', '4567891011', 'E');

-- --------------------------------------------------------

--
-- Table structure for table `thang`
--

CREATE TABLE `thang` (
  `id_thang` varchar(5) NOT NULL,
  `tahun` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `thang`
--

INSERT INTO `thang` (`id_thang`, `tahun`) VALUES
('TH001', '2002'),
('TH002', '2003'),
('TH003', '2004'),
('TH004', '2005'),
('TH005', '2007');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kasus`
--
ALTER TABLE `kasus`
  ADD PRIMARY KEY (`id_kasus`);

--
-- Indexes for table `kategorikelas`
--
ALTER TABLE `kategorikelas`
  ADD PRIMARY KEY (`id_kategori`),
  ADD KEY `id_kelas` (`id_kelas`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `pelanggaran`
--
ALTER TABLE `pelanggaran`
  ADD PRIMARY KEY (`id_pelanggaran`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `presensi`
--
ALTER TABLE `presensi`
  ADD PRIMARY KEY (`id_presensi`),
  ADD UNIQUE KEY `id_kategori` (`id_kategori`),
  ADD UNIQUE KEY `id_kelas` (`id_kelas`),
  ADD UNIQUE KEY `nis` (`nis`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`),
  ADD UNIQUE KEY `id_kategori` (`id_kategori`),
  ADD KEY `aaaa` (`id_kelas`),
  ADD KEY `bbbb` (`id_thang`);

--
-- Indexes for table `thang`
--
ALTER TABLE `thang`
  ADD PRIMARY KEY (`id_thang`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
