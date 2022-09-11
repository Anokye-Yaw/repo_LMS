-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 11, 2022 at 08:59 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE `book_details` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(80) NOT NULL,
  `author` varchar(80) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`book_id`, `book_name`, `author`, `quantity`) VALUES
(1, 'java', 'sam', 1),
(2, 'C++', 'Rasmus', 3),
(3, 'Python', 'Jonson', 5),
(4, 'Accounting', 'Ezekiel', 22),
(5, 'React  ', 'Robert  Gain', 32),
(6, 'Geography', 'Bismark', 12),
(7, 'Law of Ghana', 'Prof. Ahmed Boateng', 14);

-- --------------------------------------------------------

--
-- Table structure for table `issue_book_details`
--

CREATE TABLE `issue_book_details` (
  `id` int(11) NOT NULL,
  `book_id` int(10) NOT NULL,
  `book_name` varchar(80) NOT NULL,
  `student_id` int(10) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `issue_date` date NOT NULL,
  `due_date` date NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue_book_details`
--

INSERT INTO `issue_book_details` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES
(1, 1, 'java', 2, 'Jerry', '2022-03-24', '2022-03-24', 'returned'),
(2, 1, 'java', 2, 'Jerry', '2022-03-24', '2022-03-24', 'returned'),
(3, 2, 'C++', 3, 'Opoku Prince', '2022-03-24', '2022-03-24', 'pending'),
(4, 4, 'Accounting', 3, 'Opoku Prince', '2022-04-01', '2022-04-01', 'pending'),
(5, 4, 'Accounting', 2, 'Jerry', '2022-04-01', '2022-04-01', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `course` varchar(20) NOT NULL,
  `branch` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `name`, `course`, `branch`) VALUES
(1, 'Dominic', 'MSC', 'PLAIN'),
(2, 'Jerry', 'PHD', 'IT'),
(3, 'Opoku Prince', 'BSC', 'ELECTRONICS'),
(4, 'Yeaboah Dennis', 'BSC', 'PLAIN'),
(5, 'Rose Mary', 'IT', 'BSC');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(1, 'chess', 'pass123', 'chess@gmail.com', 987654321),
(2, 'price', 'ecirp', 'price@hotmail.com', 1234567890),
(3, 'prince', 'hotmail', 'prince@hotmail.com', 1234567890),
(4, 'james', 'darko', 'darko@gmail.com', 987654321),
(5, 'praise', 'chess', 'darko@gmail.com', 12148790),
(6, 'uncle', 'pee', 'uncle@hotmail.com', 782134098);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
