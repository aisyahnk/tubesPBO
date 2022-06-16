-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2022 at 12:37 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `latihan`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin1', 'admin1'),
('admin2', 'admin2');

-- --------------------------------------------------------

--
-- Table structure for table `camera`
--

CREATE TABLE `camera` (
  `id` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `merek` varchar(50) NOT NULL,
  `lensa` varchar(50) NOT NULL,
  `harga` int(10) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `camera`
--

INSERT INTO `camera` (`id`, `nama`, `jenis`, `merek`, `lensa`, `harga`, `keterangan`) VALUES
(1, 'Nikon D7000', 'DSLR', 'Nikon', 'Telezoom 18-200mm', 125000, 'Dengan lensa all in one'),
(2, 'Canon eos 600D', 'DSLR', 'Canon', 'kit 18-55mm', 100000, 'kualitas tajam dan jernih '),
(3, 'Canon eos M10', 'Mirrorless', 'Canon', 'Kit 18-55mm', 120000, 'Layar touchscreen '),
(4, 'Nikon olympus lite', 'Mirrorless', 'Nikon', 'Lite E-PL5', 150000, 'Layar touchscreen resolusi tinggi 16MP');

-- --------------------------------------------------------

--
-- Table structure for table `proyektor`
--

CREATE TABLE `proyektor` (
  `id` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(10) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proyektor`
--

INSERT INTO `proyektor` (`id`, `nama`, `harga`, `keterangan`) VALUES
(1, 'Proyektor infocus', 85000, 'proyektor infocus'),
(2, 'Proyektor Epson EB-S200', 100000, 'Proyektor epson EB-S200'),
(3, 'Proyektor Optoma DLP', 125000, 'Proyektor Optama DLP SA500 '),
(4, 'Proyektor Epson EB-2265U', 250000, 'Proyektor Tancap Layar Super Lebar ');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `namadepan` varchar(50) NOT NULL,
  `namabelakang` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `repass` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`namadepan`, `namabelakang`, `username`, `pass`, `repass`, `alamat`) VALUES
('aditya', 'rizkiawan nugraha', 'adityarn', 'aditya123', 'aditya123', 'Purwokerto'),
('Bimo', 'Mardiansyah', 'bimomar', 'bimo123', 'bimo123', 'Cimahi'),
('citra', 'amalia cantika', 'citraaca', 'citra123', 'citra123', 'Bandung barat'),
('dinda', 'amalia', 'dindaalia', 'dinda123', 'dinda123', 'Cianjur'),
('ervina', 'nurul asihani', 'ervinana', 'ervina16', 'ervina16', 'Majalengka');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `camera`
--
ALTER TABLE `camera`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `proyektor`
--
ALTER TABLE `proyektor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `camera`
--
ALTER TABLE `camera`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `proyektor`
--
ALTER TABLE `proyektor`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
