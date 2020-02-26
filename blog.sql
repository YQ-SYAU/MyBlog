create database blog;
use blog;

#用户表
create table user(
id varchar(200) comment 'id,无明确意义',
username varchar(20) comment '用户名',
password varchar(100) comment '密码',
qq varchar(20) comment '用户qq号',
gender varchar(20) comment '性别',
picture varchar(200) comment '用户头像保存路径',
description varchar(300) comment '个人描述',
fans int(10) comment '粉丝数目',
status int(10)comment '用户状态：1 可用；0 不可用',
primary key(id)
);

insert into user (id,username,password)values('1','admin','123');
insert into user values
('1','admin','$2a$10$WfKhmPWW1YHWE3wWOco4yubpGRNUiLFNmdS8cQ7GTJh.6Mto4BOva','285038165','男','user/-200.jpeg','我什么都不爱，我只爱编程',0,1),
('2','燕青','$2a$10$WfKhmPWW1YHWE3wWOco4yubpGRNUiLFNmdS8cQ7GTJh.6Mto4BOva','285038165','男','user/1.jpg','我什么都不爱，我只爱编程',2,1);
insert into user values
('3','大双','$2a$10$WfKhmPWW1YHWE3wWOco4yubpGRNUiLFNmdS8cQ7GTJh.6Mto4BOva','285038165','男','user/2.jpeg','我什么都不爱，我只爱编程',0,1),
('4','小双','$2a$10$WfKhmPWW1YHWE3wWOco4yubpGRNUiLFNmdS8cQ7GTJh.6Mto4BOva','285038165','男','user/3.jpg','我什么都不爱，我只爱编程',2,1);
insert into user values
('5','我怎能...','$2a$10$WfKhmPWW1YHWE3wWOco4yubpGRNUiLFNmdS8cQ7GTJh.6Mto4BOva','285038165','男','user/4.jpeg','我什么都不爱，我只爱编程',0,1),
('6','小明','$2a$10$WfKhmPWW1YHWE3wWOco4yubpGRNUiLFNmdS8cQ7GTJh.6Mto4BOva','285038165','男','user/5.jpg','我什么都不爱，我只爱编程',2,1);

#角色表
CREATE TABLE role(
id varchar(200)comment 'id,无明确意义' ,
roleName varchar(50)comment '角色名',
PRIMARY KEY(id)
);
insert into role
values
('1','ADMIN'),
('2','USER');

#用户角色表
create table user_role(
userId varchar(200)comment '用户id',
roleId varchar(200)comment '角色id',
PRIMARY KEY(userId,roleId), 
FOREIGN KEY (userId) REFERENCES user(id),
FOREIGN KEY (roleId) REFERENCES role(id)
);
insert into user_role
 values
('1','1'),
('2','2');



#文章分类表
create table category(
id varchar(200) comment 'id,无明确意义',
cname varchar(20) comment '分类名称',
primary key(id)
);
insert into category values('1','学习'),('2','游戏');

#文章表
create table article(
id varchar(200) comment 'id,无明确意义',
title varchar(40) comment '文章标题',
content varchar(5000) comment '文章内容',
picture varchar(200) comment '文章图片路径',
support int(10) comment '文章点赞总数',
publishTime varchar(50) comment '文章发布时间',
browse int(10) comment '文章浏览量',
u_id varchar(200) comment '发布人用户id',
c_id varchar(200) comment '所属分类',
commentNum int(10) comment '文章评论数',
primary key(id),
foreign key(u_id) references user(id),
foreign key(c_id) references category(id)
);



