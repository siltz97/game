USE Test;

-- Creates tha characters table.
DROP TABLE IF EXISTS [dbo].[aa_Inventory];
DROP TABLE IF EXISTS [dbo].[aa_Character];
CREATE TABLE [dbo].[aa_Character] (
    [name] NVARCHAR (50) PRIMARY KEY
);
-- Populate the table.
INSERT INTO [dbo].[aa_Character]([name])
VALUES
    (N'Goblin'),
	(N'Skeleton'),
	(N'Kobold'),
	(N'Zombie'),
	(N'Merchant'),
	(N'Guard'),
	(N'Peasant'),
	(N'Thief'),
	(N'Player')
-- Create the Items table.
DROP TABLE IF EXISTS [dbo].[aa_Items];
CREATE TABLE [dbo].[aa_Items] (
    [name]          NVARCHAR (50) PRIMARY KEY,
    [description]   NVARCHAR (50) NOT NULL,
    [price]         INT           NOT NULL,
    [durability]    INT           NOT NULL,
    [specialEffect] NVARCHAR (50) NULL
);
-- Populate items.
INSERT INTO [dbo].[aa_Items]([name], [description], [price], [durability]) VALUES
(N'silverring',	    N'A ring with minor magical properties +20 MAX MANA',	350,	1),
(N'healthpotion',	N'Restores +100 health',	                            50,	1	),
(N'firescroll',	    N'Deals 200 DMG',	                                    300,	1	),
(N'manaflask',	    N'Restores +100 MP',	                                60,	1	),
(N'ironsword',	    N'A basic but reliable sword. +20 DMG',	                200,	1	),
(N'bucket',	        N'It''s, just a bucket',	                            1,	1	)


-- Creates the Inventory table.
DROP TABLE IF EXISTS [dbo].[aa_Inventory];
CREATE TABLE [dbo].[aa_Inventory] (
    [id]            INT IDENTITY(1,1) PRIMARY KEY,
    [character]     NVARCHAR (50) NOT NULL,
    [item]          NVARCHAR (50) NOT NULL,
    CONSTRAINT [FK_Inventory_Character] FOREIGN KEY ([character]) REFERENCES [dbo].[aa_Character] ([name]),
    CONSTRAINT [FK_Inventory_Items] FOREIGN KEY ([item]) REFERENCES [dbo].[aa_Items] ([name])
);

PRINT 'Giving the Goblin a bucket.'

-- Give the goblin a bucket.
INSERT INTO [dbo].[aa_Inventory]([character], [item])
SELECT *
FROM (
    SELECT C.[name] AS [character], I.[name] AS [item]
    FROM
            [dbo].[aa_Character] AS C
        CROSS JOIN
            [dbo].[aa_Items] AS I
) AS [Input]
WHERE [Input].[character] = 'Goblin' AND [Input].[item] = 'bucket';        


SELECT *
FROM [dbo].[aa_Inventory];