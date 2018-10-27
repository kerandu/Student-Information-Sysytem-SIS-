-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2018 at 06:16 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_information_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `regno` varchar(15) NOT NULL,
  `name` varchar(200) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `unit1` int(20) NOT NULL,
  `unit2` int(20) NOT NULL,
  `unit3` int(20) NOT NULL,
  `unit4` int(20) NOT NULL,
  `unit5` int(20) NOT NULL,
  `unit6` int(20) NOT NULL,
  `unit7` int(20) NOT NULL,
  `total` int(20) NOT NULL,
  `average` float NOT NULL,
  `grade` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`regno`, `name`, `courseid`, `unit1`, `unit2`, `unit3`, `unit4`, `unit5`, `unit6`, `unit7`, `total`, `average`, `grade`) VALUES
('4988', 'samuel', 'bps', 87, 67, 78, 70, 65, 60, 71, 498, 71, 'B'),
('4988', 'samuel', 'bps', 0, 0, 0, 0, 0, 0, 0, 0, 0, 'E'),
('4988', 'samuel', 'bps', 0, 0, 0, 0, 0, 0, 0, 0, 0, 'E'),
('321', 'Liam', 'BCS', 89, 76, 90, 90, 78, 67, 56, 546, 78, 'A'),
('BPS0352017', 'ESTHER NAKHANU', 'BPS', 87, 67, 76, 98, 56, 45, 54, 483, 69, 'B');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `regno` varchar(15) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `department` varchar(20) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `program` varchar(20) NOT NULL,
  `year` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`regno`, `name`, `gender`, `department`, `courseid`, `program`, `year`) VALUES
('123', 'Eddie Randz', 'Male', 'CSIT', 'BCS', 'Degree', 2018),
('234', 'njdbs', 'nd', 'ndcsj', 'jdbsb', 'ndjvs', 877),
('321', 'Liam', 'Male', 'CSIT', 'BCS', 'Cert', 2017),
('4988', 'samuel', 'female', 'business', 'bps', 'degree', 2012),
('BPS0352017', 'ESTHER NAKHANU', 'F', 'BUSINESS', 'BPS', 'DEGREE', 2018),
('ndsnmn', 'svsn', 'nmsnvm', 'nmnvn', 'nmnsvm', 'nmsv', 978);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD KEY `regno` (`regno`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`regno`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `regno` FOREIGN KEY (`regno`) REFERENCES `student` (`regno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