insert into article
values
('1','心情好复杂','从一个实习跳进另一个院的实习，这特么什么怪圈','article/psb.jpg',24,'2019-07-02 14:07',315,'1','1'),
('2','华为“舵手”任正非——真正的商业思想家','华为，一直处于风口浪尖上。他的幕后舵手人任正非也一改往日的低调，不断地走到台前。

　　他43岁才开始创业，不惑之年始见春，一手把山寨公司变成了震惊世界的科技王国，同时创立了开中国企业先河的企业治理大法。在判断企业市场时又极具预见性，在企业繁花似锦的时候却说这很可能是企业的“寒冬”。

　　作为华为创始人，不仅不是一个食古不化的老古董，相反，他的思想前卫，格局远大，极具人格魅力。他用实际行动重新定义了中国企业家精神。他的创业故事激励着无数企业家搏杀奋斗。他和他缔造的企业一样沉稳低调，历经沉浮坎坷，却最终披荆斩棘，登上了个人意志和时代的巅峰。

　　任正非一个真正的商业思想家，一个为了观念而战斗的硬汉！任正非商界教父级别的存在，他用3万元创立的华为，目前是世界第一的通信企业，手机世界第三，芯片更是世界一流。华为目前员工18万，华为的业务遍布全球170多个国家和地区，华为年营收6000亿，有3000亿来自国外。年纳税1000亿，研发投入900亿。在福布斯品牌最具价值排行榜中，华为是中国唯一进榜的企业也是是中国的标志性业','article/psb.jpg',24,'2019-07-03 14:07',315,'1','2'),
('3','IT湘妹的回乡菜，不一样的烟火生活~','　　虽然离开深圳，现在回到老家湖南农村，但还是比较喜欢来天涯，同时也看到天涯很多高手在晒菜，自己今天也来晒一下，拍砖要手下留情哦！','article/310016845.jpg',554,'2019-07-04 14:07',315,'1','2'),
('4','年化仅5%的招商银行理财 也会暴雷，太扯了。','最奇葩理财平台“钱端”爆雷事件：9000投资户14亿资产人间蒸发，钱端说钱在招行，招商说我们早已终止合作拒不承认，钱端说我们发售的都是招行的资产包，我们只是发布的平台，招行说我们早已终止合作，钱端说：我们也是受害者，经侦说他们不是P2P而且目前还无法立案也没权限调查招商银行流水。谁真谁假，有谁能告诉我们这群90%以上都是招行推荐的投资者，只想知道钱在哪，求监管部门垂怜，求政府依靠，
　　之所以那么火，是一篇名为《中年人的风平浪静，只能靠命》的文章。建议自己去网上看看这个文章，我看了想哭。
　　文章的主人公是一个女硕士，说的是自己通过招商银行介绍，下载安装了一个叫“钱端”的APP，并在里面投资了一共86万，结果爆雷了。年化率这么高的理财产品，暴雷了，
　　这几天，深圳的招商银行门前不太平，很多投资人在门前哭诉，然而没用。最赚钱的银行，说这个事还在处理中，建议大家报警。
　　我也不敢多说。这年头，银行开始无耻了，我想应该是存银行的定期太少了，他们的招？？？。。。。。不说了。','article/201610181739277776.jpg',254,'2019-07-05 14:07',315,'1','2'),
('5','心情好复杂','从一个实习跳进另一个院的实习，这特么什么怪圈','article/psb.jpg',240,'2019-07-02 14:07',315,'1','1'),
('6','华为“舵手”任正非——真正的商业思想家','华为，一直处于风口浪尖上。他的幕后舵手人任正非也一改往日的低调，不断地走到台前。

　　他43岁才开始创业，不惑之年始见春，一手把山寨公司变成了震惊世界的科技王国，同时创立了开中国企业先河的企业治理大法。在判断企业市场时又极具预见性，在企业繁花似锦的时候却说这很可能是企业的“寒冬”。

　　作为华为创始人，不仅不是一个食古不化的老古董，相反，他的思想前卫，格局远大，极具人格魅力。他用实际行动重新定义了中国企业家精神。他的创业故事激励着无数企业家搏杀奋斗。他和他缔造的企业一样沉稳低调，历经沉浮坎坷，却最终披荆斩棘，登上了个人意志和时代的巅峰。

　　任正非一个真正的商业思想家，一个为了观念而战斗的硬汉！任正非商界教父级别的存在，他用3万元创立的华为，目前是世界第一的通信企业，手机世界第三，芯片更是世界一流。华为目前员工18万，华为的业务遍布全球170多个国家和地区，华为年营收6000亿，有3000亿来自国外。年纳税1000亿，研发投入900亿。在福布斯品牌最具价值排行榜中，华为是中国唯一进榜的企业也是是中国的标志性业','article/psb.jpg',24,'2019-07-03 14:07',315,'1','2'),
('7','IT湘妹的回乡菜，不一样的烟火生活~','　　虽然离开深圳，现在回到老家湖南农村，但还是比较喜欢来天涯，同时也看到天涯很多高手在晒菜，自己今天也来晒一下，拍砖要手下留情哦！','article/310016845.jpg',104,'2019-07-04 14:07',315,'1','2'),
('8','年化仅5%的招商银行理财 也会暴雷，太扯了。','最奇葩理财平台“钱端”爆雷事件：9000投资户14亿资产人间蒸发，钱端说钱在招行，招商说我们早已终止合作拒不承认，钱端说我们发售的都是招行的资产包，我们只是发布的平台，招行说我们早已终止合作，钱端说：我们也是受害者，经侦说他们不是P2P而且目前还无法立案也没权限调查招商银行流水。谁真谁假，有谁能告诉我们这群90%以上都是招行推荐的投资者，只想知道钱在哪，求监管部门垂怜，求政府依靠，
　　之所以那么火，是一篇名为《中年人的风平浪静，只能靠命》的文章。建议自己去网上看看这个文章，我看了想哭。
　　文章的主人公是一个女硕士，说的是自己通过招商银行介绍，下载安装了一个叫“钱端”的APP，并在里面投资了一共86万，结果爆雷了。年化率这么高的理财产品，暴雷了，
　　这几天，深圳的招商银行门前不太平，很多投资人在门前哭诉，然而没用。最赚钱的银行，说这个事还在处理中，建议大家报警。
　　我也不敢多说。这年头，银行开始无耻了，我想应该是存银行的定期太少了，他们的招？？？。。。。。不说了。','article/201610181739277776.jpg',54,'2019-07-05 14:07',315,'1','2');

insert into article
values
('9','新版本上单铠皇必备！出装铭文打法思路一体化教学','铠皇是王者荣耀历史上的一个很优秀的英雄，刚贾文葛杀人案吃生殖器出现进入王者峡谷时就一跃成为最强上单，后来因太强被官方削弱，但强度仍然不可小觑，并且在当前版本一技能被改动成恢复生命值10%的固定血量，所以这个英雄的打法又有了新的改变，当下，小鱼认为最适合铠的就是半肉流。技能解析：被动：铠的被动说通俗一点就是面对单个敌人时，他的普攻和技能伤害会对敌人造成50%的额外伤害，这也就是铠被喻为单挑王的原因了，因为他真的强。一技能：一技能被调整的很明显，丢出的刀刃命中敌人后不仅可以回复1非诚勿扰201012040%的最大生命值并增加移速，还能增加15%的攻击速度，效果真是十分全面呢！二技能：二技能是铠的主要输出手段，击飞敌人后强化下一次普攻，打人很疼。被动更是让对面无奈，就像出了一件重装霸者，但是这件重装霸者还可以回复法力值，妈妈再也不用担心我被射手消耗后频繁回程啦','article/kai.jpg',66,'2019-07-04 15:32',66,'2','3'),
('10','王者荣耀鲁班新手教学','1ADC的最佳位置绝对是下路：

很多时候，新手不知道怎么走分路，ADC会去上路中路，所有的moba游戏ADC基本上都是在下路的，这是有科学依据的，所以还是乖乖去下路吧。利用好被动技能：

鲁班在普攻的时候会有1、2、3、4的数字，这是因为被动第五下会有连续射击，所以对线的时候可以打小兵1、2、3、4堆叠数字，第五下的时候消耗对方英雄。2技能可以随时支援：

鲁班的2技能和后羿的有一些像，当然没有眩晕。但是好在我们CD短啊，所以我们可以随时支援，还可以抢BUFF，当然。。。还可以抢主宰。
红BUFF对鲁班很有用：

鲁班的攻速很快，而且射程也不错，拿红对早期的鲁班还是很有作用的，但是要注意的是2技能和大招是不受红BUFF的影响的哦。团战不要太过靠前：

虽然鲁班杀伤力很大但是他没有位移技能，所以基本上一抓就要完蛋，除了要搭配闪现技能（不要轻易用）之外，自己的站位也要小心。鲁班的输出很高：

出装上面可以以暴击为主，当然可以附带吸血，如果对方的阵容好多坦克，破军也是可以考虑的，综合数据当中可以看到鲁班的输出值很大。','article/.jpg',24,'2019-07-02 14:07',315,'1','1');





#用户关注表
create table attention(
id varchar(200) comment '关注id',
u_id varchar(200) comment '用户id',
p_id varchar(200) comment '被关注人id',
foreign key(u_id) references user(id),
foreign key(p_id) references user(id)
);

#日志表
CREATE TABLE sysLog(
    id VARCHAR(32) PRIMARY KEY comment '日志id',
    visitTime varchar(100) comment '访问时间',
    username VARCHAR(50) comment '用户名',
    ip VARCHAR(30) comment 'ip地址',
    url VARCHAR(50) comment '访问的路径',
    executionTime int comment '执行所花的时间',
    method VARCHAR(200) comment '访问的方法'
);

#轮播图
create table slideshow(
id varchar(200)comment '轮播图id',
picture1 varchar(200)comment '第一张图',
picture2 varchar(200)comment '第二张图',
picture3 varchar(200)comment '第三张图'
);
insert into slideshow
values
('1','slideshow/1.jpg','slideshow/2.jpg','slideshow/3.jpg');
#评论表
create table comments(
id varchar(200)comment '评论id',
u_id varchar(200) comment '用户id',
a_id varchar(200) comment '文章id',
c_time varchar(50) comment'评论时间',
content varchar(600) comment '评论内容',
primary key(id),
foreign key(u_id) references user(id),
foreign key(a_id) references article(id)
); 

#点赞表
create table support(
id varchar(200)comment '点赞id',
uId varchar(200) comment '用户id',
aId varchar(200) comment '文章id',
primary key(id),
foreign key(uId) references user(id),
foreign key(aId) references article(id)
); 