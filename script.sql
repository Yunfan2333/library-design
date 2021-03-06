USE [sqlDesign]
GO
/****** Object:  Table [dbo].[clc1]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[clc1](
	[clcID1] [char](1) NOT NULL,
	[clcName1] [varchar](50) NOT NULL,
 CONSTRAINT [PK_CLC1] PRIMARY KEY NONCLUSTERED 
(
	[clcID1] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[clc1] ([clcID1], [clcName1]) VALUES (N'A', N'马列主义、毛泽东思想、邓小平理论')
INSERT [dbo].[clc1] ([clcID1], [clcName1]) VALUES (N'B', N'哲学、宗教')
INSERT [dbo].[clc1] ([clcID1], [clcName1]) VALUES (N'C', N'社会科学总论')
INSERT [dbo].[clc1] ([clcID1], [clcName1]) VALUES (N'D', N'政治、法律')
INSERT [dbo].[clc1] ([clcID1], [clcName1]) VALUES (N'E', N'军事')
/****** Object:  Table [dbo].[booktype]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[booktype](
	[bookTypeID] [varchar](20) NOT NULL,
	[bookTypeName] [varchar](50) NOT NULL,
	[bookTypeInfo] [text] NULL,
 CONSTRAINT [PK_BOOKTYPE] PRIMARY KEY NONCLUSTERED 
(
	[bookTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[booktype] ([bookTypeID], [bookTypeName], [bookTypeInfo]) VALUES (N'001', N'中文图书', N'汉语')
INSERT [dbo].[booktype] ([bookTypeID], [bookTypeName], [bookTypeInfo]) VALUES (N'002', N'英文图书', N'英语')
INSERT [dbo].[booktype] ([bookTypeID], [bookTypeName], [bookTypeInfo]) VALUES (N'003', N'日语图书', N'日语')
INSERT [dbo].[booktype] ([bookTypeID], [bookTypeName], [bookTypeInfo]) VALUES (N'004', N'法语图书', N'法语')
INSERT [dbo].[booktype] ([bookTypeID], [bookTypeName], [bookTypeInfo]) VALUES (N'005', N'意大利语图书', N'意大利语')
INSERT [dbo].[booktype] ([bookTypeID], [bookTypeName], [bookTypeInfo]) VALUES (N'006', N'俄文图书', N'俄文')
/****** Object:  Table [dbo].[usertype]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[usertype](
	[userTypeID] [varchar](20) NOT NULL,
	[userType] [varchar](20) NOT NULL,
	[maxBookNum] [int] NULL,
	[maxOrder] [int] NULL,
	[maxEntrust] [int] NULL,
 CONSTRAINT [PK_USERTYPE] PRIMARY KEY NONCLUSTERED 
(
	[userTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[usertype] ([userTypeID], [userType], [maxBookNum], [maxOrder], [maxEntrust]) VALUES (N'Type1', N'本科生', 5, 5, 5)
INSERT [dbo].[usertype] ([userTypeID], [userType], [maxBookNum], [maxOrder], [maxEntrust]) VALUES (N'Type2', N'研究生', 10, 10, 10)
INSERT [dbo].[usertype] ([userTypeID], [userType], [maxBookNum], [maxOrder], [maxEntrust]) VALUES (N'Type3', N'博士生', 15, 15, 15)
INSERT [dbo].[usertype] ([userTypeID], [userType], [maxBookNum], [maxOrder], [maxEntrust]) VALUES (N'Type4', N'教师', 20, 20, 20)
/****** Object:  Table [dbo].[user]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[loginID] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
 CONSTRAINT [PK_USER] PRIMARY KEY NONCLUSTERED 
(
	[loginID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'S1', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'S2', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'S3', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'P1', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'P2', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'P3', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'D1', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'D2', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'D3', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'T1', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'T2', N'123')
INSERT [dbo].[user] ([loginID], [password]) VALUES (N'T3', N'123')
/****** Object:  Table [dbo].[location]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[location](
	[findID] [varchar](20) NOT NULL,
	[room] [varchar](50) NOT NULL,
	[shelf] [int] NULL,
	[level] [int] NULL,
 CONSTRAINT [PK_LOCATION] PRIMARY KEY NONCLUSTERED 
(
	[findID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[location] ([findID], [room], [shelf], [level]) VALUES (N'20111', N'201', 1, 1)
INSERT [dbo].[location] ([findID], [room], [shelf], [level]) VALUES (N'20122', N'201', 2, 2)
INSERT [dbo].[location] ([findID], [room], [shelf], [level]) VALUES (N'20133', N'201', 3, 3)
INSERT [dbo].[location] ([findID], [room], [shelf], [level]) VALUES (N'20211', N'202', 1, 1)
INSERT [dbo].[location] ([findID], [room], [shelf], [level]) VALUES (N'20222', N'202', 2, 2)
INSERT [dbo].[location] ([findID], [room], [shelf], [level]) VALUES (N'20233', N'202', 3, 3)
/****** Object:  Table [dbo].[document]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[document](
	[docID] [varchar](20) NOT NULL,
	[effdate] [datetime] NULL,
	[expdate] [datetime] NULL,
	[appdate] [datetime] NULL,
	[owed] [real] NULL,
	[violations] [int] NULL,
	[userTypeID] [varchar](20) NOT NULL,
	[deposit] [real] NULL,
	[credits] [int] NULL,
	[counts] [int] NULL,
 CONSTRAINT [PK_DOCUMENT] PRIMARY KEY NONCLUSTERED 
(
	[docID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161001001', CAST(0x0000A67400C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6740083D600 AS DateTime), NULL, NULL, N'Type1', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161001002', CAST(0x0000A67400C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6740083D600 AS DateTime), NULL, NULL, N'Type1', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161001003', CAST(0x0000A67400C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6740083D600 AS DateTime), NULL, NULL, N'Type1', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161002001', CAST(0x0000A67500C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6750083D600 AS DateTime), NULL, NULL, N'Type2', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161002002', CAST(0x0000A67500C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6750083D600 AS DateTime), NULL, NULL, N'Type2', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161002003', CAST(0x0000A67500C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6750083D600 AS DateTime), NULL, NULL, N'Type2', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161003001', CAST(0x0000A67600C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6760083D600 AS DateTime), NULL, NULL, N'Type3', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161003002', CAST(0x0000A67600C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6760083D600 AS DateTime), NULL, NULL, N'Type3', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161003003', CAST(0x0000A67600C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6760083D600 AS DateTime), NULL, NULL, N'Type3', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161004001', CAST(0x0000A67700C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6770083D600 AS DateTime), NULL, NULL, N'Type4', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161004002', CAST(0x0000A67700C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6770083D600 AS DateTime), NULL, NULL, N'Type4', NULL, NULL, NULL)
INSERT [dbo].[document] ([docID], [effdate], [expdate], [appdate], [owed], [violations], [userTypeID], [deposit], [credits], [counts]) VALUES (N'161004003', CAST(0x0000A67700C5C100 AS DateTime), CAST(0x0000AC2900C5C100 AS DateTime), CAST(0x0000A6770083D600 AS DateTime), NULL, NULL, N'Type4', NULL, NULL, NULL)
/****** Object:  Table [dbo].[clc2]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[clc2](
	[clcID1] [char](1) NOT NULL,
	[clcID2] [int] NOT NULL,
	[clcName2] [varchar](50) NOT NULL,
 CONSTRAINT [PK_CLC2] PRIMARY KEY NONCLUSTERED 
(
	[clcID1] ASC,
	[clcID2] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'A', 1, N'马克思、恩格斯著作')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'A', 2, N'列宁著作')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'A', 3, N'斯大林著作')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'A', 4, N'毛泽东著作')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'B', 1, N'世界哲学')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'B', 2, N'中国哲学')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'C', 1, N'社会科学理论与方法论')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'C', 2, N' 团体、会议、社会科学机构')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'C', 3, N'社会科学研究方法')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'D', 1, N'国际共产主义运动')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'D', 2, N'中国共产党')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'D', 3, N'各国共产党')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'E', 1, N'世界军事')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'E', 2, N'中国军事')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'E', 3, N'亚洲各国军事')
INSERT [dbo].[clc2] ([clcID1], [clcID2], [clcName2]) VALUES (N'B', 3, N'亚洲哲学')
/****** Object:  Table [dbo].[userdetail]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[userdetail](
	[userID] [varchar](20) NOT NULL,
	[userName] [varchar](50) NOT NULL,
	[docID] [varchar](20) NOT NULL,
	[college] [varchar](50) NULL,
	[profession] [varchar](50) NULL,
	[sex] [char](10) NULL,
	[mail] [varchar](50) NULL,
	[loginID] [varchar](20) NOT NULL,
 CONSTRAINT [PK_USERDETAIL] PRIMARY KEY NONCLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161001001', N'张三', N'161001001', N'信息学院', N'计算机', N'男        ', NULL, N'S1')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161001002', N'李四', N'161001002', N'工学院', N'自动化', N'女        ', NULL, N'S2')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161001003', N'王五', N'161001003', N'林学院', N'地信', N'男        ', NULL, N'S3')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161002001', N'赵六', N'161002001', N'信息学院', N'计算机', N'女        ', NULL, N'P1')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161002002', N'韩七', N'161002002', N'工学院', N'自动控制', N'男        ', NULL, N'P2')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161002003', N'胡八', N'161002003', N'林学院', N'林学', N'女        ', NULL, N'P3')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161003001', N'周九', N'161003001', N'信息学院', N'人工智能', N'男        ', NULL, N'D1')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161003002', N'郑十', N'161003002', N'工学院', N'车辆', N'女        ', NULL, N'D2')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161003003', N'林一', N'161003003', N'林学院', N'草业', N'男        ', NULL, N'D3')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161004001', N'刘二', N'161004001', N'信息学院', N'教授', N'女        ', NULL, N'T1')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161004002', N'路勾', N'161004002', N'工学院', N'副教授', N'男        ', NULL, N'T2')
INSERT [dbo].[userdetail] ([userID], [userName], [docID], [college], [profession], [sex], [mail], [loginID]) VALUES (N'161004003', N'孙圈', N'161004003', N'林学院', N'讲师', N'女        ', NULL, N'T3')
/****** Object:  Table [dbo].[book]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[book](
	[bookID] [varchar](50) NOT NULL,
	[bookName] [varchar](50) NOT NULL,
	[authorName] [varchar](50) NOT NULL,
	[price] [real] NULL,
	[isbn] [varchar](50) NULL,
	[info] [text] NULL,
	[stockNum] [int] NULL,
	[findID] [varchar](20) NOT NULL,
	[bookTypeID] [varchar](20) NOT NULL,
	[clcID1] [char](1) NOT NULL,
	[clcID2] [int] NOT NULL,
 CONSTRAINT [PK_BOOK] PRIMARY KEY NONCLUSTERED 
(
	[bookID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'001', N'共产党宣言', N'马克思, 恩格斯', 32, N'978-7-01-013156-6', N'本书是马克思、恩格斯为共产主义同盟撰写的纲领。', 5, N'20111', N'006', N'A', 1)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'002', N'列宁论马克思主义', N'列宁', 9, N'7-01-003598-9', N'本文库收编马克思列宁主义经典作家的重要著作，以单行本形式陆续出版。这些著作凡可独立成书者，则一文一书；有些重要文章和书信则按专题编成文集；有些著作还设有附录，收编作者本人的有关论著和与本书直接有关的材料。为帮助读者学习和研究，在每书正文之后附有“注释”和“人名索引”，有些著作还附有“名目索引”。译文和资料均以新版全集、选集为准。这套文库与全集、选集相配合，可适应广大读者的不同需要。理论工作者，教学', 3, N'20111', N'006', N'A', 2)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'003', N'斯大林文集', N'斯大林', 4.55, N'精装', N'中共中央马克思恩格斯列宁斯大林著作编译局 编译', 2, N'20111', N'006', N'A', 3)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'004', N'我们需要什么样的文明', N'张汝伦', 86, N'978-7-100-13883-3', N'本书选编张汝伦教授*演讲、随笔和论文。分为三编，各取象精神、国家、文明。上编：把握在思想中的时代；中编：现代性语境下的中国；下编：我们需要什么样的文明。在上编，作者立足一位哲学学者对古今中西哲人思想、哲学主题的探索；在中编，进入到对中国文明当下境况的反思；在下编，作者展现一位当代中国知识分子，对未来中国文明的理想与期望。', 2, N'20222', N'001', N'B', 1)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'005', N'道德经', N'老子', 48, N'978-7-5575-2119-6', N'《道德经》仅五千余言，但文约意丰、博大精深，涵盖哲学、伦理学、政治学、军事学等诸多学科，不仅对中国古老的哲学、科学、政治、宗教等产生了深刻的影响，而且对中华民族的性格铸成、政治的统一与稳定，都起着不可估量的作用。《道德经》作为中国历史上一部完整的哲学著作，被誉为“万经之王”。', 5, N'20122', N'001', N'B', 2)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'006', N'唤醒智慧的教育', N'克里希那穆提', 39.8, N'978-7-229-11101-4', N'本书是克里希那穆提的*部畅销书，也是克里希那穆提极为珍贵、专门讨论教育问题的一本论著，出版之后在欧美引起巨大反响。生而为人，我们每个人都躲避不了“教育”。我们有过漫长的受教育史，也可能已转变为教育者（老师或者父母），正在对孩子们进行教育。教育，塑造着我们的内在与外在，决定着我们的现在与未来。但对于这人生中*重要的议题，我们有正确的认识吗？人为了什么而受教育？教育的目的是什么？怎样的教育才能唤醒孩子', 2, N'20133', N'002', N'B', 3)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'007', N'中国社会科学离科学还有多远?', N'乔晓春', 55, N'978-7-301-27908-3', N'蔡元培先生曾经指出，中国从前无所谓科学，唯用哲学、以玄想独断推测事物。近一百年来，这种情形不但没有得到改变，而且在目前的中国社会科学研究中甚至更为普遍。', 1, N'20211', N'001', N'C', 1)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'008', N'北京社会组织发展研究', N'冯虹, 李东松', 89, N'978-7-5097-8650-5', N'本书是北京工业大学“首都社会建设与社会管理协同创新中心”研究成果。科技类社会组织、行业协会类社会组织、慈善公益类社会组织、城乡社区社会组织是党的十八届三中全会提出的优先发展的四类社会组织，本书重点分析北京市这四类社会组织的发展现状及发展趋势。深化社会组织体制改革是深化北京社会治理体制改革的重要内容，北京市在登记制度、枢纽型社会组织管理体系改革方面进行了探索和创新。', 2, N'20222', N'001', N'C', 2)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'009', N'分层线性模型:应用与数据分析方法', N'斯蒂芬劳登布什', 79, N'978-7-5097-9219-3', N'美)斯蒂芬·W.劳登布什(Stephen W. Raudenbush)，美国密歇根大学教育学院教授、统计学系教授，密歇根大学调查研究中心高级研究员。主要研究领域：多层分析与历时研究的统计方法。(美)安东尼·S.布里克(Anthony S. Bryk)，美国芝加哥大学社会学系城市教育Marshall Field IV 冠名教授。领导了芝加哥大学学校改进中心，并且是芝加哥大学学校研究协会的资深指导。', 3, N'20133', N'002', N'C', 3)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'010', N'原苏东地区社会主义运动现状研究', N'孔寒冰', 60, N'978-7-208-09101-6', N'《原苏东地区社会主义运动现状研究》内容简介：所谓的“原苏东地区”，指的是苏东剧变后，在地理位置上位于原来苏联和东欧版图内的国家。苏联是一个由15个加盟共和国组成的联邦制国家，地跨欧亚，领土覆盖欧洲的东部、外高加索、中亚和远东西伯利亚。苏联在1991年底解体，分裂成15个独立主权国家。其中，地处欧洲东部的有乌克兰、白俄罗斯和摩尔多瓦，波罗的海沿岸的有立陶宛、拉脱维亚和爱沙尼亚，外高加索的有格鲁吉亚、', 0, N'20222', N'001', N'D', 1)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'011', N'习近平谈治国理政', N'习近平', 80, N'978-7-119-11392-0', N'2014 年9 月出版发行的《习近平谈治国理政》，收入习近平总书记在2012年11月15日至2014年6月13日这段时间内的讲话、谈话、演讲、答问、批示、贺信等79篇，分为18个专题。受到国内外读者的广泛关注和好评。为集中反映习近平新时代中国特色社会主义思想的发展脉络和主要内容，帮助国内外读者系统了解掌握这一重要思想的精神实质和丰富内涵，中共中央宣传部(国务院新闻办公室)会同中共中央文献研究室、中国外文出版发行事业局，对《习近平谈治国理政》进行修订再版，加标“第一卷”。', 5, N'20233', N'001', N'D', 2)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'012', N'一个未完成的政治思索:葛兰西的《狱中札记》', N'萨尔沃·马斯泰罗内', 14.8, N'7-80149-270-6', N'葛兰西在身陷囹圄期间所阐发的各种概念与看法，构成了一个涉及到20世纪前半叶所有重大问题的系统的研究计划。实际上，《狱中札记》为我们提供了理解和应对两次世界大战之间世界所发生的变动的批判性方法论的框架。而这也恰恰说明《狱中札记》为什么获得了非同一般的成功。 本书所收入的各篇论文对围绕《狱中札记》所展开的讨论提供了启迪，从文献学和年代学的角度给出了对于葛兰西思想的一种忠实的解读，而这种解读是基于这', 1, N'20111', N'005', N'D', 3)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'013', N'内战:观念中的历史', N'大卫·阿米蒂奇', 58, N'978-7-5086-8867-1', N'内战的时代或许已经结束，但过去的几十年里它又在世界各地频频爆发，巴尔干、卢旺达、布隆迪、索马里、斯里兰卡、叙利亚……内战正逐渐成为人类颇为广泛、颇具破坏性且独具特色的有组织的武装暴力形式。如何定义这些形式的暴力，关系到政治、军事、经济和人道援助、国际法立法执法等方方面面，甚至影响到整个世界格局和全球人类的命运。正如作者所言：“当今', 0, N'20133', N'002', N'E', 1)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'014', N'决战朝鲜', N'李峰', 88, N'978-7-5143-6339-5', N'本书是一部全景式再现朝鲜战争历史命运的经典作品，以恢宏的气势、凝练的语言、多维度的视角记述和分析了朝鲜战争成因、决策过程、五次战役及板门店停战谈判等重大事件，包括战前国际国内形势、重要战役战况、双方将帅决策过程及这场战争中涌现的堪称“军神”级人物，塑造了一大批性格鲜明的人物形象。', 3, N'20222', N'001', N'E', 2)
INSERT [dbo].[book] ([bookID], [bookName], [authorName], [price], [isbn], [info], [stockNum], [findID], [bookTypeID], [clcID1], [clcID2]) VALUES (N'015', N'题名/责任者:日本陆军史:近代化的异化', N'户部良一', 49, N'978-7-5097-9563-7', N'户部良一，1948年生，日本历史学者。京都大学博士，专业为日本政治外交史。现为帝京大学文学部史学科教授、国际日本文化研究中心名誉教授、防卫大学校名誉教授。韦平和，译有《日中关系40年史（1972-2012）(全四卷）》《日中领土争端的起源——从历史档案看钓鱼岛问题》等。', 1, N'20111', N'003', N'E', 3)
/****** Object:  Table [dbo].[borrowInfo]    Script Date: 12/19/2018 20:03:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[borrowInfo](
	[borrowID] [int] NOT NULL,
	[bookID] [varchar](50) NOT NULL,
	[borrowTime] [datetime] NULL,
	[returnTime] [datetime] NULL,
	[userID] [varchar](20) NOT NULL,
	[returnState] [varchar](20) NULL,
 CONSTRAINT [PK_BORROWINFO] PRIMARY KEY NONCLUSTERED 
(
	[borrowID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[borrowInfo] ([borrowID], [bookID], [borrowTime], [returnTime], [userID], [returnState]) VALUES (1, N'001', CAST(0x0000A9BB0128A180 AS DateTime), NULL, N'161001001', N'未归还，未超期')
INSERT [dbo].[borrowInfo] ([borrowID], [bookID], [borrowTime], [returnTime], [userID], [returnState]) VALUES (2, N'005', CAST(0x0000A9BA00C5C100 AS DateTime), CAST(0x0000A9BB00C5C100 AS DateTime), N'161002002', N'已归还，未超期')
INSERT [dbo].[borrowInfo] ([borrowID], [bookID], [borrowTime], [returnTime], [userID], [returnState]) VALUES (3, N'004', CAST(0x0000A97B00E6B680 AS DateTime), NULL, N'161002003', N'未归还，已超期')
INSERT [dbo].[borrowInfo] ([borrowID], [bookID], [borrowTime], [returnTime], [userID], [returnState]) VALUES (4, N'009', CAST(0x0000A96C00000000 AS DateTime), CAST(0x0000A9BB005265C0 AS DateTime), N'161003002', N'已归还，已超期')
/****** Object:  ForeignKey [FK_book_booktype]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[book]  WITH CHECK ADD  CONSTRAINT [FK_book_booktype] FOREIGN KEY([bookTypeID])
REFERENCES [dbo].[booktype] ([bookTypeID])
GO
ALTER TABLE [dbo].[book] CHECK CONSTRAINT [FK_book_booktype]
GO
/****** Object:  ForeignKey [FK_book_clc1]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[book]  WITH CHECK ADD  CONSTRAINT [FK_book_clc1] FOREIGN KEY([clcID1], [clcID2])
REFERENCES [dbo].[clc2] ([clcID1], [clcID2])
GO
ALTER TABLE [dbo].[book] CHECK CONSTRAINT [FK_book_clc1]
GO
/****** Object:  ForeignKey [FK_book_location]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[book]  WITH CHECK ADD  CONSTRAINT [FK_book_location] FOREIGN KEY([findID])
REFERENCES [dbo].[location] ([findID])
GO
ALTER TABLE [dbo].[book] CHECK CONSTRAINT [FK_book_location]
GO
/****** Object:  ForeignKey [FK_borrowInfo_book]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[borrowInfo]  WITH CHECK ADD  CONSTRAINT [FK_borrowInfo_book] FOREIGN KEY([bookID])
REFERENCES [dbo].[book] ([bookID])
GO
ALTER TABLE [dbo].[borrowInfo] CHECK CONSTRAINT [FK_borrowInfo_book]
GO
/****** Object:  ForeignKey [FK_borrowInfo_userdetail]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[borrowInfo]  WITH CHECK ADD  CONSTRAINT [FK_borrowInfo_userdetail] FOREIGN KEY([userID])
REFERENCES [dbo].[userdetail] ([userID])
GO
ALTER TABLE [dbo].[borrowInfo] CHECK CONSTRAINT [FK_borrowInfo_userdetail]
GO
/****** Object:  ForeignKey [FK_clc2_clc1]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[clc2]  WITH CHECK ADD  CONSTRAINT [FK_clc2_clc1] FOREIGN KEY([clcID1])
REFERENCES [dbo].[clc1] ([clcID1])
GO
ALTER TABLE [dbo].[clc2] CHECK CONSTRAINT [FK_clc2_clc1]
GO
/****** Object:  ForeignKey [FK_document_usertype]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[document]  WITH CHECK ADD  CONSTRAINT [FK_document_usertype] FOREIGN KEY([userTypeID])
REFERENCES [dbo].[usertype] ([userTypeID])
GO
ALTER TABLE [dbo].[document] CHECK CONSTRAINT [FK_document_usertype]
GO
/****** Object:  ForeignKey [FK_userdetail_user]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[userdetail]  WITH CHECK ADD  CONSTRAINT [FK_userdetail_user] FOREIGN KEY([loginID])
REFERENCES [dbo].[user] ([loginID])
GO
ALTER TABLE [dbo].[userdetail] CHECK CONSTRAINT [FK_userdetail_user]
GO
/****** Object:  ForeignKey [FK_userdetail_userdetail]    Script Date: 12/19/2018 20:03:24 ******/
ALTER TABLE [dbo].[userdetail]  WITH CHECK ADD  CONSTRAINT [FK_userdetail_userdetail] FOREIGN KEY([docID])
REFERENCES [dbo].[document] ([docID])
GO
ALTER TABLE [dbo].[userdetail] CHECK CONSTRAINT [FK_userdetail_userdetail]
GO
