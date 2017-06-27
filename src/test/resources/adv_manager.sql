/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : adv_manager

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-06-27 09:00:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (null, null, null, null, '5c24217c7105407384e354aea81c4024', null, '7005047772946841');

-- ----------------------------
-- Table structure for adv_project
-- ----------------------------
DROP TABLE IF EXISTS `adv_project`;
CREATE TABLE `adv_project` (
  `id` int(11) DEFAULT NULL,
  `pid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `pname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `count` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `pusherea` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pruduct_pid` varchar(100) COLLATE utf8_unicode_ci DEFAULT '',
  `channel_pid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pkg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_size` double DEFAULT NULL,
  `app_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `img_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `icon_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of adv_project
-- ----------------------------
INSERT INTO `adv_project` VALUES ('1', 'aa001', '手机助手', '1', '100', '1', '中国', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `adv_project` VALUES (null, 'c1b9c1908f8640da9e66c4de8ad618b7', 'xdfsf', '1', null, '0', null, null, null, 'www.163.com', null, null, null, null, null, null, null, null, 'fsdfs');

-- ----------------------------
-- Table structure for channel_project
-- ----------------------------
DROP TABLE IF EXISTS `channel_project`;
CREATE TABLE `channel_project` (
  `id` int(11) DEFAULT NULL,
  `pid` varchar(50) NOT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `partner_name` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `remark` varchar(500) DEFAULT NULL,
  `new_user_deduct` float(11,10) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_project
-- ----------------------------
INSERT INTO `channel_project` VALUES ('1', 'bf2066faaa534b45b7af012dacd4bae0', 'aaasd', null, 'a', null, 'sdsd', '0.2000000030');

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) unsigned DEFAULT NULL,
  `en_name` varchar(255) DEFAULT NULL,
  `zh_name` varchar(255) NOT NULL,
  `zone` varchar(255) DEFAULT NULL,
  `abbreviation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`zh_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('96', 'Bhutan', '不丹', 'Asia', 'BTN');
INSERT INTO `country` VALUES ('94', 'East Timor', '东帝汶', 'Asia', 'TMP');
INSERT INTO `country` VALUES ('107', 'China', '中国大陆', 'Asia', 'CHN');
INSERT INTO `country` VALUES ('76', 'Macau', '中国澳门', 'Asia', 'MAC');
INSERT INTO `country` VALUES ('80', 'Hong Kong', '中国香港', 'Asia', 'HKG');
INSERT INTO `country` VALUES ('36', 'Central African Rep.', '中非共和国', 'Africa', 'CAF');
INSERT INTO `country` VALUES ('160', 'Denmark', '丹麦', 'Europe', 'DNK');
INSERT INTO `country` VALUES ('132', 'Ukraine', '乌克兰', 'Europe', 'UKR');
INSERT INTO `country` VALUES ('65', 'Uzbekstan', '乌兹别克斯坦', 'Asia', 'UZB');
INSERT INTO `country` VALUES ('27', 'Uganda', '乌干达', 'Africa', 'UGA');
INSERT INTO `country` VALUES ('217', 'Uruguay', '乌拉圭', 'South America', 'URY');
INSERT INTO `country` VALUES ('28', 'Chad', '乍得', 'Africa', 'TCD');
INSERT INTO `country` VALUES ('95', 'Republic of Yemen', '也门共和国', 'Asia', 'YEM');
INSERT INTO `country` VALUES ('89', 'Oth. Asia nes', '亚洲其他国家(地区)', 'Asia', '');
INSERT INTO `country` VALUES ('128', 'Armenia', '亚美尼亚', 'Europe', 'ARM');
INSERT INTO `country` VALUES ('87', 'Israel', '以色列', 'Asia', 'ISR');
INSERT INTO `country` VALUES ('81', 'Iraq', '伊拉克', 'Asia', 'IRQ');
INSERT INTO `country` VALUES ('108', 'Iran', '伊朗', 'Asia', 'IRN');
INSERT INTO `country` VALUES ('239', 'Belize', '伯利兹', 'South America', 'BLZ');
INSERT INTO `country` VALUES ('53', 'Cape Verde', '佛得角', 'Africa', 'CPV');
INSERT INTO `country` VALUES ('131', 'Russia', '俄罗斯联邦', 'Europe', 'RUS');
INSERT INTO `country` VALUES ('174', 'Bulgaria', '保加利亚', 'Europe', 'BGR');
INSERT INTO `country` VALUES ('155', 'Croatia Rep', '克罗地亚', 'Europe', 'HRV');
INSERT INTO `country` VALUES ('58', 'Gambia', '冈比亚', 'Africa', 'GMB');
INSERT INTO `country` VALUES ('135', 'Iceland', '冰岛', 'Europe', 'ISL');
INSERT INTO `country` VALUES ('18', 'Guinea', '几内亚', 'Africa', 'GIN');
INSERT INTO `country` VALUES ('34', 'Guinea Bissau', '几内亚(比绍)', 'Africa', 'GNB');
INSERT INTO `country` VALUES ('171', 'Liechtenstein', '列支敦士登', 'Europe', 'LIE');
INSERT INTO `country` VALUES ('38', 'Congo', '刚果', 'Africa', 'COG');
INSERT INTO `country` VALUES ('14', 'Libyan Arab Jm', '利比亚', 'Africa', 'LBY');
INSERT INTO `country` VALUES ('40', 'Liberia', '利比里亚', 'Africa', 'LBR');
INSERT INTO `country` VALUES ('179', 'Canada', '加拿大', 'North America', 'CAN');
INSERT INTO `country` VALUES ('22', 'Ghana', '加纳', 'Africa', 'GHA');
INSERT INTO `country` VALUES ('21', 'Gabon', '加蓬', 'Africa', 'GAB');
INSERT INTO `country` VALUES ('57', 'Canary Is', '加那利群岛', 'Africa', '');
INSERT INTO `country` VALUES ('134', 'Hungary', '匈牙利', 'Europe', 'HUN');
INSERT INTO `country` VALUES ('182', 'Oth. N.Amer. nes', '北美洲其他国家(地区)', 'North America', '');
INSERT INTO `country` VALUES ('236', 'Oth. L.Amer. nes', '南美洲其他国家(地区)', 'South America', '');
INSERT INTO `country` VALUES ('39', 'S.Africa', '南非', 'Africa', 'ZAF');
INSERT INTO `country` VALUES ('242', 'Bonaire', '博内尔', 'South America', '');
INSERT INTO `country` VALUES ('31', 'Botswana', '博茨瓦那', 'Africa', 'BWA');
INSERT INTO `country` VALUES ('102', 'Qatar', '卡塔尔', 'Asia', 'QAT');
INSERT INTO `country` VALUES ('5', 'Rwanda', '卢旺达', 'Africa', 'RWA');
INSERT INTO `country` VALUES ('165', 'Luxembourg', '卢森堡', 'Europe', 'LUX');
INSERT INTO `country` VALUES ('91', 'India', '印度', 'Asia', 'IND');
INSERT INTO `country` VALUES ('86', 'Indonesia', '印度尼西亚', 'Asia', 'IDN');
INSERT INTO `country` VALUES ('126', 'Guatemala', '危地马拉', 'Central America', 'GTM');
INSERT INTO `country` VALUES ('218', 'Ecuador', '厄瓜多尔', 'South America', 'ECU');
INSERT INTO `country` VALUES ('11', 'Eritrea', '厄立特里亚', 'Africa', 'ERI');
INSERT INTO `country` VALUES ('64', 'Syrian', '叙利亚', 'Asia', 'SYR');
INSERT INTO `country` VALUES ('110', 'Cuba', '古巴', 'Central America', 'CUB');
INSERT INTO `country` VALUES ('106', 'Taiwan prov.', '台湾', 'Asia', 'TWN');
INSERT INTO `country` VALUES ('70', 'Kirghizia', '吉尔吉斯斯坦', 'Asia', 'KGZ');
INSERT INTO `country` VALUES ('56', 'Djibouti', '吉布提', 'Africa', 'DJI');
INSERT INTO `country` VALUES ('104', 'Kazakhstan', '哈萨克斯坦', 'Asia', 'KAZ');
INSERT INTO `country` VALUES ('209', 'Colombia', '哥伦比亚', 'South America', 'COL');
INSERT INTO `country` VALUES ('109', 'Costa Rica', '哥斯达黎加', 'Central America', 'CRI');
INSERT INTO `country` VALUES ('2', 'Cameroon', '喀麦隆', 'Africa', 'CMR');
INSERT INTO `country` VALUES ('191', 'Tuvalu', '图瓦卢', 'Oceania', 'TUV');
INSERT INTO `country` VALUES ('201', 'Tubai Is', '土布艾群岛', 'Oceania', '');
INSERT INTO `country` VALUES ('101', 'Turkmenistan', '土库曼斯坦', 'Asia', 'TKM');
INSERT INTO `country` VALUES ('147', 'Turkey', '土耳其', 'Europe', 'TUR');
INSERT INTO `country` VALUES ('200', 'Tuamotu Is', '土阿莫土群岛', 'Oceania', '');
INSERT INTO `country` VALUES ('234', 'St. Kitts-Nevis', '圣其茨-尼维斯', 'South America', 'KNA');
INSERT INTO `country` VALUES ('121', 'ST. LUCIA', '圣卢西亚', 'Central America', '');
INSERT INTO `country` VALUES ('12', 'Sao Tome & Principe', '圣多美和普林西比', 'Africa', 'STP');
INSERT INTO `country` VALUES ('230', 'Saint Vincent & Grenadines', '圣文森特和格林纳丁斯', 'South America', 'VCT');
INSERT INTO `country` VALUES ('122', 'ST. VINCENT AND THE GRENADINES', '圣文森特和格纳丁斯', 'Central America', 'VAG');
INSERT INTO `country` VALUES ('237', 'St.Pierre and Miquelon', '圣皮埃尔和密克隆', 'South America', 'SPM');
INSERT INTO `country` VALUES ('235', 'Saint Martin Is', '圣马丁岛', 'South America', '');
INSERT INTO `country` VALUES ('140', 'San Marino', '圣马力诺', 'Europe', 'SMR');
INSERT INTO `country` VALUES ('211', 'Guyana', '圭亚那', 'South America', 'GUY');
INSERT INTO `country` VALUES ('23', 'Tanzania', '坦桑尼亚', 'Africa', 'TZA');
INSERT INTO `country` VALUES ('8', 'Egypt', '埃及', 'Africa', 'EGY');
INSERT INTO `country` VALUES ('49', 'Ethiopia', '埃塞俄比亚', 'Africa', 'ETH');
INSERT INTO `country` VALUES ('194', 'Kiribati', '基里巴斯', 'Oceania', 'KIR');
INSERT INTO `country` VALUES ('77', 'Tadzhikistan', '塔吉克斯坦', 'Asia', 'TJK');
INSERT INTO `country` VALUES ('32', 'Senegal', '塞内加尔', 'Africa', 'SEN');
INSERT INTO `country` VALUES ('16', 'Ceuta', '塞卜泰', 'Africa', '');
INSERT INTO `country` VALUES ('19', 'Sierra Leone', '塞拉利昂', 'Africa', 'SLE');
INSERT INTO `country` VALUES ('159', 'Cyprus', '塞浦路斯', 'Europe', 'CYP');
INSERT INTO `country` VALUES ('6', 'Seychelles', '塞舌尔', 'Africa', 'SYC');
INSERT INTO `country` VALUES ('172', 'Serbia & Montenegro', '塞黑', 'Europe', 'S&M');
INSERT INTO `country` VALUES ('112', 'Mexico', '墨西哥', 'Central America', 'MEX');
INSERT INTO `country` VALUES ('45', 'Togo', '多哥', 'Africa', 'TGO');
INSERT INTO `country` VALUES ('177', 'Dominica', '多米尼克', 'North America', 'DMA');
INSERT INTO `country` VALUES ('111', 'Dominican Rep.', '多米尼加共和国', 'Central America', 'DOM');
INSERT INTO `country` VALUES ('207', 'Oth. Ocean. nes', '大洋洲其他国家(地区)', 'Oceania', '');
INSERT INTO `country` VALUES ('173', 'Austria', '奥地利', 'Europe', 'AUT');
INSERT INTO `country` VALUES ('216', 'Venezuela', '委内瑞拉', 'South America', 'VEN');
INSERT INTO `country` VALUES ('99', 'Bangladesh', '孟加拉国', 'Asia', 'BGD');
INSERT INTO `country` VALUES ('13', 'Angola', '安哥拉', 'Africa', 'AGO');
INSERT INTO `country` VALUES ('120', 'ANGUILLA(U.K.)', '安圭拉(英)', 'Central America', '');
INSERT INTO `country` VALUES ('219', 'Antigua & Barbuda', '安提瓜和巴布达', 'South America', 'ATG');
INSERT INTO `country` VALUES ('170', 'Andorra', '安道尔', 'Europe', 'AND');
INSERT INTO `country` VALUES ('192', 'Micronesia Fs', '密克罗尼西亚联邦', 'Oceania', 'FSM');
INSERT INTO `country` VALUES ('113', 'Nicaragua', '尼加拉瓜', 'Central America', 'NIC');
INSERT INTO `country` VALUES ('52', 'Nigeria', '尼日利亚', 'Africa', 'NGA');
INSERT INTO `country` VALUES ('43', 'Niger', '尼日尔', 'Africa', 'NER');
INSERT INTO `country` VALUES ('103', 'Nepal', '尼泊尔', 'Asia', 'NPL');
INSERT INTO `country` VALUES ('79', 'Palestine', '巴勒斯坦', 'Asia', 'PAL');
INSERT INTO `country` VALUES ('221', 'Bahamas', '巴哈马', 'South America', 'BHS');
INSERT INTO `country` VALUES ('98', 'Pakistan', '巴基斯坦', 'Asia', 'PAK');
INSERT INTO `country` VALUES ('222', 'Barbados', '巴巴多斯', 'South America', 'BRB');
INSERT INTO `country` VALUES ('198', 'Papua New Guinea', '巴布亚新几内亚', 'Oceania', 'PNG');
INSERT INTO `country` VALUES ('213', 'Paraguay', '巴拉圭', 'South America', 'PRY');
INSERT INTO `country` VALUES ('114', 'Panama', '巴拿马', 'Central America', 'PAN');
INSERT INTO `country` VALUES ('66', 'Bahrian', '巴林', 'Asia', 'BHR');
INSERT INTO `country` VALUES ('241', 'Brazil', '巴西', 'South America', 'BRA');
INSERT INTO `country` VALUES ('10', 'Burkina Faso', '布基纳法索', 'Africa', 'BFA');
INSERT INTO `country` VALUES ('54', 'Burundi', '布隆迪', 'Africa', 'BDI');
INSERT INTO `country` VALUES ('156', 'Greece', '希腊', 'Europe', 'GRC');
INSERT INTO `country` VALUES ('199', 'Palau', '帕劳共和国', 'Oceania', 'PLW');
INSERT INTO `country` VALUES ('185', 'Cook Is', '库克群岛', 'Oceania', 'COK');
INSERT INTO `country` VALUES ('212', 'Curacao', '库腊索岛', 'South America', '');
INSERT INTO `country` VALUES ('223', 'Cayman Is', '开曼群岛', 'South America', 'CYM');
INSERT INTO `country` VALUES ('162', 'Germany', '德国', 'Europe', 'DEU');
INSERT INTO `country` VALUES ('164', 'Italy', '意大利', 'Europe', 'ITA');
INSERT INTO `country` VALUES ('189', 'Solomon Is', '所罗门群岛', 'Oceania', 'SLB');
INSERT INTO `country` VALUES ('144', 'Latvia', '拉脱维亚', 'Europe', 'LVA');
INSERT INTO `country` VALUES ('138', 'Norway', '挪威', 'Europe', 'NOR');
INSERT INTO `country` VALUES ('149', 'Czech Rep', '捷克共和国', 'Europe', 'CZE');
INSERT INTO `country` VALUES ('146', 'Moldavia', '摩尔多瓦', 'Europe', 'MDA');
INSERT INTO `country` VALUES ('50', 'Morocco', '摩洛哥', 'Africa', 'MAR');
INSERT INTO `country` VALUES ('137', 'Monaco', '摩纳哥', 'Europe', 'MCO');
INSERT INTO `country` VALUES ('84', 'Brunei', '文莱', 'Asia', 'BRN');
INSERT INTO `country` VALUES ('197', 'Fiji', '斐济', 'Oceania', 'FJI');
INSERT INTO `country` VALUES ('33', 'Swaziland', '斯威士兰', 'Africa', 'SWZ');
INSERT INTO `country` VALUES ('150', 'Slovak Rep', '斯洛伐克', 'Europe', 'SVK');
INSERT INTO `country` VALUES ('148', 'Slovenia Rep', '斯洛文尼亚', 'Europe', 'SVN');
INSERT INTO `country` VALUES ('72', 'Sri Lanka', '斯里兰卡', 'Asia', 'LKA');
INSERT INTO `country` VALUES ('62', 'Singapore', '新加坡', 'Asia', 'SGP');
INSERT INTO `country` VALUES ('187', 'New Caledonia', '新喀里多尼亚', 'Oceania', 'NCL');
INSERT INTO `country` VALUES ('196', 'New Zealand', '新西兰', 'Oceania', 'NZL');
INSERT INTO `country` VALUES ('67', 'Japan', '日本', 'Asia', 'JPN');
INSERT INTO `country` VALUES ('208', 'Chile', '智利', 'South America', 'CHL');
INSERT INTO `country` VALUES ('78', 'Korea,DPR', '朝鲜', 'Asia', 'PRK');
INSERT INTO `country` VALUES ('1', 'Unknow', '未知的国家', 'Unknown', 'Unknow');
INSERT INTO `country` VALUES ('97', 'Cambodia', '柬埔寨', 'Asia', 'KHM');
INSERT INTO `country` VALUES ('224', 'Grenada', '格林纳达', 'South America', 'GRD');
INSERT INTO `country` VALUES ('181', 'Greenland', '格陵兰', 'North America', 'GRL');
INSERT INTO `country` VALUES ('127', 'Georgia', '格鲁吉亚', 'Europe', 'GEO');
INSERT INTO `country` VALUES ('48', 'Melilla', '梅利利亚', 'Africa', '');
INSERT INTO `country` VALUES ('153', 'Vatican City State', '梵蒂冈城国', 'Europe', 'VAT');
INSERT INTO `country` VALUES ('133', 'Oth. Eur. nes', '欧洲其他国家(地区)', 'Europe', '');
INSERT INTO `country` VALUES ('158', 'Belgium', '比利时', 'Europe', 'BEL');
INSERT INTO `country` VALUES ('26', 'Mauritania', '毛里塔尼亚', 'Africa', 'MRT');
INSERT INTO `country` VALUES ('9', 'Mauritius', '毛里求斯', 'Africa', 'MUS');
INSERT INTO `country` VALUES ('35', 'Congo,DR', '民主刚果', 'Africa', '');
INSERT INTO `country` VALUES ('183', 'Tonga', '汤加', 'Oceania', 'TON');
INSERT INTO `country` VALUES ('100', 'Saudi Arabia', '沙特阿拉伯', 'Asia', 'SAU');
INSERT INTO `country` VALUES ('163', 'France', '法国', 'Europe', 'FRA');
INSERT INTO `country` VALUES ('210', 'French Guyana', '法属圭亚那', 'South America', 'GUF');
INSERT INTO `country` VALUES ('195', 'French Polynesia', '法属玻利尼西亚', 'Oceania', 'PYF');
INSERT INTO `country` VALUES ('167', 'Poland', '波兰', 'Europe', 'POL');
INSERT INTO `country` VALUES ('118', 'Puerto Rico', '波多黎各', 'Central America', 'PTR');
INSERT INTO `country` VALUES ('152', 'Bosnia&Hercegovina', '波斯尼亚-黑塞哥维那共和', 'Europe', 'BIH');
INSERT INTO `country` VALUES ('71', 'Thailand', '泰国', 'Asia', 'THA');
INSERT INTO `country` VALUES ('17', 'Zimbabwe', '津巴布韦', 'Africa', 'ZWE');
INSERT INTO `country` VALUES ('125', 'Honduras', '洪都拉斯', 'Central America', 'HND');
INSERT INTO `country` VALUES ('226', 'Haiti', '海地', 'South America', 'HTI');
INSERT INTO `country` VALUES ('184', 'Australia', '澳大利亚', 'Oceania', 'AUS');
INSERT INTO `country` VALUES ('157', 'Ireland', '爱尔兰', 'Europe', 'IRL');
INSERT INTO `country` VALUES ('143', 'Estonia', '爱沙尼亚', 'Europe', 'EST');
INSERT INTO `country` VALUES ('227', 'Jamaica', '牙买加', 'South America', 'JAM');
INSERT INTO `country` VALUES ('232', 'Turks & Caicos Is', '特克斯和凯科斯群岛', 'South America', 'TCA');
INSERT INTO `country` VALUES ('231', 'Trinidad & Tobago', '特立尼达和多巴哥', 'South America', 'TTO');
INSERT INTO `country` VALUES ('240', 'Bolivia', '玻利维亚', 'South America', 'BOL');
INSERT INTO `country` VALUES ('186', 'Nauru', '瑙鲁', 'Oceania', 'NRU');
INSERT INTO `country` VALUES ('141', 'Sweden', '瑞典', 'Europe', 'SWE');
INSERT INTO `country` VALUES ('142', 'Switzerland', '瑞士', 'Europe', 'CHE');
INSERT INTO `country` VALUES ('124', 'Guadeloupe', '瓜德罗普', 'Central America', 'GLP');
INSERT INTO `country` VALUES ('204', 'Wallis and Futuna', '瓦利斯和浮图纳', 'Oceania', 'WLF');
INSERT INTO `country` VALUES ('188', 'Vanuatu', '瓦努阿图', 'Oceania', 'VUT');
INSERT INTO `country` VALUES ('20', 'Reunion', '留尼汪', 'Africa', 'REU');
INSERT INTO `country` VALUES ('130', 'Byelorussia', '白俄罗斯', 'Europe', 'BLR');
INSERT INTO `country` VALUES ('178', 'Bermuda', '百慕大', 'North America', 'BMU');
INSERT INTO `country` VALUES ('205', 'Gambier Is', '盖比群岛', 'Oceania', '');
INSERT INTO `country` VALUES ('176', 'Gibraltar', '直布罗陀', 'Europe', 'GIB');
INSERT INTO `country` VALUES ('202', 'Society Is', '社会群岛', 'Oceania', '');
INSERT INTO `country` VALUES ('83', 'Kuwait', '科威特', 'Asia', 'KWT');
INSERT INTO `country` VALUES ('30', 'Comoros', '科摩罗', 'Africa', 'COM');
INSERT INTO `country` VALUES ('7', 'Cote d\'lvoir', '科特迪瓦', 'Africa', 'CIV');
INSERT INTO `country` VALUES ('214', 'Peru', '秘鲁', 'South America', 'PER');
INSERT INTO `country` VALUES ('41', 'Tunisia', '突尼斯', 'Africa', 'TUN');
INSERT INTO `country` VALUES ('145', 'Lithuania', '立陶宛', 'Europe', 'LTU');
INSERT INTO `country` VALUES ('25', 'Somalia', '索马里', 'Africa', 'SOM');
INSERT INTO `country` VALUES ('68', 'Jordan', '约旦', 'Asia', 'JOR');
INSERT INTO `country` VALUES ('46', 'Namibia', '纳米比亚', 'Africa', 'NAM');
INSERT INTO `country` VALUES ('92', 'Myanmar', '缅甸', 'Asia', 'MMR');
INSERT INTO `country` VALUES ('139', 'Romania', '罗马尼亚', 'Europe', 'ROM');
INSERT INTO `country` VALUES ('180', 'United States', '美国', 'North America', 'USA');
INSERT INTO `country` VALUES ('119', 'VIRGIN IS.(US)', '美属维尔京群岛', 'Central America', '');
INSERT INTO `country` VALUES ('74', 'Laos,PDR', '老挝', 'Asia', 'LAO');
INSERT INTO `country` VALUES ('61', 'Kenya', '肯尼亚', 'Africa', 'KEN');
INSERT INTO `country` VALUES ('175', 'Finland', '芬兰', 'Europe', 'FIN');
INSERT INTO `country` VALUES ('60', 'Sudan', '苏丹', 'Africa', 'SDN');
INSERT INTO `country` VALUES ('215', 'Suriname', '苏里南', 'South America', 'SUR');
INSERT INTO `country` VALUES ('161', 'United Kingdom', '英国', 'Europe', 'ENG');
INSERT INTO `country` VALUES ('117', 'VIRGIN IS.(U.K.)', '英属维尔京群岛', 'Central America', 'BVI');
INSERT INTO `country` VALUES ('154', 'Netherlands', '荷兰', 'Europe', 'NLD');
INSERT INTO `country` VALUES ('115', 'the Netherlands Antilles', '荷属安地列斯群岛', 'Central America', 'ANT');
INSERT INTO `country` VALUES ('123', 'NETHERLANDS ANTILLES', '荷属安德列斯', 'Central America', '');
INSERT INTO `country` VALUES ('47', 'Mozambique', '莫桑比克', 'Africa', 'MOZ');
INSERT INTO `country` VALUES ('37', 'Lesotho', '莱索托', 'Africa', 'LSO');
INSERT INTO `country` VALUES ('105', 'Philippines', '菲律宾', 'Asia', 'PHL');
INSERT INTO `country` VALUES ('116', 'El Salvador', '萨尔瓦多', 'Central America', 'SLV');
INSERT INTO `country` VALUES ('225', 'Saba', '萨巴', 'South America', '');
INSERT INTO `country` VALUES ('190', 'Samoa', '萨摩亚', 'Oceania', 'WSM');
INSERT INTO `country` VALUES ('166', 'Portugal', '葡萄牙', 'Europe', 'PRT');
INSERT INTO `country` VALUES ('88', 'Mongolia', '蒙古', 'Asia', 'MNG');
INSERT INTO `country` VALUES ('229', 'Montserrat', '蒙特塞拉特', 'South America', 'MSR');
INSERT INTO `country` VALUES ('44', 'Western Sahara', '西撒哈拉', 'Africa', 'ESH');
INSERT INTO `country` VALUES ('168', 'Spain', '西班牙', 'Europe', 'ESP');
INSERT INTO `country` VALUES ('206', 'Norfolk Is', '诺福克岛', 'Oceania', '');
INSERT INTO `country` VALUES ('3', 'Benin', '贝宁', 'Africa', 'BEN');
INSERT INTO `country` VALUES ('42', 'Zambia', '赞比亚', 'Africa', 'ZMB');
INSERT INTO `country` VALUES ('59', 'Eq.Guinea', '赤道几内亚', 'Africa', 'GNQ');
INSERT INTO `country` VALUES ('69', 'Vietnam', '越南', 'Asia', 'VNM');
INSERT INTO `country` VALUES ('129', 'Azerbaijan', '阿塞拜疆', 'Europe', 'AZE');
INSERT INTO `country` VALUES ('75', 'Afghanistan', '阿富汗', 'Asia', 'AFG');
INSERT INTO `country` VALUES ('55', 'Algeria', '阿尔及利亚', 'Africa', 'DZA');
INSERT INTO `country` VALUES ('169', 'Albania', '阿尔巴尼亚', 'Europe', 'ALB');
INSERT INTO `country` VALUES ('90', 'Oman', '阿曼', 'Asia', 'OMN');
INSERT INTO `country` VALUES ('238', 'Argentina', '阿根廷', 'South America', 'ARG');
INSERT INTO `country` VALUES ('73', 'United Arab Emirates', '阿联酋', 'Asia', 'ARE');
INSERT INTO `country` VALUES ('220', 'Aruba', '阿鲁巴岛', 'South America', 'ABW');
INSERT INTO `country` VALUES ('15', 'Oth. Afr. nes', '非洲其他国家(地区)', 'Africa', '');
INSERT INTO `country` VALUES ('63', 'Korea Rep.', '韩国', 'Asia', 'KOR');
INSERT INTO `country` VALUES ('203', 'Marquesas Is', '马克萨斯群岛', 'Oceania', '');
INSERT INTO `country` VALUES ('151', 'Macedonia Rep', '马其顿', 'Europe', 'MKD');
INSERT INTO `country` VALUES ('85', 'Maldives', '马尔代夫', 'Asia', 'MDV');
INSERT INTO `country` VALUES ('51', 'Malawi', '马拉维', 'Africa', 'MWI');
INSERT INTO `country` VALUES ('228', 'Martinique', '马提尼克', 'South America', 'MTQ');
INSERT INTO `country` VALUES ('93', 'Malaysia', '马来西亚', 'Asia', 'MYS');
INSERT INTO `country` VALUES ('29', 'Mayotte', '马约特岛', 'Africa', 'MYT');
INSERT INTO `country` VALUES ('193', 'Marshall Is Rep', '马绍尔群岛', 'Oceania', 'MHL');
INSERT INTO `country` VALUES ('136', 'Malta', '马耳他', 'Europe', 'MLT');
INSERT INTO `country` VALUES ('4', 'Madagascar', '马达加斯加', 'Africa', 'MDG');
INSERT INTO `country` VALUES ('24', 'Mali', '马里', 'Africa', 'MLI');
INSERT INTO `country` VALUES ('82', 'Lebanon', '黎巴嫩', 'Asia', 'LBN');

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` bigint(20) DEFAULT NULL,
  `api_key` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `img_url` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mode` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `uri` longtext COLLATE utf8_unicode_ci,
  `username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `uuid` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of notification
-- ----------------------------

-- ----------------------------
-- Table structure for partner
-- ----------------------------
DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner` (
  `id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `data_sync_address` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `type_description` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_no` varchar(50) DEFAULT NULL COMMENT '手机/电话号码',
  `qq_no` varchar(30) DEFAULT NULL COMMENT 'QQ号码',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `status` int(11) DEFAULT '1',
  `remark` text,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='type: 1 代表渠道商   2代表广告厂商';

-- ----------------------------
-- Records of partner
-- ----------------------------
INSERT INTO `partner` VALUES (null, '1', 'd', 's', 'a', 'a', null, 'df', 'f', 'f', null, null, 'f', null);
INSERT INTO `partner` VALUES (null, '2', '杭州', 'https://www.aliyun.com/', 'alibaba', '阿里巴巴', null, '38373@qq.com', '136444444', '15151631', null, null, '马云  牛逼', null);
INSERT INTO `partner` VALUES (null, '2', '地方', '', 'cs1', '广告厂商1', null, '15@qq.com', '', '213', null, null, '的的冯绍峰是否', null);
INSERT INTO `partner` VALUES ('2', '2', '地方', '', 'cs2', '广告厂商2', null, '15@qq.com', '', '213', '', null, '的的冯绍峰是否', '2017-03-28 17:35:48');
INSERT INTO `partner` VALUES (null, null, 'dd', 'dddd', 'sffsf', 'asfa', null, '222@qq.com', '33333', '323', null, null, 'sf', null);

-- ----------------------------
-- Table structure for product_project
-- ----------------------------
DROP TABLE IF EXISTS `product_project`;
CREATE TABLE `product_project` (
  `id` int(11) DEFAULT NULL,
  `pid` varchar(50) NOT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `partner_name` varchar(11) DEFAULT NULL,
  `in_price` double(9,2) DEFAULT '0.00',
  `status` int(11) DEFAULT '1',
  `remark` varchar(500) DEFAULT NULL,
  `money_type` int(1) DEFAULT '0' COMMENT '货币类型（0为元，1为美元）',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_project
-- ----------------------------
INSERT INTO `product_project` VALUES ('713', 'b1084a10237c46ce969e14280ffeefeb', 'aaaa', '3', 'cs1', '122.00', null, '33', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `last_login_ip` varchar(255) DEFAULT NULL,
  `last_login_time` varchar(255) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `partner_name` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '超级管理员', null, ' ', ' ', '1', '0', null);
INSERT INTO `user` VALUES ('2', 'test', 'test', '普通用户', null, null, null, '1', null, null);
