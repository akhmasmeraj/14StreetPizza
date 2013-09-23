-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 23, 2013 at 02:02 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pizzastreet`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `Id` int(5) NOT NULL AUTO_INCREMENT,
  `Order` text NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `address` text NOT NULL,
  `phone` text NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`Id`, `Order`, `name`, `email`, `address`, `phone`) VALUES
(4, 'Chicken Wings (BBQ) - Rs 229,229,1,', '', '', '', ''),
(5, 'Chicken Wings (BBQ) - Rs 229,229,1,Chicken Wings (Spicy) - Rs 229,229,2,', 'dsdsds', 'sdsdsds', '', '7373737'),
(6, 'Chicken Wings (Crispy) - Rs 229,229,1,', 'sdsds', 'sdsds', 'sdsdsdsds', '73737373'),
(7, 'Chicken Wings (Crispy) - Rs 229,229,1,', 'fdf', 'dfdfd', 'ghghg', '33333'),
(8, 'Chicken Wings (Crispy) - Rs 229,229,1,', 'cvcvc', 'cvcvcv', 'ccvcv', '282828'),
(9, 'Slice (Rs 299),299,1,Split the half (Rs 999),999,3,Slice (Rs 299),299,1,Split the half (Rs 999),999,3,Cheesy Bread - Rs 129,129,1,Chicken Wings (BBQ) - Rs 229,229,1,Chicken Wings (Crispy) - Rs 229,229,1,Chicken Wings (Spicy) - Rs 229,229,1,Apple Juice - Rs 60,60,1,Diet Coke 1.5L - Rs 100,100,2,Diet Coke 500ml - Rs 65,65,1,Mango Juice - Rs 60,60,1,Minute Maid Orange - Rs 60,60,1,Chicken Wings (Crispy) - Rs 229,229,1,Chicken Wings (Spicy) - Rs 229,229,1,Chicky Bites (NonSpicy) - Rs 229,229,1,Chicky Bites (Spicy) - Rs 229,229,1,Garlic Bread - Rs 129,129,1,Potato Skins - Rs 129,129,1,Potato Wedges - Rs 129,129,1,', 'ddsd', 'dsdsds', 'sdsdss', '737373'),
(10, 'Slice (Rs 299)-Hot-Ground Beef,299,1,', 'vcvv', 'fgfgf', 'fgfgf', '33434');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
